package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import model.Aluno;
import model.Frequencia;
import model.FrequenciaDAO;
import model.Matricula;
import model.MatriculaDAO;
import model.Nota;
import model.NotaDAO;

public class TelaMenuAluno {
	private Table tbFaltas;
	private Table tbNotas;
	
	/**
	 * Metodo responsavel por Popular a Tabela de Notas
	 * @return: null
	 */	
	private void populaNotas(int codAluno) {
		MatriculaDAO mtr_dao = new MatriculaDAO();
		ArrayList<Matricula> lista = mtr_dao.consultaMatriculaByAluno(codAluno);
		for (int i = 0; i < lista.size(); i++) {
			NotaDAO nota_dao = new NotaDAO();
			ArrayList<Nota> nota = new ArrayList<Nota>();
			nota = nota_dao.consultarByMatricula(lista.get(i).getCodMat());
			for (int j = 0; j < nota.size(); j++) {
				TableItem tbi = new TableItem(tbNotas, SWT.NONE);
				String[] valores = {Integer.toString(lista.get(i).getCodTurma()), 
									nota.get(j).getDataNota().toString(),
									Double.toString(nota.get(j).getValorNota())};
	 			tbi.setText(valores);
			}
		}
		tbNotas.layout();
		
	}
	/**
	 * Metodo responsavel por popular tabela de Faltas
	 * @return: null
	 */
	private void populaFaltas(int codAluno) {
		MatriculaDAO mtr_dao = new MatriculaDAO();
		ArrayList<Matricula> lista = mtr_dao.consultaMatriculaByAluno(codAluno);
		for (int i = 0; i < lista.size(); i++) {
			FrequenciaDAO freq_dao = new FrequenciaDAO();
			ArrayList<Frequencia> lista_freq = freq_dao.consultarByCodMat(lista.get(i).getCodMat());
			for (int j = 0; j < lista_freq.size(); j++) {
				TableItem tbi = new TableItem(tbFaltas, SWT.NONE);
				String[] valores = {Integer.toString(lista.get(i).getCodTurma()), 
									lista_freq.get(j).getDataFreq().toString(),
									lista_freq.get(j).getStatusFreq()};
	 			tbi.setText(valores);
			}
		}
		tbFaltas.layout();
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Aluno aluno) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setMaximized(true);
		shell.setText("Simple Solution, Bem Vindo - "+ aluno.getNomeAluno());
		GridLayout gl_shell = new GridLayout(2, false);
		gl_shell.verticalSpacing = 3;
		shell.setLayout(gl_shell);

		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("Faltas");
		
		Label lblNotas = new Label(shell, SWT.NONE);
		lblNotas.setText("Notas");
		
		tbFaltas = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tbFaltas.setEnabled(false);
		tbFaltas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tbFaltas.setHeaderVisible(true);
		tbFaltas.setLinesVisible(true);
		
		TableColumn tblclmnTurma = new TableColumn(tbFaltas, SWT.NONE);
		tblclmnTurma.setWidth(120);
		tblclmnTurma.setText("Turma");
		
		TableColumn tblclmnData = new TableColumn(tbFaltas, SWT.NONE);
		tblclmnData.setWidth(120);
		tblclmnData.setText("Data");
		
		TableColumn tblclmnFaltas = new TableColumn(tbFaltas, SWT.NONE);
		tblclmnFaltas.setWidth(40);
		tblclmnFaltas.setText("Status");
		
		tbNotas = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tbNotas.setEnabled(false);
		tbNotas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tbNotas.setHeaderVisible(true);
		tbNotas.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(tbNotas, SWT.NONE);
		tableColumn.setWidth(120);
		tableColumn.setText("Turma");
		
		TableColumn tblclmnNotas = new TableColumn(tbNotas, SWT.NONE);
		tblclmnNotas.setWidth(40);
		tblclmnNotas.setText("Data");
		
		TableColumn tableColumn_1 = new TableColumn(tbNotas, SWT.NONE);
		tableColumn_1.setWidth(40);
		tableColumn_1.setText("Notas");
		populaNotas(aluno.getCodAluno());
		populaFaltas(aluno.getCodAluno());

		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
