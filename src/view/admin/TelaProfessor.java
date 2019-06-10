package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import model.HistTurmaDAO;
import model.Idioma;
import model.IdiomaDAO;
import model.MatriculaDAO;
import model.Professor;
import model.ProfessorDAO;
import model.TipoEnsino;
import model.TipoEnsinoDAO;
import model.Turma;
import model.TurmaDAO;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaProfessor {

	protected Shell shlProfessor;
	private Text txbCodigo;
	private Text txbNome;
	private Text txbEmail;
	private Text txbRg;
	private Text txbTelefone;
	private Text txbCpf;
	private Table tableTurmas;

	private void novo() {
		ProfessorDAO dao = new ProfessorDAO();
		txbCodigo.setText(Integer.toString(dao.proximoId()));
		tableTurmas.setEnabled(false);
		shlProfessor.setText("Professor - Novo");
		
	}

	private void populaProfessor(Professor professor) {
		
		txbCodigo.setText(Integer.toString(professor.getCodProf()));
		ProfessorDAO dao = new ProfessorDAO();
		professor =  dao.consultar(professor);
		shlProfessor.setText("Professor - " + professor.getNomeProf());
		txbNome.setText(professor.getNomeProf());
		txbEmail.setText(professor.getEmailProf());
		txbRg.setText(professor.getRgProf());
		txbCpf.setText(professor.getCpfProf());
		txbTelefone.setText(professor.getTelProf());
		
	}
	
	private void populaTabelaTurmas() {
		HistTurmaDAO dao = new HistTurmaDAO();
		ArrayList<Integer> lista = dao.consultarCodTurmaPorProf(Integer.parseInt(txbCodigo.getText()));
		TurmaDAO dao_turma = new TurmaDAO();
		
		for (int i = 0; i < lista.size(); i++) {
			Turma turma = new Turma();
			turma.setCodTurma(lista.get(i));
			turma = dao_turma.consultar(turma);
			
			Idioma idioma = consultaIdioma(turma);
			TipoEnsino te = consultaTE(turma);
			int num_alunos = consultaNumeroAlunos(lista.get(i));
			
			String[] valores = {Integer.toString(lista.get(i)), 
					idioma.getNomeIdioma(), 
					te.getNomeTE(), 
					Integer.toString(num_alunos)};
			TableItem tbi = new TableItem(tableTurmas, SWT.NONE);
			tbi.setText(valores);
		}
	}
	

	
	private int consultaNumeroAlunos(int codTurma) {
		MatriculaDAO dao = new MatriculaDAO();
		Turma turma = new Turma();
		turma.setCodTurma(codTurma);
		return dao.alunosNaTurma(turma);
	}
	
	private Idioma consultaIdioma(Turma turma) {
		IdiomaDAO dao = new IdiomaDAO();
		Idioma idioma = new Idioma();

		
		idioma.setCodIdioma(turma.getCodIdioma());		
		idioma = dao.consultar(idioma);
		return idioma;
	}
	
	private TipoEnsino consultaTE(Turma turma) {
		TipoEnsinoDAO dao = new TipoEnsinoDAO();
		TipoEnsino te = new TipoEnsino();

		te.setCodTE(turma.getCodTE());
		te = dao.consultar(te);
		return te;
	}
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Professor professor) {
		Display display = Display.getDefault();
		createContents();
		if (professor == null) {
			novo();
		}else {
			populaProfessor(professor);
			populaTabelaTurmas();
		}
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
		
		txbCodigo = new Text(shlProfessor, SWT.BORDER);
		txbCodigo.setEnabled(false);
		txbCodigo.setEditable(false);
		txbCodigo.setBounds(10, 38, 153, 30);
		
		Label label_1 = new Label(shlProfessor, SWT.NONE);
		label_1.setText("Nome");
		label_1.setBounds(10, 74, 68, 20);
		
		txbNome = new Text(shlProfessor, SWT.BORDER);
		txbNome.setBounds(10, 100, 340, 30);
		
		Label label_2 = new Label(shlProfessor, SWT.NONE);
		label_2.setText("E-mail");
		label_2.setBounds(10, 136, 68, 20);
		
		txbEmail = new Text(shlProfessor, SWT.BORDER);
		txbEmail.setBounds(10, 159, 340, 30);
		
		Label label_3 = new Label(shlProfessor, SWT.NONE);
		label_3.setText("Data de Nascimento");
		label_3.setBounds(149, 195, 178, 20);
		
		Label label_4 = new Label(shlProfessor, SWT.NONE);
		label_4.setText("RG");
		label_4.setBounds(10, 195, 68, 20);
		
		txbRg = new Text(shlProfessor, SWT.BORDER);
		txbRg.setBounds(10, 221, 133, 30);
		
		DateTime dtNasc = new DateTime(shlProfessor, SWT.BORDER | SWT.CALENDAR | SWT.SHORT);
		dtNasc.setBounds(149, 221, 201, 157);
		
		txbTelefone = new Text(shlProfessor, SWT.BORDER);
		txbTelefone.setBounds(10, 286, 133, 30);
		
		Label label_5 = new Label(shlProfessor, SWT.NONE);
		label_5.setText("Telefone");
		label_5.setBounds(10, 257, 68, 20);
		
		Label label_6 = new Label(shlProfessor, SWT.NONE);
		label_6.setText("CPF");
		label_6.setBounds(10, 322, 68, 20);
		
		txbCpf = new Text(shlProfessor, SWT.BORDER);
		txbCpf.setBounds(10, 348, 133, 30);
		
		Label lblNewLabel = new Label(shlProfessor, SWT.NONE);
		lblNewLabel.setBounds(369, 10, 68, 20);
		lblNewLabel.setText("Turmas");
		
		tableTurmas = new Table(shlProfessor, SWT.BORDER | SWT.FULL_SELECTION);
		tableTurmas.setEnabled(false);
		tableTurmas.setBounds(369, 38, 344, 380);
		tableTurmas.setHeaderVisible(true);
		tableTurmas.setLinesVisible(true);
		
		TableColumn tblclmnCodigo = new TableColumn(tableTurmas, SWT.NONE);
		tblclmnCodigo.setWidth(72);
		tblclmnCodigo.setText("Codigo");
		
		TableColumn tblclmnIdioma = new TableColumn(tableTurmas, SWT.NONE);
		tblclmnIdioma.setWidth(103);
		tblclmnIdioma.setText("Idioma");
		
		TableColumn tblclmnTe = new TableColumn(tableTurmas, SWT.NONE);
		tblclmnTe.setWidth(65);
		tblclmnTe.setText("TE");
		
		TableColumn tblclmnNa = new TableColumn(tableTurmas, SWT.NONE);
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
