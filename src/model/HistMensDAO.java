package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela HISTMENS
 * Comunicação com a classe HistMens
 * @author Simple Solution Devs
 */
public class HistMensDAO {

	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * Método responsável por retornar uma lista com o registro de todos as mensalidades pagas
	 * @return listaHM - lista de mensalidades pagas (array)
	 */
	public HistMens[] consultaTodos() {
		sql = "SELECT * FROM HISTMENS";
		HistMens[] listaHM = new HistMens[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaHM = new HistMens[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) {						
						HistMens hm = listaHM[count];
						hm.setCodHM(dbc.rs.getInt(1));
						hm.setDataPgHM(dbc.rs.getDate(2));
						hm.setJurosPgHM(dbc.rs.getDouble(3));
						hm.setCodAluno(dbc.rs.getInt(4));
						hm.setCodMens(dbc.rs.getInt(5));
						count++;
					}
				}			
			} 
			catch (SQLException e) {
				listaHM = null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaHM;
}



	/**
	 * Método responsável por retornar um registro de acordo com o código fornecido
	 * Tabela HISTMENS
	 * @param hm - objeto instânciado da classe HistMens
	 * @return hm
	 */
	public HistMens consultar(HistMens hm) {
		sql = "SELECT * FROM HISTMENS WHERE codHM=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, hm.getCodHM());
					dbc.rs = dbc.st.executeQuery();
					hm.setDataPgHM(dbc.rs.getDate(2));
					hm.setJurosPgHM(dbc.rs.getDouble(3));
					hm.setCodAluno(dbc.rs.getInt(4));
					hm.setCodMens(dbc.rs.getInt(5));
				}			
			} 
			catch (SQLException e) {
				hm = null;
			} 
			finally {
				dbc.close();
			}
		}
		return hm; 
	}



	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela HISTMENS
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codHM') FROM HISTMENS;";
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
	 * Tabela HISTMENS
	 * @param hm - objeto instânciado da classe Matricula
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(HistMens hm) {
		sql = "INSERT INTO HISTMENS VALUES(?,?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, hm.getCodHM());
				dbc.st.setDate(2, hm.getDataPgHM());
				dbc.st.setDouble(3, hm.getJurosPgHM());
				dbc.st.setInt(4, hm.getCodAluno());
				dbc.st.setInt(5, hm.getCodMens());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE MATRICULA SET "
						+ "dataPgHM=?"
						+ "jurosPgHM=?"
						+ "codAluno=?"
						+ "codMens=?"
						+ "WHERE codHM=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setDate(1, hm.getDataPgHM());
						dbc.st.setDouble(2, hm.getJurosPgHM());
						dbc.st.setInt(3, hm.getCodAluno());
						dbc.st.setInt(4, hm.getCodMens());
						dbc.st.setInt(5, hm.getCodHM());
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
