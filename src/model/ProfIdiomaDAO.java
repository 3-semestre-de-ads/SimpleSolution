package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela PROFIDIOMA
 * Comunica��o com a classe ProfIdioma
 * @author Simple Solution Devs
 */
public class ProfIdiomaDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos as rela��es professor idioma
	 * @return listaPI - lista de professor idioma (array)
	 */
	public ProfIdioma[] consultarTodos() {
		sql = "SELECT * FROM PROFIDIOMA;";
		ProfIdioma[] listaPI = new ProfIdioma[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaPI = new ProfIdioma[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) { 
						ProfIdioma pi = listaPI[count];
						pi.setCodPI(dbc.rs.getInt(1));
						pi.setCodProf(dbc.rs.getInt(2));
						pi.setCodIdioma(dbc.rs.getInt(3));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaPI=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaPI;
	}



	/**
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela PROFIDIOMA
	 * @param pi - objeto inst�nciado da classe ProfIdioma
	 * @return pi
	 */
	public ProfIdioma consultar(ProfIdioma pi) {
		sql = "SELECT * FROM PROFIDIOMA WHERE codPI=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, pi.getCodPI());
					dbc.rs = dbc.st.executeQuery();
					pi.setCodProf(dbc.rs.getInt(2));
					pi.setCodIdioma(dbc.rs.getInt(3));
				}			
			} 
			catch (SQLException e) {
				pi = null;
			} 
			finally {
				dbc.close();
			}
		}
		return pi; 
	}



	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela PROFIDIOMA
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codPI') FROM PROFIDIOMA;";
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
	 * Tabela PROFIDIOMA
	 * @param pi - objeto inst�nciado da classe ProfIdioma
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(ProfIdioma pi) {
		sql = "INSERT INTO PROFIDIOMA VALUES(?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, pi.getCodPI());
				dbc.st.setInt(2, pi.getCodProf());
				dbc.st.setInt(3, pi.getCodIdioma());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE PROFIDIOMA SET "
						+ "codProf=?"
						+ "codIdioma=?"
						+ "WHERE codPI=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setInt(1, pi.getCodProf());
						dbc.st.setInt(2, pi.getCodIdioma());
						dbc.st.setInt(3, pi.getCodPI());
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
