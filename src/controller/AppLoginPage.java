package controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;



import model.AdministradorDAO;
import view.TelaLoginPage;
import view.TelaMenuAdministrador;

public class AppLoginPage{
	
	public static void validaLogin(String usuario, String senha) {
		System.out.println(usuario + senha);
		AdministradorDAO dao = new AdministradorDAO();
		if (usuario.indexOf("ADM")!= -1) {
			if (dao.efetuarLogin(usuario, senha)) {
				TelaMenuAdministrador tela =  new TelaMenuAdministrador();
				tela.open(usuario);
			}
		}else if (usuario.indexOf("ALN")!= -1) {
			//Inserir aqui controle da tela aluno
		}else if (usuario.indexOf("PRF")!= -1) {
			//COntrole tela professor
		}

	}
	public static void abreTela() {
		TelaLoginPage tela = new TelaLoginPage();
		tela.open();
		tela.btnLogar.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				validaLogin(tela.txbUsuario.getText(), tela.txbSenha.getText());				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public static void main(String[] args) {
		abreTela();
	}

}
