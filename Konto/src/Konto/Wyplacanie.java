package Konto;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Wyplacanie {
	private Text textOpis;
	private Text textKwota;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlWyplacanie = new Shell();
		shlWyplacanie.setSize(310, 233);
		shlWyplacanie.setText("Wyplacanie");
		
		Label lblOpis = new Label(shlWyplacanie, SWT.NONE);
		lblOpis.setBounds(10, 10, 55, 15);
		lblOpis.setText("Opis");
		
		textOpis = new Text(shlWyplacanie, SWT.BORDER);
		textOpis.setBounds(10, 29, 278, 21);
		
		Label lblKwota = new Label(shlWyplacanie, SWT.NONE);
		lblKwota.setBounds(10, 80, 55, 15);
		lblKwota.setText("Kwota");
		
		textKwota = new Text(shlWyplacanie, SWT.BORDER);
		textKwota.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		textKwota.setBounds(137, 66, 151, 42);
		
		Button btnWplac = new Button(shlWyplacanie, SWT.NONE);
		btnWplac.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		btnWplac.setBounds(84, 128, 108, 42);
		btnWplac.setText("Wyplac");

		//Listenery
		btnWplac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				float doWyplacenia = Float.parseFloat(textKwota.getText());
				String opisWyplaty = textOpis.getText();
				
				if(doWyplacenia > 0 && Konto.CzyMoznaOdejacOdSalda(doWyplacenia)) {
					//WpisHistorii Nowy = new WpisHistorii(opisWplaty, true, doWplacenia);
					//Konto.Historia.add(Nowy);
					Konto.Historia.add(new WpisHistorii(opisWyplaty, false, doWyplacenia));
					Konto.OdejmijOdSalda(doWyplacenia);
					
					shlWyplacanie.close();
				}
			}
		});
		
		shlWyplacanie.open();
		shlWyplacanie.layout();
		while (!shlWyplacanie.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
