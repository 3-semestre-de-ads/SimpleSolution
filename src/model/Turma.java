package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Nota
 * @author Simple Solution Devs
 */
public class Turma {
	
	/**
	 * Atributos da classe (colunas da tabela NOTA)
	 */
	private int codTurma;
	private int qtdAulaTurma;
	private String horarioTurma;
	private String diaTurma;
	private int codIdioma;
	private int codTE;
	
	
	
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



	/**
	 * M�todo respons�vel por retornar o valor do qtdAulaTurma
	 * @return qtdAulaTurma - valor do atributo
	 */
	public int getQtdAulaTurma() {
		return qtdAulaTurma;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de qtdAulaTurma e validar o mesmo
	 * @param qtdAulaTurma - valor do atributo
	 */
	public void setQtdAulaTurma(int qtdAulaTurma) {
		try {
			if(qtdAulaTurma == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Quantidade de Aula", 1);
			}
			else {
				this.qtdAulaTurma = qtdAulaTurma;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "Quantidade de Aula", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do horarioTurma
	 * @return horarioTurma - valor do atributo
	 */
	public String getHorarioTurma() {
		return horarioTurma;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de horarioTurma e validar o mesmo
	 * @param horarioTurma - valor do atributo
	 */
	public void setHorarioTurma(String horarioTurma) {
		if(horarioTurma.length() > 15 || horarioTurma == null || horarioTurma == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Hor�rio da Turma", 1);
		}
		else {
			this.horarioTurma = horarioTurma;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do diaTurma
	 * @return diaTurma - valor do atributo
	 */
	public String getDiaTurma() {
		return diaTurma;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de diaTurma e validar o mesmo
	 * @param diaTurma - valor do atributo
	 */
	public void setDiaTurma(String diaTurma) {
		if(diaTurma.length() > 15 || diaTurma == null || diaTurma == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Dia da Turma", 1);
		}
		else {
			this.diaTurma = diaTurma;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do codIdioma
	 * @return codIdioma - valor do atributo
	 */
	public int getCodIdioma() {
		return codIdioma;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codIdioma e validar o mesmo
	 * @param codIdioma - valor do atributo
	 */
	public void setCodIdioma(int codIdioma) {
		try {
			if(codIdioma == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Idioma", 1);
			}
			else {
				this.codIdioma = codIdioma;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Idioma", 1);
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
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo do Tipo Ensino", 1);
			}
			else {
				this.codTE = codTE;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo do Tipo Ensino", 1);
		}
	}
	
	
}
