package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Idioma
 * @author Simple Solution Devs
 */
public class Idioma {
	
	/**
	 * Atributos da classe (colunas da tabela IDIOMA)
	 */
	private int codIdioma;
	private String nomeIdioma;
	private String nivelIdioma;
	
	
	
	/**
	 * Método construtor 1
	 */
	public Idioma() {
	}



	//????
	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codIdioma
	 */
	public Idioma(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM IDIOMA WHERE codIdioma="+codigo+";");
		try {
			while (rs.next()) {
				setCodIdioma(Integer.parseInt(rs.getString(1).toString()));
				setNomeIdioma(rs.getString(2).toString());
				setNivelIdioma(rs.getString(4).toString());		
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	
	/**
	 * Método responsável por retornar o valor do codIdioma
	 * @return o codIdioma
	 */
	public int getCodIdioma() {
		return codIdioma;
	}
	/**
	 * Método responsável por estabelecer o valor de codIdioma e validar o mesmo
	 * @param codIdioma - valor do atributo
	 */
	public void setCodIdioma(int codIdioma) {
		try {
			if(codIdioma == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Idioma", 1);
			}
			else {
				this.codIdioma = codIdioma;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Idioma", 1);
		}
	}
	
	
	
	/**
	 * Método responsável por retornar o valor do nomeIdioma
	 * @return o nomeIdioma - valor do atributo
	 */
	public String getNomeIdioma() {
		return nomeIdioma;
	}
	/**
	 * Método responsável por estabelecer o valor de nomeIdioma e validar o mesmo
	 * @param nomeIdioma - valor do atributo
	 */
	public void setNomeIdioma(String nomeIdioma) {
		if(nomeIdioma.length() < 10 || nomeIdioma == null || nomeIdioma == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Idioma", 1);
		}
		else {
			this.nomeIdioma = nomeIdioma;
		}
	}
	
	
	
	/**
	 * Método responsável por retornar o valor do nivelIdioma
	 * @return o nivelIdioma - valor do atributo
	 */
	public String getNivelIdioma() {
		return nivelIdioma;
	}
	/**
	 * Método responsável por estabelecer o valor de nivelIdioma e validar o mesmo
	 * @param nivelIdioma - valor do atributo
	 */
	public void setNivelIdioma(String nivelIdioma) {
		if(nivelIdioma.length() < 10 || nivelIdioma == null || nivelIdioma == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nível Idioma", 1);
		}
		else {
			this.nivelIdioma = nivelIdioma;
		}
	}
}
