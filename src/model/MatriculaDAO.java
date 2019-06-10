package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela MATRICULA
 * Comunica��o com a classe Matricula
 * @author Simple Solution Devs
 */
public class MatriculaDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos as matriculas
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
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela MATRICULA
	 * @param matricula - objeto inst�nciado da classe Matricula
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
	
	public ArrayList<Matricula> consultaMatriculaByAluno(int codAluno){
		sql = "SELECT * FROM MATRICULA WHERE codAluno=?;";
		ArrayList<Matricula> lista = new ArrayList<Matricula>();
		try {
			if (dbc.getConnection()) {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, codAluno);
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					Matricula matricula = new Matricula();
					matricula.setCodMat(dbc.rs.getInt(1));
					matricula.setDataInMat(dbc.rs.getDate(2));
					matricula.setDataFiMat(dbc.rs.getDate(3));
					matricula.setCodAluno(codAluno);
					matricula.setCodTurma(dbc.rs.getInt(5));
					lista.add(matricula);
				}
			}			
		} 
		catch (SQLException e) {
			lista = null;
		} 
		finally {
			dbc.close();
		}
		
		return lista;
	}
	
	public int alunosNaTurma(Turma turma) {
		sql = "SELECT * FROM MATRICULA WHERE codMat=?;";
		int count = 0;
		try {
			if (dbc.getConnection()) {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, turma.getCodTurma());
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					count++;
				}
			}			
		} 
		catch (SQLException e) {
			count = -1;
		} 
		finally {
			dbc.close();
		}
		
		return count;
	}
	
	public ArrayList<Integer> consultaAlunosByTurma(int codTurma){
		sql = "SELECT * FROM MATRICULA WHERE codTurma=?;";
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			if (dbc.getConnection()) {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, codTurma);
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					lista.add(dbc.rs.getInt(4));
				}
			}			
		} 
		catch (SQLException e) {
			lista = null;
		} 
		finally {
			dbc.close();
		}
		
		return lista;
	}
	
	public ArrayList<Integer> consultaTurmaByAluno(int codAluno){
		sql = "SELECT * FROM MATRICULA WHERE codAluno=?;";
		ArrayList<Integer> lista = new ArrayList<Integer>();
		try {
			if (dbc.getConnection()) {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, codAluno);
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					lista.add(dbc.rs.getInt(5));
				}
			}			
		} 
		catch (SQLException e) {
			lista = null;
		} 
		finally {
			dbc.close();
		}
		
		return lista;
	}




	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela MATRICULA
	 * @return r - valor do pr�ximo �ndice
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
	 * M�todo respons�vel por inserir um novo registro ou atualizar um registro existente
	 * Tabela MATRICULA
	 * @param matricula - objeto inst�nciado da classe Matricula
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
