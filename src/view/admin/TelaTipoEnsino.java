package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import model.TipoEnsino;
import model.TipoEnsinoDAO;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
/**
 * Classe Controle do Tipo de Ensino
 * @return: null
 * @author: SimpleSolutionDev Team
 */
public class TelaTipoEnsino {
	private Text text;
	private Text text_1;
	private Table table;
	private Text text_2;
	
	/**
	 * Metodo caso seja novo registro
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void novoTE() {
		TipoEnsinoDAO dao = new TipoEnsinoDAO();
		text.setText(Integer.toString(dao.proximoId()));
		populaTabela();
		table.setEnabled(false);
	}
	
	/**
	 * Metodo caso seja registro antigo
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTE(TipoEnsino te) {
		populaTabela();
		table.setEnabled(true);
		text.setEnabled(false);
		text_1.setEnabled(false);
		text_2.setEnabled(false);
	}
	
	/**
	 * Metodo popular tabela
	 * @return: null
	 * @author: SimpleSolutionDev Team
	 */
	private void populaTabela() {
		TipoEnsinoDAO dao = new TipoEnsinoDAO();
		ArrayList<TipoEnsino>r = dao.consultarTodos();

		for (int i = 0; i < r.size(); i++) {
			
			TableItem tbi = new TableItem(table, SWT.NONE);
			String[] valores = {Integer.toString(r.get(i).getCodTE()), "",
								r.get(i).getNomeTE()};
 			tbi.setText(valores);
		}	
		
	}

	/**
	 * Open the window.
	 */
	public void open(TipoEnsino te) {

		Display display = Display.getDefault();
		Shell shlTipoDeEnsino = new Shell();
		shlTipoDeEnsino.setSize(449, 321);
		shlTipoDeEnsino.setText("Tipo de Ensino");
		
		Label label = new Label(shlTipoDeEnsino, SWT.NONE);
		label.setText("Codigo");
		label.setBounds(10, 10, 68, 20);
		
		Label lblNome = new Label(shlTipoDeEnsino, SWT.NONE);
		lblNome.setText("Nome");
		lblNome.setBounds(168, 10, 68, 20);
		
		text = new Text(shlTipoDeEnsino, SWT.BORDER);
		text.setEnabled(false);
		text.setEditable(false);
		text.setBounds(10, 36, 95, 30);
		
		text_1 = new Text(shlTipoDeEnsino, SWT.BORDER);
		text_1.setBounds(168, 36, 266, 30);
		
		table = new Table(shlTipoDeEnsino, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 72, 424, 153);
		table.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
					TableItem[] selection  = table.getSelection();

			        for (int i = 0; i < selection.length; i++) {
			        	text.setText(selection[i].getText(0));
			        	text_1.setText(selection[i].getText(2));
			        	
			        }				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		TableColumn tblclmnCodigo = new TableColumn(table, SWT.NONE);
		tblclmnCodigo.setWidth(100);
		tblclmnCodigo.setText("Código");
		tblclmnCodigo.setMoveable(true);
		
		TableColumn tblclmnQtde = new TableColumn(table, SWT.NONE);
		tblclmnQtde.setWidth(58);
		tblclmnQtde.setText("Qtd");
		tblclmnQtde.setMoveable(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");
		tblclmnNome.setMoveable(true);
		
		Button button = new Button(shlTipoDeEnsino, SWT.NONE);
		button.setText("Salvar");
		button.setBounds(238, 231, 95, 34);
		
		Button button_1 = new Button(shlTipoDeEnsino, SWT.NONE);
		button_1.setText("Cancelar");
		button_1.setBounds(339, 231, 95, 34);
		
		Label lblQtde = new Label(shlTipoDeEnsino, SWT.NONE);
		lblQtde.setText("Qtde");
		lblQtde.setBounds(110, 10, 68, 20);
		
		text_2 = new Text(shlTipoDeEnsino, SWT.BORDER);
		text_2.setEnabled(false);
		text_2.setEditable(false);
		text_2.setBounds(111, 36, 51, 30);

		shlTipoDeEnsino.open();
		shlTipoDeEnsino.layout();
		
		if (te == null) {
			novoTE();
		}else {
			populaTE(te);
		}
		
		while (!shlTipoDeEnsino.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
	}

}
