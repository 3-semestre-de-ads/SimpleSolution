package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import services.DbConn;
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

	private String statusAluno;
	private int codResponsavel;
	
	public Aluno() {
		
	}

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
				setTeleAluno(rs.getString(7).toString());
				setStatusAluno(rs.getString(9).toString());
				setCodResponsavel(Integer.parseInt(rs.getString(10).toString()));					
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Date getNascAluno() {
		return nascAluno;
	}

	public void setNascAluno(Date nascAluno) {
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


	public String getStatusAluno() {
		return statusAluno;
	}

	public void setStatusAluno(String statusAluno) {
		this.statusAluno = statusAluno;
	}

	public int getCodResponsavel() {
		return codResponsavel;
	}

	public void setCodResponsavel(int codResponsavel) {
		this.codResponsavel = codResponsavel;
	}
	




}
