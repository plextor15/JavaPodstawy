import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.List;

public class DodanieOceny {

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Open the window.
	 */
	public void open(String imieStudenta, String nazwiskoStudenta) {
		Display display = Display.getDefault();
		Shell shlOcenyStudenta = new Shell();
		shlOcenyStudenta.setSize(450, 300);
		shlOcenyStudenta.setText("Oceny studenta");
		
		Label lblNewLabel = new Label(shlOcenyStudenta, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 10, 190, 27);
		lblNewLabel.setText(imieStudenta+" "+nazwiskoStudenta);
		
		List listPrzedmioty = new List(shlOcenyStudenta, SWT.BORDER);
		listPrzedmioty.setBounds(10, 43, 151, 208);
		
		List listOceny = new List(shlOcenyStudenta, SWT.BORDER);
		listOceny.setBounds(167, 43, 209, 208);

		shlOcenyStudenta.open();
		shlOcenyStudenta.layout();
		while (!shlOcenyStudenta.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
