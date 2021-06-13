package Space_Impact;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import Space_Impact.Level.Kierunek;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.Scanner;

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
		shlSpaceImpact.setSize(601, 367);
		shlSpaceImpact.setText("Space Impact");
		
		Label lblWysw = new Label(shlSpaceImpact, SWT.NONE);
		lblWysw.setBounds(10, 10, 552, 217);
		lblWysw.setText("testowy\ngugu");
		
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
		
		shlSpaceImpact.open();
		shlSpaceImpact.layout();
		
		Gra.Initialize();
		
		
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
		
		
		while (!shlSpaceImpact.isDisposed()) { //Game loop
			
			Gra.Sterow();
			System.out.println(Gra.key);
			if (Gra.GraczSzer != Gra.Szerokosc - 1) {
				if (Gra.key != 'd'){
					Gra.GraczWCosUderzyl(Gra.GraczUderzylW(Kierunek.PRAWO));
					Gra.PrzesunGracza(1, Kierunek.PRAWO);
				}
			} else {
				Gra.KoniecLevelu(true);
			}
			Gra.WcisnietoKlawisz = false;
			Gra.Postep++;
			Gra.AktualizacjaWidocznejMapy(Gra.Postep);
			Gra.View();
			
			lblWysw.setText(Gra.DoWyswietlenia);
			
			//Sleep
			try {
				Thread.sleep(Gra.ileKlatka);
			} catch (InterruptedException e) {
				System.out.println("Klatka nie pykla");
				e.printStackTrace();
			}
			
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
	}
}
