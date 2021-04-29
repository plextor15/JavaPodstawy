import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Student_GUI {
	public static WprowadzenieStudenta okno = new WprowadzenieStudenta();
	public static DodanieOceny oknoOcen = new DodanieOceny();
	public static DodaniePrzedmiotu oknoPrzedmiotow = new DodaniePrzedmiotu();
	
	public static Student Wybrany = new Student("AAAA", "BBBB");
	
	private static String NazwaPliku = "lista_studentow.txt";
	
	//public static void Reload() {
	public static ArrayList<Student> GlownaListaStudentow = new ArrayList<Student>();
	public static ArrayList<Ocena> ListaOcen = new ArrayList<Ocena>();
	

	public static void main(String[] args) {
		
		Display display = Display.getDefault();
		Shell shlStudentGui = new Shell();
		shlStudentGui.setSize(463, 206);
		shlStudentGui.setText("Student GUI");
		
		Button btnStudentWybrany = new Button(shlStudentGui, SWT.CHECK);
		btnStudentWybrany.setBounds(318, 10, 119, 16);
		btnStudentWybrany.setText("Student wybrany");
		
		Button btnDodajStudenta = new Button(shlStudentGui, SWT.NONE);
		btnDodajStudenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				okno.open();
			}
		});
		btnDodajStudenta.setBounds(318, 30, 119, 25);
		btnDodajStudenta.setText("Dodaj studenta");
		
//		List list = new List(shlStudentGui, SWT.BORDER);
//		list.setBounds(10, 31, 284, 96);
//		for(int i=0; i < GlownaListaStudentow.size(); i++) {
//			list.add(GlownaListaStudentow.get(i).imie + " " + GlownaListaStudentow.get(i).nazwisko);
//		}
		//Reload(shlStudentGui);
		
		Label lblDostepniStudenci = new Label(shlStudentGui, SWT.NONE);
		lblDostepniStudenci.setBounds(10, 10, 112, 15);
		lblDostepniStudenci.setText("Dostepni studenci");
		
		Button btnOdswierz = new Button(shlStudentGui, SWT.NONE);
		btnOdswierz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Reload(shlStudentGui);
			}
		});
		btnOdswierz.setBounds(234, 132, 60, 25);
		btnOdswierz.setText("Odswierz");
		
		Button btnDodajPrzedmiot = new Button(shlStudentGui, SWT.NONE);
		btnDodajPrzedmiot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				oknoPrzedmiotow.open(Wybrany.imie, Wybrany.nazwisko);
			}
		});
		btnDodajPrzedmiot.setBounds(318, 61, 119, 25);
		btnDodajPrzedmiot.setText("Dodaj przedmiot");
		
		Button btnDodajOcene = new Button(shlStudentGui, SWT.NONE);
		btnDodajOcene.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				oknoOcen.open(Wybrany.imie, Wybrany.nazwisko);
			}
		});
		btnDodajOcene.setBounds(318, 92, 119, 25);
		btnDodajOcene.setText("Dodaj ocene");
		
		Button btnWybierz = new Button(shlStudentGui, SWT.NONE);
		btnWybierz.setBounds(10, 133, 75, 25);
		btnWybierz.setText("Wybierz");

		shlStudentGui.open();
		shlStudentGui.layout();
		while (!shlStudentGui.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
		public static void Reload(Shell uchwycik) {
			List list = new List(uchwycik, SWT.BORDER);
			list.setBounds(10, 31, 284, 96);
			for(int i=0; i < GlownaListaStudentow.size(); i++) {
				list.add(GlownaListaStudentow.get(i).imie + " " + GlownaListaStudentow.get(i).nazwisko);
			}
		}
}
