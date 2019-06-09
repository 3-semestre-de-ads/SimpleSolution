package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Matricula
 * @author Simple Solution Devs
 */
public class Matricula {
	
	/**
	 * Atributos da classe (colunas da tabela MATRICULA)
	 */
	private int codMat;
	private Date dataInMat;
	private Date dataFiMat;
	private int codAluno;
	private int codTurma;
	
	
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
	 * M�todo respons�vel por retornar o valor do dataInMat
	 * @return dataInMat - valor do atributo
	 */
	public Date getDataInMat() {
		return dataInMat;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de dataInMat e validar o mesmo
	 * @param dataInMat - valor do atributo
	 */
	public void setDataInMat(Date dataInMat) {
		try {
			if(dataInMat == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data In�cio Matr�cula", 1);
			}
			else {
				this.dataInMat = dataInMat;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data In�cio Matr�cula", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do dataFiMat
	 * @return dataFiMat - valor do atributo
	 */
	public Date getDataFiMat() {
		return dataFiMat;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de dataFiMat e validar o mesmo
	 * @param dataFiMat - valor do atributo
	 */
	public void setDataFiMat(Date dataFiMat) {
		try {
			if(dataFiMat == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Final Matr�cula", 1);
			}
			else {
				this.dataFiMat = dataFiMat;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data Final Matr�cula", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do codAluno
	 * @return codAluno - valor do atributo
	 */
	public int getCodAluno() {
		return codAluno;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codAluno e validar o mesmo
	 * @param codAluno - valor do atributo
	 */
	public void setCodAluno(int codAluno) {
		try {
			if(codAluno == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Aluno", 1);
			}
			else {
				this.codAluno = codAluno;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Aluno", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do codTurma
	 * @return codTurma - valor do atributo
	 */
	public int getCodTurma() {
		return codTurma;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codTurma e validar o mesmo
	 * @param codTurma - valor do atributo
	 */
	public void setCodTurma(int codTurma) {
		try {
			if(codTurma == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Turma", 1);
			}
			else {
				this.codTurma = codTurma;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Turma", 1);
		}
	}
	
	
	
}
