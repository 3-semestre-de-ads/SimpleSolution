package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;

public class TelaMenuAluno {
	private Table table;
	private Table table_1;
	private Table table_2;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(858, 495);
		shell.setText("Simple Solution - Aluno");
		GridLayout gl_shell = new GridLayout(3, false);
		gl_shell.verticalSpacing = 3;
		shell.setLayout(gl_shell);
		
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

		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("Faltas");
		
		Label lblNotas = new Label(shell, SWT.NONE);
		lblNotas.setText("Notas");
		
		Label lblMensalidaes = new Label(shell, SWT.NONE);
		lblMensalidaes.setText("Mensalidades");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnTurma = new TableColumn(table, SWT.NONE);
		tblclmnTurma.setWidth(120);
		tblclmnTurma.setText("Turma");
		
		TableColumn tblclmnFaltas = new TableColumn(table, SWT.NONE);
		tblclmnFaltas.setWidth(40);
		tblclmnFaltas.setText("Faltas");
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table_1, SWT.NONE);
		tableColumn.setWidth(120);
		tableColumn.setText("Turma");
		
		TableColumn tblclmnNotas = new TableColumn(table_1, SWT.NONE);
		tblclmnNotas.setWidth(40);
		tblclmnNotas.setText("Notas");
		
		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		TableColumn tblclmnValor = new TableColumn(table_2, SWT.NONE);
		tblclmnValor.setWidth(120);
		tblclmnValor.setText("Valor");
		
		TableColumn tblclmnData = new TableColumn(table_2, SWT.NONE);
		tblclmnData.setWidth(40);
		tblclmnData.setText("Data");
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);


		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
