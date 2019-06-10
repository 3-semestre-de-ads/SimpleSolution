package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import model.Administrador;
import model.AdministradorDAO;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Classe Menu Professor
 * @return: null
 * @author: SimpleSolutionDev Team
 */
public class TelaAdministrador {

	protected Shell shlAdministrado;
	private Text txbCodigo;
	private Text txbUsuario;
	private Text txbSenha;
	private Table table;
	
	/**
	 * Metodo caso seja novo registro
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void novo() {
		shlAdministrado.setText("Administrador - Novo");
		table.setEnabled(false);
		txbCodigo.setEnabled(false);
		txbUsuario.setEnabled(false);
		AdministradorDAO dao = new AdministradorDAO();
		txbCodigo.setText(Integer.toString(dao.proximoId()));
		txbUsuario.setText(String.format("ADM%05d", dao.proximoId()));
		populaTabela();
	}
	
	/**
	 * Metodo caso seja registro antigo
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaAdmin(Administrador admin) {
		populaTabela();
		AdministradorDAO dao = new AdministradorDAO();
		txbCodigo.setEnabled(false);
		txbUsuario.setEnabled(false);
		admin = dao.consultar(admin);
		shlAdministrado.setText("Administrador - Consulta");
	}
	
	/**
	 * Metodo para popular Tabela
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTabela() {
		AdministradorDAO dao = new AdministradorDAO();
		ArrayList<Administrador> r = dao.consultarTodos();
		
		for (int i = 0; i < r.size(); i++) {
			
			TableItem tbi = new TableItem(table, SWT.NONE);
			String[] valores = {Integer.toString(r.get(i).getCodAdmin()),
					r.get(i).getUserAdmin()};
 			tbi.setText(valores);
		}	

	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(Administrador admin) {
		Display display = Display.getDefault();
		createContents();
		if (admin ==null) {
			novo();
		}else {
			populaAdmin(admin);
		}
		shlAdministrado.open();
		shlAdministrado.layout();
		while (!shlAdministrado.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAdministrado = new Shell();
		shlAdministrado.setSize(425, 337);
		shlAdministrado.setText("Administrador");
		
		Label lblNewLabel = new Label(shlAdministrado, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 68, 20);
		lblNewLabel.setText("Codigo");
		
		Label lblNewLabel_1 = new Label(shlAdministrado, SWT.NONE);
		lblNewLabel_1.setBounds(154, 10, 68, 20);
		lblNewLabel_1.setText("Usuario");
		
		Label lblNewLabel_2 = new Label(shlAdministrado, SWT.NONE);
		lblNewLabel_2.setBounds(292, 10, 68, 20);
		lblNewLabel_2.setText("Senha");
		
		txbCodigo = new Text(shlAdministrado, SWT.BORDER);
		txbCodigo.setBounds(10, 34, 116, 30);
		
		txbUsuario = new Text(shlAdministrado, SWT.BORDER);
		txbUsuario.setBounds(154, 34, 116, 30);
		
		txbSenha = new Text(shlAdministrado, SWT.PASSWORD);
		txbSenha.setBounds(292, 36, 116, 30);
		
		table = new Table(shlAdministrado, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 93, 398, 156);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				TableItem[] selection  = table.getSelection();

		        for (int i = 0; i < selection.length; i++) {
		        	txbCodigo.setText(selection[i].getText(0));
		        	txbUsuario.setText(selection[i].getText(1));
		        	txbSenha.setText("xxxxxx");
		        	
		        }	
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Codigo");
		
		TableColumn Usuario = new TableColumn(table, SWT.NONE);
		Usuario.setWidth(100);
		Usuario.setText("Usuario");
		
		Button button = new Button(shlAdministrado, SWT.NONE);
		button.setText("Salvar");
		button.setBounds(207, 256, 95, 34);
		
		Button button_1 = new Button(shlAdministrado, SWT.NONE);
		button_1.setText("Cancelar");
		button_1.setBounds(313, 256, 95, 34);

	}
}
