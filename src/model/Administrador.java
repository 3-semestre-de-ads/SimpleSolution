package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Administrador
 * @author Simple Solution Devs
 */
public class Administrador {

	/**
	 * Atributos da classe (colunas da tabela ADMINISTRADOR)
	 */
	private int codAdmin;
	private String userAdmin;
	private String senhaAdmin;
	private String statusAdmin;



	
	
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



	/**
	 * M�todo respons�vel por retornar o valor do userAdmin
	 * @return userAdmin - valor do atributo
	 */
	public String getUserAdmin() {
		return userAdmin;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de userAdmin e validar o mesmo
	 * @param userAdmin - valor do atributo
	 */
	public void setUserAdmin(String userAdmin) {
		if(userAdmin.length() != 8 || userAdmin == null || userAdmin == "") {
			JOptionPane.showMessageDialog(null, "Tamanho diferente do esperado ou campo nulo", "User Administrador", 1);
		}
		else {
			this.userAdmin = userAdmin;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do senhaAdmin
	 * @return senhaAdmin - valor do atributo 
	 */
	public String getSenhaAdmin() {
		return senhaAdmin;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de senhaAdmin e validar o mesmo
	 * @param senhaAdmin - valor do atributo
	 */
	public void setSenhaAdmin(String senhaAdmin) {
		if(senhaAdmin.length() > 10 || senhaAdmin == null || senhaAdmin == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Senha Administrador", 1);
		}
		else {
			this.senhaAdmin = senhaAdmin;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do statusAdmin
	 * @return statusAdmin - valor do atributo
	 */
	public String getStatusAdmin() {
		return statusAdmin;

	}
	/**
	 * M�todo respons�vel por estabelecer o valor de statusAdmin e o mesmo
	 * @param statusAdmin - valor do atributo
	 */
	public void setStatusAdmin(String statusAdmin) {
			this.statusAdmin = statusAdmin;

	}
	
	
	
}
