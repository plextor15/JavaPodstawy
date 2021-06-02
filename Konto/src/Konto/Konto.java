package Konto;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Konto {
	private static Wplacanie oknoWplacenia = new Wplacanie();
	private static Wyplacanie oknoWyplacenia = new Wyplacanie();
	
	private static float Saldo;
	public static void DodajDoSalda(float ile) {
		Saldo = Saldo + ile;
	}
	public static boolean CzyMoznaOdejacOdSalda(float ile) {
		if (Saldo < ile) {
			return false;
		} else {
			return true;
		}
	}
	public static void OdejmijOdSalda(float ile) {
		Saldo = Saldo - ile;
	}
	
	public static ArrayList<WpisHistorii> Historia = new ArrayList<WpisHistorii>();
	public static void DodajDoHistorii(WpisHistorii wpis) {
		Historia.add(wpis);
	}
	//public static void Odswierz() {}
	
	private static Table table;
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlKontoBankowe = new Shell();
		shlKontoBankowe.setSize(340, 271);
		shlKontoBankowe.setText("Konto bankowe");
		
		Label lblSrodki = new Label(shlKontoBankowe, SWT.NONE);
		lblSrodki.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblSrodki.setBounds(105, 10, 55, 23);
		lblSrodki.setText("srodki");
		
		Label lblSaldo = new Label(shlKontoBankowe, SWT.NONE);
		lblSaldo.setAlignment(SWT.RIGHT);
		lblSaldo.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblSaldo.setBounds(166, 10, 145, 56);
		lblSaldo.setText("00");
		
		Button btnWplac = new Button(shlKontoBankowe, SWT.NONE);
		
		btnWplac.setBounds(10, 10, 75, 25);
		btnWplac.setText("Wplac");
		
		Button btnWyplac = new Button(shlKontoBankowe, SWT.NONE);
		
		btnWyplac.setBounds(10, 41, 75, 25);
		btnWyplac.setText("Wyplac");
		
		table = new Table(shlKontoBankowe, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 72, 301, 143);
		
		TableColumn tblclmnOpis = new TableColumn(table, SWT.NONE);
		tblclmnOpis.setWidth(194);
		tblclmnOpis.setText("Opis");
		
		TableColumn tblclmnIle = new TableColumn(table, SWT.NONE);
		tblclmnIle.setWidth(102);
		tblclmnIle.setText("Ile");
		
		Button btnOdswierz = new Button(shlKontoBankowe, SWT.NONE);
		btnOdswierz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblSaldo.setText(Float.toString(Saldo));
				
				TableItem items1 = new TableItem(table, SWT.NONE, 0);
				TableItem items2 = new TableItem(table, SWT.NONE, 1);
				
				for (int i=0; i<Historia.size(); i++) {
					items1.setText(Historia.get(i).Opis);
					
					if(Historia.get(i).CzyWplata) {
						items2.setText("+" + Float.toString(Historia.get(i).Ile));
					} else {
						items2.setText("-" + Float.toString(Historia.get(i).Ile));
					}
					
				}
				
				/*
				 * for (int i=0; i<items.length; i++) { 
				 * 	items [i].setText (index, "Item " + i +
				 * "a"); 
				 * } 
				 * column.pack ();
				 */
			}
		});
		btnOdswierz.setBounds(91, 41, 75, 25);
		btnOdswierz.setText("Odswierz");
		
		
		//Listenery
		btnWplac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				oknoWplacenia.open();
			}
		});
		
		btnWyplac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				oknoWyplacenia.open();
			}
		});
		
		

		shlKontoBankowe.open();
		shlKontoBankowe.layout();
		while (!shlKontoBankowe.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	public static void Odswierz() {
		
	}
}
