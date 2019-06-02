package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Administrador
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
	 * Método construtor 1
	 */
	public Administrador() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codAdmin
	 */
	public Administrador(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM ADMINSTRADOR WHERE codAdmin="+codigo+";");
		try {
			while (rs.next()) {
				setCodAdmin(Integer.parseInt(rs.getString(1).toString()));
				setUserAdmin(rs.getString(2).toString());
				setSenhaAdmin(rs.getString(3).toString());
				setStatusAdmin(rs.getString(4).toString());				
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	/**
	 * Método responsável por retornar o valor do codAdmin
	 * @return codAdmin - valor do atributo
	 */
	public int getCodAdmin() {
		return codAdmin;
	}
	/**
	 * Método responsável por estabelecer o valor de codAdmin e validar o mesmo
	 * @param codAdmin - valor do atributo
	 */
	public void setCodAdmin(int codAdmin) {
		try {
			if(codAdmin == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Administrador", 1);
			}
			else {
				this.codAdmin = codAdmin;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Administrador", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do userAdmin
	 * @return userAdmin - valor do atributo
	 */
	public String getUserAdmin() {
		return userAdmin;
	}
	/**
	 * Método responsável por estabelecer o valor de userAdmin e validar o mesmo
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
	 * Método responsável por retornar o valor do senhaAdmin
	 * @return senhaAdmin - valor do atributo 
	 */
	public String getSenhaAdmin() {
		return senhaAdmin;
	}
	/**
	 * Método responsável por estabelecer o valor de senhaAdmin e validar o mesmo
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
	 * Método responsável por retornar o valor do statusAdmin
	 * @return statusAdmin - valor do atributo
	 */
	public String getStatusAdmin() {
		return statusAdmin;

	}
	/**
	 * Método responsável por estabelecer o valor de statusAdmin e o mesmo
	 * @param statusAdmin - valor do atributo
	 */
	public void setStatusAdmin(String statusAdmin) {
		if(statusAdmin.length() > 1 || statusAdmin == null || statusAdmin == "" || statusAdmin != "A" && statusAdmin != "I") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, valor incorreto ou campo nulo", "Status Administrador", 1);
		}
		else {
			this.statusAdmin = statusAdmin;
		}
	}
	
	
	
}
