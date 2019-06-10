package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import model.HistTurma;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
/**
 * Classe Controle
 * @return: null
 * @author: SimpleSolutionDev Team
 */
public class TelaTurma {

	protected Shell shlTurma;
	private Text txbCodigo;
	private Text txbDiasAula;
	private Text txbCodProf;
	private Text txbNomeProf;
	private Text txbCodIdioma;
	private Text txbIdioma;
	private Table table;
	private Text txbCodTE;
	private Text txbTE;
	private Text txbHorario;
	private Label lblNumAlunos;
	
	/**
	 * Metodo caso seja novo registro
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void novaTurma() {
		table.setEnabled(false);
		populaTabela();
		shlTurma.setText("Turma - Nova");
	}
	
	/**
	 * Metodo caso seja registro antigo
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTurma(Turma turma) {
		
		txbCodTE.setEnabled(false);
		txbTE.setEnabled(false);
		TurmaDAO dao = new TurmaDAO();
		txbCodigo.setText(Integer.toString(turma.getCodTurma()));
		turma = dao.consultar(turma);		
		txbDiasAula.setText(turma.getDiaTurma());
		txbHorario.setText(turma.getHorarioTurma());
		txbCodProf.setText(""); //alterar aqui depois	
		
		Idioma idioma = consultaIdioma(turma);
		txbCodIdioma.setText(Integer.toString(idioma.getCodIdioma()));
		txbIdioma.setText(idioma.getNomeIdioma());
		
		
		//Tipo de Ensino
		TipoEnsino te = consultaTE(turma);
		txbCodTE.setText(Integer.toString(te.getCodTE()));	
		txbTE.setText(te.getNomeTE());
		
		//Professor
		Professor prof = consultaProfessor(turma);
		
		if (prof.getNomeProf() != null) {
			txbCodProf.setText(Integer.toString(prof.getCodProf()));
			txbNomeProf.setText(prof.getNomeProf());
		}else {
			txbNomeProf.setText("");
		}
		
				
		
		lblNumAlunos.setText(Integer.toString(consultaNumeroAlunos(turma)));
		populaTabela();
		shlTurma.setText("Turma - " + txbIdioma.getText() + " - PROF: " + txbNomeProf.getText());
	}
	
	/**
	 * Metodo popular tabela
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTabela() {
		table.removeAll();
		TurmaDAO dao = new TurmaDAO();

		ArrayList<Turma> lista = dao.consultarTodos();
		
		for (int i = 0; i < lista.size(); i++) {
			
			TableItem tbi = new TableItem(table, SWT.NONE);
			
			Idioma idioma = consultaIdioma(lista.get(i));
			Professor prof = consultaProfessor(lista.get(i));
			TipoEnsino te = consultaTE(lista.get(i));
			
			String[] valores = {Integer.toString(lista.get(i).getCodTurma()), 
					idioma.getNomeIdioma(),
					prof.getNomeProf(),
					te.getNomeTE(),
					Integer.toString(consultaNumeroAlunos(lista.get(i)))};
 			tbi.setText(valores);
		}
	}
	
	/**
	 * Metodo consultar idioma relacionado a Turma
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private Idioma consultaIdioma(Turma turma) {
		IdiomaDAO dao = new IdiomaDAO();
		Idioma idioma = new Idioma();
		
		idioma.setCodIdioma(turma.getCodIdioma());		
		idioma = dao.consultar(idioma);
		return idioma;
	}
	/**
	 * Metodo consultar tipo de ensino relacionado a Turma
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private TipoEnsino consultaTE(Turma turma) {
		TipoEnsinoDAO dao = new TipoEnsinoDAO();
		TipoEnsino te = new TipoEnsino();
		
		te.setCodTE(turma.getCodTE());
		te = dao.consultar(te);
		return te;
	}
	
	/**
	 * Metodo para consultar Professor relacionado a Turma
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private Professor consultaProfessor(Turma turma) {
		HistTurma ht = new HistTurma();
		HistTurmaDAO ht_dao = new HistTurmaDAO();
		ht.setCodMat(turma.getCodTurma());
		ht = ht_dao.consultarPorTurma(ht);
		
		Professor professor = new Professor();
		ProfessorDAO dao = new ProfessorDAO();
		professor.setCodProf(ht.getCodProf());
		professor = dao.consultar(professor);
		
		return professor;	
	}
	
	/**
	 * Metodo contador do numero de alunos
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private int consultaNumeroAlunos(Turma turma) {
		MatriculaDAO dao = new MatriculaDAO();
		return dao.alunosNaTurma(turma);
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Turma turma) {
		Display display = Display.getDefault();
		createContents();
		if (turma == null) {
			novaTurma();
		}else {
			turma.setCodTurma(1);
			populaTurma(turma);
		}
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
		txbNomeProf.setEnabled(false);
		txbNomeProf.setBounds(10, 88, 326, 30);
		
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
		txbIdioma.setEnabled(false);
		txbIdioma.setBounds(10, 88, 159, 30);
		
		table = new Table(shlTurma, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(222, 198, 563, 174);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				TableItem[] selection  = table.getSelection();
				Turma turma = new Turma();

		        for (int i = 0; i < selection.length; i++) {
		        	turma.setCodTurma(Integer.parseInt(selection[i].getText(0)));
		        	txbCodigo.setText(selection[i].getText(0));
		        	
		        }
		        
		        populaTurma(turma);
				
			}				
			
		});
		
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
		
		txbCodTE = new Text(grpTipoDeEnsino, SWT.BORDER);
		txbCodTE.setEnabled(false);
		txbCodTE.setBounds(10, 26, 159, 30);
		
		Label lblTipoDeEnsino = new Label(grpTipoDeEnsino, SWT.NONE);
		lblTipoDeEnsino.setText("Tipo de Ensino");
		lblTipoDeEnsino.setBounds(10, 62, 159, 20);
		
		txbTE = new Text(grpTipoDeEnsino, SWT.BORDER);
		txbTE.setEnabled(false);
		txbTE.setBounds(10, 88, 159, 30);
		
		Label lblNewLabel_1 = new Label(shlTurma, SWT.NONE);
		lblNewLabel_1.setBounds(10, 392, 130, 20);
		lblNewLabel_1.setText("Número de Alunos:");
		
		lblNumAlunos = new Label(shlTurma, SWT.NONE);
		lblNumAlunos.setBounds(146, 392, 68, 20);
		lblNumAlunos.setText("0");
		
		txbHorario = new Text(shlTurma, SWT.BORDER);
		txbHorario.setBounds(10, 158, 181, 30);

	}
}
