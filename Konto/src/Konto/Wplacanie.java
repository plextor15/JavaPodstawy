package Konto;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Wplacanie {
	private Text textOpis;
	private Text textKwota;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlWplacanie = new Shell();
		shlWplacanie.setSize(310, 233);
		shlWplacanie.setText("Wplacanie");
		
		Label lblOpis = new Label(shlWplacanie, SWT.NONE);
		lblOpis.setBounds(10, 10, 55, 15);
		lblOpis.setText("Opis");
		
		textOpis = new Text(shlWplacanie, SWT.BORDER);
		textOpis.setBounds(10, 29, 278, 21);
		
		Label lblKwota = new Label(shlWplacanie, SWT.NONE);
		lblKwota.setBounds(10, 80, 55, 15);
		lblKwota.setText("Kwota");
		
		textKwota = new Text(shlWplacanie, SWT.BORDER);
		textKwota.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		textKwota.setBounds(137, 66, 151, 42);
		
		Button btnWplac = new Button(shlWplacanie, SWT.NONE);
		btnWplac.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		btnWplac.setBounds(84, 128, 108, 42);
		btnWplac.setText("Wplac");

		//Listenery
		btnWplac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				float doWplacenia = Float.parseFloat(textKwota.getText());
				String opisWplaty = textOpis.getText();
				
				if(doWplacenia > 0) {
					//WpisHistorii Nowy = new WpisHistorii(opisWplaty, true, doWplacenia);
					//Konto.Historia.add(Nowy);
					Konto.Historia.add(new WpisHistorii(opisWplaty, true, doWplacenia));
					Konto.DodajDoSalda(doWplacenia);
					
					shlWplacanie.close();
				}
			}
		});
		
		shlWplacanie.open();
		shlWplacanie.layout();
		while (!shlWplacanie.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
