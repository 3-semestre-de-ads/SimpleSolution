package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a HistTurma
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
	 * Método construtor 1
	 */
	public HistTurma() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codHT
	 */
	public HistTurma(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM HISTTURMA WHERE codHT="+codigo+";");
		try {
			while (rs.next()) {
				setCodHT(Integer.parseInt(rs.getString(1).toString()));
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");				
				setDataInHT((Date)format.parse(rs.getString(2).toString()));
				setDataFiHT((Date)format.parse(rs.getString(3).toString()));
				setCodMat(Integer.parseInt(rs.getString(4).toString()));
				setCodProf(Integer.parseInt(rs.getString(5).toString()));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * Método responsável por retornar o valor do codHT
	 * @return codHT - valor do atributo
	 */
	public int getCodHT() {
		return codHT;
	}
	/**
	 * Método responsável por estabelecer o valor de codHT e validar o mesmo
	 * @param codHT - valor do atributo
	 */
	public void setCodHT(int codHT) {
		try {
			if(codHT == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Histórico Turma", 1);
			}
			else {
				this.codHT = codHT;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Histórico Turma", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do dataInHT
	 * @return dataInHT - valor do atributo
	 */
	public Date getDataInHT() {
		return dataInHT;
	}
	/**
	 * Método responsável por estabelecer o valor de dataInHT e validar o mesmo
	 * @param dataInHT - valor do atributo
	 */
	public void setDataInHT(Date dataInHT) {
		try {
			if(dataInHT == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Início Histórico Turma", 1);
			}
			else {
				this.dataInHT = dataInHT;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data Início Histórico Turma", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do dataFiHT
	 * @return dataFiHT - valor do atributo
	 */
	public Date getDataFiHT() {
		return dataFiHT;
	}
	/**
	 * Método responsável por estabelecer o valor de dataFiHT e validar o mesmo
	 * @param dataFiHT - valor do atributo
	 */
	public void setDataFiHT(Date dataFiHT) {
		try {
			if(dataFiHT == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Fim Histórico Turma", 1);
			}
			else {
				this.dataFiHT = dataFiHT;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data Fim Histórico Turma", 1);
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
	 * Método responsável por retornar o valor do codProf
	 * @return codProf - valor do atributo
	 */
	public int getCodProf() {
		return codProf;
	}
	/**
	 * Método responsável por estabelecer o valor de codProf e validar o mesmo
	 * @param codProf - valor do atributo
	 */
	public void setCodProf(int codProf) {
		try {
			if(codProf == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Professor", 1);
			}
			else {
				this.codProf = codProf;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Professor", 1);
		}
	}

	
}
