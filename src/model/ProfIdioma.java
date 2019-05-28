package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a ProfIdioma
 * @author Simple Solution Devs
 */
public class ProfIdioma {

	/**
	 * Atributos da classe (colunas da tabela PROFIDIOMA)
	 */
	private int codPI;
	private int codProf;
	private int codIdioma;
	
	
	
	/**
	 * Método construtor 1
	 */
	public ProfIdioma() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codPI
	 */
	public ProfIdioma(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM PROFIDIOMA WHERE codPI="+codigo+";");
		try {
			while (rs.next()) {
				setCodPI(Integer.parseInt(rs.getString(1).toString()));
				setCodProf(Integer.parseInt(rs.getString(4).toString()));
				setCodIdioma(Integer.parseInt(rs.getString(5).toString()));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}


	
	/**
	 * Método responsável por retornar o valor do codPI
	 * @return codPI - valor do atributo
	 */
	public int getCodPI() {
		return codPI;
	}
	/**
	 * Método responsável por estabelecer o valor de codPI e validar o mesmo
	 * @param codPI - valor do atributo
	 */
	public void setCodPI(int codPI) {
		try {
			if(codPI == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Professor Idioma", 1);
			}
			else {
				this.codPI = codPI;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Professor Idioma", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do codProf
	 * @return codProf - valor do atributo
	 */
	public int getCodProf() {
		return codProf;
	}
	/**
	 * Método responsável por estabelecer o valor de codProf e validar o mesmo
	 * @param codProf - valor do atributo
	 */
	public void setCodProf(int codProf) {
		try {
			if(codProf == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Professor", 1);
			}
			else {
				this.codProf = codProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Professor", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do codIdioma
	 * @return codIdioma - valor do atributo
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
	
	
	
}
