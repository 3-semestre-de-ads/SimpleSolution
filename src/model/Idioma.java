package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Idioma
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
	 * M�todo respons�vel por retornar o valor do codIdioma
	 * @return o codIdioma
	 */
	public int getCodIdioma() {
		return codIdioma;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codIdioma e validar o mesmo
	 * @param codIdioma - valor do atributo
	 */
	public void setCodIdioma(int codIdioma) {
		try {
			if(codIdioma == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Idioma", 1);
			}
			else {
				this.codIdioma = codIdioma;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Idioma", 1);
		}
	}
	
	
	
	/**
	 * M�todo respons�vel por retornar o valor do nomeIdioma
	 * @return o nomeIdioma - valor do atributo
	 */
	public String getNomeIdioma() {
		return nomeIdioma;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nomeIdioma e validar o mesmo
	 * @param nomeIdioma - valor do atributo
	 */
	public void setNomeIdioma(String nomeIdioma) {
		if(nomeIdioma.length() > 10 || nomeIdioma == null || nomeIdioma == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Idioma", 1);
		}
		else {
			this.nomeIdioma = nomeIdioma;
		}
	}
	
	
	
	/**
	 * M�todo respons�vel por retornar o valor do nivelIdioma
	 * @return o nivelIdioma - valor do atributo
	 */
	public String getNivelIdioma() {
		return nivelIdioma;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nivelIdioma e validar o mesmo
	 * @param nivelIdioma - valor do atributo
	 */
	public void setNivelIdioma(String nivelIdioma) {
		if(nivelIdioma.length() > 10 || nivelIdioma == null || nivelIdioma == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "N�vel Idioma", 1);
		}
		else {
			this.nivelIdioma = nivelIdioma;
		}
	}
}
