package view.professor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import model.Aluno;
import model.AlunoDAO;
import model.HistTurmaDAO;
import model.MatriculaDAO;
import model.Professor;
import model.Turma;
import model.TurmaDAO;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;

/**
 * Classe Controle de frequencias
 * @return: null
 * @author: SimpleSolutionDev Team
 */
public class TelaFrequencia {
	private Table tbAlunos;
	private Table tbTurmas;

	
	/**
	 * Metodo popular tabela
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
			TableItem tbi = new TableItem(tbTurmas, SWT.NONE);
			tbi.setText(valores);
		}
		
	}
	
	/**
	 * Metodo popular tabela
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTabelaAlunos(int codTurma) {
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
			String[] valores = {lista_alunos.get(i).getNomeAluno(), "P"};
			TableItem tbi = new TableItem(tbAlunos, SWT.NONE);
			tbi.setText(valores);
		}
 		tbAlunos.setEnabled(true);
	}
	


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Professor professor) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(600, 510);
		shell.setText("Frequência");
		
		tbAlunos = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tbAlunos.setEnabled(false);
		tbAlunos.setBounds(232, 36, 352, 396);
		tbAlunos.setHeaderVisible(true);
		tbAlunos.setLinesVisible(true);
		tbAlunos.addMouseListener(new MouseListener() {
			
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
				TableItem[] selection = tbAlunos.getSelection();
				
		        for (int i = 0; i < selection.length; i++) {
		        	String[] valores = {"",""};
		        	if (selection[i].getText(1).contains("P")) {
		        		valores[0] = selection[i].getText(0);
		        		valores[1] = "F";
		        		
					}else {
		        		valores[0] = selection[i].getText(0);
		        		valores[1] = "P";
					}
		        	
		        	selection[i].setText(valores);		        	
		        }
		        tbAlunos.layout();
				
			}
		});
		
		TableColumn tblclmnNomeAluno = new TableColumn(tbAlunos, SWT.NONE);
		tblclmnNomeAluno.setWidth(250);
		tblclmnNomeAluno.setText("Nome do Aluno");
		
		TableColumn tblclmnPresenca = new TableColumn(tbAlunos, SWT.NONE);
		tblclmnPresenca.setResizable(false);
		tblclmnPresenca.setWidth(100);
		tblclmnPresenca.setText("Presença");
		
		Label lblAlunos = new Label(shell, SWT.NONE);
		lblAlunos.setText("Alunos");
		lblAlunos.setBounds(232, 10, 68, 20);
		
		tbTurmas = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tbTurmas.setLinesVisible(true);
		tbTurmas.setHeaderVisible(true);
		tbTurmas.setBounds(10, 102, 216, 330);
		tbTurmas.addMouseListener(new MouseListener() {
			
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
				TableItem[] selection = tbTurmas.getSelection();
				
		        for (int i = 0; i < selection.length; i++) {		        	
		        	populaTabelaAlunos(Integer.parseInt(selection[i].getText(0)));
		        }
				
			}
		});
		
		TableColumn tblclmnIdioma = new TableColumn(tbTurmas, SWT.NONE);
		tblclmnIdioma.setWidth(100);
		tblclmnIdioma.setText("Idioma");
		
		TableColumn tblclmnDias = new TableColumn(tbTurmas, SWT.NONE);
		tblclmnDias.setWidth(100);
		tblclmnDias.setText("Dias");
		
		Label lblTurma = new Label(shell, SWT.NONE);
		lblTurma.setText("Turmas");
		lblTurma.setBounds(10, 76, 99, 20);
		
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
		dateTime.setBounds(10, 36, 216, 34);
		
		Label lblDataDaAula = new Label(shell, SWT.NONE);
		lblDataDaAula.setText("Data da Aula");
		lblDataDaAula.setBounds(10, 10, 99, 20);
		
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
