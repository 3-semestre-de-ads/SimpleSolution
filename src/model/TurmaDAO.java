package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Turma
 * @author Simple Solution Devs
 */
public class TurmaDAO {
	
	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos as turmas
	 * @return listaTurma - lista de turmas (array)
	 */
	public ArrayList<Turma> consultarTodos() {
		sql = "SELECT * FROM TURMA;";
		ArrayList<Turma> listaTurma = new ArrayList<Turma>();
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();

					while (dbc.rs.next()) { 
						Turma turma = new Turma();
						turma.setCodTurma(dbc.rs.getInt(1));
						turma.setQtdAulaTurma(dbc.rs.getInt(2));
						turma.setHorarioTurma(dbc.rs.getString(3));
						turma.setDiaTurma(dbc.rs.getString(4));
						turma.setCodIdioma(dbc.rs.getInt(5));
						turma.setCodTE(dbc.rs.getInt(6));
						listaTurma.add(turma);
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
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela TURMA
	 * @param turma - objeto inst�nciado da classe Turma
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
					while (dbc.rs.next()) {
						turma.setQtdAulaTurma(dbc.rs.getInt(2));
						turma.setHorarioTurma(dbc.rs.getString(3));
						turma.setDiaTurma(dbc.rs.getString(4));
						turma.setCodIdioma(dbc.rs.getInt(5));
						turma.setCodTE(dbc.rs.getInt(6));
					}
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
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela TURMA
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX(codTurma) FROM TURMA;";
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
	 * M�todo respons�vel por inserir um novo registro ou atualizar um registro existente
	 * Tabela TURMA
	 * @param turma - objeto inst�nciado da classe Nota
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
