package view.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.ui.forms.widgets.FormToolkit;

import model.Aluno;
import model.AlunoDAO;
import model.Responsavel;
import model.ResponsavelDAO;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.internal.DPIUtil;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TelaAluno {

	protected Shell shlAluno;
	private Text txbCodigo;
	private Text txbNome;
	private Text txbEmail;
	private Text txbRg;
	private Text txbCpf;
	private Text txbTelefone;
	private Text txbLogin;
	private Text txbSenha;
	private Text txbCodResp;
	private Text txbNomeResp;
	private Table tbTurmCad;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table tblResponsavel;
	private DateTime dtDatNasc;
	
	private void populaResponsavel() {		
		ResponsavelDAO dao = new ResponsavelDAO();
		ArrayList<Responsavel> r = dao.consultaTodos();
		TableItem tbi_novo = new TableItem(tblResponsavel, SWT.NONE);
		String[] novo = {"" , "<<Novo Responsavel>>"};
		tbi_novo.setText(novo);

		for (int i = 0; i < r.size(); i++) {
			
			TableItem tbi = new TableItem(tblResponsavel, SWT.NONE);
			String[] valores = {Integer.toString(r.get(i).getCodResp()), 
								r.get(i).getNomeResp()};
 			tbi.setText(valores);
		}		
	}
	
	private void populaAluno(Aluno aluno) {
		txbCodigo.setText(Integer.toString(aluno.getCodAluno()));
		txbNome.setText(aluno.getNomeAluno());
		txbEmail.setText(aluno.getEmailAluno());
		txbRg.setText(aluno.getRgAluno());
		txbCpf.setText(aluno.getCpfAluno());
		txbTelefone.setText(aluno.getTelAluno());
		txbLogin.setText(aluno.getUserAluno());
		txbSenha.setText(aluno.getSenhaAluno());
		txbCodResp.setText(Integer.toString(aluno.getCodResp()));
		dtDatNasc.getParent().layout();



	}
	private Aluno populaClasse() {
		Aluno aln = new Aluno();
		
		aln.setCodAluno(Integer.parseInt(txbCodigo.getText()));
		aln.setNomeAluno(txbNome.getText());
		aln.setEmailAluno(txbEmail.getText());
		aln.setRgAluno(txbRg.getText());
		aln.setCpfAluno(txbCpf.getText());
		aln.setTelAluno(txbTelefone.getText());
		aln.setSenhaAluno(txbSenha.getText());
		aln.setCodResp(Integer.parseInt(txbCodResp.getText()));
		return aln;
	}
	
	private void novoAluno() {
		shlAluno.setText("Aluno - Novo");
		AlunoDAO dao = new AlunoDAO();
		txbCodigo.setText(Integer.toString(dao.proximoId()));
		txbLogin.setText(String.format("ALN%05d", dao.proximoId()));
	}


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Aluno aluno) {
		Display display = Display.getDefault();
		createContents();
		if (aluno == null) {
			novoAluno();
		}else {
			populaAluno(aluno);
		}

		shlAluno.open();
		shlAluno.layout();	
		populaResponsavel();
		while (!shlAluno.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAluno = new Shell();
		shlAluno.setSize(715, 742);		
		
		
		Label label = new Label(shlAluno, SWT.NONE);
		label.setText("Código");
		label.setBounds(10, 10, 68, 20);
		
		txbCodigo = new Text(shlAluno, SWT.BORDER);
		txbCodigo.setEnabled(false);
		txbCodigo.setEditable(false);
		txbCodigo.setBounds(10, 38, 153, 30);
		
		Label lblNome = new Label(shlAluno, SWT.NONE);
		lblNome.setText("Nome");
		lblNome.setBounds(10, 74, 68, 20);
		
		txbNome = new Text(shlAluno, SWT.BORDER);
		txbNome.setBounds(10, 100, 340, 30);
		txbNome.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent arg0) {
				arg0.text = arg0.text.toUpperCase();
				
			}
		});
		
		Label lblEmail = new Label(shlAluno, SWT.NONE);
		lblEmail.setText("E-mail");
		lblEmail.setBounds(10, 136, 68, 20);
		
		txbEmail = new Text(shlAluno, SWT.BORDER);
		txbEmail.setBounds(10, 159, 340, 30);
		txbEmail.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent arg0) {
				arg0.text = arg0.text.toUpperCase();
				
			}
		});
		
		Label lblRG = new Label(shlAluno, SWT.NONE);
		lblRG.setText("RG");
		lblRG.setBounds(10, 195, 68, 20);
		
		txbRg = new Text(shlAluno, SWT.BORDER);
		txbRg.setBounds(10, 221, 133, 30);
		
		Label lblCPF = new Label(shlAluno, SWT.NONE);
		lblCPF.setText("CPF");
		lblCPF.setBounds(10, 322, 68, 20);
		
		txbCpf = new Text(shlAluno, SWT.BORDER);
		txbCpf.setBounds(10, 348, 133, 30);
		
		Label label_5 = new Label(shlAluno, SWT.NONE);
		label_5.setText("Telefone");
		label_5.setBounds(10, 257, 68, 20);
		
		txbTelefone = new Text(shlAluno, SWT.BORDER);
		txbTelefone.setBounds(10, 286, 133, 30);
		

		Group group = new Group(shlAluno, SWT.NONE);
		group.setText("Sistema");
		group.setBounds(374, 10, 185, 177);
		
		Label label_11 = new Label(group, SWT.NONE);
		label_11.setText("Login");
		label_11.setBounds(10, 10, 68, 20);
		
		txbLogin = new Text(group, SWT.BORDER);
		txbLogin.setEnabled(false);
		txbLogin.setEditable(false);
		txbLogin.setBounds(10, 36, 153, 30);
		
		Label label_12 = new Label(group, SWT.NONE);
		label_12.setText("Senha");
		label_12.setBounds(10, 72, 68, 20);
		
		txbSenha = new Text(group, SWT.PASSWORD);
		txbSenha.setBounds(10, 98, 153, 30);
		
		Group grpResponsavl = new Group(shlAluno, SWT.NONE);
		grpResponsavl.setText("Responsavél");
		grpResponsavl.setBounds(372, 208, 331, 320);
		
		Label label_13 = new Label(grpResponsavl, SWT.NONE);
		label_13.setText("Cód. Resp");
		label_13.setBounds(10, 10, 68, 20);
		
		txbCodResp = new Text(grpResponsavl, SWT.BORDER);
		txbCodResp.setBounds(10, 36, 153, 30);
		txbCodResp.setEnabled(false);
		
		Label label_14 = new Label(grpResponsavl, SWT.NONE);
		label_14.setText("Nome");
		label_14.setBounds(10, 72, 68, 20);
		
		txbNomeResp = new Text(grpResponsavl, SWT.BORDER);
		txbNomeResp.setBounds(10, 98, 312, 30);
		txbNomeResp.setEnabled(false);
		

		tblResponsavel = new Table(grpResponsavl, SWT.BORDER | SWT.FULL_SELECTION);
		tblResponsavel.setBounds(10, 134, 312, 154);
		formToolkit.adapt(tblResponsavel);
		formToolkit.paintBordersFor(tblResponsavel);
		tblResponsavel.setHeaderVisible(true);
		tblResponsavel.setLinesVisible(true);
		tblResponsavel.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (tblResponsavel.getSelectionIndex() != 0) {
					TableItem[] selection  = tblResponsavel.getSelection();

			        for (int i = 0; i < selection.length; i++) {
			        	txbCodResp.setText(selection[i].getText(0));
			        	txbNomeResp.setText(selection[i].getText(1));
			        	
			        }
				}else {
					txbCodResp.setText("");
					txbNomeResp.setText("");
				}				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		tblResponsavel.addMouseListener(new MouseListener() {
			
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
				TelaResponsavel tela = new TelaResponsavel();
				Responsavel resp = new Responsavel();
				
				if (tblResponsavel.isSelected(0)) {
					tela.open(null);
				}else {
					resp.setCodResp(Integer.parseInt(txbCodResp.getText().trim()));
					tela.open(resp);
				}


				
			}
		});
		
		TableColumn tblclmnCodResp = new TableColumn(tblResponsavel, SWT.NONE);
		tblclmnCodResp.setWidth(100);
		tblclmnCodResp.setText("Cod Resp");
		
		TableColumn tblclmnNomeResp = new TableColumn(tblResponsavel, SWT.NONE);
		tblclmnNomeResp.setWidth(100);
		tblclmnNomeResp.setText("Nome Resp");
		
		

		Label label_15 = new Label(shlAluno, SWT.NONE);
		label_15.setText("Data de Nascimento");
		label_15.setBounds(149, 195, 178, 20);
		
		tbTurmCad = new Table(shlAluno, SWT.BORDER | SWT.FULL_SELECTION);
		tbTurmCad.setBounds(10, 534, 693, 120);
		tbTurmCad.setHeaderVisible(true);
		tbTurmCad.setLinesVisible(true);
		
		TableColumn tblclmnCodigo = new TableColumn(tbTurmCad, SWT.NONE);
		tblclmnCodigo.setWidth(100);
		tblclmnCodigo.setText("Código");
		
		TableColumn tblclmnIdioma = new TableColumn(tbTurmCad, SWT.NONE);
		tblclmnIdioma.setWidth(100);
		tblclmnIdioma.setText("Idioma");
		
		TableColumn tblclmnProfessor = new TableColumn(tbTurmCad, SWT.NONE);
		tblclmnProfessor.setWidth(100);
		tblclmnProfessor.setText("Professor");
		
		Label lblTurmasCadastradas = new Label(shlAluno, SWT.NONE);
		lblTurmasCadastradas.setText("Turmas Cadastradas");
		lblTurmasCadastradas.setBounds(10, 508, 206, 20);
		
		Button btnSalvar = new Button(shlAluno, SWT.NONE);
		btnSalvar.setBounds(507, 660, 95, 34);
		btnSalvar.setText("Salvar");
		btnSalvar.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				AlunoDAO dao = new AlunoDAO();
				Aluno salvar = populaClasse();
				dao.inserirAtualizar(salvar);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnCancelar = new Button(shlAluno, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAluno.close();
			}
		});
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(608, 660, 95, 34);
		
		dtDatNasc = new DateTime(shlAluno, SWT.BORDER | SWT.CALENDAR | SWT.SHORT);
		dtDatNasc.setBounds(149, 221, 201, 157);

	}
	

}
