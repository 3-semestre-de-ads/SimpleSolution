package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela ADMINISTRADOR
 * Comunicação com a classe Administrador
 * @author Simple Solution Devs
 */
public class AdministradorDAO {

	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String sql;
	private String men;



	/**
	 * Validar os atributos userAdmin e senhaAdmin para o usuário poder efetuar o login
	 * Tabela ADMINISTRADOR
	 * @param user - valor recebido para o atributo userAdmin
	 * @param senha - valor recebido para o atributo senhaAdmin
	 * @return valor boolean - TRUE (select retornado com sucesso) ou FALSE (select sem retorno ou cadastro inativo)
	 */
	public boolean efetuarLogin(String user, String senha) {
		sql = "SELECT statusAdmin FROM ADMINISTRADOR WHERE userAdmin=? AND senhaAdmin=?";
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setString(1, user.trim());
				dbc.st.setString(2, senha.trim());
				dbc.rs = dbc.st.executeQuery();
				String res = dbc.rs.toString();
				if(res == "A") { 
					return true;
				}
				else {
					JOptionPane.showMessageDialog(null,"Usuário inativo", "Login Administrador", 1);
					return false;
				}
			}
			catch (SQLException e) {
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
				return false;
			}
			finally {
				dbc.close();
			}
		}
		return false;
	}


	
	/**
	 * Método responsável por retornar uma lista com o registro de todos os administradores
	 * @return listaAdmin - lista de administradores (array)
	 */
	public Administrador[] consultarTodos() {
		sql = "SELECT * FROM ADMINISTRADOR;";
		Administrador[] listaAdmin = new Administrador[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaAdmin = new Administrador[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) { 
						Administrador administrador = listaAdmin[count];
						administrador.setCodAdmin(dbc.rs.getInt(1));
						administrador.setUserAdmin(dbc.rs.getString(2));
						administrador.setSenhaAdmin(dbc.rs.getString(3));
						administrador.setStatusAdmin(dbc.rs.getString(4));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaAdmin = null; 
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaAdmin;
	}
	
	
	
	/**
	 * Método que retorna o próximo número do índice no banco de dados
	 * Tabela ADMINISTRADOR
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codAdmin') FROM ADMINISTRADOR;";
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
	 * Método responsável por atualizar o status de algum registro
	 * Tabela ADMINISTRADOR
	 * @param administrador - objeto instânciado da classe Administrador
	 * @return men - mensagem de aviso
	 */
	public String ativarInativar(Administrador administrador) {
		if (administrador.getStatusAdmin() == "A") {
			sql = "UPDATE ADMINISTRADOR SET statusAdmin='I' WHERE codAdmin=?;";
		}
		else {
			sql = "UPDATE ADMINISTRADOR SET statusAdmin='A' WHERE codAdmin=?;";
		}
		sql = "UPDATE ADMINISTRADOR SET statusAdmin WHERE codAdmin=?;";
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, administrador.getCodAdmin());
				dbc.rs = dbc.st.executeQuery();
				men = "O registro foi atualizado com sucesso";
			} 
			catch (SQLException e) {
				men = "Falha: "+ e;
			}
			finally {
				dbc.close();
			}
		}
		return men;
	}




	/**
	 * Método responsável por inserir um novo registro ou atualizar um registro existente
	 * Tabela ADMINISTRADOR
	 * @param administrador - objeto instânciado da classe Administrador
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Administrador administrador) {
		sql = "INSERT INTO ADMINISTRADOR VALUES(?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, administrador.getCodAdmin());
				dbc.st.setString(2, administrador.getUserAdmin());
				dbc.st.setString(3, administrador.getSenhaAdmin());
				dbc.st.setString(4, administrador.getStatusAdmin());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE ADMINISTRADOR SET "
						+ "userAdmin=?"
						+ "senhaAdmin=?"
						+ "statusAdmin=?"
						+ "WHERE codAdmin=?";
				if (dbc.getConnection()) {
					try {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setString(1, administrador.getUserAdmin());
						dbc.st.setString(2, administrador.getSenhaAdmin());
						dbc.st.setString(3, administrador.getStatusAdmin());
						dbc.st.setInt(4, administrador.getCodAdmin());
						dbc.rs = dbc.st.executeQuery();
						men = "Atualizado com sucesso";
					}
					catch (SQLException e2) {
						men = "Falha: " + e2;
					}	
				}
			}
			finally {
				dbc.close();
			}
		}
		return men;
	}

}
