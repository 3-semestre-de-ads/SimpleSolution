package controller;
/**
 * A classe "TipoEnsino" consiste na criação
 * do cadastro do tipo de ensino e seus atributos.
 * @author Andressa, Ede, Leonardo, Natalia.
 */

public class TipoEnsino {
private int codTE;
private String nomeTE;
private int quantAlunoTE;
/**
 * @return o codTE
 */
private int getCodTE() {
	return codTE;
}
/**
 * @param codTE o codTE para set
 */
private void setCodTE(int codTE) {
	this.codTE = codTE;
}
/**
 * @return o nomeTE
 */
private String getNomeTE() {
	return nomeTE;
}
/**
 * @param nomeTE o nomeTE para set
 */
private void setNomeTE(String nomeTE) {
	this.nomeTE = nomeTE;
}
/**
 * @return o quantAlunoTE
 */
private int getQuantAlunoTE() {
	return quantAlunoTE;
}
/**
 * @param quantAlunoTE o quantAlunoTE para set
 */
private void setQuantAlunoTE(int quantAlunoTE) {
	this.quantAlunoTE = quantAlunoTE;
}

}
