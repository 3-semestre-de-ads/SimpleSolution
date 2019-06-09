package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Nota
 * @author Simple Solution Devs
 */
public class Nota {
	
	/**
	 * Atributos da classe (colunas da tabela NOTA)
	 */
	private int codNota;
	private Date dataNota;
	private double valorNota;
	private int codMat;
	private int codAval;
	
	
	/**
	 * M�todo respons�vel por retornar o valor do codNota
	 * @return codNota - valor do atributo
	 */
	public int getCodNota() {
		return codNota;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codNota e validar o mesmo
	 * @param codNota - valor do atributo
	 */
	public void setCodNota(int codNota) {
		try {
			if(codNota == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Nota", 1);
			}
			else {
				this.codNota = codNota;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Nota", 1);
		}
	}
	
	
	
	/**
	 * M�todo respons�vel por retornar o valor do dataNota
	 * @return dataNota - valor do atributo
	 */
	public Date getDataNota() {
		return dataNota;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de dataNota e validar o mesmo
	 * @param dataNota - valor do atributo
	 */
	public void setDataNota(Date dataNota) {
		try {
			if(dataNota == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Nota", 1);
			}
			else {
				this.dataNota = dataNota;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data Nota", 1);
		}
	}
	
	
	
	//Verifica��o e select de acordo com o valor definido no codAval
	/**
	 * M�todo respons�vel por retornar o valor do valorNota
	 * @return valorNota - valor do atributo
	 */
	public double getValorNota() {
		return valorNota;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de valorNota e validar o mesmo
	 * @param valorNota - valor do atributo
	 */
	public void setValorNota(double valorNota) {
		try {
			this.valorNota = valorNota;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "Valor Nota", 1);
		}
	}
	
	
	
	//SELECT PARA VALIDAR codMat
	/**
	 * M�todo respons�vel por retornar o valor do codMat
	 * @return codMat - valor do atributo
	 */
	public int getCodMat() {
		return codMat;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codMat e validar o mesmo
	 * @param codMat - valor do atributo
	 */
	public void setCodMat(int codMat) {
		try {
			if(codMat == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Matr�cula", 1);
			}
			else {
				this.codMat = codMat;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Matr�cula", 1);
		}
	}
	
	
	
	//SELECT PARA VALIDAR codAval
	/**
	 * M�todo respons�vel por retornar o valor do codAval
	 * @return codAval - valor do atributo
	 */
	public int getCodAval() {
		return codAval;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de cpfAluno e validar o mesmo
	 * @param cpfAluno - valor do atributo
	 */
	public void setCodAval(int codAval) {
		try {
			if(codAval == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Avalia��o", 1);
			}
			else {
				this.codAval = codAval;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Avalia��o", 1);
		}
	}
	
}
