package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import services.DbConn;

public class ResponsavelDAO {
	private DbConn dbc = new DbConn();
	private String men, sql;
	
	
	/**
	 * Função que retorna o proximo ID, usada na criação de um novo objeto
	 * @return int
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
	 * Função para consultar objetos
	 * @param none
	 * @return Responsavel[]
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
						responsavel.setTelefoneResp(dbc.rs.getString(7));
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
	 * Função para popular o objeto
	 * @param responsavel
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
					responsavel.setTelefoneResp(dbc.rs.getString(7));
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
	 * Função para ativar ou inativar o usuãrio
	 * @param responsavel
	 * @return String
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
	 * Insere ou cria um novo responsavel.
	 * @model.Responsavel
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
				dbc.st.setString(7, responsavel.getTelefoneResp());
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
						dbc.st.setString(6, responsavel.getTelefoneResp());
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
