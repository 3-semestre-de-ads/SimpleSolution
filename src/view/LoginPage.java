package view;

import org.eclipse.swt.widgets.Display;


import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.Menu;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

import model.*;

public class LoginPage {
	private static Text txbUsuario;
	private static Text txbSenha;


	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlLoginpage = new Shell();
		shlLoginpage.setSize(319, 240);
		shlLoginpage.setText("SimpleSolution - Login Page");


		txbUsuario = new Text(shlLoginpage, SWT.BORDER);
		txbUsuario.setBounds(10, 41, 293, 30);
		txbUsuario.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent arg0) {
				arg0.text = arg0.text.toUpperCase();

			}
		});

		Label lblNewLabel = new Label(shlLoginpage, SWT.NONE);
		lblNewLabel.setBounds(10, 15, 68, 20);
		lblNewLabel.setText("Usuário");

		Label lblNewLabel_1 = new Label(shlLoginpage, SWT.NONE);
		lblNewLabel_1.setBounds(10, 77, 68, 20);
		lblNewLabel_1.setText("Senha");

		txbSenha = new Text(shlLoginpage, SWT.BORDER);
		txbSenha.setBounds(10, 103, 293, 30);

		Button btnLogin = new Button(shlLoginpage, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				if (txbUsuario.getText().trim() != "" || txbSenha.getText().trim() != "") {
					if (txbUsuario.getText().contains("ADM")) {
						ConsultaDb cdb = new ConsultaDb();
						boolean consulta = cdb.consultaLoginAdm(txbUsuario.getText().trim(), txbSenha.getText().trim());						
						if (consulta) {
							shlLoginpage.close();
							MenuAdministrador tela = new MenuAdministrador();
							tela.open();
						}else {
							JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
						}
					}	
				}else if (txbUsuario.getText().contains("PRF")) {
					shlLoginpage.close();
					MenuProfessor tela = new MenuProfessor();
					tela.open();
				}else if (txbUsuario.getText().contains("ALN")) {
					shlLoginpage.close();
					MenuAluno tela = new MenuAluno();
					tela.open();
				}

			}
		});
		btnLogin.setBounds(10, 150, 293, 34);
		btnLogin.setText("Logar");

		shlLoginpage.open();
		shlLoginpage.layout();
		while (!shlLoginpage.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
