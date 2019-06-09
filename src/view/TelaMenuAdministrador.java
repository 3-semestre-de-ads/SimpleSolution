package view;

import java.io.InputStream;
import view.admin.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import model.Administrador;
import model.Aluno;
import model.AlunoDAO;
import model.Idioma;
import model.Professor;
import model.TipoEnsino;
import model.Turma;
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
		itemSair.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
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
		itemCadAluno.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				TelaAluno tela = new TelaAluno();
				tela.open(null);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});

		
		MenuItem itemConAluno = new MenuItem(menuAluno, SWT.NONE);
		itemConAluno.setText("Consultar / Alterar Aluno");
		itemConAluno.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String aluno = JOptionPane.showInputDialog("Digite o código do Aluno:");
				if (aluno != "") {
					AlunoDAO dao = new AlunoDAO();
					Aluno a = new Aluno();
					a.setCodAluno(Integer.parseInt(aluno));
					a = dao.consultar(a);
					if (a.getNomeAluno() != null) {
						TelaAluno tela = new TelaAluno();
						tela.open(a);
					}

				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

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
				cadIdioma.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaIdioma tela = new TelaIdioma();						
						tela.open(null);
						
					}					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {}});
				
				MenuItem conIdioma = new MenuItem(menuIdiomas, SWT.PUSH);
				conIdioma.setText("Consultar");
				conIdioma.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaIdioma tela = new TelaIdioma();	
						Idioma idioma = new Idioma();
						tela.open(idioma);
						
					}					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {}});
			/*
			 * MenuIdiomas
			 */
			MenuItem itemTurma = new MenuItem(menuAulas, SWT.CASCADE);
			itemTurma.setText("Turmas");
			Menu menuTurma = new Menu(itemTurma);	
			itemTurma.setMenu(menuTurma);
				MenuItem cadTurma = new MenuItem(menuTurma, SWT.PUSH);
				cadTurma.setText("Cadastrar");
				cadTurma.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaTurma tela = new TelaTurma();
						tela.open(null);
						
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				MenuItem conTurma = new MenuItem(menuTurma, SWT.PUSH);
				conTurma.setText("Consultar");
				conTurma.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaTurma tela = new TelaTurma();
						Turma turma = new Turma();
						tela.open(turma);
						
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
			/*
			 * Menu Tipo de Ensino
			 */
			MenuItem itemTipoEnsino = new MenuItem(menuAulas, SWT.CASCADE);
			itemTipoEnsino.setText("Tipos de Ensino");
			Menu menuTe = new Menu(itemTipoEnsino);	
			itemTipoEnsino.setMenu(menuTe);
				MenuItem cadTipoEnsino = new MenuItem(menuTe, SWT.PUSH);
				cadTipoEnsino.setText("Cadastrar");
				cadTipoEnsino.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaTipoEnsino tela = new TelaTipoEnsino();
						tela.open(null);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				MenuItem conTipoEnsino = new MenuItem(menuTe, SWT.PUSH);
				conTipoEnsino.setText("Consultar");
				conTipoEnsino.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaTipoEnsino tela = new TelaTipoEnsino();
						TipoEnsino TE = new TipoEnsino();
						tela.open(TE);
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});

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
				cadProfessor.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaProfessor tela = new TelaProfessor();
						tela.open(null);
						
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				MenuItem conProfessor = new MenuItem(menuProfessor, SWT.PUSH);
				conProfessor.setText("Consultar");
				conProfessor.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaProfessor tela = new TelaProfessor();
						Professor professor = new Professor();
						professor.setCodProf(Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do Professor")));
						tela.open(professor);						
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
			
			/*
			 * Sub Menu Administrador
			 */
			MenuItem itemAdm = new MenuItem(menuFuncionarios, SWT.CASCADE);
			itemAdm.setText("Adminstrador");
			Menu menuAdm = new Menu(itemAdm);
			itemAdm.setMenu(menuAdm);
				MenuItem cadAdm = new MenuItem(menuAdm, SWT.PUSH);
				cadAdm.setText("Cadastrar");
				cadAdm.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						TelaAdministrador tela = new TelaAdministrador();
						tela.open(null);
						
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				MenuItem conAdm = new MenuItem(menuAdm, SWT.PUSH);
				conAdm.setText("Consultar");
				conAdm.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						Administrador admin = new Administrador();
						TelaAdministrador tela = new TelaAdministrador();
						tela.open(admin);
						
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
		


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
		
		shell.setMaximized(true);
		shell.setText("SimpleSolution - " + usuario);


	}
}
