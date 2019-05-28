package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela HISTVALOR
 * Comunicação com a classe HistValor
 * @author Simple Solution Devs
 */
public class HistValorDAO {

	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * Método responsável por retornar uma lista com o registro de todos os valores
	 * @return listaHV - lista de valores (array)
	 */
	public HistValor[] consultarTodos() {
		sql = "SELECT * FROM HISTVALOR;";
		HistValor[] listaHV = new HistValor[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaHV = new HistValor[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count =0;
					while (dbc.rs.next()) { 
						HistValor hv = listaHV[count];
						hv.setCodHV(dbc.rs.getInt(1));
						hv.setValorPadHV(dbc.rs.getDouble(2));
						hv.setCodTE(dbc.rs.getInt(3));
						hv.setCodMens(dbc.rs.getInt(4));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaHV = null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaHV;
	}



	/**
	 * Método responsável por retornar um registro de acordo com o código fornecido
	 * Tabela HISTVALOR
	 * @param hv - objeto instânciado da classe Matricula
	 * @return hv
	 */
	public HistValor consultar(HistValor hv) {
		sql = "SELECT * FROM HISTVALOR WHERE codHV=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, hv.getCodHV());
					dbc.rs = dbc.st.executeQuery();
					hv.setValorPadHV(dbc.rs.getDouble(2));
					hv.setCodTE(dbc.rs.getInt(3));
					hv.setCodMens(dbc.rs.getInt(4));
				}			
			} 
			catch (SQLException e) {
				hv = null;
			} 
			finally {
				dbc.close();
			}
		}
		return hv; 
	}



	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela HISTVALOR
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codHV') FROM HISTVALOR;";
		int r = 0;
		if(dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.rs = dbc.st.executeQuery();
				r = dbc.rs.getInt(1)+1;
			}
			catch (SQLException e) {
				r = -1;
			} 
			finally {
				dbc.close();
			}
		}
		return r;
	}


	
	/**
	 * Método responsável por inserir um novo registro ou atualizar um registro existente
	 * Tabela HISTVALOR
	 * @param hv - objeto instânciado da classe HistValor
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(HistValor hv) {
		sql = "INSERT INTO HISTVALOR VALUES(?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, hv.getCodHV());
				dbc.st.setDouble(2, hv.getValorPadHV());
				dbc.st.setInt(3, hv.getCodTE());
				dbc.st.setInt(4, hv.getCodMens());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE HISTVALOR SET "
						+ "valorPadHV=?"
						+ "codTE=?"
						+ "codMens=?"
						+ "WHERE codHV=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setDouble(1, hv.getValorPadHV());
						dbc.st.setInt(2, hv.getCodTE());
						dbc.st.setInt(3, hv.getCodMens());
						dbc.st.setInt(4, hv.getCodHV());
						dbc.rs = dbc.st.executeQuery();
						men = "Atualizado com sucesso";
					} 
				}
				catch (SQLException e2) {
					men = "Falha: "+ e2;
				}	
			}
			finally {
				dbc.close();
			}
		}
		return men;
	}
}
