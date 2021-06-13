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
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;

public class Space_Impact {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlSpaceImpact = new Shell();
		shlSpaceImpact.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		shlSpaceImpact.setSize(599, 554);
		shlSpaceImpact.setText("Space Impact");
		
		Image wyjscie = new Image(display, "e:/Projector/Zacmienie/Space_Impact/src/Space_Impact/wyjscie.jpg");
		Image dol = new Image(display, "e:/Projector/Zacmienie/Space_Impact/src/Space_Impact/dol.jpg");
		Image gora = new Image(display, "e:/Projector/Zacmienie/Space_Impact/src/Space_Impact/gora.jpg");
		Image krawedzDol = new Image(display, "e:/Projector/Zacmienie/Space_Impact/src/Space_Impact/krawedzDol.jpg");
		Image krawedzGora = new Image(display, "e:/Projector/Zacmienie/Space_Impact/src/Space_Impact/krawedzGora.jpg");
		
		TxT Gra = new TxT();
		
		
		Label lblWysw = new Label(shlSpaceImpact, SWT.NONE);
		lblWysw.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		lblWysw.setFont(SWTResourceManager.getFont("Courier New", 14, SWT.BOLD));
		lblWysw.setBounds(10, 70, 565, 229);
		lblWysw.setText("testowy\ngugu");
		
		Label label = new Label(shlSpaceImpact, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		
		label.setBounds(10, 297, 565, 2);
		
		Canvas canvasGorny = new Canvas(shlSpaceImpact, SWT.NONE);
		canvasGorny.setBounds(0, 0, 593, 64);
		canvasGorny.setBackgroundImage(krawedzGora);
		
		Canvas canvasDolny = new Canvas(shlSpaceImpact, SWT.NONE);
		canvasDolny.setBounds(0, 297, 583, 220);
		canvasDolny.setBackgroundImage(krawedzDol);
		
		Button btnQuit = new Button(canvasDolny, SWT.NONE);
		btnQuit.setBounds(232, 23, 122, 176);
		btnQuit.setImage(wyjscie);
		
		Button btnDogory = new Button(canvasDolny, SWT.NONE);
		btnDogory.setBounds(10, 10, 205, 95);
		btnDogory.setImage(gora);
		
		Button btnDodolu = new Button(canvasDolny, SWT.NONE);
		btnDodolu.setLocation(10, 99);
		btnDodolu.setSize(205, 100);
		btnDodolu.setImage(dol);
		btnDodolu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Gra.WcisnietoKlawisz = true;
				Gra.key = 's';
			}
		});
		
		//Listener
		btnDogory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Gra.WcisnietoKlawisz = true;
				Gra.key = 'w';
			}
		});
		
		
		MessageBox dialog = new MessageBox(shlSpaceImpact, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
		
		Label lblMapa = new Label(shlSpaceImpact, SWT.NONE);
		lblMapa.setBounds(793, 526, 40, 15);
		lblMapa.setText("Mapa");
		
		Label lblMszer = new Label(shlSpaceImpact, SWT.NONE);
		lblMszer.setBounds(839, 526, 55, 15);
		lblMszer.setText("Mszer");
		
		Label lblMwys = new Label(shlSpaceImpact, SWT.NONE);
		lblMwys.setBounds(900, 526, 55, 15);
		lblMwys.setText("Mwys");
		
		Label lblWys = new Label(shlSpaceImpact, SWT.NONE);
		lblWys.setBounds(839, 547, 55, 15);
		
		Label lblSzer = new Label(shlSpaceImpact, SWT.NONE);
		lblSzer.setBounds(900, 547, 55, 15);
		
		Label lblWidok = new Label(shlSpaceImpact, SWT.NONE);
		lblWidok.setBounds(793, 547, 40, 15);
		lblWidok.setText("Widok");
		
		Label lblPostep = new Label(shlSpaceImpact, SWT.NONE);
		lblPostep.setBounds(793, 568, 45, 15);
		lblPostep.setText("Postep");
		
		Label lblPos = new Label(shlSpaceImpact, SWT.NONE);
		lblPos.setBounds(849, 568, 55, 15);
		
		dialog.setText("Start");
		dialog.setMessage("Gotowe do grania");
		int returnCode = dialog.open();
		
		if(returnCode == 256) {
			shlSpaceImpact.close();
		}
		
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlSpaceImpact.close();
			}
		});
		
		
		
		shlSpaceImpact.open();
		shlSpaceImpact.layout();
		
		Gra.Initialize();
		
		//DEBUG ONLY!!
		lblWys.setText(String.valueOf(Gra.WysokoscWidok));
		lblSzer.setText(String.valueOf(Gra.SzerokoscWidok));
		
		lblMwys.setText(String.valueOf(Gra.Wysokosc));
		lblMszer.setText(String.valueOf(Gra.Szerokosc));
		
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
