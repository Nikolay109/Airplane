import java.awt.Rectangle;
import java.util.Random;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Enemy extends Plane{

//	int x = ;
//	int y = Plane.y+50;
//	int v = 10;
//	double direction = 0.0;
//	double vx;
//	double vy;
//	Image img = new Image(null, "res/Plane.png");
//	boolean killed = false;
	
//	public PaintListener listener;
//	
//	int xb;
//	int yb;
//	int xo = 1;
	Plane plane;
	final int TIMER_INTERVAL = 50;
	final int V0 = 19;
	
//	public void shot(){
//		//Main m = new Main();
//		xb = (int)(x + 20 + 29*Math.cos(direction));
//		yb = (int)(y + 20 + 29*Math.sin(direction));
//		map.bullets.add(new Bullet(xb, yb, this.direction));
//	}
	
	public Rectangle getRect(){
		return new Rectangle(x, y, 40, 40);
	}
	
	boolean q = true;
	
	public void die(){
		if (xo < LIGHTING)

			xo += 1;
		
	}
	public void auto_fly(){
		v = V0;
//		if (y<-250) direction = 2*Math.PI - direction;
//		if (x>980) direction = Math.PI - direction;
//		if (x<-420) direction = Math.PI - direction;
//		if (y>500) direction = 2*Math.PI - direction;
		if (!(killed)){
			vx =  v*Math.cos(direction);
			vy =  v*Math.sin(direction);
			x += (int) vx;
			y += (int) vy;
			if (direction + 0.08 > 2*Math.PI)
				direction = 0;
			else
				direction += 0.08;
			Random rand = new Random();
			if(rand.nextInt(1) == 0){  
				this.shot();
			}
		}
	}
	Canvas canvas;
	Shell shell;
	//Map map;
	public Enemy(Canvas cn, Shell sh, Plane p){
		this.canvas = cn;
		this.shell = sh;
//		//this.map = m;
		this.plane = p;
		x = X0;
		y = Y0; 
//	}
//	public void live(){
		Display display = this.canvas.getDisplay();
        
        Runnable runnable = new Runnable() {
	    	public void run() {
	    		//System.out.println("UTYTYTDD");
	            if(killed)
	            	die();
	            else
	                auto_fly(); 
	            //System.out.println(x);
	            canvas.redraw();
	            if(plane.killed){
	            	dispose();
	            	return;
	            }
	            display.timerExec(TIMER_INTERVAL, this);
	    	}
        };
        
        listener = new PaintListener() {
	        public void paintControl(PaintEvent event) {
	        	int x0 = 470;
	        	int y0 = 300;
	        	if(!(killed)){

			        Transform transform1 = new Transform(display);
			        transform1.translate(x-plane.get_x() + x0, y-plane.get_y() + y0);
			        double dir1 = 0.5*(direction/Math.PI)*360;
			        transform1.rotate((float) dir1 + 45);
			        transform1.translate(-(x-plane.get_x() + x0)-25, -(y-plane.get_y() + y0)-25);
			        event.gc.setTransform(transform1);
			        transform1.dispose();
			        event.gc.drawImage(img, x-plane.get_x() + x0, y-plane.get_y() + y0);
			    }else{
			      	if((xo%2 == 0)&&(xo<30)){
//			       		Color c1 = new Color(event.display, 250, 0, 0);
//			       		event.gc.setBackground(c1);
			      		Transform transform1 = new Transform(display);
				        transform1.translate(x-plane.get_x() + x0 + 20, y-plane.get_y() + y0 + 20);
				        double dir1 = 0.5*(direction/Math.PI)*360;
				        transform1.rotate((float) dir1 + 45);
				        transform1.translate(-(x-plane.get_x() + x0)-20, -(y-plane.get_y() + y0)-20);
				        event.gc.setTransform(transform1);
				        transform1.dispose();
			       		event.gc.drawImage(img, x-plane.get_x() + x0, y-plane.get_y() + y0);
			       		//event.gc.fillOval(x-Plane.x + x0-30, y-Plane.y + y0-160, xo, xo);
			       	}
			    }
	        }
	    };
	    canvas.addPaintListener(listener);
	    display.timerExec(TIMER_INTERVAL, runnable);
	    //display.timerExec(-1, runnable);
    }
	
	public void dispose(){
		canvas.removePaintListener(listener);
	}
		
}
	

