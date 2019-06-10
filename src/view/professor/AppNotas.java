package view.professor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import model.Aluno;
import model.AlunoDAO;
import model.Avaliacao;
import model.AvaliacaoDAO;
import model.HistTurmaDAO;
import model.MatriculaDAO;
import model.Professor;
import model.Turma;
import model.TurmaDAO;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * Classe Controle
 * @return: null
 * @author: SimpleSolutionDev Team
 */
public class AppNotas {
	private Table table;
	private Table tbAluno;
	private Table tbTurma;
	
	/**
	 * Metodo popular tabela
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTabela(int codProf){
		AvaliacaoDAO dao = new AvaliacaoDAO();
		ArrayList<Avaliacao> lista = dao.consultarTodos();
		for (int i = 0; i < lista.size(); i++) {
			String[] valores = {lista.get(i).getNomeAval(), Double.toString(lista.get(i).getValorAval())};
			TableItem tbi = new TableItem(table, SWT.NONE);
			tbi.setText(valores);
		}
	}
	
	/**
	 * Metodo popular tabela turma relacionada as notas
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTabelaTurma(int codProf) {
		HistTurmaDAO ht_dao = new HistTurmaDAO();
		ArrayList<Integer> lista = ht_dao.consultarPorProfessor(codProf);
		TurmaDAO turma_dao = new TurmaDAO();
		
		for (int i = 0; i < lista.size(); i++) {
			Turma turma = new Turma();
			turma.setCodTurma(lista.get(i));
			turma = turma_dao.consultar(turma);
			String[] valores = {Integer.toString(turma.getCodTurma()), turma.getHorarioTurma()};
			TableItem tbi = new TableItem(tbTurma, SWT.NONE);
			tbi.setText(valores);
		}
	}
	
	/**
	 * Metodo popular tabela
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTabelaAluno(int codTurma) {
		MatriculaDAO matr_dao = new MatriculaDAO();
		ArrayList<Integer> lista = matr_dao.consultaAlunosByTurma(codTurma);
		ArrayList<Aluno> lista_alunos = new ArrayList<Aluno>();
 		for (int i = 0; i < lista.size(); i++) {
			AlunoDAO dao_aln = new AlunoDAO();
			Aluno aluno = new Aluno();
			aluno.setCodAluno(lista.get(i));
			aluno = dao_aln.consultar(aluno);
			lista_alunos.add(aluno);
		}
 		
 		for (int i = 0; i < lista_alunos.size(); i++) {
			String[] valores = {lista_alunos.get(i).getNomeAluno(), ""};
			TableItem tbi = new TableItem(tbAluno, SWT.NONE);
			tbi.setText(valores);
		}
 		tbAluno.setEnabled(true);
	}
	

	/**po
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Professor professor) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(610, 512);
		shell.setText("Notas");
		
		Label lblProvas = new Label(shell, SWT.NONE);
		lblProvas.setText("Avaliação");
		lblProvas.setBounds(10, 10, 99, 20);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Alunos");
		label_1.setBounds(232, 10, 68, 20);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 36, 216, 139);
		
		TableColumn tableTurma = new TableColumn(table, SWT.NONE);
		tableTurma.setWidth(148);
		tableTurma.setText("Nome");
		
		TableColumn tableData = new TableColumn(table, SWT.NONE);
		tableData.setWidth(66);
		tableData.setText("Peso");
		
		tbAluno = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tbAluno.setLinesVisible(true);
		tbAluno.setHeaderVisible(true);
		tbAluno.setBounds(232, 36, 352, 396);
		tbAluno.addMouseListener(new MouseListener() {
			
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
				TableItem[] selection = tbAluno.getSelection();
				
		        for (int i = 0; i < selection.length; i++) {	
		        	String[] valores = {selection[i].getText(0),JOptionPane.showInputDialog("Insira a Nota")};
		        	selection[i].setText(valores);		        	
		        }
		        tbAluno.layout();
				
			}
		});
		
		TableColumn tableAluno = new TableColumn(tbAluno, SWT.NONE);
		tableAluno.setWidth(250);
		tableAluno.setText("Nome do Aluno");
		
		TableColumn tableNota = new TableColumn(tbAluno, SWT.NONE);
		tableNota.setWidth(100);
		tableNota.setText("Nota");
		tableNota.setResizable(false);
		
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("Turma");
		label_2.setBounds(10, 181, 99, 20);
		
		Label lblDataDaProva = new Label(shell, SWT.NONE);
		lblDataDaProva.setText("Data da Prova");
		lblDataDaProva.setBounds(10, 372, 99, 20);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.SHORT);
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
		
		tbTurma = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tbTurma.setLinesVisible(true);
		tbTurma.setHeaderVisible(true);
		tbTurma.setBounds(10, 207, 216, 159);
		tbTurma.addMouseListener(new MouseListener() {
			
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
				TableItem[] selection = tbTurma.getSelection();
				
		        for (int i = 0; i < selection.length; i++) {		        	
		        	populaTabelaAluno(Integer.parseInt(selection[i].getText(0)));
		        }
				
			}
		});
		
		TableColumn tblclmnCodigo = new TableColumn(tbTurma, SWT.NONE);
		tblclmnCodigo.setWidth(60);
		tblclmnCodigo.setText("Codigo");
		
		TableColumn tblclmnHorario = new TableColumn(tbTurma, SWT.NONE);
		tblclmnHorario.setWidth(66);
		tblclmnHorario.setText("Horario");
		
		populaTabela(professor.getCodProf());
		populaTabelaTurma(professor.getCodProf());
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
