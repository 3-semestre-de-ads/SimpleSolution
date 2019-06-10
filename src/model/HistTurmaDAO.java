package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela HISTTURMA
 * Comunica��o com a classe HistTurma
 * @author Simple Solution Devs
 */
public class HistTurmaDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todo o hist�rico
	 * @return listaHT- lista de hist�rico (array)
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
	 * M�todo respons�vel por popular a tabela
	 * Tabela HISTTURMA
	 * @param ht - objeto inst�nciado da classe HistTurma
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
					while (dbc.rs.next()) {
						ht.setDataInHT(dbc.rs.getDate(2));
						ht.setDataFiHT(dbc.rs.getDate(3));
						ht.setCodMat(dbc.rs.getInt(4));
						ht.setCodProf(dbc.rs.getInt(4));
					}
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
	
	public HistTurma consultarPorTurma(HistTurma ht) {
		sql = "SELECT * FROM HISTTURMA WHERE codMat=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, ht.getCodMat());
					dbc.rs = dbc.st.executeQuery();
					while (dbc.rs.next()) {
						ht.setDataInHT(dbc.rs.getDate(2));
						ht.setDataFiHT(dbc.rs.getDate(3));
						ht.setCodMat(dbc.rs.getInt(4));
						ht.setCodProf(dbc.rs.getInt(4));
					}
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
	
	public ArrayList<Integer> consultarPorProfessor(int codProf) {
		sql = "SELECT * FROM HISTTURMA WHERE codMat=?;";
		ArrayList<Integer> lista = new ArrayList<Integer>();
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, codProf);
					dbc.rs = dbc.st.executeQuery();
					while (dbc.rs.next()) {
						lista.add(dbc.rs.getInt(4));
					}
				}			
			} 
			catch (SQLException e) {
				lista = null;
			} 
			finally {
				dbc.close();
			}
		}
		return lista; 
	}

	

	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela HISTTURMA
	 * @return r - valor do pr�ximo �ndice
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

	public ArrayList<Integer> consultarCodTurmaPorProf(int codProf) {
		sql = "SELECT * FROM HISTTURMA WHERE codProf=?";
		ArrayList<Integer> listaTurma = new ArrayList<Integer>();
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, codProf);
					dbc.rs = dbc.st.executeQuery();

					while (dbc.rs.next()) {
						listaTurma.add(dbc.rs.getInt(4));
					}									
				}			
			} 
			catch (SQLException e) {
				listaTurma=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaTurma;
	}
	
	/**
	 * M�todo respons�vel por inserir um novo registro ou atualizar um registro existente
	 * Tabela HISTTURMA
	 * @param ht - objeto inst�nciado da classe HistTurma
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
