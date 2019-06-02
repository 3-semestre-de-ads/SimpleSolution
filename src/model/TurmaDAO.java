package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Turma
 * @author Simple Solution Devs
 */
public class TurmaDAO {
	
	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * Método responsável por retornar uma lista com o registro de todos as turmas
	 * @return listaTurma - lista de turmas (array)
	 */
	public Turma[] consultarTodos() {
		sql = "SELECT * FROM TURMA;";
		Turma[] listaTurma = new Turma[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaTurma = new Turma[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) { 
						Turma turma = listaTurma[count];
						turma.setCodTurma(dbc.rs.getInt(1));
						turma.setQtdAulaTurma(dbc.rs.getInt(2));
						turma.setHorarioTurma(dbc.rs.getString(3));
						turma.setDiaTurma(dbc.rs.getString(4));
						turma.setCodIdioma(dbc.rs.getInt(5));
						turma.setCodTE(dbc.rs.getInt(6));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaTurma=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaTurma;
	}



	/**
	 * Método responsável por retornar um registro de acordo com o código fornecido
	 * Tabela TURMA
	 * @param turma - objeto instânciado da classe Turma
	 * @return turma
	 */
	public Turma consultar(Turma turma) {
		sql = "SELECT * FROM TURMA WHERE codTurma=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, turma.getCodTurma());
					dbc.rs = dbc.st.executeQuery();
					//mensalidade.setNomeAluno(dbc.rs.getString(2));
					//mensalidade.setNomeAluno(dbc.rs.getString(3));
					//mensaldiade.setNascAluno(dbc.rs.getDate(4));
				}			
			} 
			catch (SQLException e) {
				turma = null;
			} 
			finally {
				dbc.close();
			}
		}
		return turma; 
	}



	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela TURMA
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codTurma') FROM TURMA;";
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
	 * Tabela TURMA
	 * @param turma - objeto instânciado da classe Nota
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Turma turma) {
		sql = "INSERT INTO TURMA VALUES(?,?,?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, turma.getCodTurma());
				dbc.st.setInt(2, turma.getQtdAulaTurma());
				dbc.st.setString(3, turma.getHorarioTurma());
				dbc.st.setString(4, turma.getDiaTurma());
				dbc.st.setInt(5, turma.getCodIdioma());
				dbc.st.setInt(6, turma.getCodTE());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE TURMA SET "
						+ "qtdAulaTurma=?"
						+ "horarioTurma=?"
						+ "diaTurma=?"
						+ "codIdioma=?"
						+ "codTE=?"
						+ "WHERE codTurma=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setInt(1, turma.getQtdAulaTurma());
						dbc.st.setString(2, turma.getHorarioTurma());
						dbc.st.setString(3, turma.getDiaTurma());
						dbc.st.setInt(4, turma.getCodIdioma());
						dbc.st.setInt(5, turma.getCodTE());
						dbc.st.setInt(6, turma.getCodTurma());
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
