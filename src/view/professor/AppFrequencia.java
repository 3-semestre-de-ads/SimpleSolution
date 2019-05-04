package view.professor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;

public class AppFrequencia {
	private Text text_2;
	private Table table;
	private Table table_1;


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(600, 510);
		shell.setText("Frequência");
		
		Label lblIdioma = new Label(shell, SWT.NONE);
		lblIdioma.setText("Turma");
		lblIdioma.setBounds(10, 311, 99, 20);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setEnabled(false);
		text_2.setBounds(10, 337, 216, 30);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setEnabled(false);
		table.setBounds(232, 36, 352, 396);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNomeAluno = new TableColumn(table, SWT.NONE);
		tblclmnNomeAluno.setWidth(250);
		tblclmnNomeAluno.setText("Nome do Aluno");
		
		TableColumn tblclmnPresenca = new TableColumn(table, SWT.NONE);
		tblclmnPresenca.setResizable(false);
		tblclmnPresenca.setWidth(100);
		tblclmnPresenca.setText("Presença");
		
		Label lblAlunos = new Label(shell, SWT.NONE);
		lblAlunos.setText("Alunos");
		lblAlunos.setBounds(232, 10, 68, 20);
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(10, 36, 216, 269);
		
		TableColumn tblclmnIdioma = new TableColumn(table_1, SWT.NONE);
		tblclmnIdioma.setWidth(100);
		tblclmnIdioma.setText("Idioma");
		
		TableColumn tblclmnDias = new TableColumn(table_1, SWT.NONE);
		tblclmnDias.setWidth(100);
		tblclmnDias.setText("Dias");
		
		Label lblTurma = new Label(shell, SWT.NONE);
		lblTurma.setText("Turmas");
		lblTurma.setBounds(10, 10, 99, 20);
		
		Button btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnCancelar.setBounds(489, 437, 95, 34);
		btnCancelar.setText("Cancelar");
		
		Button btnSalvar = new Button(shell, SWT.NONE);
		btnSalvar.setBounds(388, 437, 95, 34);
		btnSalvar.setText("Salvar");
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.SHORT);
		dateTime.setEnabled(false);
		dateTime.setBounds(10, 398, 216, 34);
		
		Label lblDataDaAula = new Label(shell, SWT.NONE);
		lblDataDaAula.setText("Data da Aula");
		lblDataDaAula.setBounds(10, 373, 99, 20);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
