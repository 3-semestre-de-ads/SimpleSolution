package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela ALUNO
 * Comunica��o com a classe Aluno
 * @author Simple Solution Devs
 */
public class ResponsavelDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;



	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela RESPONSAVEL
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX(codResponsavel) FROM RESPONSAVEL;";
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
	 * M�todo respons�vel por retornar uma lista com o registro de todos os respons�veis
	 * @return lista_responsaveis - lista de responsaveis (array)
	 */
	public ArrayList<Responsavel> consultaTodos() {
		sql = "SELECT * FROM RESPONSAVEL";
		ArrayList<Responsavel> lista_responsaveis = new ArrayList<Responsavel>();
		if (dbc.getConnection()) {
			try {

				dbc.st = dbc.con.prepareStatement(sql);
				dbc.rs = dbc.st.executeQuery();

				while (dbc.rs.next()) {						
					Responsavel responsavel = new Responsavel();
					responsavel.setCodResp(dbc.rs.getInt(1));
					responsavel.setNomeResp(dbc.rs.getString(2));
					responsavel.setNascResp(dbc.rs.getDate(3));
					responsavel.setRgResp(dbc.rs.getString(4));
					responsavel.setCpfResp(dbc.rs.getString(5));
					responsavel.setEmailResp(dbc.rs.getString(6));
					responsavel.setTelResp(dbc.rs.getString(7));
					responsavel.setStatusResp(dbc.rs.getString(8));
					lista_responsaveis.add(responsavel);
				}

			} catch (SQLException e) {
				System.out.println(e);
				lista_responsaveis = null;
			} finally {
				dbc.close();
			}
		}
		System.out.println(lista_responsaveis);

		return lista_responsaveis;
	}



	/**
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela RESPONSAVEL
	 * @param responsavel - objeto inst�nciado da classe Aluno
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
					while (dbc.rs.next()) {
						responsavel.setNomeResp(dbc.rs.getString(2));
						responsavel.setNascResp(dbc.rs.getDate(3));
						responsavel.setRgResp(dbc.rs.getString(4));
						responsavel.setCpfResp(dbc.rs.getString(5));
						responsavel.setEmailResp(dbc.rs.getString(6));
						responsavel.setTelResp(dbc.rs.getString(7));
						responsavel.setStatusResp(dbc.rs.getString(8));
					}
				}			
			} catch (SQLException e) {
				System.out.println(e);
				responsavel = null;
			} finally {
				dbc.close();
			}
		}
		return responsavel;
	}



	/**
	 * M�todo respons�vel por atualizar o status de algum registro
	 * Tabela RESPONSAVEL
	 * @param responsavel - objeto inst�nciado da classe Responsavel
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
	 * M�todo respons�vel por inserir um novo registro ou atualizar um registro existente
	 * Tabela RESPONSAVEL
	 * @param responsavel - objeto inst�nciado da classe Responsavel
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
