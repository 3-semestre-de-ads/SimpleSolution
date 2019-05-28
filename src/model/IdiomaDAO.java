package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela IDIOMA
 * Comunicação com a classe Idioma
 * @author Simple Solution Devs
 */
public class IdiomaDAO {

	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;
	
	
	
	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela IDIOMA
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codIdioma') FROM IDIOMA;";
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
	 * Método responsável por retornar uma lista com o registro de todos os idiomas
	 * @return lista_idioma - lista de idiomas (array)
	 */
	public Idioma[] consultarTodos() {
		sql = "SELECT * FROM IDIOMA;";
		Idioma[] listaIdioma = new Idioma[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaIdioma = new Idioma[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count = 0;
					while (dbc.rs.next()) { 
						Idioma idioma = listaIdioma[count];
						idioma.setCodIdioma(dbc.rs.getInt(1));
						idioma.setNomeIdioma(dbc.rs.getString(2));
						idioma.setNivelIdioma(dbc.rs.getString(3));
						count ++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaIdioma=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaIdioma;
	}
	
	
	
	/**
	 * Método responsável por retornar um registro de acordo com o código fornecido
	 * Tabela IDIOMA
	 * @param idioma - objeto instânciado da classe Idioma
	 * @return idioma 
	 */
	public Idioma consultar(Idioma idioma) {
		sql = "SELECT * FROM IDIOMA WHERE codIdioma=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, idioma.getCodIdioma());
					dbc.rs = dbc.st.executeQuery();
					idioma.setNomeIdioma(dbc.rs.getString(2));
					idioma.setNivelIdioma(dbc.rs.getString(3));
				}			
			} 
			catch (SQLException e) {
				idioma = null;
			} 
			finally {
				dbc.close();
			}
		}
		return idioma; 
	}
	
	
	
	/**
	 * Método responsável por inserir um novo registro ou atualizar um registro existente
	 * Tabela IDIOMA
	 * @param idioma - objeto instânciado da classe Idioma
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Idioma idioma) {
		sql = "INSERT INTO IDIOMA VALUES(?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, idioma.getCodIdioma());
				dbc.st.setString(2, idioma.getNomeIdioma());
				dbc.st.setString(3, idioma.getNivelIdioma());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE IDIOMA SET "
						+ "nomeIdioma=?"
						+ "nivelIdioma=?"
						+ "WHERE codIdioma=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setString(1, idioma.getNomeIdioma());
						dbc.st.setString(2, idioma.getNivelIdioma());
						dbc.st.setInt(3, idioma.getCodIdioma());
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
