package model;

import java.sql.Date;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Aluno
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
	 * Método construtor 1
	 */
	public Aluno() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codAluno
	 */
	public Aluno(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM ALUNO WHERE codAluno="+codigo+";");
		try {
			while (rs.next()) {
				setCodAluno(Integer.parseInt(rs.getString(1).toString()));
				setNomeAluno(rs.getString(2).toString());
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");				
				setNascAluno((Date)format.parse(rs.getString(3).toString()));
				setRgAluno(rs.getString(4).toString());
				setCpfAluno(rs.getString(5).toString());
				setEmailAluno(rs.getString(6).toString());
				setTelAluno(rs.getString(7).toString());
				setStatusAluno(rs.getString(9).toString());
				setCodResp(Integer.parseInt(rs.getString(10).toString()));					
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * Método responsável por retornar o valor do codAluno
	 * @return codAluno - valor do atributo
	 */
	public int getCodAluno() {
		return codAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de codAluno e validar o mesmo
	 * @param codAluno - valor do atributo
	 */
	public void setCodAluno(int codAluno) {
		try {
			if(codAluno == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Aluno", 1);
			}
			else {
				this.codAluno = codAluno;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Aluno", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do nomeAluno
	 * @return nomeAluno - valor do atributo
	 */
	public String getNomeAluno() {
		return nomeAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de nomeAluno e validar o mesmo
	 * @param nomeAluno - valor do atributo
	 */
	public void setNomeAluno(String nomeAluno) {
		if(nomeAluno.length() < 20 || nomeAluno == null || nomeAluno == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Aluno", 1);
		}
		else {
			this.nomeAluno = nomeAluno;
		}
	}



	/**
	 * Método responsável por retornar o valor do nascAluno
	 * @return nascAluno - valor do atributo
	 */
	public Date getNascAluno() {
		return nascAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de nascAluno e validar o mesmo
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
	 * Método responsável por retornar o valor do rgAluno
	 * @return rgAluno - valor do atributo
	 */
	public String getRgAluno() {
		return rgAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de rgAluno e validar o mesmo
	 * @param rgAluno - valor do atributo
	 */
	public void setRgAluno(String rgAluno) {
		if(rgAluno.length() < 10) {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "RG Aluno", 1);
		}
		else {
			this.rgAluno = rgAluno;
		}
	}



	/**
	 * Método responsável por retornar o valor do cpfAluno
	 * @return cpfAluno - valor do atributo
	 */
	public String getCpfAluno() {
		return cpfAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de cpfAluno e validar o mesmo
	 * @param cpfAluno - valor do atributo
	 */
	public void setCpfAluno(String cpfAluno) {
		if(cpfAluno.length() < 11) {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "CPF Aluno", 1);
		}
		else {
			this.cpfAluno = cpfAluno;
		}
	}



	/**
	 * Método responsável por retornar o valor do emailAluno
	 * @return emailAluno - valor do atributo
	 */
	public String getEmailAluno() {
		return emailAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de emailAluno e validar o mesmo
	 * @param emailAluno - valor do atributo
	 */
	public void setEmailAluno(String emailAluno) {
		if(emailAluno.length() < 35) {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "E-mail Aluno", 1);
		}
		else {
			this.emailAluno = emailAluno;
		}
	}



	/**
	 * Método responsável por retornar o valor do telAluno
	 * @return telAluno - valor do atributo
	 */
	public String getTelAluno() {
		return telAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de telAluno e validar o mesmo
	 * @param telAluno - valor do atributo
	 */
	public void setTelAluno(String telAluno) {
		if(telAluno.length() < 11 || telAluno == null || telAluno == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Telefone Aluno", 1);
		}
		else {
			this.telAluno = telAluno;
		}
	}



	/**
	 * Método responsável por retornar o valor do userAluno
	 * @return - valor do atributo
	 */
	public String getUserAluno() {
		return userAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de userAluno e validar o mesmo
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
	 * Método responsável por retornar o valor do senhaAluno
	 * @return senhaAluno - valor do atributo
	 */
	public String getSenhaAluno() {
		return senhaAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de senhaAluno e validar o mesmo
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
	 * Método responsável por retornar o valor do statusAluno
	 * @return statusAluno - valor do atributo
	 */
	public String getStatusAluno() {
		return statusAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de statusAluno e validar o mesmo
	 * @param statusAluno - valor do atributo
	 */
	public void setStatusAluno(String statusAluno) {
		if(statusAluno.length() > 1 || statusAluno == null || statusAluno == "" || statusAluno != "A" && statusAluno != "I") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, valor incorreto ou campo nulo", "Status Aluno", 1);
		}
		else {
			this.statusAluno = statusAluno;
		}
	}



	//SELECT PARA VALIDAR codResp
	/**
	 * Método responsável por retornar o valor do codResp
	 * @return codResp - valor do atributo
	 */
	public int getCodResp() {
		return codResp;
	}
	/**
	 * Método responsável por estabelecer o valor de codResp e validar o mesmo
	 * @param codResp - valor do atributo
	 */
	public void setCodResp(int codResp) {
		try {
			if(codResp == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Responsável", 1);
			}
			else {
				this.codResp = codResp;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Responsável", 1);
		}
	}



}
