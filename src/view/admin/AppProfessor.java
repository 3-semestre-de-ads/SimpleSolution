package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AppProfessor {

	protected Shell shlProfessor;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Table table;



	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlProfessor.open();
		shlProfessor.layout();
		while (!shlProfessor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlProfessor = new Shell();
		shlProfessor.setSize(729, 465);
		shlProfessor.setText("Professor - <cod_professor>");
		
		Label label = new Label(shlProfessor, SWT.NONE);
		label.setText("Código");
		label.setBounds(10, 10, 68, 20);
		
		text = new Text(shlProfessor, SWT.BORDER);
		text.setEnabled(false);
		text.setEditable(false);
		text.setBounds(10, 38, 153, 30);
		
		Label label_1 = new Label(shlProfessor, SWT.NONE);
		label_1.setText("Nome");
		label_1.setBounds(10, 74, 68, 20);
		
		text_1 = new Text(shlProfessor, SWT.BORDER);
		text_1.setBounds(10, 100, 340, 30);
		
		Label label_2 = new Label(shlProfessor, SWT.NONE);
		label_2.setText("E-mail");
		label_2.setBounds(10, 136, 68, 20);
		
		text_2 = new Text(shlProfessor, SWT.BORDER);
		text_2.setBounds(10, 159, 340, 30);
		
		Label label_3 = new Label(shlProfessor, SWT.NONE);
		label_3.setText("Data de Nascimento");
		label_3.setBounds(149, 195, 178, 20);
		
		Label label_4 = new Label(shlProfessor, SWT.NONE);
		label_4.setText("RG");
		label_4.setBounds(10, 195, 68, 20);
		
		text_3 = new Text(shlProfessor, SWT.BORDER);
		text_3.setBounds(10, 221, 133, 30);
		
		DateTime dateTime = new DateTime(shlProfessor, SWT.BORDER | SWT.CALENDAR | SWT.SHORT);
		dateTime.setBounds(149, 221, 201, 157);
		
		text_4 = new Text(shlProfessor, SWT.BORDER);
		text_4.setBounds(10, 286, 133, 30);
		
		Label label_5 = new Label(shlProfessor, SWT.NONE);
		label_5.setText("Telefone");
		label_5.setBounds(10, 257, 68, 20);
		
		Label label_6 = new Label(shlProfessor, SWT.NONE);
		label_6.setText("CPF");
		label_6.setBounds(10, 322, 68, 20);
		
		text_5 = new Text(shlProfessor, SWT.BORDER);
		text_5.setBounds(10, 348, 133, 30);
		
		Label lblNewLabel = new Label(shlProfessor, SWT.NONE);
		lblNewLabel.setBounds(369, 10, 68, 20);
		lblNewLabel.setText("Turmas");
		
		table = new Table(shlProfessor, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(369, 38, 344, 380);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCodigo = new TableColumn(table, SWT.NONE);
		tblclmnCodigo.setWidth(72);
		tblclmnCodigo.setText("Codigo");
		
		TableColumn tblclmnIdioma = new TableColumn(table, SWT.NONE);
		tblclmnIdioma.setWidth(103);
		tblclmnIdioma.setText("Idioma");
		
		TableColumn tblclmnTe = new TableColumn(table, SWT.NONE);
		tblclmnTe.setWidth(65);
		tblclmnTe.setText("TE");
		
		TableColumn tblclmnNa = new TableColumn(table, SWT.NONE);
		tblclmnNa.setWidth(100);
		tblclmnNa.setText("NA");
		
		Button btnSalvar = new Button(shlProfessor, SWT.NONE);
		btnSalvar.setBounds(149, 384, 95, 34);
		btnSalvar.setText("Salvar");
		
		Button btnCancelar = new Button(shlProfessor, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlProfessor.close();
			}
		});
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(255, 384, 95, 34);

	}

}
