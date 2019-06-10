package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.DbConn;

/**
* Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela PROFESSOR
* Comunica��o com a classe Professor
* @author Simple Solution Devs
*/
public class ProfessorDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * Validar os atributos userProf e senhaProf para o usu�rio poder efetuar o login
	 * Tabela PROFESSOR
	 * @param user - valor recebido para o atributo userProf
	 * @param senha - valor recebido para o atributo senhaProf
	 * @return valor boolean - TRUE (select retornado com sucesso) ou FALSE (select sem retorno ou cadastro inativo)
	 */
	public Professor efetuarLogin(String user, String senha) {
		sql = "SELECT * FROM PROFESSOR WHERE userProf=? AND senhaProf=?";
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setString(1, user.trim());
				dbc.st.setString(2, senha.trim());
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {					
					if (dbc.rs.getString(10).indexOf("A") != -1) {
						Professor prof = new Professor();
						prof.setCodProf(dbc.rs.getInt(1));
						prof.setNomeProf(dbc.rs.getString(2));
						prof.setNascProf(dbc.rs.getDate(3));
						prof.setRgProf(dbc.rs.getString(4));
						prof.setCpfProf(dbc.rs.getString(5));
						prof.setEmailProf(dbc.rs.getString(6));
						prof.setTelProf(dbc.rs.getString(7));
						prof.setUserProf(dbc.rs.getString(8));
										
						return prof;
					}
					else {
						JOptionPane.showMessageDialog(null,"Usuário Inativo");
						return null;
					}
				}
				if (dbc.rs.getRow()==0) {
					JOptionPane.showMessageDialog(null,"Usuário ou Senha inválidos ");
					return null;
				}

			}
			catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
			finally {
				dbc.close();
			}
		}
		return null;
	}
	
	

	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos os professores
	 * @return listaProf - lista de professores (array)
	 */
	public ArrayList<Professor> consultarTodos() {
		sql = "SELECT * FROM PROFESSOR;";
		ArrayList<Professor> listaProf = new ArrayList<Professor>();
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();


					while (dbc.rs.next()) {
						Professor professor = new Professor();
						professor.setCodProf(dbc.rs.getInt(1));
						professor.setNomeProf(dbc.rs.getString(2));
						professor.setNascProf(dbc.rs.getDate(3));
						professor.setRgProf(dbc.rs.getString(4));
						professor.setCpfProf(dbc.rs.getString(5));
						professor.setEmailProf(dbc.rs.getString(6));
						professor.setTelProf(dbc.rs.getString(7));
						professor.setUserProf(dbc.rs.getString(8));
						professor.setSenhaProf(dbc.rs.getString(9));
						professor.setStatusProf(dbc.rs.getString(10));
						listaProf.add(professor);
					}									
				}			
			} 
			catch (SQLException e) {
				listaProf=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaProf;
	}



	/**
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela PROFESSOR
	 * @param professor - objeto inst�nciado da classe Professor
	 * @return professor 
	 */
	public Professor consultar(Professor professor) {
		sql = "SELECT * FROM PROFESSOR WHERE codProf=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, professor.getCodProf());
					dbc.rs = dbc.st.executeQuery();
					while (dbc.rs.next()) {
						professor.setNomeProf(dbc.rs.getString(2));
						professor.setNascProf(dbc.rs.getDate(3));
						professor.setRgProf(dbc.rs.getString(4));
						professor.setCpfProf(dbc.rs.getString(5));
						professor.setEmailProf(dbc.rs.getString(6));
						professor.setTelProf(dbc.rs.getString(7));
						professor.setUserProf(dbc.rs.getString(8));
						professor.setSenhaProf(dbc.rs.getString(9));
						professor.setStatusProf(dbc.rs.getString(10));
					}
				}			
			} 
			catch (SQLException e) {
				professor = null;
			} 
			finally {
				dbc.close();
			}
		}
		return professor; 
	}



	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela PROFESSOR
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX(codProf) FROM PROFESSOR";
		int r = 0;
		if(dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					r = dbc.rs.getInt(1)+1;
				}
				
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
	 * M�todo respons�vel por atualizar o status de algum registro
	 * Tabela PROFESSOR
	 * @param professor - objeto inst�nciado da classe Professor
	 * @return men - mensagem de aviso
	 */
	public String ativarInativar(Professor professor) {
		if(professor.getStatusProf() == "A") {
			sql = "UPDATE PROFESSOR SET statusProf='I' WHERE codProf=?;";
		}
		else {
			sql = "UPDATE PROFESSOR SET statusProf='A' WHERE codProf=?;";
		}
		sql = "UPDATE PROFESSOR SET statusProf WHERE codProf=?;";
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, professor.getCodProf());
				dbc.rs = dbc.st.executeQuery();
				men = "O registro foi atualizado com sucesso";
			}
			catch (SQLException e) {
				men = "Falha: " + e;
			}
			finally {
				dbc.close();
			}
		}
		return men;
	}



	/**
	 * M�todo respons�vel por inserir um novo registro ou atualizar um registro existente
	 * Tabela PROFESSOR
	 * @param professor - objeto inst�nciado da classe Professor
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Professor professor) {
		sql = "INSERT INTO PROFESSOR VALUES(?,?,?,?,?,?,?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, professor.getCodProf());
				dbc.st.setString(2, professor.getNomeProf());
				dbc.st.setDate(3, professor.getNascProf());
				dbc.st.setString(4, professor.getRgProf());
				dbc.st.setString(5, professor.getCpfProf());
				dbc.st.setString(6, professor.getEmailProf());
				dbc.st.setString(7, professor.getTelProf());
				dbc.st.setString(8, professor.getUserProf());
				dbc.st.setString(9, professor.getSenhaProf());
				dbc.st.setString(10, professor.getStatusProf()); 
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE PROFESSOR SET "
						+ "nomeProf=?"
						+ "nascProf=?"
						+ "rgProf=?"
						+ "cpfProf=?"
						+ "emailProf=?"
						+ "telProf=?"
						+ "userProf=?"
						+ "nomeProf=?"
						+ "statusProf=?"
						+ "WHERE codProf=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setString(1, professor.getNomeProf());
						dbc.st.setDate(2, professor.getNascProf());
						dbc.st.setString(3, professor.getRgProf());
						dbc.st.setString(4, professor.getCpfProf());
						dbc.st.setString(5, professor.getEmailProf());
						dbc.st.setString(6, professor.getTelProf());
						dbc.st.setString(7, professor.getUserProf());
						dbc.st.setString(8, professor.getSenhaProf());
						dbc.st.setString(9, professor.getStatusProf());
						dbc.st.setInt(10, professor.getCodProf());
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
