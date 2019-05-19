package model;

import java.sql.Date;

/**
 * A classe "Frequencia" constitui-se na cria��o
 * do cadastro de frequ�ncia e seus atributos.
 * @author Andressa, Ede, Leonardo, Nat�lia.
 */
public class Frequencia {
	private int codFrequencia;
	private int codAluno;
	private int codProfessor;
	private Date dataFrequencia;
	private String statusFrequencia;
	/**
	 * @return o codFrequencia
	 */
	private int getCodFrequencia() {
		return codFrequencia;
	}
	/**
	 * @param codFrequencia o codFrequencia para set
	 */
	private void setCodFrequencia(int codFrequencia) {
		this.codFrequencia = codFrequencia;
	}
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
	 * @return o codProfessor
	 */
	private int getCodProfessor() {
		return codProfessor;
	}
	/**
	 * @param codProfessor o codProfessor para set
	 */
	private void setCodProfessor(int codProfessor) {
		this.codProfessor = codProfessor;
	}
	/**
	 * @return o dataFrequencia
	 */
	private Date getDataFrequencia() {
		return dataFrequencia;
	}
	/**
	 * @param dataFrequencia o dataFrequencia para set
	 */
	private void setDataFrequencia(Date dataFrequencia) {
		this.dataFrequencia = dataFrequencia;
	}
	/**
	 * @return o statusFrequencia
	 */
	private String getStatusFrequencia() {
		return statusFrequencia;
	}
	/**
	 * @param statusFrequencia o statusFrequencia para set
	 */
	private void setStatusFrequencia(String statusFrequencia) {
		this.statusFrequencia = statusFrequencia;
	}
	
}
