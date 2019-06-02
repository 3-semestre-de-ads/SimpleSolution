package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import controller.AppLoginPage;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaLoginPage {
	public Text txbSenha;
	public Text txbUsuario;
	public Button btnLogar;


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlLoginPage = new Shell();
		shlLoginPage.setSize(318, 240);
		shlLoginPage.setText("Login Page");
		
		btnLogar = new Button(shlLoginPage, SWT.NONE);
		btnLogar.setText("Logar");
		btnLogar.setBounds(10, 145, 293, 34);
			
		txbSenha = new Text(shlLoginPage, SWT.BORDER);
		txbSenha.setBounds(10, 98, 293, 30);
		
		Label label = new Label(shlLoginPage, SWT.NONE);
		label.setText("Senha");
		label.setBounds(10, 72, 68, 20);
		
		txbUsuario = new Text(shlLoginPage, SWT.BORDER);
		txbUsuario.setBounds(10, 36, 293, 30);
		
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
