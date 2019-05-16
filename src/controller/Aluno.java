package controller;

import java.sql.Date;
import java.sql.ResultSet;

import jdk.nashorn.internal.ir.SetSplitState;
import model.ConsultaDb;
import model.DbConn;
/**
 * Classe aluno constitui se na cria��o do cadastro dos alunos
 * e seus respectivos atributos
 * @author Andressa, Ede, Leonardo, Nat�lia.
 */
public class Aluno {
	private String codAluno;
	private String nomeAluno;
	private String nascAluno;
	private String rgAluno;
	private String cpfAluno;
	private String emailAluno;
	private String teleAluno;
	private String senhaAluno;
	private String statusAluno;
	private String codResponsavel;
	
	public Aluno(String codigo) {
		if (codigo != "novo") {
			ConsultaDb cdb = new ConsultaDb();
			ResultSet rs = cdb.consultaPorId("ALUNO","codAluno",codigo);
			try {
				while (rs.next()) {
					setCodAluno(rs.getString(1).toString());
					setNomeAluno(rs.getString(2).toString());
					setNascAluno(rs.getString(1).toString());
					setRgAluno(rs.getString(4).toString());
					setCpfAluno(rs.getString(5).toString());
					setEmailAluno(rs.getString(6).toString());
					setTeleAluno(rs.getString(7).toString());
					setSenhaAluno(rs.getString(8).toString());
					setStatusAluno(rs.getString(9).toString());
					setCodResponsavel(rs.getString(10).toString());					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public String getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(String codAluno) {
		this.codAluno = codAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNascAluno() {
		return nascAluno;
	}

	public void setNascAluno(String nascAluno) {
		this.nascAluno = nascAluno;
	}

	public String getRgAluno() {
		return rgAluno;
	}

	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getTeleAluno() {
		return teleAluno;
	}

	public void setTeleAluno(String teleAluno) {
		this.teleAluno = teleAluno;
	}

	public String getSenhaAluno() {
		return senhaAluno;
	}

	public void setSenhaAluno(String senhaAluno) {
		this.senhaAluno = senhaAluno;
	}

	public String getStatusAluno() {
		return statusAluno;
	}

	public void setStatusAluno(String statusAluno) {
		this.statusAluno = statusAluno;
	}

	public String getCodResponsavel() {
		return codResponsavel;
	}

	public void setCodResponsavel(String codResponsavel) {
		this.codResponsavel = codResponsavel;
	}



}
