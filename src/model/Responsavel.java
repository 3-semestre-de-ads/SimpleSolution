package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import services.DbConn;

/**
 * A classe "Respons�vel" permite a cria��o
 * do cadastro de respos�vel e seus requisitos.
 * @author Andressa, Ede, Leonardo, Nat�lia.
 */

public class Responsavel {
	private int codResp;
	private String nomeResp;
	private Date nascResp;
	private String rgResp;
	private String cpfResp;
	private String emailResp;
	private String telefoneResp;
	private String statusResp;
	
	public Responsavel() {
		
	}

	public int getCodResp() {
		return codResp;
	}


	public void setCodResp(int codResp) {
		this.codResp = codResp;
	}


	public String getNomeResp() {
		return nomeResp;
	}


	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}


	public String getRgResp() {
		return rgResp;
	}


	public void setRgResp(String rgResp) {
		this.rgResp = rgResp;
	}


	public String getCpfResp() {
		return cpfResp;
	}


	public void setCpfResp(String cpfResp) {
		this.cpfResp = cpfResp;
	}


	public String getEmailResp() {
		return emailResp;
	}


	public void setEmailResp(String emailResp) {
		this.emailResp = emailResp;
	}


	public String getTelefoneResp() {
		return telefoneResp;
	}


	public void setTelefoneResp(String telefoneResp) {
		this.telefoneResp = telefoneResp;
	}


	public String getStatusResp() {
		return statusResp;
	}


	public void setStatusResp(String statusResp) {
		this.statusResp = statusResp;
	}

	public Date getNascResp() {
		return nascResp;
	}

	public void setNascResp(Date nascResp) {
		this.nascResp = nascResp;
	}

}
