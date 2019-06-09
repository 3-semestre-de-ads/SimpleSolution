package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Avalia��o
 * @author Simple Solution Devs
 */
public class Avaliacao {

	/**
	 * Atributos da classe (colunas da tabela AVALIACAO)
	 */
	private int codAval;
	private String nomeAval;
	private double valorAval;
	private int codAdmin;



	/**
	 * M�todo respons�vel por retornar o valor do codAval
	 * @return codAval - valor do atributo
	 */
	public int getCodAval() {
		return codAval;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codAval e validar o mesmo
	 * @param codAval - valor do atributo
	 */
	public void setCodAval(int codAval) {
		try {
			this.codAval = codAval;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Avalia��o", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do nomeAval
	 * @return nomeAval - valor do atributo
	 */
	public String getNomeAval() {
		return nomeAval;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nomeAval e validar o mesmo
	 * @param nomeAval - valor do atributo
	 */
	public void setNomeAval(String nomeAval) {
		if(nomeAval.length() < 10 || nomeAval == null || nomeAval == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Avalia��o", 1);
		}
		else {
			this.nomeAval = nomeAval;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do valorAval
	 * @return valorAval - valor do atributo
	 */
	public double getValorAval() {
		return valorAval;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de valorAval e validar o mesmo
	 * @param valorAval
	 */
	public void setValorAval(double valorAval) {
		try {
			this.valorAval = valorAval;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "Nota Avalia��o", 1);
		}
	}



	//SELECT PARA VALIDAR codAdmin
	/**
	 * M�todo respons�vel por retornar o valor do codAdmin
	 * @return codAdmin - valor do atributo
	 */
	public int getCodAdmin() {
		return codAdmin;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codAdmin e validar o mesmo
	 * @param codAdmin - valor do atributo
	 */
	public void setCodAdmin(int codAdmin) {
		try {
			if(codAdmin == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Administrador", 1);
			}
			else {
				this.codAdmin = codAdmin;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Administrador", 1);
		}
	}




}
