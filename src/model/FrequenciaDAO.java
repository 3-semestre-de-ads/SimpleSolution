package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela FREQUENCIA
 * Comunica��o com a classe Administrador
 * @author Simple Solution Devs
 */
public class FrequenciaDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;
	
	
	
	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela FREQUENCIA
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codFreq') FROM FREQUENCIA;";
		int r = 0;
		if(dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.rs = dbc.st.executeQuery();
				r = dbc.rs.getInt(1)+1;
			} catch (SQLException e) {
				r = -1;
			} finally {
				dbc.close();
			}
		}
		return r;
	}
	
	public ArrayList<Frequencia> consultarByCodMat(int codMat) {
		sql = "SELECT * FROM FREQUENCIA WHERE codMat=?;";
		ArrayList<Frequencia> listaFreq = new ArrayList<Frequencia>();
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, codMat);
					dbc.rs = dbc.st.executeQuery();

					while (dbc.rs.next()) { 
						Frequencia frequencia = new Frequencia();
						frequencia.setCodFreq(dbc.rs.getInt(1));
						frequencia.setDataFreq(dbc.rs.getDate(2));
						frequencia.setStatusFreq(dbc.rs.getString(3));
						frequencia.setCodMat(dbc.rs.getInt(4));
						listaFreq.add(frequencia);
					}									
				}			
			} 
			catch (SQLException e) {
				listaFreq = null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaFreq;
	}
	
	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos as frequ�ncias
	 * @return listaFreq - lista de frequ�ncias (array)
	 */
	public Frequencia[] consultarTodos() {
		sql = "SELECT * FROM FREQUENCIA;";
		Frequencia[] listaFreq = new Frequencia[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaFreq = new Frequencia[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) { 
						Frequencia frequencia = listaFreq[count];
						frequencia.setCodFreq(dbc.rs.getInt(1));
						frequencia.setDataFreq(dbc.rs.getDate(2));
						frequencia.setStatusFreq(dbc.rs.getString(3));
						frequencia.setCodMat(dbc.rs.getInt(4));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaFreq = null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaFreq;
	}
	
	
	
	/**
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela FREQUENCIA
	 * @param frequencia - objeto inst�nciado da classe Frequencia
	 * @return frequencia 
	 */
	public Frequencia consultar(Frequencia frequencia) {
		sql = "SELECT * FROM FREQUENCIA WHERE codFreq=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, frequencia.getCodFreq());
					dbc.rs = dbc.st.executeQuery();
					frequencia.setDataFreq(dbc.rs.getDate(2));
					frequencia.setStatusFreq(dbc.rs.getString(3));
					frequencia.setCodMat(dbc.rs.getInt(4));
				}			
			} 
			catch (SQLException e) {
				frequencia = null;
			} 
			finally {
				dbc.close();
			}
		}
		return frequencia; 
	}
	
	
	
	/**
	 * M�todo respons�vel por inserir um novo registro ou atualizar um registro existente
	 * Tabela FREQUENCIA
	 * @param frequencia - objeto inst�nciado da classe Frequencia
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Frequencia frequencia) {
		sql = "INSERT INTO FREQUENCIA VALUES(?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, frequencia.getCodFreq());
				dbc.st.setDate(2, frequencia.getDataFreq());
				dbc.st.setString(3, frequencia.getStatusFreq());
				dbc.st.setInt(4, frequencia.getCodMat());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE FREQUENCIA SET "
						+ "dataFreq=?"
						+ "statusFreq=?"
						+ "codMat=?"
						+ "WHERE codFreq=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setDate(1, frequencia.getDataFreq());
						dbc.st.setString(2, frequencia.getStatusFreq());
						dbc.st.setInt(3, frequencia.getCodMat());
						dbc.st.setInt(4, frequencia.getCodFreq());
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
