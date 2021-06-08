package Zbiory;

import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;

public class Zbiory {
	public static Set<Integer> ZbiorA;
	public static Set<Integer> ZbiorB;
	public static Set<Integer> Przeciecie;
	public static Set<Integer> Suma;
	public static Set<Integer> RoznicaA;
	public static Set<Integer> RoznicaB;
	
	public static String PrzeciecieStr;
	public static String SumaStr;
	public static String RoznicaAStr;
	public static String RoznicaBStr;
	
	private static Text txtIleint;
	public static int wielkoscZbioru;
	
	public static int minimum, maximum;
	private static Text mini;
	private static Text maxi;

	public static int Random() {
		int randomNum = ThreadLocalRandom.current().nextInt(10000, 99999);
	    return randomNum;
	}
	
	public static void Generowanie() {
		//int TMPint;

		ZbiorA = new HashSet<Integer>(wielkoscZbioru);
		ZbiorB = new HashSet<Integer>(wielkoscZbioru);
		
		for (int i = 0; i < wielkoscZbioru; i++) {
			ZbiorA.add( minimum + (Random() % maximum) );
			ZbiorB.add( minimum + (Random() % maximum) );
		}
	}
	
	public static void Przetnij() {
		Przeciecie = new HashSet<Integer>(ZbiorA);
		Przeciecie.retainAll(ZbiorB);
		PrzeciecieStr = Przeciecie.toString();
	}
	
	public static void Zsumuj() {
		Suma = new HashSet<Integer>(ZbiorA);
		Suma.addAll(ZbiorB);
		SumaStr = Suma.toString();
	}
	
	public static void ZroznicujA() {
		RoznicaA = new HashSet<Integer>(ZbiorA);
		RoznicaA.removeAll(ZbiorB);
		RoznicaAStr = RoznicaA.toString();
	}
	
	public static void ZroznicujB() {
		RoznicaB = new HashSet<Integer>(ZbiorB);
		RoznicaB.removeAll(ZbiorA);
		RoznicaBStr = RoznicaB.toString();
	}
	
	public static void Deb() {
		System.out.println("A: " + ZbiorA);
		System.out.println("B: " + ZbiorB);
		System.out.println(wielkoscZbioru + "  " + minimum + "  " + maximum + "\n\n");
		
		System.out.println(ZbiorA.toString());
	}
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		//Integer wielkoscZbioru = new Integer(0);
		
		
		Display display = Display.getDefault();
		Shell shlZbiory = new Shell();
		shlZbiory.setSize(667, 211);
		shlZbiory.setText("Zbiory");
		
		Button btnGeneruj = new Button(shlZbiory, SWT.NONE);
		
		btnGeneruj.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		btnGeneruj.setBounds(20, 81, 140, 61);
		btnGeneruj.setText("Generuj");
		
		Label lblWygenerowano = new Label(shlZbiory, SWT.NONE);
		lblWygenerowano.setAlignment(SWT.CENTER);
		lblWygenerowano.setBounds(30, 148, 119, 15);
		lblWygenerowano.setText("Wygenerowano");
		lblWygenerowano.setVisible(false);
		
		txtIleint = new Text(shlZbiory, SWT.BORDER);
		txtIleint.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		txtIleint.setText("ile liczb");
		txtIleint.setBounds(31, 10, 98, 26);
		
		mini = new Text(shlZbiory, SWT.BORDER);
		mini.setText("min");
		mini.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		mini.setBounds(10, 42, 65, 33);
		
		maxi = new Text(shlZbiory, SWT.BORDER);
		maxi.setText("max");
		maxi.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		maxi.setBounds(107, 42, 65, 33);
		
		Label lblOddzielacz = new Label(shlZbiory, SWT.NONE);
		lblOddzielacz.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblOddzielacz.setBounds(81, 42, 20, 33);
		lblOddzielacz.setText(" - ");
		
		
		
		//Listenery
		btnGeneruj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (lblWygenerowano.getVisible()) {	
				} else {
					if (txtIleint.getText() != "ile liczb") {
						wielkoscZbioru = Integer.parseInt(txtIleint.getText());
					} else {
						wielkoscZbioru = 0;
					}
					
					maximum = Integer.parseInt(maxi.getText());
					minimum = Integer.parseInt(mini.getText());
					
					Generowanie();
					Deb();
					
					lblWygenerowano.setVisible(true);
				}
			}
		});

		shlZbiory.open();
		shlZbiory.layout();
		while (!shlZbiory.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
