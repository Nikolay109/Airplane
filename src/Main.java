
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

//Airplane_3
public class Main{
	
//	Plane p = new Plane();
//	
//	
//	public static Canvas canvas;

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		
		Canvas canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
		shell.setText("Airplane_menu");
		Menu menu = new Menu(canvas, shell);
		shell.open();

		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		menu.dispose();
		
		display.dispose();
	}
}
