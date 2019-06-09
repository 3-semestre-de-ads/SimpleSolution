package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a HistTurma
 * @author Simple Solution Devs
 */
public class HistTurma {

	/**
	 * Atributos da classe (colunas da tabela HISTTURMA)
	 */
	private int codHT;
	private Date dataInHT;
	private Date dataFiHT;
	private int codMat;
	private int codProf;
	
	
	

	/**
	 * M�todo respons�vel por retornar o valor do codHT
	 * @return codHT - valor do atributo
	 */
	public int getCodHT() {
		return codHT;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codHT e validar o mesmo
	 * @param codHT - valor do atributo
	 */
	public void setCodHT(int codHT) {
		try {
			if(codHT == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Hist�rico Turma", 1);
			}
			else {
				this.codHT = codHT;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Hist�rico Turma", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do dataInHT
	 * @return dataInHT - valor do atributo
	 */
	public Date getDataInHT() {
		return dataInHT;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de dataInHT e validar o mesmo
	 * @param dataInHT - valor do atributo
	 */
	public void setDataInHT(Date dataInHT) {
		try {
			if(dataInHT == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data In�cio Hist�rico Turma", 1);
			}
			else {
				this.dataInHT = dataInHT;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data In�cio Hist�rico Turma", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do dataFiHT
	 * @return dataFiHT - valor do atributo
	 */
	public Date getDataFiHT() {
		return dataFiHT;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de dataFiHT e validar o mesmo
	 * @param dataFiHT - valor do atributo
	 */
	public void setDataFiHT(Date dataFiHT) {
		try {
			if(dataFiHT == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Fim Hist�rico Turma", 1);
			}
			else {
				this.dataFiHT = dataFiHT;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data Fim Hist�rico Turma", 1);
		}
	}



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



	/**
	 * M�todo respons�vel por retornar o valor do codProf
	 * @return codProf - valor do atributo
	 */
	public int getCodProf() {
		return codProf;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codProf e validar o mesmo
	 * @param codProf - valor do atributo
	 */
	public void setCodProf(int codProf) {
		try {
			if(codProf == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Professor", 1);
			}
			else {
				this.codProf = codProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Professor", 1);
		}
	}

	
}
