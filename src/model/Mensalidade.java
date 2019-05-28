package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a Mensalidade
 * @author Simple Solution Devs
 */
public class Mensalidade {
	
	/**
	 * Atributos da classe (colunas da tabela MENSALIDADE)
	 */
	private int codMens;
	private double descontoMens;
	private String tipoPgMens;
	private Date dataVencMens;
	
	
	
	/**
	 * Método construtor 1
	 */
	public Mensalidade () {
	}



	//????
	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codMens
	 */
	public Mensalidade (String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM MENSALIDADE WHERE codAMens="+codigo+";");
		try {
			while (rs.next()) {
				setCodMens(Integer.parseInt(rs.getString(1).toString()));
				setDescontoMens(Double.parseDouble((rs.getString(2).toString())));
				setTipoPgMens(rs.getString(3).toString());
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");				
				setDataVencMens((Date)format.parse(rs.getString(3).toString()));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
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
	
	
	/**
	 * Método responsável por retornar o valor do descontoMens
	 * @return descontoMens - valor do atributo
	 */
	public double getDescontoMens() {
		return descontoMens;
	}
	/**
	 * Método responsável por estabelecer o valor de descontoMens e validar o mesmo
	 * @param descontoMens - valor do atributo
	 */
	public void setDescontoMens(double descontoMens) {
		try {
			this.descontoMens = descontoMens;
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Desconto Mensalidade", 1);
		}
	}
	
	
	
	/**
	 * Método responsável por retornar o valor do tipoPgMens
	 * @return tipoPgMens - valor do atributo
	 */
	public String getTipoPgMens() {
		return tipoPgMens;
	}
	/**
	 * Método responsável por estabelecer o valor de tipoPgMens e validar o mesmo
	 * @param tipoPgMens - valor do atributo
	 */
	public void setTipoPgMens(String tipoPgMens) {
		if(tipoPgMens.length() < 10 || tipoPgMens == null || tipoPgMens == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Tipo do Pagamento", 1);
		}
		else{
			this.tipoPgMens = tipoPgMens;
		}
	}
	
	
	
	/**
	 * Método responsável por retornar o valor do dataVencMens
	 * @return dataVencMens - valor do atributo
	 */
	public Date getDataVencMens() {
		return dataVencMens;
	}
	/**
	 * Método responsável por estabelecer o valor de dataVencMens e validar o mesmo
	 * @param dataVencMens - valor do atributo
	 */
	public void setDataVencMens(Date dataVencMens) {
		try {
			if(dataVencMens == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Data de Vencimento", 1);
			}
			else {
				this.dataVencMens = dataVencMens;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Data de Vencimento", 1);
		}
	}
	
}
