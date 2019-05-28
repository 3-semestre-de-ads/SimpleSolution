package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela MATRICULA
 * Comunicação com a classe Matricula
 * @author Simple Solution Devs
 */
public class MatriculaDAO {

	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * Método responsável por retornar uma lista com o registro de todos as matriculas
	 * @return listaMat - lista de matriculas (array)
	 */
	public Matricula[] consultarTodos() {
		sql = "SELECT * FROM MATRICULA;";
		Matricula[] listaMat = new Matricula[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaMat = new Matricula[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) {
						Matricula matricula = listaMat[count];
						matricula.setCodMat(dbc.rs.getInt(1));
						matricula.setDataInMat(dbc.rs.getDate(2));
						matricula.setDataFiMat(dbc.rs.getDate(3));
						matricula.setCodAluno(dbc.rs.getInt(4));
						matricula.setCodTurma(dbc.rs.getInt(5));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaMat=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaMat;
	}



	/**
	 * Método responsável por retornar um registro de acordo com o código fornecido
	 * Tabela MATRICULA
	 * @param matricula - objeto instânciado da classe Matricula
	 * @return matricula
	 */
	public Matricula consultar(Matricula matricula) {
		sql = "SELECT * FROM MATRICULA WHERE codMat=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, matricula.getCodMat());
					dbc.rs = dbc.st.executeQuery();
					matricula.setDataInMat(dbc.rs.getDate(2));
					matricula.setDataFiMat(dbc.rs.getDate(3));
					matricula.setCodAluno(dbc.rs.getInt(4));
					matricula.setCodTurma(dbc.rs.getInt(5));
				}			
			} 
			catch (SQLException e) {
				matricula = null;
			} 
			finally {
				dbc.close();
			}
		}
		return matricula; 
	}



	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela MATRICULA
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codMat') FROM MATRICULA;";
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


	
	/**
	 * Método responsável por inserir um novo registro ou atualizar um registro existente
	 * Tabela MATRICULA
	 * @param matricula - objeto instânciado da classe Matricula
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Matricula matricula) {
		sql = "INSERT INTO MATRICULA VALUES(?,?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, matricula.getCodMat());
				dbc.st.setDate(2, matricula.getDataInMat());
				dbc.st.setDate(3, matricula.getDataFiMat());
				dbc.st.setInt(4, matricula.getCodAluno());
				dbc.st.setInt(5, matricula.getCodTurma());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE MATRICULA SET "
						+ "dataInMat=?"
						+ "valorFiMat=?"
						+ "codAluno=?"
						+ "codTurma=?"
						+ "WHERE codMat=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setDate(1, matricula.getDataInMat());
						dbc.st.setDate(2, matricula.getDataFiMat());
						dbc.st.setInt(3, matricula.getCodAluno());
						dbc.st.setInt(4, matricula.getCodTurma());
						dbc.st.setInt(5, matricula.getCodMat());
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
