package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Professor
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
	 * Método construtor 1
	 */
	public Professor() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codProf
	 */
	public Professor(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM PROFESSOR WHERE codProf="+codigo+";");
		try {
			while (rs.next()) {
				setCodProf(Integer.parseInt(rs.getString(1).toString()));
				setNomeProf(rs.getString(2).toString());
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");				
				setNascProf((Date)format.parse(rs.getString(3).toString()));
				setRgProf(rs.getString(4).toString());
				setCpfProf(rs.getString(5).toString());
				setEmailProf(rs.getString(6).toString());
				setTelProf(rs.getString(7).toString());
				setUserProf(rs.getString(8).toString());
				setSenhaProf(rs.getString(9).toString());
				setStatusProf(rs.getString(10).toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
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
	 * Método responsável por retornar o valor do nomeProf
	 * @return nomeProf - valor do atributo
	 */
	public String getNomeProf() {
		return nomeProf;
	}
	/**
	 * Método responsável por estabelecer o valor de nomeProf e validar o mesmo
	 * @param nomeProf - valor do atributo
	 */
	public void setNomeProf(String nomeProf) {
		if(nomeProf.length() < 20 || nomeProf == null || nomeProf == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Professor", 1);
		}
		else {
			this.nomeProf = nomeProf;
		}
	}
	
	
	
	/**
	 * Método responsável por retornar o valor do nascProf
	 * @return nascProf - valor do atributo
	 */
	public Date getNascProf() {
		return nascProf;
	}
	/**
	 * Método responsável por estabelecer o valor de nascProf e validar o mesmo
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
	 * Método responsável por retornar o valor do rgProf
	 * @return rgProf - valor do atributo
	 */
	public String getRgProf() {
		return rgProf;
	}
	/**
	 * Método responsável por estabelecer o valor de rgProf e validar o mesmo
	 * @param rgProf - valor do atributo
	 */
	public void setRgProf(String rgProf) {
		try {
			if(rgProf.length() < 10 || rgProf == null || rgProf == "") {
				JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "RG Professor", 1);
			}
			else {
				this.rgProf = rgProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número, campo nulo ou vazio", "RG Professor", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do cpfProf
	 * @return cpfProf - valor do atributo
	 */
	public String getCpfProf() {
		return cpfProf;
	}
	/**
	 * Método responsável por estabelecer o valor de cpfProf e validar o mesmo
	 * @param cpfProf - valor do atributo
	 */
	public void setCpfProf(String cpfProf) {
		try {
			if(cpfProf.length() < 11 || cpfProf == null || cpfProf == "") {
				JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, campo nulo ou vazio", "CPF Professor", 1);
			}
			else {
				this.cpfProf = cpfProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "CPF Professor", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do emilProf
	 * @return emailProf - valor do atributo
	 */
	public String getEmailProf() {
		return emailProf;
	}
	/**
	 * Método responsável por estabelecer o valor de emailProf e validar o mesmo
	 * @param emailProf - valor do atributo
	 */
	public void setEmailProf(String emailProf) {
		try {
			if(emailProf.length() < 35 || emailProf == null || emailProf == "") {
				JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, campo nulo ou vazio", "E-mail Professor", 1);
			}
			else {
				this.emailProf = emailProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "E-mail Professor", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do telProf
	 * @return telProf - valor do atributo
	 */
	public String getTelProf() {
		return telProf;
	}
	/**
	 * Método responsável por estabelecer o valor de telProf e validar o mesmo
	 * @param telProf - valor do atributo
	 */
	public void setTelProf(String telProf) {
		if(telProf.length() < 11 || telProf == null || telProf == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Telefone Professor", 1);
		}
		else {
			this.telProf = telProf;
		}
	}



	/**
	 * Método responsável por retornar o valor do userProf
	 * @return userProf - valor do atributo
	 */
	public String getUserProf() {
		return userProf;
	}
	/**
	 * Método responsável por estabelecer o valor de userProf e validar o mesmo
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
	 * Método responsável por retornar o valor do senhaProf
	 * @return senhaProf - valor do atributo
	 */
	public String getSenhaProf() {
		return senhaProf;
	}
	/**
	 * Método responsável por estabelecer o valor de senhaProf e validar o mesmo
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
	 * Método responsável por retornar o valor do statusProf
	 * @return statusProf - valor do atributo
	 */
	public String getStatusProf() {
		return statusProf;
	}
	/**
	 * Método responsável por estabelecer o valor de statusProf e validar o mesmo
	 * @param statusProf - valor do atributo
	 */
	public void setStatusProf(String statusProf) {
		if(statusProf.length() > 1 || statusProf == null || statusProf == "" || statusProf != "A" && statusProf != "I") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, valor incorreto ou campo nulo", "Status Professor", 1);
		}
		else {
			this.statusProf = statusProf;
		}
	}
	
}

