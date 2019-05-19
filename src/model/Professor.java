package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.ibm.icu.text.DateFormat;

import services.DbConn;

/**
 * A classe "Professor" consiste na cria��o 
 * para cadastro de professor e seus atributos.
 * @author Andressa, Ede, Leonardo, Nat�lia
 *
 */
public class Professor {
	private int codProf;
	private String nomeProf;
	private Date nascProf;
	private String rgProf;
	private String cpfProf;
	private String emailProf;
	private String telefoneProf;
	private String statusProf;
	


	public Professor(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM PROFESSOR WHERE codProf="+codigo+";");
		try {
			while (rs.next()) {
				setCodProf(Integer.parseInt(rs.getString(1).toString()));
				setNomeProf(rs.getString(2).toString());
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");				
				setNascProf((Date)format.parse(rs.getString(3).toString()));
				setRgProf(rs.getString(4).toString());
				setCpfProf(rs.getString(5).toString());
				setEmailProf(rs.getString(6).toString());
				setTelefoneProf(rs.getString(7).toString());
				setStatusProf(rs.getString(9).toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	/**
	 * @return o codProf
	 */
	private int getCodProf() {
		return codProf;
	}
	/**
	 * @param codProf o codProf para set
	 */
	private void setCodProf(int codProf) {
		this.codProf = codProf;
	}
	/**
	 * @return o nomeProf
	 */
	private String getNomeProf() {
		return nomeProf;
	}
	/**
	 * @param nomeProf o nomeProf para set
	 */
	private void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}
	/**
	 * @return o nascProf
	 */
	private Date getNascProf() {
		return nascProf;
	}
	/**
	 * @param nascProf o nascProf para set
	 */
	private void setNascProf(Date nascProf) {
		this.nascProf = nascProf;
	}
	/**
	 * @return o rgProf
	 */
	private String getRgProf() {
		return rgProf;
	}
	/**
	 * @param rgProf o rgProf para set
	 */
	private void setRgProf(String rgProf) {
		this.rgProf = rgProf;
	}
	/**
	 * @return o cpfProf
	 */
	private String getCpfProf() {
		return cpfProf;
	}
	/**
	 * @param cpfProf o cpfProf para set
	 */
	private void setCpfProf(String cpfProf) {
		this.cpfProf = cpfProf;
	}
	/**
	 * @return o emailProf
	 */
	private String getEmailProf() {
		return emailProf;
	}
	/**
	 * @param emailProf o emailProf para set
	 */
	private void setEmailProf(String emailProf) {
		this.emailProf = emailProf;
	}
	/**
	 * @return o telefoneProf
	 */
	private String getTelefoneProf() {
		return telefoneProf;
	}
	/**
	 * @param telefoneProf o telefoneProf para set
	 */
	private void setTelefoneProf(String telefoneProf) {
		this.telefoneProf = telefoneProf;
	}
	
	public String getStatusProf() {
		return statusProf;
	}

	public void setStatusProf(String statusProf) {
		this.statusProf = statusProf;
	}

}

