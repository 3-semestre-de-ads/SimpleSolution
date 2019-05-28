package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a HistMens
 * @author Simple Solution Devs
 */
public class HistMens {

	/**
	 * Atributos da classe (colunas da tabela HISTMENS)
	 */
	private int codHM;
	private Date dataPgHM;
	private double jurosPgHM;
	private int codAluno;
	private int codMens;
	
	
	
	/**
	 * Método construtor 1
	 */
	public HistMens() {
	}



	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codMat
	 */
	public HistMens(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM HISTMENS WHERE codHM="+codigo+";");
		try {
			while (rs.next()) {
				setCodHM(Integer.parseInt(rs.getString(1).toString()));
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");				
				setDataPgHM((Date)format.parse(rs.getString(2).toString()));
				setJurosPgHM(Double.parseDouble(rs.getString(3).toString()));
				setCodAluno(Integer.parseInt(rs.getString(4).toString()));
				setCodMens(Integer.parseInt(rs.getString(5).toString()));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * Método responsável por retornar o valor do codHM
	 * @return codHM - valor do atributo
	 */
	public int getCodHM() {
		return codHM;
	}
	/**
	 * Método responsável por estabelecer o valor de codHM e validar o mesmo
	 * @param codHM - valor do atributo
	 */
	public void setCodHM(int codHM) {
		try {
			if(codHM == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Histórico Mensalidade", 1);
			}
			else {
				this.codHM = codHM;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Histórico Mensalidade", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do dataPgHM
	 * @return dataPgHM - valor do atributo
	 */
	public Date getDataPgHM() {
		return dataPgHM;
	}
	/**
	 * Método responsável por estabelecer o valor de dataPgHM e validar o mesmo
	 * @param dataPgHM - valor do atributo
	 */
	public void setDataPgHM(Date dataPgHM) {
		try {
			if(dataPgHM == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data Pagamento", 1);
			}
			else {
				this.dataPgHM = dataPgHM;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data Pagamento", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do jurosPgHM
	 * @return jurosPgHM - valor do atributo
	 */
	public double getJurosPgHM() {
		return jurosPgHM;
	}
	/**
	 * Método responsável por estabelecer o valor de jurosPgHM e validar o mesmo
	 * @param jurosPgHM - valor do atributo
	 */
	public void setJurosPgHM(double jurosPgHM) {
		try {
			this.jurosPgHM = jurosPgHM;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Juros do Pagamento", 1);
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
	 * Método responsável por retornar o valor do codMens
	 * @return codMens - valor do atributo
	 */
	public int getCodMens() {
		return codMens;
	}
	/**
	 * Método responsável por estabelecer o valor de codMens e validar o mesmo
	 * @param codMens - valor do atributo
	 */
	public void setCodMens(int codMens) {
		try {
			if(codMens == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Mensalidade", 1);
			}
			else {
				this.codMens = codMens;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Mensalidade", 1);
		}
	}
	
	
	
	
}
