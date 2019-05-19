package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import view.professor.TelaFrequencia;
import view.professor.AppNotas;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;

public class TelaMenuProfessor {

	protected Shell shlSimplesolutionAluno;


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSimplesolutionAluno.setLayout(new FillLayout());
		Menu menu = new Menu(shlSimplesolutionAluno, SWT.BAR);
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
			itemSair.addSelectionListener(new SelectionAdapter() {
			      public void widgetSelected(SelectionEvent e) {
			    	  shlSimplesolutionAluno.close();
			          TelaLoginPage tela = new TelaLoginPage();
			          tela.main(null);
			        }
			      });
			
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
			itemFrequencia.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					TelaFrequencia tela = new TelaFrequencia();
					tela.open();
				}
			});
			MenuItem itemNota = new MenuItem(menuAula, SWT.NONE);
			itemNota.setText("Nota");
			itemNota.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					AppNotas tela = new AppNotas();
					tela.open();
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
		shlSimplesolutionAluno = new Shell();
		shlSimplesolutionAluno.setSize(450, 300);
		shlSimplesolutionAluno.setText("SimpleSolution - Aluno");
		
		Menu menu = new Menu(shlSimplesolutionAluno, SWT.BAR);
		shlSimplesolutionAluno.setMenuBar(menu);

	}
}
