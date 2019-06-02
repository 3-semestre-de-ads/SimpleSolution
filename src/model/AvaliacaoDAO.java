package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela AVALIACAO
 * Comunicação com a classe Avaliacao
 * @author Simple Solution Devs
 */
public class AvaliacaoDAO {
	
	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String sql;
	private String men;
	
	
	
	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela AVALIACAO
	 * @return r - valor do próximo índice
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
	 * Método responsável por retornar uma lista com o registro de todos as avaliações
	 * @return listaAval - lista de avaliações (array)
	 */
	public Avaliacao[] consultarTodos() {
		sql = "SELECT * FROM AVALIACAO;";
		Avaliacao[] listaAval = new Avaliacao[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaAval = new Avaliacao[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) { 
						Avaliacao avaliacao = listaAval[count];
						avaliacao.setCodAval(dbc.rs.getInt(1));
						avaliacao.setNomeAval(dbc.rs.getString(2));
						avaliacao.setValorAval(dbc.rs.getDouble(3));
						avaliacao.setCodAdmin(dbc.rs.getInt(4));
						count ++;
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
	 * Método responsável por retornar um registro de acordo com o código fornecido
	 * Tabela AVALIACAO
	 * @param avaliacao - objeto instânciado da classe Avaliacao
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
	 * Método responsável por inserir um novo registro ou atualizar um registro existente
	 * Tabela AVALIACAO
	 * @param avaliacao - objeto instânciado da classe Avaliacao
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
