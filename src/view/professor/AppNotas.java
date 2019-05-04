package view.professor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AppNotas {
	private Table table;
	private Table table_1;
	private Text text;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(610, 512);
		shell.setText("Notas");
		
		Label lblProvas = new Label(shell, SWT.NONE);
		lblProvas.setText("Provas");
		lblProvas.setBounds(10, 10, 99, 20);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Alunos");
		label_1.setBounds(232, 10, 68, 20);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 36, 216, 269);
		
		TableColumn tableTurma = new TableColumn(table, SWT.NONE);
		tableTurma.setWidth(148);
		tableTurma.setText("Turma");
		
		TableColumn tableData = new TableColumn(table, SWT.NONE);
		tableData.setWidth(66);
		tableData.setText("Data");
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setEnabled(false);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(232, 36, 352, 396);
		
		TableColumn tableAluno = new TableColumn(table_1, SWT.NONE);
		tableAluno.setWidth(250);
		tableAluno.setText("Nome do Aluno");
		
		TableColumn tableNota = new TableColumn(table_1, SWT.NONE);
		tableNota.setWidth(100);
		tableNota.setText("Nota");
		tableNota.setResizable(false);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("Turma");
		label_2.setBounds(10, 311, 99, 20);
		
		text = new Text(shell, SWT.BORDER);
		text.setEnabled(false);
		text.setBounds(10, 337, 216, 30);
		
		Label lblDataDaProva = new Label(shell, SWT.NONE);
		lblDataDaProva.setText("Data da Prova");
		lblDataDaProva.setBounds(10, 373, 99, 20);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.SHORT);
		dateTime.setEnabled(false);
		dateTime.setBounds(10, 398, 216, 34);
		
		Button btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnCancelar.setBounds(488, 438, 95, 34);
		btnCancelar.setText("Cancelar");
		
		Button btnSalvar = new Button(shell, SWT.NONE);
		btnSalvar.setText("Salvar");
		btnSalvar.setBounds(387, 438, 95, 34);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
