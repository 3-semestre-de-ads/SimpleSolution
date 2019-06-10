package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela NOTA
 * Comunica��o com a classe Nota
 * @author Simple Solution Devs
 */
public class NotaDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos as notas
	 * @return listaNota - lista de notas (array)
	 */
	public Nota[] consultarTodos() {
		sql = "SELECT * FROM NOTA;";
		Nota[] listaNota = new Nota[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaNota = new Nota[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) {
						Nota nota = listaNota[count];
						nota.setCodNota(dbc.rs.getInt(1));
						nota.setDataNota(dbc.rs.getDate(2));
						nota.setValorNota(dbc.rs.getDouble(3));
						nota.setCodMat(dbc.rs.getInt(4));
						nota.setCodAval(dbc.rs.getInt(5));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaNota=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaNota;
	}
	
	public ArrayList<Nota> consultarByMatricula(int codMatricula) {
		sql = "SELECT * FROM NOTA WHERE codMat=?;";
		ArrayList<Nota> listaNota = new ArrayList<Nota>();

		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, codMatricula);
					dbc.rs = dbc.st.executeQuery();

					while (dbc.rs.next()) {
						Nota nota = new Nota();
						nota.setCodNota(dbc.rs.getInt(1));
						nota.setDataNota(dbc.rs.getDate(2));
						nota.setValorNota(dbc.rs.getDouble(3));
						nota.setCodMat(dbc.rs.getInt(4));
						nota.setCodAval(dbc.rs.getInt(5));
						listaNota.add(nota);
					}									
				}			
			} 
			catch (SQLException e) {
				listaNota=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaNota;
	}



	/**
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela NOTA
	 * @param nota - objeto inst�nciado da classe Nota
	 * @return nota
	 */
	public Nota consultar(Nota nota) {
		sql = "SELECT * FROM NOTA WHERE codNota=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, nota.getCodNota());
					dbc.rs = dbc.st.executeQuery();
					nota.setDataNota(dbc.rs.getDate(2));
					nota.setValorNota(dbc.rs.getDouble(3));
					nota.setCodMat(dbc.rs.getInt(4));
					nota.setCodAval(dbc.rs.getInt(5));
				}			
			} 
			catch (SQLException e) {
				nota = null;
			} 
			finally {
				dbc.close();
			}
		}
		return nota; 
	}



	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela NOTA
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codNota') FROM NOTA;";
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
	 * Tabela NOTA
	 * @param nota - objeto inst�nciado da classe Nota
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Nota nota) {
		sql = "INSERT INTO NOTA VALUES(?,?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, nota.getCodNota());
				dbc.st.setDate(2, nota.getDataNota());
				dbc.st.setDouble(3, nota.getValorNota());
				dbc.st.setInt(4, nota.getCodMat());
				dbc.st.setInt(5, nota.getCodAval());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE NOTA SET "
						+ "dataNota=?"
						+ "valorNota=?"
						+ "codMat=?"
						+ "codAval=?"
						+ "WHERE codNota=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setDate(1, nota.getDataNota());
						dbc.st.setDouble(2, nota.getValorNota());
						dbc.st.setInt(3, nota.getCodMat());
						dbc.st.setInt(4, nota.getCodAval());
						dbc.st.setInt(5, nota.getCodNota());
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
