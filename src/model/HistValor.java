package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Matricula
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
	 * M�todo construtor 1
	 */
	public HistValor() {
	}



	/**
	 * M�todo construtor 2
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
	 * M�todo respons�vel por retornar o valor do codHV
	 * @return codHV - valor do atributo
	 */
	public int getCodHV() {
		return codHV;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codHV e validar o mesmo
	 * @param codHV - valor do atributo
	 */
	public void setCodHV(int codHV) {
		try {
			if(codHV == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Hist�rico Valor", 1);
			}
			else {
				this.codHV = codHV;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Hist�rico Valor", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do valorPadHV
	 * @return valorPadHV - valor do atributo
	 */
	public double getValorPadHV() {
		return valorPadHV;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de valorPadHV e validar o mesmo
	 * @param valorPadHV - valor do atributo
	 */
	public void setValorPadHV(double valorPadHV) {
		try {
			this.valorPadHV = valorPadHV;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "Valor Padr�o", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do codTE
	 * @return codTE - valor do atributo
	 */
	public int getCodTE() {
		return codTE;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codTE e validar o mesmo
	 * @param codTE - valor do atributo
	 */
	public void setCodTE(int codTE) {
		try {
			if(codTE == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Tipo Ensino", 1);
			}
			else {
				this.codTE = codTE;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Tipo Ensino", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do codMens
	 * @return codMens - valor do atributo
	 */
	public int getCodMens() {
		return codMens;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codMens e validar o mesmo
	 * @param codMens - valor do atributo
	 */
	public void setCodMens(int codMens) {
		try {
			if(codMens == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Mensalidade", 1);
			}
			else {
				this.codMens = codMens;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Mensalidade", 1);
		}
	}
	
}
