package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

public class MenuAdministrador {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MenuAdministrador window = new MenuAdministrador();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		shell.setLayout(new GridLayout(1, false));
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);			
		
		/*
		 * @Criando Menu Arquivo
		 */
		MenuItem itemArquivo = new MenuItem(menu, SWT.CASCADE);
		itemArquivo.setText("Arquivo");		
		Menu menuArquivo= new Menu(itemArquivo);
		itemArquivo.setMenu(menuArquivo);
		
		/*
		 * Criação de Submenus Arquivo
		 */
		MenuItem itemSair = new MenuItem(menuArquivo, SWT.NONE);
		itemSair.setText("Sair");
		itemSair.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		          shell.close();
		          LoginPage tela = new LoginPage();
		          tela.main(null);
		        }
		      });
		
		/*
		 * @Criando Menu Aluno
		 */
		MenuItem itemAluno = new MenuItem(menu, SWT.CASCADE);
		itemAluno.setText("Aluno");		
		Menu menuAluno= new Menu(itemAluno);
		itemAluno.setMenu(menuAluno);
		
		/*
		 * Criação de Submenus Aluno
		 */
		MenuItem itemCadAluno = new MenuItem(menuAluno, SWT.NONE);
		itemCadAluno.setText("Cadastrar Aluno");
		itemCadAluno.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		          AppAluno tela = new AppAluno();
		          tela.open();
		        }
		      });
		
		MenuItem itemConAluno = new MenuItem(menuAluno, SWT.NONE);
		itemConAluno.setText("Consultar / Alterar Aluno");
		itemConAluno.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		          AppAluno tela = new AppAluno();
		          tela.open();
		        }
		      });
		
		MenuItem itemDelAluno = new MenuItem(menuAluno, SWT.NONE);
		itemDelAluno.setText("Inativar Aluno");
		itemDelAluno.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		          AppAluno tela = new AppAluno();
		          tela.open();
		        }
		      });
		
		/*
		 * @Criando Menu Aulas
		 */
		MenuItem itemAulas = new MenuItem(menu, SWT.CASCADE);
		itemAulas.setText("Aulas");		
		Menu menuAulas= new Menu(itemAulas);
		itemAulas.setMenu(menuAulas);
		
		/*
		 * Criação de Submenus Aulas
		 */

		MenuItem itemCadIdioma = new MenuItem(menuAulas, SWT.NONE);
		itemCadIdioma.setText("Cadastrar / Consultar Idiomas");
		itemCadIdioma.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		          AppIdioma tela = new AppIdioma();
		          tela.open();
		        }
		      });
		MenuItem itemCadTurma = new MenuItem(menuAulas, SWT.NONE);
		itemCadTurma.setText("Cadastrar / Consultar Turmas");
		
		
		/*
		 * @Criando Menu Funcionários
		 */
		MenuItem itemFuncionarios = new MenuItem(menu, SWT.CASCADE);
		itemFuncionarios.setText("Funcionários");		
		Menu menuFuncionarios= new Menu(itemFuncionarios);
		itemFuncionarios.setMenu(menuFuncionarios);
		
		/*
		 * Criação de Submenus Funcionários
		 */

		MenuItem itemProfessor = new MenuItem(menuFuncionarios, SWT.NONE);
		itemProfessor.setText("Cadastrar / Consultar Professor");
		MenuItem itemAdm = new MenuItem(menuFuncionarios, SWT.NONE);
		itemAdm.setText("Cadastrar / Consultar Adminstrador");
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("SimpleSolution - Administrador");

	}
}
