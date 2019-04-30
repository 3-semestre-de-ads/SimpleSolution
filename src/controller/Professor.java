package controller;

import java.sql.Date;

/**
 * A classe "Professor" consiste na criação 
 * para cadastro de professor e seus atributos.
 * @author Andressa, Ede, Leonardo, Natália
 *
 */
public class Professor {
	private int codProf;
	private String nomeProf;
	private Date nascProf;
	private String rgProf;
	private String cpfProf;
	private String emailProf;
	private String telefoneProf;
	/**
	 * @return o codProf
	 */
	private int getCodProf() {
		return codProf;
	}
	/**
	 * @param codProf o codProf para set
	 */
	private void setCodProf(int codProf) {
		this.codProf = codProf;
	}
	/**
	 * @return o nomeProf
	 */
	private String getNomeProf() {
		return nomeProf;
	}
	/**
	 * @param nomeProf o nomeProf para set
	 */
	private void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}
	/**
	 * @return o nascProf
	 */
	private Date getNascProf() {
		return nascProf;
	}
	/**
	 * @param nascProf o nascProf para set
	 */
	private void setNascProf(Date nascProf) {
		this.nascProf = nascProf;
	}
	/**
	 * @return o rgProf
	 */
	private String getRgProf() {
		return rgProf;
	}
	/**
	 * @param rgProf o rgProf para set
	 */
	private void setRgProf(String rgProf) {
		this.rgProf = rgProf;
	}
	/**
	 * @return o cpfProf
	 */
	private String getCpfProf() {
		return cpfProf;
	}
	/**
	 * @param cpfProf o cpfProf para set
	 */
	private void setCpfProf(String cpfProf) {
		this.cpfProf = cpfProf;
	}
	/**
	 * @return o emailProf
	 */
	private String getEmailProf() {
		return emailProf;
	}
	/**
	 * @param emailProf o emailProf para set
	 */
	private void setEmailProf(String emailProf) {
		this.emailProf = emailProf;
	}
	/**
	 * @return o telefoneProf
	 */
	private String getTelefoneProf() {
		return telefoneProf;
	}
	/**
	 * @param telefoneProf o telefoneProf para set
	 */
	private void setTelefoneProf(String telefoneProf) {
		this.telefoneProf = telefoneProf;
	}

}

