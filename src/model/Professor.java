package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Professor
 * @author Simple Solution Devs
 */
public class Professor {
	
	/**
	 * Atributos da classe (colunas da tabela PROFESSOR)
	 */
	private int codProf;
	private String nomeProf;
	private Date nascProf;
	private String rgProf;
	private String cpfProf;
	private String emailProf;
	private String telProf;
	private String userProf;
	private String senhaProf;
	private String statusProf;
	


	/**
	 * M�todo respons�vel por retornar o valor do codProf
	 * @return codProf - valor do atributo
	 */
	public int getCodProf() {
		return codProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codProf e validar o mesmo
	 * @param codProf - valor do atributo
	 */
	public void setCodProf(int codProf) {
		try {
			if(codProf == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Professor", 1);
			}
			else {
				this.codProf = codProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Professor", 1);
		}
	}

	

	/**
	 * M�todo respons�vel por retornar o valor do nomeProf
	 * @return nomeProf - valor do atributo
	 */
	public String getNomeProf() {
		return nomeProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nomeProf e validar o mesmo
	 * @param nomeProf - valor do atributo
	 */
	public void setNomeProf(String nomeProf) {
		if(nomeProf.length() > 20 || nomeProf == null || nomeProf == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Professor", 1);
		}
		else {
			this.nomeProf = nomeProf;
		}
	}
	
	
	
	/**
	 * M�todo respons�vel por retornar o valor do nascProf
	 * @return nascProf - valor do atributo
	 */
	public Date getNascProf() {
		return nascProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nascProf e validar o mesmo
	 * @param nascProf - valor do atributo
	 */
	public void setNascProf(Date nascProf) {
		try {
			if(nascProf == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Nascimento Professor", 1);
			}
			else {
				this.nascProf = nascProf;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Nascimento Professor", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do rgProf
	 * @return rgProf - valor do atributo
	 */
	public String getRgProf() {
		return rgProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de rgProf e validar o mesmo
	 * @param rgProf - valor do atributo
	 */
	public void setRgProf(String rgProf) {
		try {
			if(rgProf.length() > 10 || rgProf == null || rgProf == "") {
				JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "RG Professor", 1);
			}
			else {
				this.rgProf = rgProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero, campo nulo ou vazio", "RG Professor", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do cpfProf
	 * @return cpfProf - valor do atributo
	 */
	public String getCpfProf() {
		return cpfProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de cpfProf e validar o mesmo
	 * @param cpfProf - valor do atributo
	 */
	public void setCpfProf(String cpfProf) {
		try {
			if(cpfProf.length() > 11 || cpfProf == null || cpfProf == "") {
				JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, campo nulo ou vazio", "CPF Professor", 1);
			}
			else {
				this.cpfProf = cpfProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "CPF Professor", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do emilProf
	 * @return emailProf - valor do atributo
	 */
	public String getEmailProf() {
		return emailProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de emailProf e validar o mesmo
	 * @param emailProf - valor do atributo
	 */
	public void setEmailProf(String emailProf) {
		try {
			if(emailProf.length() > 35 || emailProf == null || emailProf == "") {
				JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, campo nulo ou vazio", "E-mail Professor", 1);
			}
			else {
				this.emailProf = emailProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "E-mail Professor", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do telProf
	 * @return telProf - valor do atributo
	 */
	public String getTelProf() {
		return telProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de telProf e validar o mesmo
	 * @param telProf - valor do atributo
	 */
	public void setTelProf(String telProf) {
		if(telProf.length() > 11 || telProf == null || telProf == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Telefone Professor", 1);
		}
		else {
			this.telProf = telProf;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do userProf
	 * @return userProf - valor do atributo
	 */
	public String getUserProf() {
		return userProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de userProf e validar o mesmo
	 * @param userProf - valor do atributo
	 */
	public void setUserProf(String userProf) {
		if(userProf.length() != 8 || userProf == null || userProf == "") {
			JOptionPane.showMessageDialog(null, "Tamanho diferente do esperado ou campo nulo", "User Pofessor", 1);
		}
		else {
			this.userProf = userProf;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do senhaProf
	 * @return senhaProf - valor do atributo
	 */
	public String getSenhaProf() {
		return senhaProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de senhaProf e validar o mesmo
	 * @param senhaProf - valor do atributo
	 */
	public void setSenhaProf(String senhaProf) {
		if(senhaProf.length() > 10 || senhaProf == null || senhaProf == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Senha Professor", 1);
		}
		else {
			this.senhaProf = senhaProf;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do statusProf
	 * @return statusProf - valor do atributo
	 */
	public String getStatusProf() {
		return statusProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de statusProf e validar o mesmo
	 * @param statusProf - valor do atributo
	 */
	public void setStatusProf(String statusProf) {
			this.statusProf = statusProf;

	}
	
}

