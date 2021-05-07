import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.MouseMoveListener;

public class Drawing {
	static int X = 0;
	static int Y = 0;


	static void Znacznik(GC gc, Coord XY) {
		gc.drawOval(XY.x+2, XY.y+2, 4, 4);
	}
	
	
	
	public static void main(String[] args) {
		Coord XYki[] = new Coord[4];
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		shell.setSize(749, 625);
		
		shell.setText("Rysowanie | X: "+X+" Y: "+Y+" - DEBUG");
		
		Label Poziomy = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		Poziomy.setSize(500, 2);
		
		shell.open();
		
		Label Pionowy = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		Pionowy.setSize(2, 500);
		
		Scale poX = new Scale(shell, SWT.NONE);
		poX.setMaximum(500);
		poX.setBounds(10, 516, 500, 40);
		
		Scale poY = new Scale(shell, SWT.VERTICAL);
		poY.setLocation(516, 10);
		poY.setSize(40, 500);
		poY.setMaximum(500);
		
		Button Lol = new Button(shell, SWT.NONE);
		Lol.setBounds(597, 63, 34, 25);
		Lol.setText("lol");
		
		Label DebugText = new Label(shell, SWT.NONE);
		DebugText.setBounds(594, 104, 108, 15);
		DebugText.setText("New Label");
		
		Canvas canvasik = new Canvas(shell, SWT.NONE);
		canvasik.setBounds(10, 10, 500, 500);
		
		GC gc = new GC(canvasik);
				
		Button ToDrag = new Button(canvasik, SWT.FLAT);
		//ToDrag.setBounds(92, 172, 10, 10);
		ToDrag.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		ToDrag.setText(" ");
		
		
				
		
//		Point cursorLocation = Display.getCurrent().getCursorLocation();
//		Point relative = Display.getCurrent().getFocusControl().toControl(cursorLocation);
//		X = relative.x;
//		Y = relative.y;
//		DebugText.setText("X: "+X+", Y: "+Y);
		
		
		
		//DEZIER
		Path path = new Path(gc.getDevice());
		path.moveTo(10, 10);
		path.cubicTo(150, 150, 300, 300, 50, 250);
		//path.curveTo(150, 150, 300, 300, 50, 250);
		gc.drawPath(path);
		
		
		
		//LISTENERY
		poX.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                X = poX.getSelection();
            	
                shell.setText("Rysowanie | X: "+X+" Y: "+Y+" - DEBUG");
                Pionowy.setBounds(X+10, 10, 2, 500);
            }
        });
		
		poY.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Y = poY.getSelection();
                
                shell.setText("Rysowanie | X: "+X+" Y: "+Y+" - DEBUG");
                Poziomy.setBounds(10, Y+10, 500, 2);
            }
        });
		
		Lol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				ToDrag.setBounds(X-5, Y-5, 10, 10);
			}
		});
		
		
		canvasik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				canvasik.setFocus();
				
				Point cursor = Display.getCurrent().getCursorLocation();
				Point relative = Display.getCurrent().getFocusControl().toControl(cursor);
				X = relative.x;
				Y = relative.y;
				DebugText.setText("X: "+X+", Y: "+Y);
				
				Znacznik(gc, new Coord(X, Y));
			}
		});
		canvasik.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				Point cursor = Display.getCurrent().getCursorLocation();
				Point relative = Display.getCurrent().getFocusControl().toControl(cursor);
				X = relative.x;
				Y = relative.y + 505;
				DebugText.setText("X: "+X+", Y: "+Y);
				
				//Pionowy.setBounds(X+10, 10, 2, 500);
				//Poziomy.setBounds(10, Y+10, 500, 2);
				poX.setSelection(X);
				poY.setSelection(Y);
			}
		});
		
		
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		display.dispose();
	}
}
