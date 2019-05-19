package model;

import java.sql.SQLException;

import services.DbConn;

public class AlunoDAO {
	private DbConn dbc = new DbConn();
	private String men, sql;

	public Aluno[] consultaTodos() {
		sql = "SELECT * FROM ALUNO;";
		Aluno[] lista_alunos = new Aluno[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();

					dbc.rs.last();
					lista_alunos = new Aluno[dbc.rs.getRow()];
					dbc.rs.beforeFirst();

					for (int i = 0; i < lista_alunos.length; i++) {
						Aluno aluno = lista_alunos[i];
						aluno.setCodAluno(dbc.rs.getInt(1));
						aluno.setNomeAluno(dbc.rs.getString(2));
						aluno.setNascAluno(dbc.rs.getDate(3));
						aluno.setRgAluno(dbc.rs.getString(4));
						aluno.setCpfAluno(dbc.rs.getString(5));
						aluno.setEmailAluno(dbc.rs.getString(6));
						aluno.setTeleAluno(dbc.rs.getString(7));
						aluno.setStatusAluno(dbc.rs.getString(9));
						aluno.setCodResponsavel(dbc.rs.getInt(10));
					}									

				}			
			} catch (SQLException e) {

			} finally {
				dbc.close();
			}
		}
		return lista_alunos;
	}

	public Aluno consulta(Aluno a) {
		sql = "SELECT * FROM ALUNO WHERE codAluno=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, a.getCodAluno());
					dbc.rs = dbc.st.executeQuery();
					a.setNomeAluno(dbc.rs.getString(2));
					a.setNascAluno(dbc.rs.getDate(3));
					a.setRgAluno(dbc.rs.getString(4));
					a.setCpfAluno(dbc.rs.getString(5));
					a.setEmailAluno(dbc.rs.getString(6));
					a.setTeleAluno(dbc.rs.getString(7));
					a.setStatusAluno(dbc.rs.getString(9));
					a.setCodResponsavel(dbc.rs.getInt(10));
				}			
			} catch (SQLException e) {
				a = null;
			} finally {
				dbc.close();
			}
		}

		return a;
	}

	public int proximoId() {
		sql = "SELECT IDENT_CURRENT('ALUNO')";
		int r = 0;
		if(dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.rs = dbc.st.executeQuery();
				r = dbc.rs.getInt(1)+1;
			} catch (SQLException e) {
				// TODO: handle exception
			} finally {
				dbc.close();
			}
		}
		return r;
	}
}
