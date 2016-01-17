import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;

public class Lose {
	Canvas canvas;
	Shell shell;
	Image img = new Image(null, "res/die.jpg");
	Button buttonExit;
	public PaintListener listener;
	
	public Lose(Canvas cn, Shell sh){
		this.canvas = cn;
		this.shell = sh;
		Display display = this.canvas.getDisplay();
		Runnable runnable = new Runnable() {
	    	public void run() {
	    		canvas.redraw();
		        display.timerExec(50, this);
	    	}
		};
		listener = new PaintListener() {
	        public void paintControl(PaintEvent event) {
	        	event.gc.drawImage(img, 170, 0);
	        }
		};
		buttonExit = new Button(canvas, SWT.PUSH);
		buttonExit.setLocation(new Point(300,400));
		buttonExit.setSize(new Point(356,98));
		buttonExit.setText("Покинуть");
		this.canvas.addPaintListener(listener);
		buttonExit.addListener(SWT.Selection, new Listener() 
		{
			public void handleEvent(Event e) 
			{
				display.dispose();	   
		    }
		});
        display.timerExec(50, runnable);
	}

}
