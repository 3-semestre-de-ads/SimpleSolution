package controller;

import java.sql.Date;

/**
 * A classe "Nota" constitui-se na criação do
 * cadastro de notas e seus atributos.
 * @author Andressa, Ede, Leonardo e Natália.
 */
public class Nota {
private int codNota;
private int codAluno;
private int codProfessor;
private int codAvalicao;
private Date dataNota;
private double valorNota;
/**
 * @return o codNota
 */
private int getCodNota() {
	return codNota;
}
/**
 * @param codNota o codNota para set
 */
private void setCodNota(int codNota) {
	this.codNota = codNota;
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
 * @return o codAvalicao
 */
private int getCodAvalicao() {
	return codAvalicao;
}
/**
 * @param codAvalicao o codAvalicao para set
 */
private void setCodAvalicao(int codAvalicao) {
	this.codAvalicao = codAvalicao;
}
/**
 * @return o dataNota
 */
private Date getDataNota() {
	return dataNota;
}
/**
 * @param dataNota o dataNota para set
 */
private void setDataNota(Date dataNota) {
	this.dataNota = dataNota;
}
/**
 * @return o valorNota
 */
private double getValorNota() {
	return valorNota;
}
/**
 * @param valorNota o valorNota para set
 */
private void setValorNota(double valorNota) {
	this.valorNota = valorNota;
}

}
