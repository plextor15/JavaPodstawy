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
		shlSpaceImpact.setSize(1051, 805);
		shlSpaceImpact.setText("Space Impact");
		
		Label lblTestowy = new Label(shlSpaceImpact, SWT.NONE);
		lblTestowy.setBounds(10, 10, 659, 217);
		lblTestowy.setText("testowy\ngugu");
		
		MessageBox dialog = new MessageBox(shlSpaceImpact, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
		
		Button btnDogory = new Button(shlSpaceImpact, SWT.NONE);
		btnDogory.setBounds(149, 233, 75, 25);
		btnDogory.setText("DoGory");
		
		Button btnDodolu = new Button(shlSpaceImpact, SWT.NONE);
		btnDodolu.setBounds(149, 283, 75, 25);
		btnDodolu.setText("DoDolu");
		
		
		dialog.setText("Start");
		dialog.setMessage("Gotowe do grania");
		int returnCode = dialog.open();
		
		if(returnCode == 256) {
			shlSpaceImpact.close();
		}
		
		TxT Gra = new TxT();
		Gra.GameLoop();
		
		String info;
		String info2;
		if (Gra.czyWygral) {
			info = "Poziom ukonczony :)\n";
		}
		else{
			info = "Przegrana :(\n";
		}
		
		info2 = "Uzyskano punktow: " + String.valueOf(Gra.GetPunktyLevel());
		
		MessageBox dialog2 = new MessageBox(shlSpaceImpact, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
		dialog.setText(info);
		dialog.setMessage(info2);
		int retCode = dialog2.open();
		
		if (retCode == 32) {
			shlSpaceImpact.close();
		}
		
		//Listener
		btnDogory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Gra.WcisnietoKlawisz = true;
				Gra.key = 'w';
			}
		});
		btnDodolu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Gra.WcisnietoKlawisz = true;
				Gra.key = 's';
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
