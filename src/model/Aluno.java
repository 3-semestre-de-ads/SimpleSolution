package model;

import java.sql.Date;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Aluno
 * @author Simple Solution Devs
 */
public class Aluno {

	/**
	 * Atributos da classe (colunas da tabela ALUNO)
	 */
	private int codAluno;
	private String nomeAluno;
	private Date nascAluno;
	private String rgAluno;
	private String cpfAluno;
	private String emailAluno;
	private String telAluno;
	private String userAluno;
	private String senhaAluno;
	private String statusAluno;
	private int codResp;



	/**
	 * M�todo respons�vel por retornar o valor do codAluno
	 * @return codAluno - valor do atributo
	 */
	public int getCodAluno() {
		return codAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codAluno e validar o mesmo
	 * @param codAluno - valor do atributo
	 */
	public void setCodAluno(int codAluno) {
		try {
			if(codAluno == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Aluno", 1);
			}
			else {
				this.codAluno = codAluno;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Aluno", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do nomeAluno
	 * @return nomeAluno - valor do atributo
	 */
	public String getNomeAluno() {
		return nomeAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nomeAluno e validar o mesmo
	 * @param nomeAluno - valor do atributo
	 */
	public void setNomeAluno(String nomeAluno) {
		if(nomeAluno.length() > 20 || nomeAluno == null || nomeAluno == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Aluno", 1);
		}
		else {
			this.nomeAluno = nomeAluno;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do nascAluno
	 * @return nascAluno - valor do atributo
	 */
	public Date getNascAluno() {
		return nascAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nascAluno e validar o mesmo
	 * @param nascAluno - valor do atributo
	 */
	public void setNascAluno(Date nascAluno) {
		try {
			if(nascAluno == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Nascimento Aluno", 1);
			}
			else {
				this.nascAluno = nascAluno;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Nascimento Aluno", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do rgAluno
	 * @return rgAluno - valor do atributo
	 */
	public String getRgAluno() {
		return rgAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de rgAluno e validar o mesmo
	 * @param rgAluno - valor do atributo
	 */
	public void setRgAluno(String rgAluno) {
		if(rgAluno.length() > 10) {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "RG Aluno", 1);
		}
		else {
			this.rgAluno = rgAluno;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do cpfAluno
	 * @return cpfAluno - valor do atributo
	 */
	public String getCpfAluno() {
		return cpfAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de cpfAluno e validar o mesmo
	 * @param cpfAluno - valor do atributo
	 */
	public void setCpfAluno(String cpfAluno) {
		if(cpfAluno.length() > 11) {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "CPF Aluno", 1);
		}
		else {
			this.cpfAluno = cpfAluno;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do emailAluno
	 * @return emailAluno - valor do atributo
	 */
	public String getEmailAluno() {
		return emailAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de emailAluno e validar o mesmo
	 * @param emailAluno - valor do atributo
	 */
	public void setEmailAluno(String emailAluno) {
		if(emailAluno.length() > 35) {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "E-mail Aluno", 1);
		}
		else {
			this.emailAluno = emailAluno;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do telAluno
	 * @return telAluno - valor do atributo
	 */
	public String getTelAluno() {
		return telAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de telAluno e validar o mesmo
	 * @param telAluno - valor do atributo
	 */
	public void setTelAluno(String telAluno) {
		if(telAluno.length() > 11 || telAluno == null || telAluno == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Telefone Aluno", 1);
		}
		else {
			this.telAluno = telAluno;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do userAluno
	 * @return - valor do atributo
	 */
	public String getUserAluno() {
		return userAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de userAluno e validar o mesmo
	 * @param userAluno - valor do atributo
	 */
	public void setUserAluno(String userAluno) {
		if(userAluno.length() != 8 || userAluno == null || userAluno == "") {
			JOptionPane.showMessageDialog(null, "Tamanho diferente do esperado ou campo nulo", "User Aluno", 1);
		}
		else {
			this.userAluno = userAluno;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do senhaAluno
	 * @return senhaAluno - valor do atributo
	 */
	public String getSenhaAluno() {
		return senhaAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de senhaAluno e validar o mesmo
	 * @param senhaAluno - valor do atributo
	 */
	public void setSenhaAluno(String senhaAluno) {
		if(senhaAluno.length() > 10 || senhaAluno == null || senhaAluno == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Senha Aluno", 1);
		}
		else {
			this.senhaAluno = senhaAluno;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do statusAluno
	 * @return statusAluno - valor do atributo
	 */
	public String getStatusAluno() {
		return statusAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de statusAluno e validar o mesmo
	 * @param statusAluno - valor do atributo
	 */
	public void setStatusAluno(String statusAluno) {
		if(statusAluno.indexOf("A") ==-1 && statusAluno.indexOf("I") ==-1 ) {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, valor incorreto ou campo nulo", "Status Aluno", 1);
		}
		else {
			this.statusAluno = statusAluno;
		}
	}



	//SELECT PARA VALIDAR codResp
	/**
	 * M�todo respons�vel por retornar o valor do codResp
	 * @return codResp - valor do atributo
	 */
	public int getCodResp() {
		return codResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codResp e validar o mesmo
	 * @param codResp - valor do atributo
	 */
	public void setCodResp(int codResp) {
		try {
			if(codResp == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Respons�vel", 1);
			}
			else {
				this.codResp = codResp;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Respons�vel", 1);
		}
	}



}
