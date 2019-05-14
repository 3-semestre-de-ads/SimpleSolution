package controller;

import java.sql.Date;

import model.ConsultaDb;
/**
 * Classe aluno constitui se na cria��o do cadastro dos alunos
 * e seus respectivos atributos
 * @author Andressa, Ede, Leonardo, Nat�lia.
 */
public class Aluno {

	private int codAluno;
	private String nomeAluno;
	private Date nascAluno;
	private String rgAluno;
	private String cpfAluno;
	private String emailAluno;
	private String teleAluno;
	private int codResponsavel;
	/**
	 * @return o codAluno
	 */
	private int getCodAluno() {
		return codAluno;
	}
	/**
	 * @param codAluno o codAluno para set
	 */
	private void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}
	/**
	 * @return o nomeAluno
	 */
	private String getNomeAluno() {
		return nomeAluno;
	}
	/**
	 * @param nomeAluno o nomeAluno para set
	 */
	private void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	/**
	 * @return o nascAluno
	 */
	private Date getNascAluno() {
		return nascAluno;
	}
	/**
	 * @param nascAluno o nascAluno para set
	 */
	private void setNascAluno(Date nascAluno) {
		this.nascAluno = nascAluno;
	}
	/**
	 * @return o rgAluno
	 */
	private String getRgAluno() {
		return rgAluno;
	}
	/**
	 * @param rgAluno o rgAluno para set
	 */
	private void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}
	/**
	 * @return o cpfAluno
	 */
	private String getCpfAluno() {
		return cpfAluno;
	}
	/**
	 * @param cpfAluno o cpfAluno para set
	 */
	private void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}
	/**
	 * @return o emailAluno
	 */
	private String getEmailAluno() {
		return emailAluno;
	}
	/**
	 * @param emailAluno o emailAluno para set
	 */
	private void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	/**
	 * @return o teleAluno
	 */
	private String getTeleAluno() {
		return teleAluno;
	}
	/**
	 * @param teleAluno o teleAluno para set
	 */
	private void setTeleAluno(String teleAluno) {
		this.teleAluno = teleAluno;
	}
	/**
	 * @return o codResponsavel
	 */
	private int getCodResponsavel() {
		return codResponsavel;
	}
	/**
	 * @param codResponsavel o codResponsavel para set
	 */
	private void setCodResponsavel(int codResponsavel) {
		this.codResponsavel = codResponsavel;
	}


}
