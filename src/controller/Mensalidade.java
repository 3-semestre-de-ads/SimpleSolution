package controller;

import java.sql.Date;
/**
 * A classe "Mensalidade consiste na criação
 * do cadastro da mensalidade e seus respectivos atributos.
 * @author Andressa, Ede, Leonardo, Natália
 */
public class Mensalidade {
	/**
	 * @return o codMensalidade
	 */
	private int getCodMensalidade() {
		return codMensalidade;
	}
	/**
	 * @param codMensalidade o codMensalidade para set
	 */
	private void setCodMensalidade(int codMensalidade) {
		this.codMensalidade = codMensalidade;
	}
	/**
	 * @return o codTE
	 */
	private int getCodTE() {
		return codTE;
	}
	/**
	 * @param codTE o codTE para set
	 */
	private void setCodTE(int codTE) {
		this.codTE = codTE;
	}
	/**
	 * @return o valorMensal
	 */
	private double getValorMensal() {
		return valorMensal;
	}
	/**
	 * @param valorMensal o valorMensal para set
	 */
	private void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	/**
	 * @return o dataInMens
	 */
	private Date getDataInMens() {
		return dataInMens;
	}
	/**
	 * @param dataInMens o dataInMens para set
	 */
	private void setDataInMens(Date dataInMens) {
		this.dataInMens = dataInMens;
	}
	/**
	 * @return o dataFiMens
	 */
	private Date getDataFiMens() {
		return dataFiMens;
	}
	/**
	 * @param dataFiMens o dataFiMens para set
	 */
	private void setDataFiMens(Date dataFiMens) {
		this.dataFiMens = dataFiMens;
	}
	private int codMensalidade;
	private int codTE;
	private double valorMensal;
	private Date dataInMens;
	private Date dataFiMens;

}
