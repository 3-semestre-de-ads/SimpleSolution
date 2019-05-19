package controller;

import model.AdministradorDAO;
import view.TelaMenuAdministrador;

public class AppLoginPage{
	
	public void validaLogin(String usuario, String senha) {
		AdministradorDAO dao = new AdministradorDAO();
		if (usuario.indexOf("ADM")!= -1) {
			if (dao.efetuaLogin(usuario, senha)) {
				TelaMenuAdministrador tela =  new TelaMenuAdministrador();
				tela.open(usuario);
			}
		}else if (usuario.indexOf("ALN")!= -1) {
			//Inserir aqui controle da tela aluno
		}else if (usuario.indexOf("PRF")!= -1) {
			//COntrole tela professor
		}

	}

}
