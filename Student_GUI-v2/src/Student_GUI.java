import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Button;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Student_GUI {
	public static WprowadzenieStudenta okno = new WprowadzenieStudenta();
	public static DodanieOceny oknoOcen = new DodanieOceny();
	public static DodaniePrzedmiotu oknoPrzedmiotow = new DodaniePrzedmiotu();
	
	public static Student Wybrany = new Student("AAAA", "BBBB");
	
	public static String NazwaPliku = "lista_studentow.txt";
	
	//public static void Reload() {
	public static ArrayList<Student> GlownaListaStudentow = new ArrayList<Student>(5);
	public static ArrayList<Ocena> ListaOcen = new ArrayList<Ocena>();
	//public static ArrayList<String> debuglista = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		try{
            FileInputStream readData = new FileInputStream(NazwaPliku);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            GlownaListaStudentow = (ArrayList<Student>) readStream.readObject();
            readStream.close();

            //System.out.println(people2.toString());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		
		Display display = Display.getDefault();
		Shell shlStudentGui = new Shell();
		shlStudentGui.setSize(463, 422);
		shlStudentGui.setText("Student GUI");
		
		Button btnStudentWybrany = new Button(shlStudentGui, SWT.CHECK);
		btnStudentWybrany.setBounds(318, 221, 119, 16);
		btnStudentWybrany.setText("Student wybrany");
		
		Button btnDodajStudenta = new Button(shlStudentGui, SWT.NONE);
		btnDodajStudenta.setBounds(318, 30, 119, 25);
		btnDodajStudenta.setText("Dodaj studenta");
		
		Label lblDostepniStudenci = new Label(shlStudentGui, SWT.NONE);
		lblDostepniStudenci.setBounds(10, 10, 112, 15);
		lblDostepniStudenci.setText("Dostepni studenci");
		
		Button btnOdswierz = new Button(shlStudentGui, SWT.NONE);
		btnOdswierz.setBounds(234, 132, 60, 25);
		btnOdswierz.setText("Odswierz");
		
		Button btnDodajPrzedmiot = new Button(shlStudentGui, SWT.NONE);
		btnDodajPrzedmiot.setGrayed(true);
		btnDodajPrzedmiot.setBounds(318, 61, 119, 25);
		btnDodajPrzedmiot.setText("Dodaj przedmiot");
		
		Button btnDodajOcene = new Button(shlStudentGui, SWT.NONE);
		btnDodajOcene.setBounds(318, 92, 119, 25);
		btnDodajOcene.setText("Dodaj ocene");
		
		Button btnWybierz = new Button(shlStudentGui, SWT.NONE);
		
		btnWybierz.setBounds(10, 133, 75, 25);
		btnWybierz.setText("Wybierz");
		
		Button btnNewButton = new Button(shlStudentGui, SWT.NONE);
		btnNewButton.setBounds(324, 243, 75, 25);
		btnNewButton.setText("New Button");
		
		
		List lista = new List(shlStudentGui, SWT.BORDER | SWT.H_SCROLL);
		lista.setTouchEnabled(true);
		lista.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
		lista.setBounds(10, 30, 284, 97);
//		for(int i=0; i < GlownaListaStudentow.size(); i++) {	
//		}
		
		//listenery
		btnDodajStudenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				okno.open();
			}
		});
		btnOdswierz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//Reload(shlStudentGui);
				lista.removeAll();
				for(int i=0; i < GlownaListaStudentow.size(); i++) {
					lista.add(GlownaListaStudentow.get(i).imie + " " + GlownaListaStudentow.get(i).nazwisko);
					//lista.add(NazwaPliku);
				}
			}
		});
		btnDodajPrzedmiot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				oknoPrzedmiotow.open(Wybrany.imie, Wybrany.nazwisko);
			}
		});
		btnDodajOcene.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				oknoOcen.open(Wybrany.imie, Wybrany.nazwisko);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				for (int i = 0; i < GlownaListaStudentow.size(); i++) {
				System.out.print(Student_GUI.GlownaListaStudentow.get(i).nazwisko+"\n");
				}
			}
		});
		btnWybierz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				btnStudentWybrany.setSelection(true);
				lista.removeAll();
			}
		});

		shlStudentGui.open();
		shlStudentGui.layout();
		while (!shlStudentGui.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
//		public static void Reload(Shell uchwycik) {
//			//List lista = new List(uchwycik, SWT.BORDER);
//			//lista.setBounds(10, 31, 284, 96);
//			for(int i=0; i < GlownaListaStudentow.size(); i++) {
//				lista.add(GlownaListaStudentow.get(i).imie + " " + GlownaListaStudentow.get(i).nazwisko);
//				//lista.add(NazwaPliku);
//			}
//			
//		}
}
