package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Avaliação
 * @author Simple Solution Devs
 */
public class Avaliacao {

	/**
	 * Atributos da classe (colunas da tabela AVALIACAO)
	 */
	private int codAval;
	private String nomeAval;
	private double valorAval;
	private int codAdmin;



	/**
	 * Método construtor 1
	 */
	public Avaliacao() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codAval
	 */
	public Avaliacao (String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM AVALIACAO WHERE codAval="+codigo+";");
		try {
			setCodAval(Integer.parseInt(rs.getString(1).toString()));
			setNomeAval(rs.getString(2).toString());
			setValorAval(Double.parseDouble(rs.getString(3).toString()));
			setCodAdmin(Integer.parseInt(rs.getString(4).toString()));
		}
		catch (Exception e) {
		}
	}



	/**
	 * Método responsável por retornar o valor do codAval
	 * @return codAval - valor do atributo
	 */
	public int getCodAval() {
		return codAval;
	}
	/**
	 * Método responsável por estabelecer o valor de codAval e validar o mesmo
	 * @param codAval - valor do atributo
	 */
	public void setCodAval(int codAval) {
		try {
			this.codAval = codAval;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Avaliação", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do nomeAval
	 * @return nomeAval - valor do atributo
	 */
	public String getNomeAval() {
		return nomeAval;
	}
	/**
	 * Método responsável por estabelecer o valor de nomeAval e validar o mesmo
	 * @param nomeAval - valor do atributo
	 */
	public void setNomeAval(String nomeAval) {
		if(nomeAval.length() < 10 || nomeAval == null || nomeAval == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Avaliação", 1);
		}
		else {
			this.nomeAval = nomeAval;
		}
	}



	/**
	 * Método responsável por retornar o valor do valorAval
	 * @return valorAval - valor do atributo
	 */
	public double getValorAval() {
		return valorAval;
	}
	/**
	 * Método responsável por estabelecer o valor de valorAval e validar o mesmo
	 * @param valorAval
	 */
	public void setValorAval(double valorAval) {
		try {
			this.valorAval = valorAval;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Nota Avaliação", 1);
		}
	}



	//SELECT PARA VALIDAR codAdmin
	/**
	 * Método responsável por retornar o valor do codAdmin
	 * @return codAdmin - valor do atributo
	 */
	public int getCodAdmin() {
		return codAdmin;
	}
	/**
	 * Método responsável por estabelecer o valor de codAdmin e validar o mesmo
	 * @param codAdmin - valor do atributo
	 */
	public void setCodAdmin(int codAdmin) {
		try {
			if(codAdmin == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Administrador", 1);
			}
			else {
				this.codAdmin = codAdmin;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Administrador", 1);
		}
	}




}
