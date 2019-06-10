package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import model.Professor;
import view.professor.TelaFrequencia;
import view.professor.AppNotas;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;

/**
 * Classe Menu Professor
 * @return: null
 * @author: SimpleSolutionDev Team
 */
public class TelaMenuProfessor {
	

	protected Shell shlSimplesolutionAluno;


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Professor professor) {
		Display display = Display.getDefault();
		
		shlSimplesolutionAluno = new Shell();
		shlSimplesolutionAluno.setMaximized(true);
		shlSimplesolutionAluno.setText("SimpleSolution, Bem Vindo Professor - "+ professor.getNomeProf());
		
		Menu menu = new Menu(shlSimplesolutionAluno, SWT.BAR);
		shlSimplesolutionAluno.setMenuBar(menu);
		
		shlSimplesolutionAluno.setLayout(new FillLayout());

		shlSimplesolutionAluno.setMenuBar(menu);
		shlSimplesolutionAluno.open();
		shlSimplesolutionAluno.layout();
		
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

			
		/*
		 * Criando Aulas 
		 */
		MenuItem itemAula = new MenuItem(menu, SWT.CASCADE);
		itemAula.setText("Aulas");		
		Menu menuAula= new Menu(itemAula);
		itemAula.setMenu(menuAula);
		
			/*
			 * Criação de Submenus Aulas
			 */
			MenuItem itemFrequencia = new MenuItem(menuAula, SWT.NONE);
			itemFrequencia.setText("Frequencia");
			itemFrequencia.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					TelaFrequencia tela = new TelaFrequencia();
					tela.open(professor);
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {

					
				}
			});

			MenuItem itemNota = new MenuItem(menuAula, SWT.NONE);
			itemNota.setText("Nota");
			itemNota.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					AppNotas tela = new AppNotas();
					tela.open(professor);
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});

			
		
		
		
		while (!shlSimplesolutionAluno.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {


	}
}
