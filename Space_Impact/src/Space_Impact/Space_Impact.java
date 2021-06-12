package Space_Impact;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Space_Impact {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlSpaceImpact = new Shell();
		shlSpaceImpact.setSize(872, 746);
		shlSpaceImpact.setText("Space Impact");
		
		Label lblTestowy = new Label(shlSpaceImpact, SWT.NONE);
		lblTestowy.setBounds(10, 10, 719, 225);
		lblTestowy.setText("testowy\ngugu");
		
		MessageBox dialog = new MessageBox(shlSpaceImpact, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
		
		Button btnDogory = new Button(shlSpaceImpact, SWT.NONE);
		btnDogory.setBounds(234, 298, 75, 25);
		btnDogory.setText("DoGory");
		
		Button btnDodolu = new Button(shlSpaceImpact, SWT.NONE);
		btnDodolu.setBounds(234, 348, 75, 25);
		btnDodolu.setText("DoDolu");
		
		
		dialog.setText("Start");
		dialog.setMessage("Gotowe do grania");
		int returnCode = dialog.open();
		
		if(returnCode == 256) {
			shlSpaceImpact.close();
		}
		
		//Listener
		btnDogory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		btnDodolu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});

		shlSpaceImpact.open();
		shlSpaceImpact.layout();
		while (!shlSpaceImpact.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
