import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class WprowadzenieStudenta {
	
	private static Text Imie_text;
	private static Text Nazwisko_text;
	
	public static String ImieStr;
	public static String NazwiskoStr;
	
	public static Student ListaStudentow[] = new Student[20];
	private static int licznik = 0;
	
	//private static String NazwaPliku = Student_GUI.NazwaPliku;
	
	public static void Wprowadzanie() {
		Student TMP = new Student(ImieStr, NazwiskoStr);
		ListaStudentow[licznik] = TMP;
		licznik++;
		
		//System.out.print(ImieStr+" "+NazwiskoStr+"\n");
		Student_GUI.GlownaListaStudentow.add(TMP);
		
		System.out.print(Integer.toString(ListaStudentow.length)+"\n");
//		for (int i = 0; i < ListaStudentow.length; i++) {
//			System.out.print(Student_GUI.GlownaListaStudentow.get(i).nazwisko+"\n");
//		}
	}

	public static void Zapisanie() {
//		try {
//			PrintWriter plik = new PrintWriter(new BufferedWriter(new FileWriter(NazwaPliku)));
//		
//			for(int i = 0; i < licznik; i++) {
//				plik.println(ListaStudentow[i].imie + " " + ListaStudentow[i].nazwisko);
//			}
//		
//			plik.close();
//		}
//		catch(IOException e) {} 
		//try {
//			FileOutputStream fos = new FileOutputStream(Student_GUI.NazwaPliku);
//		    ObjectOutputStream plik = new ObjectOutputStream(fos);   
//		    plik.writeObject(Student_GUI.GlownaListaStudentow);
//		    plik.close();
			
//			PrintWriter pw = new PrintWriter(new FileOutputStream(Student_GUI.NazwaPliku));
//		    for (Student stud : Student_GUI.GlownaListaStudentow)
//		         pw.println(stud); // call toString() on Student, like stud.toString()
//		    pw.close();
			
			
		//}
		//catch(IOException e) {}
		
		try{
		    FileOutputStream writeData = new FileOutputStream(Student_GUI.NazwaPliku);
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    writeStream.writeObject(Student_GUI.GlownaListaStudentow);
		    writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlWprowadzanieDanych = new Shell();
		shlWprowadzanieDanych.setSize(390, 139);
		shlWprowadzanieDanych.setText("Wprowadzanie studenta");
		
		Label lblImie = new Label(shlWprowadzanieDanych, SWT.NONE);
		lblImie.setBounds(10, 10, 55, 15);
		lblImie.setText("Imie");
		
		Imie_text = new Text(shlWprowadzanieDanych, SWT.BORDER);
		Imie_text.setBounds(10, 31, 104, 21);
		
		Label lblNazwisko = new Label(shlWprowadzanieDanych, SWT.NONE);
		lblNazwisko.setText("Nazwisko");
		lblNazwisko.setBounds(120, 10, 55, 15);
		
		Nazwisko_text = new Text(shlWprowadzanieDanych, SWT.BORDER);
		Nazwisko_text.setBounds(120, 31, 150, 21);
		
		Button btnWprowadz = new Button(shlWprowadzanieDanych, SWT.NONE);
		btnWprowadz.setBounds(276, 10, 83, 42);
		btnWprowadz.setText("Wprowadz");
		
		Label horizon = new Label(shlWprowadzanieDanych, SWT.SEPARATOR | SWT.HORIZONTAL);
		horizon.setBounds(10, 58, 349, 2);
		
		Button btnZapisz = new Button(shlWprowadzanieDanych, SWT.NONE);
		btnZapisz.setBounds(151, 66, 75, 25);
		btnZapisz.setText("Zapisz");
		
		//listenery
		btnWprowadz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				ImieStr = Imie_text.getText();
				NazwiskoStr = Nazwisko_text.getText();
				Wprowadzanie();
				
				Imie_text.setText("");
				Nazwisko_text.setText("");
			}
		});
		btnZapisz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Zapisanie();
			}
		});

		shlWprowadzanieDanych.open();
		shlWprowadzanieDanych.layout();
		while (!shlWprowadzanieDanych.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
