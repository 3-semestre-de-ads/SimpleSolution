package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import model.AdministradorDAO;
import model.Aluno;
import model.AlunoDAO;
import model.Professor;
import model.ProfessorDAO;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

public class TelaLoginPage {
	public Text txbSenha;
	public Text txbUsuario;
	public Button btnLogar;
	public Display display;
	public Shell shlLoginPage;

	public static void main(String[] args) {
		TelaLoginPage tela = new TelaLoginPage();
		tela.open();
	}
	public void limpaCampos() {
		txbUsuario.setText("");
		txbSenha.setText("");
		txbUsuario.setFocus();
	}
	public void validaLogin() {

		if (txbUsuario.getText().contains("ADM")) {
			AdministradorDAO dao = new AdministradorDAO();
			if (dao.efetuarLogin(txbUsuario.getText(), txbSenha.getText())) {
				TelaMenuAdministrador tela =  new TelaMenuAdministrador();					
				tela.open(txbUsuario.getText());
				limpaCampos();

			}
		}else if (txbUsuario.getText().contains("ALN")) {
			AlunoDAO dao = new AlunoDAO();
			Aluno r = dao.efetuarLogin(txbUsuario.getText(), txbSenha.getText());
			if (r != null) {
				TelaMenuAluno tela =  new TelaMenuAluno();
				tela.open(r);
				limpaCampos();				
			}

		}else if (txbUsuario.getText().contains("PRF")) {
			ProfessorDAO dao = new ProfessorDAO();
			Professor p = dao.efetuarLogin(txbUsuario.getText(), txbSenha.getText());
			if (p != null) {
				TelaMenuProfessor tela =  new TelaMenuProfessor();
				tela.open(p);
				limpaCampos();
			}	
		}

	}
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		display = Display.getDefault();
		shlLoginPage = new Shell();
		shlLoginPage.setSize(318, 240);
		shlLoginPage.setText("Login Page");

		txbUsuario = new Text(shlLoginPage, SWT.BORDER);
		txbUsuario.setBounds(10, 36, 293, 30);
		txbUsuario.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent arg0) {
				arg0.text = arg0.text.toUpperCase();

			}
		});


		txbSenha = new Text(shlLoginPage, SWT.PASSWORD);
		txbSenha.setBounds(10, 98, 293, 30);
		txbSenha.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.keyCode == SWT.CR) {					
					validaLogin();
				}

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		Label label = new Label(shlLoginPage, SWT.NONE);
		label.setText("Senha");
		label.setBounds(10, 72, 68, 20);




		btnLogar = new Button(shlLoginPage, SWT.NONE);
		btnLogar.setText("Logar");
		btnLogar.setBounds(10, 145, 293, 34);
		btnLogar.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				validaLogin();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});


		Label label_1 = new Label(shlLoginPage, SWT.NONE);
		label_1.setText("Usuário");
		label_1.setBounds(10, 10, 68, 20);

		shlLoginPage.open();
		shlLoginPage.layout();
		while (!shlLoginPage.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
