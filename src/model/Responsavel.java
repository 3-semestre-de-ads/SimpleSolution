package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por receber e estabelecer os atributos referentes a Responsavel
 * @author Simple Solution Devs
 */
public class Responsavel {

	/**
	 * Atributos da classe (colunas da tabela Resp)
	 */
	private int codResp;
	private String nomeResp;
	private Date nascResp;
	private String rgResp;
	private String cpfResp;
	private String emailResp;
	private String telResp;
	private String statusResp;



	/**
	 * M�todo construtor 1
	 */
	public Responsavel() {
	}



	/**
	 * M�todo construtor 2
	 * @param codigo - valor do atributo codResp
	 */
	public Responsavel(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM RESPONSAVEL WHERE codResp="+codigo+";");
		try {
			while (rs.next()) {
				setCodResp(Integer.parseInt(rs.getString(1).toString()));
				setNomeResp(rs.getString(2).toString());
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");				
				setNascResp((Date)format.parse(rs.getString(3).toString()));
				setRgResp(rs.getString(4).toString());
				setCpfResp(rs.getString(5).toString());
				setEmailResp(rs.getString(6).toString());
				setTelResp(rs.getString(7).toString());
				setStatusResp(rs.getString(9).toString());
				setCodResp(Integer.parseInt(rs.getString(10).toString()));					
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do codResp
	 * @return codResp - valor do atributo
	 */
	public int getCodResp() {
		return codResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de codResp e validar o mesmo
	 * @param codResp - valor do atributo
	 */
	public void setCodResp(int codResp) {
		try {
			if(codResp == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "C�digo Respons�vel", 1);
			}
			else {
				this.codResp = codResp;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "C�digo Respons�vel", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do nomeResp
	 * @return nomeResp - valor do atributo
	 */
	public String getNomeResp() {
		return nomeResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nomeResp e validar o mesmo
	 * @param nomeResp - valor do atributo
	 */
	public void setNomeResp(String nomeResp) {
		if(nomeResp.length() < 20 || nomeResp == null || nomeResp == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Respons�vel", 1);
		}
		else {
			this.nomeResp = nomeResp;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do nascResp
	 * @return nascResp - valor do atributo
	 */
	public Date getNascResp() {
		return nascResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de nascResp e validar o mesmo
	 * @param nascResp - valor do atributo
	 */
	public void setNascResp(Date nascResp) {
		try {
			if(nascResp == null) {
				JOptionPane.showMessageDialog(null, "Campo nulo", "Nascimento Respons�vel", 1);
			}
			else {
				this.nascResp = nascResp;
			}
		}
		catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, e, "Nascimento Respons�vel", 1);
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do rgResp
	 * @return rgResp - valor do atributo
	 */
	public String getRgResp() {
		return rgResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de rgResp e validar o mesmo
	 * @param rgResp - valor do atributo
	 */
	public void setRgResp(String rgResp) {
		if(rgResp.length() < 10 || rgResp == null || rgResp == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "RG Respons�vel", 1);
		}
		else {
			this.rgResp = rgResp;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do cpfResp
	 * @return cpfResp - valor do atributo
	 */
	public String getCpfResp() {
		return cpfResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de cpfResp e validar o mesmo
	 * @param cpfResp - valor do atributo
	 */
	public void setCpfResp(String cpfResp) {
		if(cpfResp.length() < 11) {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado", "CPF Resp", 1);
		}
		else {
			this.cpfResp = cpfResp;
		}
		JOptionPane.showMessageDialog(null, "O dado inserido deve ser um n�mero", "CPF Respons�vel", 1);
	}



	/**
	 * M�todo respons�vel por retornar o valor do emailResp
	 * @return emailResp - valor do atributo
	 */
	public String getEmailResp() {
		return emailResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de emailResp e validar o mesmo
	 * @param emailResp - valor do atributo
	 */
	public void setEmailResp(String emailResp) {
		if(emailResp.length() < 35 || emailResp == null || emailResp == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "E-mail Respons�vel", 1);
		}
		else {
			this.emailResp = emailResp;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do telResp
	 * @return telResp - valor do atributo
	 */
	public String getTelResp() {
		return telResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de teleResp e validar o mesmo
	 * @param teleResp - valor do atributo
	 */
	public void setTelResp(String telResp) {
		if(telResp.length() < 11 || telResp == null || telResp == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Telefone Respons�vel", 1);
		}
		else {
			this.telResp = telResp;
		}
	}



	/**
	 * M�todo respons�vel por retornar o valor do statusResp
	 * @return statusResp - valor do atributo
	 */
	public String getStatusResp() {
		return statusResp;
	}
	/**
	 * M�todo respons�vel por estabelecer o valor de statusResp e validar o mesmo
	 * @param statusResp - valor do atributo
	 */
	public void setStatusResp(String statusResp) {
		if(statusResp.length() > 1 || statusResp == null || statusResp == "" || statusResp != "A" && statusResp != "I") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado, valor incorreto ou campo nulo", "Status Respons�vel", 1);
		}
		else {
			this.statusResp = statusResp;
		}
	}

}
