package model;
/**
 * A classe "Idioma" permite o cadastro dos idiomas
 * e seus respectivos atributos.
 * @author Andressa, Ede, Leonardo, Nat�lia.
 */
public class Idioma {
	private int codIdioma;
	private String nomeIdioma;
	private String nivelIdioma;
	/**
	 * @return o codIdioma
	 */
	private int getCodIdioma() {
		return codIdioma;
	}
	/**
	 * @param codIdioma o codIdioma para set
	 */
	private void setCodIdioma(int codIdioma) {
		this.codIdioma = codIdioma;
	}
	/**
	 * @return o nomeIdioma
	 */
	private String getNomeIdioma() {
		return nomeIdioma;
	}
	/**
	 * @param nomeIdioma o nomeIdioma para set
	 */
	private void setNomeIdioma(String nomeIdioma) {
		this.nomeIdioma = nomeIdioma;
	}
	/**
	 * @return o nivelIdioma
	 */
	private String getNivelIdioma() {
		return nivelIdioma;
	}
	/**
	 * @param nivelIdioma o nivelIdioma para set
	 */
	private void setNivelIdioma(String nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}
}
