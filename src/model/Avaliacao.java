package model;

import java.sql.ResultSet;

import services.DbConn;

/**
 * A classe "Avaliacao" constitui-se na cria��o do
 *  cadastro de avalia��es e seus respectivos atributos.
 * @author Andressa, Ede, Leonardo, Nat�lia.
 */
public class Avaliacao {
	private int codAvaliacao;
	private String nomeAvaliacao;
	private double valorAvaliacao;
	private int codAdmin;

	public Avaliacao(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM AVALIACAO WHERE codAval="+codigo+";");
		try {
			setCodAvaliacao(Integer.parseInt(rs.getString(1).toString()));
			setNomeAvaliacao(rs.getString(2).toString());
			setValorAvaliacao(Double.parseDouble(rs.getString(3).toString()));
			setCodAdmin(Integer.parseInt(rs.getString(4).toString()));

		}
		catch (Exception e) {

		}
	}
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
	public int getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}
	
}
