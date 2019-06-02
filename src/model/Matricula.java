package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Matricula
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
	 * Método construtor 1
	 */
	public Matricula() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codMat
	 */
	public Matricula(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM MATRICULA WHERE codMat="+codigo+";");
		try {
			while (rs.next()) {
				setCodTurma(Integer.parseInt(rs.getString(1).toString()));
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");				
				setDataInMat((Date)format.parse(rs.getString(2).toString()));
				setDataFiMat((Date)format.parse(rs.getString(3).toString()));
				setCodAluno(Integer.parseInt(rs.getString(4).toString()));
				setCodTurma(Integer.parseInt(rs.getString(5).toString()));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * Método responsável por retornar o valor do codMat
	 * @return codMat - valor do atributo
	 */
	public int getCodMat() {
		return codMat;
	}
	/**
	 * Método responsável por estabelecer o valor de codMat e validar o mesmo
	 * @param codMat - valor do atributo
	 */
	public void setCodMat(int codMat) {
		try {
			if(codMat == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Matrícula", 1);
			}
			else {
				this.codMat = codMat;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Matrícula", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do dataInMat
	 * @return dataInMat - valor do atributo
	 */
	public Date getDataInMat() {
		return dataInMat;
	}
	/**
	 * Método responsável por estabelecer o valor de dataInMat e validar o mesmo
	 * @param dataInMat - valor do atributo
	 */
	public void setDataInMat(Date dataInMat) {
		try {
			if(dataInMat == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Início Matrícula", 1);
			}
			else {
				this.dataInMat = dataInMat;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data Início Matrícula", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do dataFiMat
	 * @return dataFiMat - valor do atributo
	 */
	public Date getDataFiMat() {
		return dataFiMat;
	}
	/**
	 * Método responsável por estabelecer o valor de dataFiMat e validar o mesmo
	 * @param dataFiMat - valor do atributo
	 */
	public void setDataFiMat(Date dataFiMat) {
		try {
			if(dataFiMat == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Final Matrícula", 1);
			}
			else {
				this.dataFiMat = dataFiMat;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data Final Matrícula", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do codAluno
	 * @return codAluno - valor do atributo
	 */
	public int getCodAluno() {
		return codAluno;
	}
	/**
	 * Método responsável por estabelecer o valor de codAluno e validar o mesmo
	 * @param codAluno - valor do atributo
	 */
	public void setCodAluno(int codAluno) {
		try {
			if(codAluno == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Aluno", 1);
			}
			else {
				this.codAluno = codAluno;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Aluno", 1);
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
	
	
	
}
