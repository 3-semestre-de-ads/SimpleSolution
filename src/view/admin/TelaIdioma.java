package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;

import java.util.ArrayList;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.ibm.icu.impl.UResource.Array;

import model.Idioma;
import model.IdiomaDAO;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TelaIdioma {

	protected Shell shlIdioma;
	private Table table;
	private Text txbCodigo;
	private Text txbIdioma;
	
	private void novoIdioma() {
		IdiomaDAO dao = new IdiomaDAO();
		txbCodigo.setText(Integer.toString(dao.proximoId()));
		populaTabela();
		table.setEnabled(false);
	}
	private void populaIdioma() {
		populaTabela();
		txbIdioma.setEnabled(false);		
	}
	
	private void populaTabela() {
		IdiomaDAO dao = new IdiomaDAO();
		ArrayList<Idioma> r = dao.consultarTodos();
		for (int i = 0; i < r.size(); i++) {
			
			TableItem tbi = new TableItem(table, SWT.NONE);
			String[] valores = {Integer.toString(r.get(i).getCodIdioma()), 
								r.get(i).getNomeIdioma()};
 			tbi.setText(valores);
		}	
		
	}

	/**
	 * Open the window.
	 */
	public void open(Idioma idioma) {
		Display display = Display.getDefault();
		createContents();
		if (idioma ==null) {
			novoIdioma();
		}else {
			populaIdioma();
		}
		shlIdioma.open();
		shlIdioma.layout();
		while (!shlIdioma.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIdioma = new Shell();
		shlIdioma.setSize(450, 307);
		shlIdioma.setText("Idiomas");
		
		table = new Table(shlIdioma, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 72, 424, 153);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				TableItem[] selection  = table.getSelection();

		        for (int i = 0; i < selection.length; i++) {
		        	txbCodigo.setText(selection[i].getText(0));
		        	txbIdioma.setText(selection[i].getText(1));
		        	
		        }
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		TableColumn tblclmnCodigo = new TableColumn(table, SWT.NONE);
		tblclmnCodigo.setMoveable(true);
		tblclmnCodigo.setWidth(100);
		tblclmnCodigo.setText("Código");
		
		TableColumn tblclmnDesc = new TableColumn(table, SWT.NONE);
		tblclmnDesc.setMoveable(true);
		tblclmnDesc.setWidth(100);
		tblclmnDesc.setText("Descrição");
		
		Label lblNewLabel = new Label(shlIdioma, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 68, 20);
		lblNewLabel.setText("Codigo");
		
		txbCodigo = new Text(shlIdioma, SWT.BORDER);
		txbCodigo.setEnabled(false);
		txbCodigo.setEditable(false);
		txbCodigo.setBounds(10, 36, 103, 30);
		
		txbIdioma = new Text(shlIdioma, SWT.BORDER);
		txbIdioma.setBounds(119, 36, 315, 30);
		
		Label lblIdioma = new Label(shlIdioma, SWT.NONE);
		lblIdioma.setText("Idioma");
		lblIdioma.setBounds(119, 10, 68, 20);
		
		Button btnSalvar = new Button(shlIdioma, SWT.NONE);
		btnSalvar.setBounds(238, 231, 95, 34);
		btnSalvar.setText("Salvar");
		
		Button btnCancelar = new Button(shlIdioma, SWT.NONE);
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(339, 231, 95, 34);

	}

}
