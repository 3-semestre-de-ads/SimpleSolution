package model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por receber e estabelecer os atributos referentes a TipoEnsino
 * @author Simple Solution Devs
 */
public class TipoEnsino {
	
	/**
	 * Atributos da classe (colunas da tabela NOTA)
	 */
	private int codTE;
	private String nomeTE;
	private int qtdAlunoTE;
	
	
	/**
	 * Método construtor 1
	 */
	public TipoEnsino() {
	}


	
	/**
	 * Método construtor 2
	 * @param codigo - valor do atributo codTE
	 */
	public TipoEnsino(String codigo) {
		DbConn cdb = new DbConn();
		ResultSet rs = cdb.consultaRegistro("SELECT * FROM TIPOENSINO WHERE codTE="+codigo+";");
		try {
			while (rs.next()) {
				setCodTE(Integer.parseInt(rs.getString(1).toString()));
				setNomeTE(rs.getString(1).toString());
				setQtdAlunoTE(Integer.parseInt(rs.getString(1).toString()));
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}



	/**
	 * Método responsável por retornar o valor do getCodTE
	 * @return getCodTE - valor do atributo
	 */
	public int getCodTE() {
		return codTE;
	}
	/**
	 * Método responsável por estabelecer o valor de getCodTE e validar o mesmo
	 * @param getCodTE - valor do atributo
	 */
	public void setCodTE(int codTE) {
		try {
			if(codTE == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Código Tipo Ensino", 1);
			}
			else {
				this.codTE = codTE;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Código Tipo Ensino", 1);
		}
	}



	/**
	 * Método responsável por retornar o valor do nomeTE
	 * @return nomeTE - valor do atributo
	 */
	public String getNomeTE() {
		return nomeTE;
	}
	/**
	 * Método responsável por estabelecer o valor de nomeTE e validar o mesmo
	 * @param nomeTE - valor do atributo
	 */
	public void setNomeTE(String nomeTE) {
		if(nomeTE.length() < 10 || nomeTE == null || nomeTE == "") {
			JOptionPane.showMessageDialog(null, "Tamanho acima do esperado ou campo nulo", "Nome Tipo Ensino", 1);
		}
		else {
			this.nomeTE = nomeTE;
		}
	}



	/**
	 * Método responsável por retornar o valor do qtdAlunoTE
	 * @return qtdAlunoTE - valor do atributo
	 */
	public int getQtdAlunoTE() {
		return qtdAlunoTE;
	}
	/**
	 * Método responsável por estabelecer o valor de qtdAlunoTE e validar o mesmo
	 * @param qtdAlunoTE - valor do atributo
	 */
	public void setQtdAlunoTE(int qtdAlunoTE) {
		try {
			if(qtdAlunoTE == 0) {
				JOptionPane.showMessageDialog(null, "O dado inserido deve ser maior que 0", "Quantidade de Aluno", 1);
			}
			else {
				this.qtdAlunoTE = qtdAlunoTE;
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "O dado inserido deve ser um número", "Quantidade de Aluno", 1);
		}
	}

}
