package view.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TelaAdministrador {

	protected Shell shlAdministrado;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
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
		shlAdministrado.setSize(450, 300);
		shlAdministrado.setText("Administrador");

	}

}
