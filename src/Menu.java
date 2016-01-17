import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Menu {
	Canvas canvas;
	Shell shell;
	//private Map map;
	
	private Image imageStart = new Image(null, "res/start.png");
	Button buttonStart;
//	private Image imageExit = new Image(null, "./img/exit.png");
//	Button buttonExit;
	
	public Menu(Canvas cn, Shell sh){
	
		this.shell = sh;
		this.canvas = cn;
		
		//Button buttonStart = new Button(canvas, SWT.PUSH);
		//Image image = new Image(null, "res/plane.png");
		buttonStart = new Button(canvas, SWT.PUSH);
		buttonStart.setLocation(new Point(300,200));
		buttonStart.setSize(new Point(356,98));
		buttonStart.setImage(imageStart);
	
//		button.addListener(SWT.Selection, new Listener()
//		{
//			public void handleEvent(Event e)
//			{
//				switch (e.type)
//				{
//					case SWT.Selection:
//					Map map = new Map(cn, sh);
//					button.dispose();
//					//image.dispose();
//					//this.dispose();
//					break;
//				}
//			}
//		});
//		canvas.addKeyListener(new KeyAdapter(){
//	    	public void keyPressed(KeyEvent e){
//	    		int key = e.keyCode;
//	    		if (key != SWT.SHIFT)
//	    			//plane.keyPressed(e);
//	    			key = key;
//	    		else{
//	    			Enemy enemy = new Enemy(canvas, shell);
//	    			//enemy.live();
//	    			Map.enemies.add(enemy);
//	    		}
//	    	}
//	    });
		buttonStart.addListener(SWT.Selection, new Listener() 
		{
			public void handleEvent(Event e) 
			{
				
			    switch (e.type) 
			    {
				    case SWT.Selection:
				    	
				    	//Plane plane = new Plane(canvas, shell);
				    	Map map = new Map(canvas, shell);
				    	
				    	
				    	
				    	dispose();
				        break;
			    }
		    }
		});
	}
	public void dispose()
	{
		//map.dispose();
		imageStart.dispose();
		buttonStart.dispose();
		//imageExit.dispose();
		//buttonExit.dispose();
	}
}
