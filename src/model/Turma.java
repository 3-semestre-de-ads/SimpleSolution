package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Nota
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
	 * Método construtor 1
	 */
	public Turma() {
	}



	//????
	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codTurma
	 */
	public Turma(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM TURMA WHERE codTurma="+codigo+";");
		try {
			while (rs.next()) {
				setCodTurma(Integer.parseInt(rs.getString(1).toString()));				
				setQtdAulaTurma(Integer.parseInt(rs.getString(2).toString()));
				setHorarioTurma(rs.getString(3).toString());
				setDiaTurma(rs.getString(4).toString());
				setCodIdioma(Integer.parseInt(rs.getString(5).toString()));
				setCodTE(Integer.parseInt(rs.getString(6).toString()));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}


	/**
	 * Método responsável por retornar o valor do codTurma
	 * @return codTurma - valor do atributo
	 */
	public int getCodTurma() {
		return codTurma;
	}
	/**
	 * Método responsável por estabelecer o valor de codTurma e validar o mesmo
	 * @param codTurma - valor do atributo
	 */
	public void setCodTurma(int codTurma) {
		try {
			if(codTurma == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Turma", 1);
			}
			else {
				this.codTurma = codTurma;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Turma", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do qtdAulaTurma
	 * @return qtdAulaTurma - valor do atributo
	 */
	public int getQtdAulaTurma() {
		return qtdAulaTurma;
	}
	/**
	 * Método responsável por estabelecer o valor de qtdAulaTurma e validar o mesmo
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
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Quantidade de Aula", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do horarioTurma
	 * @return horarioTurma - valor do atributo
	 */
	public String getHorarioTurma() {
		return horarioTurma;
	}
	/**
	 * Método responsável por estabelecer o valor de horarioTurma e validar o mesmo
	 * @param horarioTurma - valor do atributo
	 */
	public void setHorarioTurma(String horarioTurma) {
		if(horarioTurma.length() < 15 || horarioTurma == null || horarioTurma == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Horário da Turma", 1);
		}
		else {
			this.horarioTurma = horarioTurma;
		}
	}



	/**
	 * Método responsável por retornar o valor do diaTurma
	 * @return diaTurma - valor do atributo
	 */
	public String getDiaTurma() {
		return diaTurma;
	}
	/**
	 * Método responsável por estabelecer o valor de diaTurma e validar o mesmo
	 * @param diaTurma - valor do atributo
	 */
	public void setDiaTurma(String diaTurma) {
		if(diaTurma.length() < 15 || diaTurma == null || diaTurma == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Dia da Turma", 1);
		}
		else {
			this.diaTurma = diaTurma;
		}
	}



	/**
	 * Método responsável por retornar o valor do codIdioma
	 * @return codIdioma - valor do atributo
	 */
	public int getCodIdioma() {
		return codIdioma;
	}
	/**
	 * Método responsável por estabelecer o valor de codIdioma e validar o mesmo
	 * @param codIdioma - valor do atributo
	 */
	public void setCodIdioma(int codIdioma) {
		try {
			if(codIdioma == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Idioma", 1);
			}
			else {
				this.codIdioma = codIdioma;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Idioma", 1);
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
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código do Tipo Ensino", 1);
			}
			else {
				this.codTE = codTE;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código do Tipo Ensino", 1);
		}
	}
	
	
}
