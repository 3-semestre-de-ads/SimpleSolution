package view;

import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import view.admin.TelaAluno;

import org.eclipse.swt.layout.GridData;

public class TelaMenuAdministrador {

	protected Shell shell;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(String usuario) {
		Display display = Display.getDefault();
		createContents(usuario);
		shell.open();
		shell.layout();
		shell.setLayout(new FillLayout());
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
		itemSair.setText("Logoff");
		
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

		
		MenuItem itemConAluno = new MenuItem(menuAluno, SWT.NONE);
		itemConAluno.setText("Consultar / Alterar Aluno");

		/*
		 * Criando Menu Aulas
		 */
		MenuItem itemAulas = new MenuItem(menu, SWT.CASCADE);
		itemAulas.setText("Aulas");		
		Menu menuAulas= new Menu(itemAulas);
		itemAulas.setMenu(menuAulas);
			/*
			 * MenuIdiomas
			 */
			MenuItem itemIdioma = new MenuItem(menuAulas, SWT.CASCADE);
			itemIdioma.setText("Idioma");
			Menu menuIdiomas = new Menu(itemIdioma);	
			itemIdioma.setMenu(menuIdiomas);				
				MenuItem cadIdioma = new MenuItem(menuIdiomas, SWT.PUSH);
				cadIdioma.setText("Cadastrar");			
				MenuItem conIdioma = new MenuItem(menuIdiomas, SWT.PUSH);
				conIdioma.setText("Consultar");
			/*
			 * MenuIdiomas
			 */
			MenuItem itemTurma = new MenuItem(menuAulas, SWT.CASCADE);
			itemTurma.setText("Turmas");
			Menu menuTurma = new Menu(itemTurma);	
			itemTurma.setMenu(menuTurma);
				MenuItem cadTurma = new MenuItem(menuTurma, SWT.PUSH);
				cadTurma.setText("Cadastrar");		
				MenuItem conTurma = new MenuItem(menuTurma, SWT.PUSH);
				conTurma.setText("Consultar");
				
			/*
			 * Menu Tipo de Ensino
			 */
			MenuItem itemTipoEnsino = new MenuItem(menuAulas, SWT.CASCADE);
			itemTipoEnsino.setText("Tipos de Ensino");
			Menu menuTe = new Menu(itemTipoEnsino);	
			itemTipoEnsino.setMenu(menuTe);
				MenuItem cadTipoEnsino = new MenuItem(menuTe, SWT.PUSH);
				cadTipoEnsino.setText("Cadastrar");
				MenuItem conTipoEnsino = new MenuItem(menuTe, SWT.PUSH);
				conTipoEnsino.setText("Consultar");
		

		/*
		 * Menu Funcionários
		 */
		MenuItem itemFuncionarios = new MenuItem(menu, SWT.CASCADE);
		itemFuncionarios.setText("Funcionários");		
		Menu menuFuncionarios= new Menu(itemFuncionarios);
		itemFuncionarios.setMenu(menuFuncionarios);	
			
			/*
			 * Sub Menu Professor
			 */
			MenuItem itemProfessor = new MenuItem(menuFuncionarios, SWT.CASCADE);
			itemProfessor.setText("Professor");
			Menu menuProfessor = new Menu(itemProfessor);	
			itemProfessor.setMenu(menuProfessor);
				MenuItem cadProfessor = new MenuItem(menuProfessor, SWT.PUSH);
				cadProfessor.setText("Cadastrar");
				MenuItem conProfessor = new MenuItem(menuProfessor, SWT.PUSH);
				conProfessor.setText("Consultar");
			
			/*
			 * Sub Menu Administrador
			 */
			MenuItem itemAdm = new MenuItem(menuFuncionarios, SWT.CASCADE);
			itemAdm.setText("Adminstrador");
			Menu menuAdm = new Menu(itemAdm);
			itemAdm.setMenu(menuAdm);
				MenuItem cadAdm = new MenuItem(menuAdm, SWT.PUSH);
				cadAdm.setText("Cadastrar");
				MenuItem conAdm = new MenuItem(menuAdm, SWT.PUSH);
				conAdm.setText("Consultar");
		
		/*
		 * @Criando Menu Financeiro
		 */
		MenuItem itemFinanceiro = new MenuItem(menu, SWT.CASCADE);
		itemFinanceiro.setText("Financeiro");		
		Menu menuFinanceiro= new Menu(itemFinanceiro);
		itemFinanceiro.setMenu(menuFinanceiro);
		
		
		/*
		 * Criação de Submenus Financeiro
		 */
		MenuItem itemResumoMensalidades = new MenuItem(menuFinanceiro, SWT.NONE);
		itemResumoMensalidades.setText("Mensalidades");
		
	    

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(String usuario) {
		shell = new Shell();
		
		shell.setSize(800, 600);
		shell.setText("SimpleSolution - " + usuario);


	}
}
