package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MenuAluno {

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Simple Solution - Aluno");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		/*
		 * Criando Menu Arquivo
		 */
		MenuItem itemArquivo = new MenuItem(menu, SWT.CASCADE);
		itemArquivo.setText("Arquivo");		
		Menu menuArquivo= new Menu(itemArquivo);
		itemArquivo.setMenu(menuArquivo);
		
			/*
			 * Criação de Submenus Arquivo
			 */
			MenuItem itemSair = new MenuItem(menuArquivo, SWT.NONE);
			itemSair.setText("Logoff");
			itemSair.addSelectionListener(new SelectionAdapter() {
			      public void widgetSelected(SelectionEvent e) {
			    	  shell.close();
			          LoginPage tela = new LoginPage();
			          tela.main(null);
			        }
			      });

		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
