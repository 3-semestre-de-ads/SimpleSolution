package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela HISTTURMA
 * Comunicação com a classe HistTurma
 * @author Simple Solution Devs
 */
public class HistTurmaDAO {

	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * Método responsável por retornar uma lista com o registro de todo o histórico
	 * @return listaHT- lista de histórico (array)
	 */
	public HistTurma[] consultarTodos() {
		sql = "SELECT * FROM HISTTURMA;";
		HistTurma[] listaHT = new HistTurma[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaHT = new HistTurma[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count = 0;
					while (dbc.rs.next()) { 
						HistTurma ht = listaHT[count];
						ht.setCodHT(dbc.rs.getInt(1));
						ht.setDataInHT(dbc.rs.getDate(2));
						ht.setDataFiHT(dbc.rs.getDate(3));
						ht.setCodMat(dbc.rs.getInt(4));
						ht.setCodProf(dbc.rs.getInt(5));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaHT = null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaHT;
	}



	/**
	 * Método responsável por popular a tabela
	 * Tabela HISTTURMA
	 * @param ht - objeto instânciado da classe HistTurma
	 * @return ht
	 */
	public HistTurma consultar(HistTurma ht) {
		sql = "SELECT * FROM HISTTURMA WHERE codHT=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, ht.getCodMat());
					dbc.rs = dbc.st.executeQuery();
					ht.setDataInHT(dbc.rs.getDate(2));
					ht.setDataFiHT(dbc.rs.getDate(3));
					ht.setCodMat(dbc.rs.getInt(4));
					ht.setCodProf(dbc.rs.getInt(4));
				}			
			} 
			catch (SQLException e) {
				ht = null;
			} 
			finally {
				dbc.close();
			}
		}
		return ht; 
	}



	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela HISTTURMA
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codHT') FROM HISTTURMA;";
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
	 * Tabela HISTTURMA
	 * @param ht - objeto instânciado da classe HistTurma
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(HistTurma ht) {
		sql = "INSERT INTO HISTTURMA VALUES(?,?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, ht.getCodHT());
				dbc.st.setDate(2, ht.getDataInHT());
				dbc.st.setDate(3, ht.getDataFiHT());
				dbc.st.setInt(4, ht.getCodMat());
				dbc.st.setInt(5, ht.getCodProf());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE HISTTURMA SET "
						+ "dataInHT=?"
						+ "valorFiHT=?"
						+ "codMat=?"
						+ "codProf=?"
						+ "WHERE codHT=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setDate(1, ht.getDataInHT());
						dbc.st.setDate(2, ht.getDataFiHT());
						dbc.st.setInt(3, ht.getCodMat());
						dbc.st.setInt(4, ht.getCodProf());
						dbc.st.setInt(5, ht.getCodHT());
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
