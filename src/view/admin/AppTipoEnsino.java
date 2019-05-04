package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;

public class AppTipoEnsino {
	private Text text;
	private Text text_1;
	private Table table;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppTipoEnsino window = new AppTipoEnsino();
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
		
		TableColumn tblclmnCodigo = new TableColumn(table, SWT.NONE);
		tblclmnCodigo.setWidth(100);
		tblclmnCodigo.setText("Código");
		tblclmnCodigo.setMoveable(true);
		
		TableColumn tblclmnQtde = new TableColumn(table, SWT.NONE);
		tblclmnQtde.setWidth(58);
		tblclmnQtde.setText("Descrição");
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
		while (!shlTipoDeEnsino.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
