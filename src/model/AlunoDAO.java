package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela ALUNO
 * Comunica��o com a classe Aluno
 * @author Simple Solution Devs
 */
public class AlunoDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;



	/**
	 * Validar os atributos userAluno e senhaAluno para o usu�rio poder efetuar o login
	 * Tabela ALUNO
	 * @param user - valor recebido para o atributo userAluno
	 * @param senha - valor recebido para o atributo senhaAluno
	 * @return valor boolean - TRUE (select retornado com sucesso) ou FALSE (select sem retorno ou cadastro inativo)
	 */
	public Aluno efetuarLogin(String user, String senha) {
		sql = "SELECT * FROM ALUNO WHERE userAluno=? AND senhaAluno=?";
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setString(1, user.trim());
				dbc.st.setString(2, senha.trim());
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					System.out.println(dbc.rs.getString(1));
					if (dbc.rs.getString(10).indexOf("A") != -1) {
						Aluno aluno = new Aluno();
						aluno.setCodAluno(dbc.rs.getInt(1));
						aluno.setNomeAluno(dbc.rs.getString(2));
						aluno.setNascAluno(dbc.rs.getDate(3));
						aluno.setRgAluno(dbc.rs.getString(4));
						aluno.setCpfAluno(dbc.rs.getString(5));
						aluno.setEmailAluno(dbc.rs.getString(6));
						aluno.setTelAluno(dbc.rs.getString(7));
						aluno.setUserAluno(dbc.rs.getString(8));
						aluno.setSenhaAluno(dbc.rs.getString(9));
						aluno.setStatusAluno(dbc.rs.getString(10));
						aluno.setCodResp(dbc.rs.getInt(11));
						return aluno;
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
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
				return null;
			}
			finally {
				dbc.close();
			}
		}
		return null;
	}



	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos os alunos
	 * @return listaAluno - lista de alunos (array)
	 */
	public Aluno[] consultarTodos() {
		sql = "SELECT * FROM ALUNO;";
		Aluno[] listaAluno = new Aluno[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaAluno = new Aluno[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) { 
						Aluno aluno = listaAluno[count];
						aluno.setCodAluno(dbc.rs.getInt(1));
						aluno.setNomeAluno(dbc.rs.getString(2));
						aluno.setNascAluno(dbc.rs.getDate(3));
						aluno.setRgAluno(dbc.rs.getString(4));
						aluno.setCpfAluno(dbc.rs.getString(5));
						aluno.setEmailAluno(dbc.rs.getString(6));
						aluno.setTelAluno(dbc.rs.getString(7));
						aluno.setUserAluno(dbc.rs.getString(8));
						aluno.setSenhaAluno(dbc.rs.getString(9));
						aluno.setStatusAluno(dbc.rs.getString(10));
						aluno.setCodResp(dbc.rs.getInt(11));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaAluno = null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaAluno;
	}



	/**
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela ALUNO
	 * @param aluno - objeto inst�nciado da classe Aluno
	 * @return aluno 
	 */
	public Aluno consultar(Aluno aluno) {
		sql = "SELECT * FROM ALUNO WHERE codAluno=?;";
		if (dbc.getConnection()) {
			try {

				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, aluno.getCodAluno());
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					aluno.setNomeAluno(dbc.rs.getString(2));
					aluno.setNascAluno(dbc.rs.getDate(3));
					aluno.setRgAluno(dbc.rs.getString(4));
					aluno.setCpfAluno(dbc.rs.getString(5));
					aluno.setEmailAluno(dbc.rs.getString(6));
					aluno.setTelAluno(dbc.rs.getString(7));
					aluno.setUserAluno(dbc.rs.getString(8));
					aluno.setSenhaAluno(dbc.rs.getString(9));
					aluno.setStatusAluno(dbc.rs.getString(10));
					aluno.setCodResp(dbc.rs.getInt(11));
				}
			} 
			catch (SQLException e) {				
				aluno = null;
			} 
			finally {
				dbc.close();
			}
		}
		return aluno; 
	}



	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela ALUNO
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX(codAluno) FROM ALUNO;";
		int r = 0;
		if(dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.rs = dbc.st.executeQuery();
				while(dbc.rs.next()) {
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
	 * Tabela ALUNO
	 * @param aluno - objeto inst�nciado da classe Aluno
	 * @return men - mensagem de aviso
	 */
	public String ativarInativar(Aluno aluno) {
		if(aluno.getStatusAluno() == "A") {
			sql = "UPDATE ALUNO SET statusAluno='I' WHERE codAluno=?;";
		}
		else {
			sql = "UPDATE ALUNO SET statusAluno='A' WHERE codAluno=?;";
		}
		sql = "UPDATE ALUNO SET statusAluno WHERE codAluno=?;";
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, aluno.getCodAluno());
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
	 * Tabela ALUNO
	 * @param aluno - objeto inst�nciado da classe Aluno
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Aluno aluno) {
		sql = "INSERT INTO ALUNO VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, aluno.getCodAluno());
				dbc.st.setString(2, aluno.getNomeAluno());
				dbc.st.setDate(3, aluno.getNascAluno());
				dbc.st.setString(4, aluno.getRgAluno());
				dbc.st.setString(5, aluno.getCpfAluno());
				dbc.st.setString(6, aluno.getEmailAluno());
				dbc.st.setString(7, aluno.getTelAluno());
				dbc.st.setString(8, aluno.getUserAluno());
				dbc.st.setString(9, aluno.getSenhaAluno());
				dbc.st.setString(10, aluno.getStatusAluno()); 
				dbc.st.setInt(11, aluno.getCodResp());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE ALUNO SET "
						+ "nomeAluno=?"
						+ "nascAluno=?"
						+ "rgAluno=?"
						+ "cpfAluno=?"
						+ "emailAluno=?"
						+ "telAluno=?"
						+ "userAluno=?"
						+ "nomeAluno=?"
						+ "statusAluno=?"
						+ "codResp=?"
						+ "WHERE codAluno=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setString(1, aluno.getNomeAluno());
						dbc.st.setDate(2, aluno.getNascAluno());
						dbc.st.setString(3, aluno.getRgAluno());
						dbc.st.setString(4, aluno.getCpfAluno());
						dbc.st.setString(5, aluno.getEmailAluno());
						dbc.st.setString(6, aluno.getTelAluno());
						dbc.st.setString(7, aluno.getUserAluno());
						dbc.st.setString(8, aluno.getSenhaAluno());
						dbc.st.setString(9, aluno.getStatusAluno()); 
						dbc.st.setInt(10, aluno.getCodResp()); 
						dbc.st.setInt(11, aluno.getCodAluno());
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
