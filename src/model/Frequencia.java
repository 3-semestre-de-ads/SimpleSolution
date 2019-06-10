package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Frequ�ncia
 * @author Simple Solution Devs
 */
public class Frequencia {

	/**
	 * Atributos da classe (colunas da tabela FREQUENCIA)
	 */
	private int codFreq;
	private Date dataFreq;
	private String statusFreq;
	private int codMat;


	/**
	 * M�todo respons�vel por retornar o valor do codFreq
	 * @return codFreq - valor do atributo
	 */
	public int getCodFreq() {
		return codFreq;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codFreq e validar o mesmo
	 * @param codFreq - valor do atributo
	 */
	public void setCodFreq(int codFreq) {
		try {
			if(codFreq == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Frequ�ncia", 1);
			}
			else {
				this.codFreq = codFreq;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Frequ�ncia", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do dataFreq
	 * @return dataFreq - valor do atributo
	 */
	public Date getDataFreq() {
		return dataFreq;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de dataFreq e validar o mesmo
	 * @param dataFreq - valor do atributo
	 */
	public void setDataFreq(Date dataFreq) {
		try {
			if(dataFreq == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Frequ�ncia", 1);
			}
			else {
				this.dataFreq = dataFreq;
			}
		}
		catch(DateTimeParseException e){
			JOptionPane.showMessageDialog(null, e, "Data Frequ�ncia", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do statusFreq
	 * @return statusFreq - valor do atributo
	 */
	public String getStatusFreq() {
		return statusFreq;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de statusFreq e validar o mesmo
	 * @param statusFreq - valor do atributo
	 */
	public void setStatusFreq(String statusFreq) {
			this.statusFreq = statusFreq;
	}



	//SELECT PARA VALIDAR codMAt
	/**
	 * M�todo respons�vel por retornar o valor do codResponsavel
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

}
