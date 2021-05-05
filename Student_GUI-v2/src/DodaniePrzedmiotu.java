import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class DodaniePrzedmiotu {

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void open(String imieStudenta, String nazwiskoStudenta) {
		Display display = Display.getDefault();
		Shell shlDodaniePrzedmiotu = new Shell();
		shlDodaniePrzedmiotu.setSize(415, 131);
		shlDodaniePrzedmiotu.setText("Dodanie przedmiotu");
		
		Label lblNewLabel = new Label(shlDodaniePrzedmiotu, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 160, 35);
		lblNewLabel.setText(imieStudenta+" "+nazwiskoStudenta);
		
		Label lblOpcjaJeszczeNiedostepna = new Label(shlDodaniePrzedmiotu, SWT.NONE);
		lblOpcjaJeszczeNiedostepna.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblOpcjaJeszczeNiedostepna.setBounds(10, 31, 389, 46);
		lblOpcjaJeszczeNiedostepna.setText("Opcja jeszcze niedostepna");
		


		shlDodaniePrzedmiotu.open();
		shlDodaniePrzedmiotu.layout();
		while (!shlDodaniePrzedmiotu.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
