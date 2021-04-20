import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Kalkulatorek {

	protected Shell shlKalkulatorek;
	private Text Input;
	private Text Output;
	
	//moje zmienne
	//private int KtoraZKolei = 1; //bedzie za chwile wpisywana,
								//nie ktora aktualnie jest wpisywana
	private boolean zapamietany = false;
	
	//private float x;
	private String xStr;
	//private float y;
	private String yStr;
	String wynikStr;
	//private float Wynik;
	//private String WynikStr;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Kalkulatorek window = new Kalkulatorek();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlKalkulatorek.open();
		shlKalkulatorek.layout();
		while (!shlKalkulatorek.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlKalkulatorek = new Shell();
		shlKalkulatorek.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		shlKalkulatorek.setSize(281, 284);
		shlKalkulatorek.setText("Kalkulatorek");
		shlKalkulatorek.setLayout(null);
		
		Input = new Text(shlKalkulatorek, SWT.BORDER);
		Input.setToolTipText("Liczba");
		Input.setBounds(10, 10, 240, 48);
		Input.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		
		Output = new Text(shlKalkulatorek, SWT.BORDER);
		Output.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		Output.setEditable(false);
		Output.setToolTipText("Wynik");
		Output.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.NORMAL));
		Output.setBounds(10, 215, 79, 18);
		
		Button Dodaj = new Button(shlKalkulatorek, SWT.NONE);
		Dodaj.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		Dodaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//if(KtoraZKolei == 1) {
				if(!zapamietany) {
					xStr = Input.getText();
					//KtoraZKolei += 1;
					
					zapamietany = true;
					Output.setText("zapamietany");
					
					//Output.setText(KtoraZKolei);
					//Kontrolka.setEnabled(true);
				}
				else {
					yStr = Input.getText();
					Policz(1);
				}
				
				Input.setText("");
			}
		});
		Dodaj.setToolTipText("Dodaj");
		Dodaj.setBounds(10, 78, 54, 48);
		Dodaj.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		Dodaj.setText("+");
		
		Button Odejmij = new Button(shlKalkulatorek, SWT.NONE);
		Odejmij.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		Odejmij.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(!zapamietany) {
					xStr = Input.getText();
					
					zapamietany = true;
					Output.setText("zapamietany");
				}
				else {
					yStr = Input.getText();
					Policz(2);
				}
				
				Input.setText("");
			}
		});
		Odejmij.setToolTipText("Odejmij");
		Odejmij.setText("-");
		Odejmij.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		Odejmij.setBounds(84, 78, 54, 48);
		
		Button Pomnoz = new Button(shlKalkulatorek, SWT.NONE);
		Pomnoz.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		Pomnoz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(!zapamietany) {
					xStr = Input.getText();
					
					zapamietany = true;
					Output.setText("zapamietany");
				}
				else {
					yStr = Input.getText();
					Policz(3);
				}
				
				Input.setText("");
			}
		});
		Pomnoz.setToolTipText("Pomnoz");
		Pomnoz.setText("*");
		Pomnoz.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		Pomnoz.setBounds(10, 145, 54, 48);
		
		Button Podziel = new Button(shlKalkulatorek, SWT.NONE);
		Podziel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
		Podziel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(!zapamietany) {
					xStr = Input.getText();
					
					zapamietany = true;
					Output.setText("zapamietany");
				}
				else {
					yStr = Input.getText();
					Policz(4);
				}
				
				Input.setText("");
			}
		});
		Podziel.setToolTipText("Podziel");
		Podziel.setText("/");
		Podziel.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		Podziel.setBounds(84, 145, 54, 48);
		
		Button Czysc = new Button(shlKalkulatorek, SWT.CENTER);
		Czysc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				xStr = "";
				yStr = "";
				//KtoraZKolei = 1;
				zapamietany = false;
				Output.setText("czysto");
				
				Input.setText("");
				//Kontrolka.setEnabled(false);
			}
		});
		Czysc.setToolTipText("Wyczysc");
		Czysc.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		Czysc.setText("C");
		Czysc.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		Czysc.setBounds(164, 78, 91, 48);
		
		Button RownaSie = new Button(shlKalkulatorek, SWT.CENTER);
		RownaSie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Input.setText(wynikStr);
			}
		});
		RownaSie.setToolTipText("Wyczysc");
		RownaSie.setText("=");
		RownaSie.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		RownaSie.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		RownaSie.setBounds(164, 145, 91, 48);
		
	}
	
	void Policz(int wybor) {
		float x = Float.parseFloat(xStr);
		float y = Float.parseFloat(yStr);
		float wynik;
		//String wynikStr;
		
		switch (wybor) {
		case 1: {
			wynik = x + y;
			break;
		}
		case 2: {
			wynik = x - y;
			break;
		}
		case 3: {
			wynik = x * y;
			break;
		}
		case 4: {
			if(x == 0) {
				wynik = 9999;
			}
			else {
				wynik = x / y;
			}
			break;
		}
		default:
			wynik = 99999;
			throw new IllegalArgumentException("Unexpected value: " + wybor);
		}
		
		wynikStr = Float.toString(wynik);
		Input.setText(wynikStr);
		
		xStr = wynikStr;
		zapamietany = true;
		//KtoraZKolei = 2;
	}
}
