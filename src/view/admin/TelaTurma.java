package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaTurma {

	protected Shell shlTurma;
	private Text txbCodigo;
	private Text txbDiasAula;
	private Text txbCodProf;
	private Text txbNomeProf;
	private Text txbCodIdioma;
	private Text txbIdioma;
	private Table table;
	private Text text;
	private Text text_1;



	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlTurma.open();
		shlTurma.layout();
		while (!shlTurma.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTurma = new Shell();
		shlTurma.setSize(800, 458);
		shlTurma.setText("Turma - <cod_turma>");
		
		Label lblNewLabel = new Label(shlTurma, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 68, 20);
		lblNewLabel.setText("Código");
		
		txbCodigo = new Text(shlTurma, SWT.BORDER);
		txbCodigo.setEditable(false);
		txbCodigo.setEnabled(false);
		txbCodigo.setBounds(10, 36, 181, 30);
		
		Label lblDiasDeAula = new Label(shlTurma, SWT.NONE);
		lblDiasDeAula.setText("Dias de Aula");
		lblDiasDeAula.setBounds(10, 72, 111, 20);
		
		txbDiasAula = new Text(shlTurma, SWT.BORDER);
		txbDiasAula.setBounds(10, 96, 181, 30);
		
		Label lblHorrio = new Label(shlTurma, SWT.NONE);
		lblHorrio.setText("Horário");
		lblHorrio.setBounds(10, 132, 111, 20);
		
		DateTime dtHorario = new DateTime(shlTurma, SWT.BORDER | SWT.TIME | SWT.SHORT);
		dtHorario.setBounds(10, 158, 181, 34);
		
		Group grpProfessor = new Group(shlTurma, SWT.NONE);
		grpProfessor.setText("Professor");
		grpProfessor.setBounds(222, 10, 348, 174);
		
		Label label = new Label(grpProfessor, SWT.NONE);
		label.setText("Código");
		label.setBounds(10, 0, 68, 20);
		
		txbCodProf = new Text(grpProfessor, SWT.BORDER);
		txbCodProf.setBounds(10, 26, 159, 30);
		
		Label lblNome = new Label(grpProfessor, SWT.NONE);
		lblNome.setText("Nome");
		lblNome.setBounds(10, 62, 68, 20);
		
		txbNomeProf = new Text(grpProfessor, SWT.BORDER);
		txbNomeProf.setBounds(10, 88, 326, 30);
		
		Button btnNewButton = new Button(grpProfessor, SWT.NONE);
		btnNewButton.setBounds(241, 22, 95, 34);
		btnNewButton.setText("Pesquisar");
		
		Group grpIdioma = new Group(shlTurma, SWT.NONE);
		grpIdioma.setText("Idioma");
		grpIdioma.setBounds(10, 198, 181, 174);
		
		Label label_1 = new Label(grpIdioma, SWT.NONE);
		label_1.setText("Código");
		label_1.setBounds(10, 0, 68, 20);
		
		txbCodIdioma = new Text(grpIdioma, SWT.BORDER);
		txbCodIdioma.setEditable(false);
		txbCodIdioma.setEnabled(false);
		txbCodIdioma.setBounds(10, 26, 159, 30);
		
		Label lblIdioma = new Label(grpIdioma, SWT.NONE);
		lblIdioma.setText("Idioma");
		lblIdioma.setBounds(10, 62, 68, 20);
		
		txbIdioma = new Text(grpIdioma, SWT.BORDER);
		txbIdioma.setBounds(10, 88, 159, 30);
		
		table = new Table(shlTurma, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(222, 198, 563, 174);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCodigo = new TableColumn(table, SWT.NONE);
		tblclmnCodigo.setWidth(100);
		tblclmnCodigo.setText("Codigo");
		
		TableColumn tblclmnIdioma = new TableColumn(table, SWT.NONE);
		tblclmnIdioma.setWidth(100);
		tblclmnIdioma.setText("Idioma");
		
		TableColumn tblclmnProfessor = new TableColumn(table, SWT.NONE);
		tblclmnProfessor.setWidth(154);
		tblclmnProfessor.setText("Professor");
		
		TableColumn tblclmnTe = new TableColumn(table, SWT.NONE);
		tblclmnTe.setWidth(83);
		tblclmnTe.setText("TE");
		
		TableColumn tblclmnNumalunos = new TableColumn(table, SWT.NONE);
		tblclmnNumalunos.setWidth(100);
		tblclmnNumalunos.setText("NumAlunos");
		
		Button btnSalvar = new Button(shlTurma, SWT.NONE);
		btnSalvar.setBounds(587, 378, 95, 34);
		btnSalvar.setText("Salvar");
		
		Button btnCancelar = new Button(shlTurma, SWT.CENTER);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTurma.close();
			}
		});
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(690, 378, 95, 34);
		
		Group grpTipoDeEnsino = new Group(shlTurma, SWT.NONE);
		grpTipoDeEnsino.setText("Tipo de Ensino");
		grpTipoDeEnsino.setBounds(604, 10, 181, 174);
		
		Label label_2 = new Label(grpTipoDeEnsino, SWT.NONE);
		label_2.setText("Código");
		label_2.setBounds(10, 0, 68, 20);
		
		text = new Text(grpTipoDeEnsino, SWT.BORDER);
		text.setBounds(10, 26, 159, 30);
		
		Label lblTipoDeEnsino = new Label(grpTipoDeEnsino, SWT.NONE);
		lblTipoDeEnsino.setText("Tipo de Ensino");
		lblTipoDeEnsino.setBounds(10, 62, 159, 20);
		
		text_1 = new Text(grpTipoDeEnsino, SWT.BORDER);
		text_1.setBounds(10, 88, 159, 30);
		
		Label lblNewLabel_1 = new Label(shlTurma, SWT.NONE);
		lblNewLabel_1.setBounds(10, 392, 130, 20);
		lblNewLabel_1.setText("Número de Alunos:");
		
		Label lblNumAlunos = new Label(shlTurma, SWT.NONE);
		lblNumAlunos.setBounds(146, 392, 68, 20);
		lblNumAlunos.setText("0");

	}
}
