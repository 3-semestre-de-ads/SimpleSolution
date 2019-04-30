package controller;
/**
 * A classe "Avaliacao" constitui-se na criação do
 *  cadastro de avaliações e seus respectivos atributos.
 * @author Andressa, Ede, Leonardo, Natália.
 */
public class Avaliacao {
	private int codAvaliacao;
	private String nomeAvaliacao;
	private double valorAvaliacao;
	/**
	 * @return o codAvaliacao
	 */
	private int getCodAvaliacao() {
		return codAvaliacao;
	}
	/**
	 * @param codAvaliacao o codAvaliacao para set
	 */
	private void setCodAvaliacao(int codAvaliacao) {
		this.codAvaliacao = codAvaliacao;
	}
	/**
	 * @return o nomeAvaliacao
	 */
	private String getNomeAvaliacao() {
		return nomeAvaliacao;
	}
	/**
	 * @param nomeAvaliacao o nomeAvaliacao para set
	 */
	private void setNomeAvaliacao(String nomeAvaliacao) {
		this.nomeAvaliacao = nomeAvaliacao;
	}
	/**
	 * @return o valorAvaliacao
	 */
	private double getValorAvaliacao() {
		return valorAvaliacao;
	}
	/**
	 * @param valorAvaliacao o valorAvaliacao para set
	 */
	private void setValorAvaliacao(double valorAvaliacao) {
		this.valorAvaliacao = valorAvaliacao;
	}
}
