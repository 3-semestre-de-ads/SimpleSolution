package model;

import java.sql.SQLException;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela ALUNO
 * Comunicação com a classe Aluno
 * @author Simple Solution Devs
 */
public class ResponsavelDAO {
	
	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;
	
	
	
	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela RESPONSAVEL
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codResponsavel') FROM RESPONSAVEL;";
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
	 * Método responsável por retornar uma lista com o registro de todos os responsáveis
	 * @return lista_responsaveis - lista de responsaveis (array)
	 */
	public Responsavel[] consultaTodos() {
		sql = "SELECT * FROM RESPONSAVEL";
		Responsavel[] lista_responsaveis = new Responsavel[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					
					//Bloco para contagem de registros
					dbc.rs.last();
					lista_responsaveis = new Responsavel[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					//Fim do bloco
					
					
					int count=0;
					while (dbc.rs.next()) {						
						Responsavel responsavel = lista_responsaveis[count];
						responsavel.setCodResp(dbc.rs.getInt(1));
						responsavel.setNomeResp(dbc.rs.getString(2));
						responsavel.setNascResp(dbc.rs.getDate(3));
						responsavel.setRgResp(dbc.rs.getString(4));
						responsavel.setCpfResp(dbc.rs.getString(5));
						responsavel.setEmailResp(dbc.rs.getString(6));
						responsavel.setTelResp(dbc.rs.getString(7));
						responsavel.setStatusResp(dbc.rs.getString(8));
						count++;
					}
				}			
			} catch (SQLException e) {
				lista_responsaveis = null;
			} finally {
				dbc.close();
			}
		}
		return lista_responsaveis;
	}
	
	

	/**
	 * Método responsável por retornar um registro de acordo com o código fornecido
	 * Tabela RESPONSAVEL
	 * @param responsavel - objeto instânciado da classe Aluno
	 * @return responsavel 
	 */
	public Responsavel consulta(Responsavel responsavel) {
		sql = "SELECT * FROM RESPONSAVEL WHERE codResp=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, responsavel.getCodResp());
					dbc.rs = dbc.st.executeQuery();
					responsavel.setNomeResp(dbc.rs.getString(2));
					responsavel.setNascResp(dbc.rs.getDate(3));
					responsavel.setRgResp(dbc.rs.getString(4));
					responsavel.setCpfResp(dbc.rs.getString(5));
					responsavel.setEmailResp(dbc.rs.getString(6));
					responsavel.setTelResp(dbc.rs.getString(7));
					responsavel.setStatusResp(dbc.rs.getString(8));
				}			
			} catch (SQLException e) {
				responsavel = null;
			} finally {
				dbc.close();
			}
		}
		return responsavel;
	}
	
	
	
	/**
	 * Método responsável por atualizar o status de algum registro
	 * Tabela RESPONSAVEL
	 * @param responsavel - objeto instânciado da classe Responsavel
	 * @return men - mensagem de aviso
	 */
	public String ativaInativa(Responsavel responsavel) {
		if(responsavel.getStatusResp()=="A") {
			sql = "UPDATE RESPONSAVEL SET statusResp='I' WHERE codResp=?;";
		}else {
			sql = "UPDATE RESPONSAVEL SET statusResp='A' WHERE codResp=?;";
		}
		sql = "UPDATE RESPONSAVEL SET statusResp WHERE codResp=?;";
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, responsavel.getCodResp());
				dbc.rs = dbc.st.executeQuery();
				men="Sucesso";
			} catch (SQLException e) {
				men="Falha:"+e;
			}finally {
				dbc.close();
			}
		}
		return men;
	}
	
	
	
	/**
	 * Método responsável por inserir um novo registro ou atualizar um registro existente
	 * Tabela RESPONSAVEL
	 * @param responsavel - objeto instânciado da classe Responsavel
	 * @return men - mensagem de aviso
	 */
	public String insereAtualiza(Responsavel responsavel) {
		sql = "INSERT INTO RESPONSAVEL VALUES(?,?,?,?,?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, responsavel.getCodResp());
				dbc.st.setString(2, responsavel.getNomeResp());
				dbc.st.setDate(3, responsavel.getNascResp());
				dbc.st.setString(4, responsavel.getRgResp());
				dbc.st.setString(5, responsavel.getCpfResp());
				dbc.st.setString(6, responsavel.getEmailResp());
				dbc.st.setString(7, responsavel.getTelResp());
				dbc.st.setString(8, responsavel.getStatusResp()); 
				dbc.rs = dbc.st.executeQuery();
			} catch (SQLException e) {
				sql = "UPDATE RESPONSAVEL SET nomeResp=?"
											+ "nascRes=?"
											+ "rgResp=?"
											+ "cpfResp=?"
											+ "emailResp=?"
											+ "telResp=?"
											+ "statusResp=?"
				+ "WHERE codResp=?";
				if (dbc.getConnection()) {
					try {
						dbc.st = dbc.con.prepareStatement(sql);
						
						dbc.st.setString(1, responsavel.getNomeResp());
						dbc.st.setDate(2, responsavel.getNascResp());
						dbc.st.setString(3, responsavel.getRgResp());
						dbc.st.setString(4, responsavel.getCpfResp());
						dbc.st.setString(5, responsavel.getEmailResp());
						dbc.st.setString(6, responsavel.getTelResp());
						dbc.st.setString(7, responsavel.getStatusResp()); 
						
						dbc.st.setInt(8, responsavel.getCodResp());
						dbc.rs = dbc.st.executeQuery();
					} catch (SQLException e2) {
						men = "Falha"+ e2;
					}

				}				
				
			}finally {
				dbc.close();
			}

		}
		return men;
	}

}
