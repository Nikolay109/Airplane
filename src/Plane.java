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

abstract public class Plane {
	final int LIGHTING = 30;
	final int X0 = 4070;
	final int Y0 = 3000;
	protected int x;
	protected int y;
	protected int v;
	double direction;
	double vx;
	double vy;
	Image img = new Image(null, "res/Plane.png");
	boolean killed = false;
	
	PaintListener listener;
	
	int get_x(){
		return x;
	}
	
	int get_y(){
		return y;
	}
	
	Rectangle getRect(){
		return new Rectangle(x, y, 40, 40);
	}
	
	
//	public void fly(){
////		if (y<-300) direction = 2*Math.PI - direction;
////		if (x>8981-470) direction = Math.PI - direction;
////		if (x<-470) direction = Math.PI - direction;
////		if (y>5565-300) direction = 2*Math.PI - direction;
//		
//		if (y<-300) y = 5565-300;
//		if (x>8981-470) x = -470;
//		if (x<-470) x = 8981 - 470;
//		if (y>5565-300) y = -300;
//		
//		if (!(killed)){
//			vx =  v*Math.cos(direction);
//			vy =  v*Math.sin(direction);
//			x += (int) vx;
//			y += (int) vy;
//		}
//	}
	
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
//	public void keyPressed(KeyEvent e) {
//		int key = e.keyCode;
//		if (key == SWT.ARROW_UP){
//			v += 1;
//		}
//		if (key == SWT.ARROW_DOWN){
//			v -= 1;
//		}
//		
//		if (key == SWT.ARROW_LEFT){
//			if (direction - 0.22 < 0) 
//				direction = 2*Math.PI;
//			else
//				direction -= 0.22;
//		}
//		if (key == SWT.ARROW_RIGHT){
//			if (direction + 0.22 > 2*Math.PI)
//				direction = 0;
//			else
//				direction += 0.22;
//		}
//		if(key == SWT.CONTROL) this.shot();
//		
//	}
	int xb;
	int yb;
	int xo = 0;
	boolean q = true;
	
	public void die(){
		xo += 1;
	}
	
	void shot(){
		xb = (int)(x + 20 + 29*Math.cos(direction));
		yb = (int)(y + 20 + 29*Math.sin(direction));
		Map.bullets.add(new Bullet(xb, yb, this.direction));
	}
	
	//Canvas canvas;
	//Shell shell;
	//Map map;
//	Player(Canvas cn, Shell sh, Map m) {
//		this.map = m;
//		this.canvas = cn;
//		this.shell = sh;
//	}
//	}
	//void live();
//		Display display = this.shell.getDisplay();
//		Runnable runnable = new Runnable() {
//	    	public void run() {
//		        if(killed){
//		        	if(xo < 30)
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
//		        display.timerExec(50, this);
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
//	    display.timerExec(50, runnable);
//	    //display.timerExec(-1, runnable);
//	}
//	public void dispose(){
//		canvas.removePaintListener(listener);
//	}
}