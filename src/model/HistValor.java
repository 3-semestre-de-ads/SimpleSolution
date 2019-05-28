package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Matricula
 * @author Simple Solution Devs
 */
public class HistValor {

	/**
	 * Atributos da classe (colunas da tabela MATRICULA)
	 */
	private int codHV;
	private double valorPadHV;
	private int codTE;
	private int codMens;
	
	
	
	/**
	 * Método construtor 1
	 */
	public HistValor() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codHV
	 */
	public HistValor(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM HISTVALOR WHERE codHV="+codigo+";");
		try {
			while (rs.next()) {
				setCodHV(Integer.parseInt(rs.getString(1).toString()));
				setValorPadHV(Double.parseDouble(rs.getString(2).toString()));
				setCodTE(Integer.parseInt(rs.getString(3).toString()));
				setCodMens(Integer.parseInt(rs.getString(4).toString()));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * Método responsável por retornar o valor do codHV
	 * @return codHV - valor do atributo
	 */
	public int getCodHV() {
		return codHV;
	}
	/**
	 * Método responsável por estabelecer o valor de codHV e validar o mesmo
	 * @param codHV - valor do atributo
	 */
	public void setCodHV(int codHV) {
		try {
			if(codHV == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Histórico Valor", 1);
			}
			else {
				this.codHV = codHV;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Histórico Valor", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do valorPadHV
	 * @return valorPadHV - valor do atributo
	 */
	public double getValorPadHV() {
		return valorPadHV;
	}
	/**
	 * Método responsável por estabelecer o valor de valorPadHV e validar o mesmo
	 * @param valorPadHV - valor do atributo
	 */
	public void setValorPadHV(double valorPadHV) {
		try {
			this.valorPadHV = valorPadHV;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Valor Padrão", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do codTE
	 * @return codTE - valor do atributo
	 */
	public int getCodTE() {
		return codTE;
	}
	/**
	 * Método responsável por estabelecer o valor de codTE e validar o mesmo
	 * @param codTE - valor do atributo
	 */
	public void setCodTE(int codTE) {
		try {
			if(codTE == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Tipo Ensino", 1);
			}
			else {
				this.codTE = codTE;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Tipo Ensino", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do codMens
	 * @return codMens - valor do atributo
	 */
	public int getCodMens() {
		return codMens;
	}
	/**
	 * Método responsável por estabelecer o valor de codMens e validar o mesmo
	 * @param codMens - valor do atributo
	 */
	public void setCodMens(int codMens) {
		try {
			if(codMens == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Mensalidade", 1);
			}
			else {
				this.codMens = codMens;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Mensalidade", 1);
		}
	}
	
}
