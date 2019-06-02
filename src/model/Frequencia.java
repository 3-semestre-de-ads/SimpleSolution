package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Frequência
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
	 * Método construtor 1
	 */
	public Frequencia () {
	}



	//????
	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codFreq
	 */
	public Frequencia (String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM FREQUENCIA WHERE codFreq="+codigo+";");
		try {
			while (rs.next()) {
				setCodFreq(Integer.parseInt(rs.getString(1).toString()));
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				setDataFreq((Date)format.parse(rs.getString(2).toString()));
				setStatusFreq(rs.getString(3).toString());
				setCodMat(Integer.parseInt(rs.getString(4).toString()));				
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * Método responsável por retornar o valor do codFreq
	 * @return codFreq - valor do atributo
	 */
	public int getCodFreq() {
		return codFreq;
	}
	/**
	 * Método responsável por estabelecer o valor de codFreq e validar o mesmo
	 * @param codFreq - valor do atributo
	 */
	public void setCodFreq(int codFreq) {
		try {
			if(codFreq == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Frequência", 1);
			}
			else {
				this.codFreq = codFreq;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Frequência", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do dataFreq
	 * @return dataFreq - valor do atributo
	 */
	public Date getDataFreq() {
		return dataFreq;
	}
	/**
	 * Método responsável por estabelecer o valor de dataFreq e validar o mesmo
	 * @param dataFreq - valor do atributo
	 */
	public void setDataFreq(Date dataFreq) {
		try {
			if(dataFreq == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Frequência", 1);
			}
			else {
				this.dataFreq = dataFreq;
			}
		}
		catch(DateTimeParseException e){
			JOptionPane.showMessageDialog(null, e, "Data Frequência", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do statusFreq
	 * @return statusFreq - valor do atributo
	 */
	public String getStatusFreq() {
		return statusFreq;
	}
	/**
	 * Método responsável por estabelecer o valor de statusFreq e validar o mesmo
	 * @param statusFreq - valor do atributo
	 */
	public void setStatusFreq(String statusFreq) {
		if(statusFreq.length() > 1 || statusFreq == null || statusFreq == "" || statusFreq != "P" && statusFreq != "F") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, valor incorreto ou campo nulo", "Status Frequência", 1);
		}
		else {
			this.statusFreq = statusFreq;
		}
	}



	//SELECT PARA VALIDAR codMAt
	/**
	 * Método responsável por retornar o valor do codResponsavel
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

}
