//Airplane_3


//Airplane_3


import java.awt.Rectangle;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Player extends Plane{
	final int TIMER_INTERVAL = 50;
//	static int x = 4070;
//	static int y = 1300;
	private int v = 10;
	
	
	
	private final int PLANE_CENTER_X = 470;
	private final int PLANE_CENTER_Y = 300;
	
	
	private final int V_MAX = 30;
	private final int V_MIN = 10;
	private final int DV = 1;
	private final double DIRECTION = 0.22;
	
	private final int MAP_RIGHT = 8511;
	private final int MAP_LEFT = - 470;
	private final int MAP_UP = -300;
	private final int MAP_DOWN = 5265;
	
//	double direction = 0.0;
//	double vx;
//	double vy;
//	Image img = new Image(null, "res/Plane.png");
//	static boolean killed = false;
	
//	public PaintListener listener;
	
//	public Rectangle getRect(){
//		return new Rectangle(this.x, this.y, 40, 40);
//	}
	
	public void fly(){
//		if (y<-300) direction = 2*Math.PI - direction;
//		if (x>8981-470) direction = Math.PI - direction;
//		if (x<-470) direction = Math.PI - direction;
//		if (y>5565-300) direction = 2*Math.PI - direction;
		
		if (y<-MAP_UP) y = MAP_DOWN;
		if (x>MAP_RIGHT) x = MAP_LEFT;
		if (x<-MAP_LEFT) x = MAP_RIGHT;
		if (y>MAP_DOWN) y = MAP_UP;
		
		if (!(killed)){
			vx =  v*Math.cos(direction);
			vy =  v*Math.sin(direction);
			x += (int) vx;
			y += (int) vy;
		}
	}
	
	//List<Bullet> bullets = new ArrayList<Bullet> ();
//	public void keyPressed(KeyEvent e) {
//		int key = e.keyCode;
//		if (key == ){
//			v += 5;
//		}
//		if (key == KeyEvent.VK_DOWN){
//			v += 5;
//		}
//		if (key == KeyEvent.VK_RIGHT){
//			if (direction - 0.1 > 0) 
//				direction = 0;
//			else
//				direction -= 0.1;
//		}
//		if (key == KeyEvent.VK_LEFT){
//			if (direction + 0.1 > Math.PI)
//				direction = 0;
//			else
//				direction += 0.1;
//		}
//		
//	}
	public void keyPressed(KeyEvent e) {
		int key = e.keyCode;
		if (key == SWT.ARROW_UP){
			if(v<V_MAX)
			v += DV;
		}
		if (key == SWT.ARROW_DOWN){
			if (v>V_MIN)
			v -= DV;
		}
		if (key == SWT.ARROW_LEFT){
			if (direction - DIRECTION < 0) 
				direction = 2*Math.PI;
			else
				direction -= DIRECTION;
		}
		if (key == SWT.ARROW_RIGHT){
			if (direction + DIRECTION > 2*Math.PI)
				direction = 0;
			else
				direction += DIRECTION;
		}
		if(key == SWT.CONTROL) this.shot();
		
	}
//	int xb;
//	int yb;
//	int xo = 0;
//	boolean q = true;
//	public void die(){
//		//if (xo < 30){
//			xo += 1;
//		//}
////		else{
////			Lose l = new Lose(canvas, shell);
////			dispose();
////			return;
////		}
//		
//	}
//	public void shot(){
//		//Main m = new Main();
//		xb = (int)(x + 20 + 29*Math.cos(direction));
//		yb = (int)(y + 20 + 29*Math.sin(direction));
//		Map.bullets.add(new Bullet(xb, yb, this.direction));
//	}
	//private Canvas canvas;
	//private Shell shell;
	//Map map;
	Player() {
		//this.canvas = cn;
		//this.shell = sh;
		//this.map = m;
		x = X0;
		y = Y0;
	}
//	void live(){
//		Display display = this.shell.getDisplay();
//		Runnable runnable = new Runnable() {
//	    	public void run() {
//		        if(killed){
//		        	if(xo < LIGHTING)
//		        		die();
//		        	else{
//		    			Lose l = new Lose(canvas, shell);
//		    			dispose();
//		    			return;
//		        	}
//		        }
//		        		
//		        else
//		        	fly();
//		        canvas.redraw();
//		        //System.out.println("fewgerher");
//		        display.timerExec(TIMER_INTERVAL, this);
//	    	}
//		};
//		
//		canvas.addKeyListener(new KeyAdapter(){
//	    	public void keyPressed(KeyEvent e){
//	    		int key = e.keyCode;
//	    		if (key == SWT.ARROW_UP){
//	    			if(v<30)
//	    			v += 1;
//	    		}
//	    		if (key == SWT.ARROW_DOWN){
//	    			if (v>10)
//	    			v -= 1;
//	    		}
//	    		
//	    		if (key == SWT.ARROW_LEFT){
//	    			if (direction - 0.22 < 0) 
//	    				direction = 2*Math.PI;
//	    			else
//	    				direction -= 0.22;
//	    		}
//	    		if (key == SWT.ARROW_RIGHT){
//	    			if (direction + 0.22 > 2*Math.PI)
//	    				direction = 0;
//	    			else
//	    				direction += 0.22;
//	    		}
//	    		if(key == SWT.CONTROL) shot();
//	    	}
//	    });
//		
//		
//        listener = new PaintListener() {
//	        public void paintControl(PaintEvent event) {
//	        	if (!(killed)){
//			        Transform transform = new Transform(display);
//			        transform.translate(490, 320);
//			        double dir = 0.5*(direction/Math.PI)*360;
//			        transform.rotate((float) dir + 45);
//			        transform.translate(-490, -320);
//			        event.gc.setTransform(transform);
//			        transform.dispose();
//	        		//System.out.println("GFYTFYUGIHJKHJY");
//			        event.gc.drawImage(img, 470, 300);
//	            }else{
//	            	if((xo%2 == 0)&&(xo < 30)){
//	            		Transform transform = new Transform(display);
//				        transform.translate(490, 320);
//				        double dir = 0.5*(direction/Math.PI)*360;
//				        transform.rotate((float) dir + 45);
//				        transform.translate(-490, -320);
//				        event.gc.setTransform(transform);
//				        transform.dispose();
//				        event.gc.drawImage(img, 470, 300);
//	            		//event.gc.fillOval(470, 300, xo, xo);
//	            	}
//	            }
//	        }
//        };
//        canvas.addPaintListener(listener);
//	    display.timerExec(TIMER_INTERVAL, runnable);
//	    //display.timerExec(-1, runnable);
//	}
//	public void dispose(){
//		canvas.removePaintListener(listener);
//	}
}