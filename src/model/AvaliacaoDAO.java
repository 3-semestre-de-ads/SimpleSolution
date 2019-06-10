package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela AVALIACAO
 * Comunica��o com a classe Avaliacao
 * @author Simple Solution Devs
 */
public class AvaliacaoDAO {
	
	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String sql;
	private String men;
	
	
	
	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela AVALIACAO
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codAval') FROM AVALIACAO;";
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
	
	
	
	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos as avalia��es
	 * @return listaAval - lista de avalia��es (array)
	 */
	public ArrayList<Avaliacao> consultarTodos() {
		sql = "SELECT * FROM AVALIACAO;";
		ArrayList<Avaliacao> listaAval = new ArrayList<Avaliacao>();
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();

					while (dbc.rs.next()) { 
						Avaliacao avaliacao = new Avaliacao();
						avaliacao.setCodAval(dbc.rs.getInt(1));
						avaliacao.setNomeAval(dbc.rs.getString(2));
						avaliacao.setValorAval(dbc.rs.getDouble(3));
						avaliacao.setCodAdmin(dbc.rs.getInt(4));
						listaAval.add(avaliacao);
					}									
				}			
			} 
			catch (SQLException e) {
				listaAval = null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaAval;
	}
	
	
	public ArrayList<Avaliacao> consultarTodosProf(int codProf) {
		sql = "SELECT * FROM AVALIACAO WHERE codAdmin=?;";
		ArrayList<Avaliacao> listaAval = new ArrayList<Avaliacao>();
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, codProf);
					dbc.rs = dbc.st.executeQuery();

					while (dbc.rs.next()) { 
						Avaliacao avaliacao = new Avaliacao();
						avaliacao.setCodAval(dbc.rs.getInt(1));
						avaliacao.setNomeAval(dbc.rs.getString(2));
						avaliacao.setValorAval(dbc.rs.getDouble(3));
						avaliacao.setCodAdmin(dbc.rs.getInt(4));
						listaAval.add(avaliacao);
					}									
				}			
			} 
			catch (SQLException e) {
				listaAval = null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaAval;
	}
	
	
	
	/**
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela AVALIACAO
	 * @param avaliacao - objeto inst�nciado da classe Avaliacao
	 * @return avaliacao 
	 */
	public Avaliacao consultar(Avaliacao avaliacao) {
		sql = "SELECT * FROM AVALIACAO WHERE codAval=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, avaliacao.getCodAval());
					dbc.rs = dbc.st.executeQuery();
					avaliacao.setNomeAval(dbc.rs.getString(2));
					avaliacao.setValorAval(dbc.rs.getDouble(3));
					avaliacao.setCodAdmin(dbc.rs.getInt(4));
				}			
			} 
			catch (SQLException e) {
				avaliacao = null;
			} 
			finally {
				dbc.close();
			}
		}
		return avaliacao; 
	}
	
	
	
	/**
	 * M�todo respons�vel por inserir um novo registro ou atualizar um registro existente
	 * Tabela AVALIACAO
	 * @param avaliacao - objeto inst�nciado da classe Avaliacao
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Avaliacao avaliacao) {
		sql = "INSERT INTO AVALIACAO VALUES(?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, avaliacao.getCodAval());
				dbc.st.setString(2, avaliacao.getNomeAval());
				dbc.st.setDouble(3, avaliacao.getValorAval());
				dbc.st.setInt(4, avaliacao.getCodAdmin());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE AVALIACAO SET "
						+ "nomeAval=?"
						+ "valorAval=?"
						+ "codAdmin=?"
						+ "WHERE codAval=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setString(1, avaliacao.getNomeAval());
						dbc.st.setDouble(2, avaliacao.getValorAval());
						dbc.st.setInt(3, avaliacao.getCodAdmin());
						dbc.st.setInt(4, avaliacao.getCodAval());
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
