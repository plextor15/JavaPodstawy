import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class DodaniePrzedmiotu {

	
//	public static void main(String[] args) {
//		try {
//			DodaniePrzedmiotu window = new DodaniePrzedmiotu();
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void open(String imieStudenta, String nazwiskoStudenta) {
		Display display = Display.getDefault();
		Shell shlDodaniePrzedmiotu = new Shell();
		shlDodaniePrzedmiotu.setSize(450, 300);
		shlDodaniePrzedmiotu.setText("Dodanie przedmiotu");
		
		Label lblNewLabel = new Label(shlDodaniePrzedmiotu, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 160, 35);
		lblNewLabel.setText(imieStudenta+" "+nazwiskoStudenta);
		


		shlDodaniePrzedmiotu.open();
		shlDodaniePrzedmiotu.layout();
		while (!shlDodaniePrzedmiotu.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
