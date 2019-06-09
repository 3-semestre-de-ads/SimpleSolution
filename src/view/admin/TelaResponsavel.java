package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import model.Responsavel;
import model.ResponsavelDAO;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TelaResponsavel {

	protected Shell shlResponsavl;
	private Text txbCodigo;
	private Text txbNome;
	private Text txbEmail;
	private Text txbRg;
	private Text txbTelefone;
	private Text txbCpf;
	private Table table;
	
	private void novoResp() {
		shlResponsavl.setText("Responsavel - Novo");
	}
	
	private void populaResp(Responsavel resp) {
		ResponsavelDAO dao = new ResponsavelDAO();
		resp = dao.consulta(resp);
		txbCodigo.setText(Integer.toString(resp.getCodResp()));
		txbNome.setText(resp.getNomeResp());
		txbEmail.setText(resp.getEmailResp());
		txbRg.setText(resp.getRgResp());
		txbCpf.setText(resp.getCpfResp());
		txbTelefone.setText(resp.getTelResp());
	}


	/**
	 * Open the window.
	 */
	public void open(Responsavel responsavel) {
		Display display = Display.getDefault();
		createContents();
		if (responsavel == null) {
			novoResp();
		}else {
			populaResp(responsavel);
		}
		shlResponsavl.open();
		shlResponsavl.layout();
		while (!shlResponsavl.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlResponsavl = new Shell();
		shlResponsavl.setSize(373, 529);
		
		
		Label label = new Label(shlResponsavl, SWT.NONE);
		label.setText("Código");
		label.setBounds(10, 10, 68, 20);
		
		txbCodigo = new Text(shlResponsavl, SWT.BORDER);
		txbCodigo.setEnabled(false);
		txbCodigo.setEditable(false);
		txbCodigo.setBounds(10, 38, 153, 30);
		
		txbNome = new Text(shlResponsavl, SWT.BORDER);
		txbNome.setBounds(10, 100, 340, 30);
		
		Label label_1 = new Label(shlResponsavl, SWT.NONE);
		label_1.setText("E-mail");
		label_1.setBounds(10, 136, 68, 20);
		
		txbEmail = new Text(shlResponsavl, SWT.BORDER);
		txbEmail.setBounds(10, 159, 340, 30);
		
		Label label_2 = new Label(shlResponsavl, SWT.NONE);
		label_2.setText("Nome");
		label_2.setBounds(10, 74, 68, 20);
		
		Label label_3 = new Label(shlResponsavl, SWT.NONE);
		label_3.setText("RG");
		label_3.setBounds(10, 195, 68, 20);
		
		txbRg = new Text(shlResponsavl, SWT.BORDER);
		txbRg.setBounds(10, 221, 153, 30);
		
		Label label_4 = new Label(shlResponsavl, SWT.NONE);
		label_4.setText("Telefone");
		label_4.setBounds(10, 257, 68, 20);
		
		txbTelefone = new Text(shlResponsavl, SWT.BORDER);
		txbTelefone.setBounds(10, 283, 153, 30);
		
		Label label_5 = new Label(shlResponsavl, SWT.NONE);
		label_5.setText("CPF");
		label_5.setBounds(173, 195, 68, 20);
		
		txbCpf = new Text(shlResponsavl, SWT.BORDER);
		txbCpf.setBounds(169, 221, 181, 30);
		
		Button btnSalvar = new Button(shlResponsavl, SWT.NONE);
		btnSalvar.setBounds(146, 456, 95, 34);
		btnSalvar.setText("Salvar");
		
		Button btnCancelar = new Button(shlResponsavl, SWT.NONE);
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(255, 456, 95, 34);
		
		table = new Table(shlResponsavl, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 358, 340, 92);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCodAluno = new TableColumn(table, SWT.NONE);
		tblclmnCodAluno.setWidth(100);
		tblclmnCodAluno.setText("Codigo");
		
		TableColumn tblclmnNomeAluno = new TableColumn(table, SWT.NONE);
		tblclmnNomeAluno.setWidth(100);
		tblclmnNomeAluno.setText("NomeAluno");
		
		Label lblAlunosDependentes = new Label(shlResponsavl, SWT.NONE);
		lblAlunosDependentes.setText("Alunos Dependentes");
		lblAlunosDependentes.setBounds(10, 332, 203, 20);

	}

}
