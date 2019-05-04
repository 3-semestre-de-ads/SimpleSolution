package view.admin;

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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.TableColumn;

public class AppAluno {

	protected Shell shlAluno;
	private Text txbCodigo;
	private Text txbNome;
	private Text txbEmail;
	private Text txbRg;
	private Text txbCpf;
	private Text txbTelefone;
	private Text txbEndereco;
	private Text txbBairro;
	private Text txbCidade;
	private Text txbNumero;
	private Text txbEstado;
	private Text txbLogin;
	private Text txbSenha;
	private Text txbCodResp;
	private Text txbNomeResp;
	private Table tbTurmCad;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;


	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAluno.open();
		shlAluno.layout();
		

		
		
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
		shlAluno.setText("Aluno - <cod_aluno>");
		
		
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
		
		Label label_6 = new Label(shlAluno, SWT.NONE);
		label_6.setText("Endereço");
		label_6.setBounds(10, 384, 68, 20);
		
		txbEndereco = new Text(shlAluno, SWT.BORDER);
		txbEndereco.setBounds(10, 410, 257, 30);
		txbEndereco.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent arg0) {
				arg0.text = arg0.text.toUpperCase();
				
			}
		});
		
		Label label_7 = new Label(shlAluno, SWT.NONE);
		label_7.setText("Bairro");
		label_7.setBounds(10, 446, 68, 20);
		
		txbBairro = new Text(shlAluno, SWT.BORDER);
		txbBairro.setBounds(10, 472, 133, 30);
		txbBairro.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent arg0) {
				arg0.text = arg0.text.toUpperCase();
				
			}
		});
		
		Label label_8 = new Label(shlAluno, SWT.NONE);
		label_8.setText("Cidade");
		label_8.setBounds(148, 446, 68, 20);
		
		txbCidade = new Text(shlAluno, SWT.BORDER);
		txbCidade.setBounds(152, 472, 137, 30);
		txbCidade.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent arg0) {
				arg0.text = arg0.text.toUpperCase();
				
			}
		});
		
		Label label_9 = new Label(shlAluno, SWT.NONE);
		label_9.setText("Numero");
		label_9.setBounds(273, 384, 68, 20);
		
		txbNumero = new Text(shlAluno, SWT.BORDER);
		txbNumero.setBounds(273, 410, 77, 30);
		
		txbEstado = new Text(shlAluno, SWT.BORDER);
		txbEstado.setBounds(295, 472, 55, 30);
		txbEstado.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent arg0) {
				arg0.text = arg0.text.toUpperCase();
				
			}
		});
		
		Label label_10 = new Label(shlAluno, SWT.NONE);
		label_10.setText("Estado");
		label_10.setBounds(296, 446, 68, 20);
		
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
		
		txbSenha = new Text(group, SWT.BORDER);
		txbSenha.setBounds(10, 98, 153, 30);
		
		Group grpResponsavl = new Group(shlAluno, SWT.NONE);
		grpResponsavl.setText("Responsavél");
		grpResponsavl.setBounds(372, 208, 331, 320);
		
		Label label_13 = new Label(grpResponsavl, SWT.NONE);
		label_13.setText("Cód. Resp");
		label_13.setBounds(10, 10, 68, 20);
		
		txbCodResp = new Text(grpResponsavl, SWT.BORDER);
		txbCodResp.setBounds(10, 36, 153, 30);
		
		Label label_14 = new Label(grpResponsavl, SWT.NONE);
		label_14.setText("Nome");
		label_14.setBounds(10, 72, 68, 20);
		
		txbNomeResp = new Text(grpResponsavl, SWT.BORDER);
		txbNomeResp.setBounds(10, 98, 312, 30);
		
		Button button = new Button(grpResponsavl, SWT.NONE);
		button.setText("Buscar Resp.");
		button.setBounds(169, 36, 101, 34);
		
		table = new Table(grpResponsavl, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 134, 312, 154);
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCodResp = new TableColumn(table, SWT.NONE);
		tblclmnCodResp.setWidth(100);
		tblclmnCodResp.setText("Cod Resp");
		
		TableColumn tblclmnNomeResp = new TableColumn(table, SWT.NONE);
		tblclmnNomeResp.setResizable(false);
		tblclmnNomeResp.setWidth(100);
		tblclmnNomeResp.setText("Nome Resp");
		
		Button btnAddResponsavel = new Button(grpResponsavl, SWT.NONE);
		btnAddResponsavel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AppResponsavel tela = new AppResponsavel();
				tela.open();
			}
		});
		btnAddResponsavel.setText("+");
		btnAddResponsavel.setBounds(276, 36, 43, 34);
		formToolkit.adapt(btnAddResponsavel, true, true);
		
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
		
		Button btnCancelar = new Button(shlAluno, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAluno.close();
			}
		});
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(608, 660, 95, 34);
		
		DateTime dtDatNasc = new DateTime(shlAluno, SWT.BORDER | SWT.CALENDAR | SWT.SHORT);
		dtDatNasc.setBounds(149, 221, 201, 157);

	}
}
