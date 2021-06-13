package Space_Impact;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import Space_Impact.Level.Kierunek;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

//import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Space_Impact {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlSpaceImpact = new Shell();
		shlSpaceImpact.setSize(601, 526);
		shlSpaceImpact.setText("Space Impact");
		
		Label lblWysw = new Label(shlSpaceImpact, SWT.NONE);
		lblWysw.setFont(SWTResourceManager.getFont("Courier New", 14, SWT.BOLD));
		lblWysw.setBounds(10, 10, 565, 229);
		lblWysw.setText("testowy\ngugu");
		
		MessageBox dialog = new MessageBox(shlSpaceImpact, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
		
		Button btnDogory = new Button(shlSpaceImpact, SWT.NONE);
		btnDogory.setBounds(149, 264, 75, 25);
		btnDogory.setText("DoGory");
		
		Button btnDodolu = new Button(shlSpaceImpact, SWT.NONE);
		btnDodolu.setBounds(149, 306, 75, 25);
		btnDodolu.setText("DoDolu");
		
		Label lblMapa = new Label(shlSpaceImpact, SWT.NONE);
		lblMapa.setBounds(10, 420, 40, 15);
		lblMapa.setText("Mapa");
		
		Label lblMszer = new Label(shlSpaceImpact, SWT.NONE);
		lblMszer.setBounds(56, 420, 55, 15);
		lblMszer.setText("Mszer");
		
		Label lblMwys = new Label(shlSpaceImpact, SWT.NONE);
		lblMwys.setBounds(117, 420, 55, 15);
		lblMwys.setText("Mwys");
		
		Label lblWys = new Label(shlSpaceImpact, SWT.NONE);
		lblWys.setBounds(56, 441, 55, 15);
		
		Label lblSzer = new Label(shlSpaceImpact, SWT.NONE);
		lblSzer.setBounds(117, 441, 55, 15);
		
		Label lblWidok = new Label(shlSpaceImpact, SWT.NONE);
		lblWidok.setBounds(10, 441, 40, 15);
		lblWidok.setText("Widok");
		
		Label lblPostep = new Label(shlSpaceImpact, SWT.NONE);
		lblPostep.setBounds(10, 462, 45, 15);
		lblPostep.setText("Postep");
		
		Label lblPos = new Label(shlSpaceImpact, SWT.NONE);
		lblPos.setBounds(66, 462, 55, 15);
		
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
		
		//DEBUG ONLY!!
		lblWys.setText(String.valueOf(Gra.WysokoscWidok));
		lblSzer.setText(String.valueOf(Gra.SzerokoscWidok));
		
		lblMwys.setText(String.valueOf(Gra.Wysokosc));
		lblMszer.setText(String.valueOf(Gra.Szerokosc));
		
		Button btnQuit = new Button(shlSpaceImpact, SWT.NONE);
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlSpaceImpact.close();
			}
		});
		btnQuit.setBounds(56, 280, 75, 25);
		btnQuit.setText("Quit");
		
		
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
			System.out.println(Gra.key + "  " + Gra.Postep);
			if (Gra.GraczSzer != Gra.Szerokosc - 1) {
				//if (Gra.key != 'd'){
					Gra.GraczWCosUderzyl(Gra.GraczUderzylW(Kierunek.PRAWO));
					Gra.PrzesunGracza(1, Kierunek.PRAWO);
				//}
			} else {
				Gra.KoniecLevelu(true);
				
				dialog.setText("Wygrana");
				dialog.setMessage("Uzyskano punktow: " + Gra.PunktyLevel);
				dialog.open();
				shlSpaceImpact.close();
			}
			Gra.WcisnietoKlawisz = false;
			Gra.Postep++;
			Gra.AktualizacjaWidocznejMapy(Gra.Postep);
			Gra.View();
			
			lblWysw.setText(Gra.DoWyswietlenia);
			
			if(!Gra.czyWygral) {
				dialog.setText("Przegrana :(");
				dialog.setMessage("Uzyskano punktow: " + Gra.PunktyLevel);
				dialog.open();
				shlSpaceImpact.close();
			}
			
			//Sleep
			try {
				Thread.sleep(Gra.ileKlatka);
			} catch (InterruptedException e) {
				System.out.println("Klatka nie pykla");
				e.printStackTrace();
			}
			
			//DEBUG ONLY!!
			lblPos.setText(String.valueOf(Gra.Postep));
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
	}
}
