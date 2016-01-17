import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

//Airplane_3
public class Map {
	Image img = new Image(null, "res/map.jpg");
	Player p;
	Map map = this;
	
	final int PICTURE_SIZE = 20;
	final int x0 = 470;
	final int y0 = 300;
	final int BULLET_S = 700;
	final int LIGHTING = 30;
	
	final int DEGREE = 45;
	
	final int TIMER_INTERVAL = 50;
	
	static public List<Bullet> bullets = new ArrayList<Bullet> ();
	private List<Enemy> enemies = new ArrayList<Enemy> ();
	private Canvas canvas;
	private Shell shell;
	//Plane p;
	public PaintListener listener;
	//Plane p;
	public Map(Canvas cn, Shell sh){
		//this.p = plane;
		
		
		//this.p = plane;
		
		this.canvas = cn;
		this.shell = sh;
		p = new Player();
		p.killed = false;
		//p.live();
		
	
	    this.shell.setText("Airplane");
	    //PaintListener listener;
	    Display display = shell.getDisplay();
	    //Plane p = new Plane(canvas, shell);
	    
	    Runnable runnable = new Runnable() {
	    	public void run() {
		        if(p.killed)
		        	p.die();
		        else
		        	p.fly();
//	              Iterator<Enemy> enemy = enemies.iterator();
//		          while(enemy.hasNext()){
//	            	  Enemy en = enemy.next();
//	            	  if(en.killed)
//	            		  en.die();
//	            	  else
//	            		  en.auto_fly();            
//	              }
		          //e.auto_fly();
		          Iterator<Bullet> bullet = bullets.iterator();
	              while(bullet.hasNext()){
	            	  Bullet b = bullet.next();
	            	  if (b.s > BULLET_S){
	            		  bullet.remove();
	            	  
	            	  }else{
	            		  b.move();
	            		  //System.out.println(b.x);
	            	  }
	            	  if ((b.getRect().intersects(p.getRect()))&&(!(p.killed))){
	            		  p.killed = true;
	            		  System.out.println("Вас грохнули");
	            		  //Lose l = new Lose(canvas, shell);
	            		  dispose();
//	            		  Iterator<Enemy> enemy2 = enemies.iterator();
//		    	          while(enemy2.hasNext()){
//		                	  Enemy e = enemy2.next();
//		                	  e.dispose();          
//		                  }
		    	          Iterator<Bullet> bullet1 = bullets.iterator();
			              while(bullet.hasNext()){
			            	  Bullet b1 = bullet1.next();
			            	  bullet1.remove();
			              }
			              Lose l = new Lose(canvas, shell);
		    	          
		    	          return;
	            		  
	            		  
	            	  };
	            	  Iterator<Enemy> enemy1 = enemies.iterator();
	    	          while(enemy1.hasNext()){
	                	  Enemy e = enemy1.next();
	                	  if((e.getRect().intersects(b.getRect()))&&(!(e.killed))){
	                		  System.out.println("KILL");
	                		  e.killed = true;
	                		  if (e.xo == LIGHTING){
	                			  enemy1.remove();
	                		  }
	                	  }          
	                  }
	              }
		          //b.move();
		          canvas.redraw();
		          //System.out.println("DFGFGGGGH");
		          display.timerExec(TIMER_INTERVAL, this);
		        }

	      };
	    
	    listener = new PaintListener() {
	        public void paintControl(PaintEvent event) {
	        	// Draw the background
	        	event.gc.fillRectangle(canvas.getBounds());
		          //event.gc.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_RED));
	        	//Transform transform = new Transform(display);
	        	//transform.translate(495, 325);
		        //double dir = 0.5*(p.direction/Math.PI)*360;
		        //transform.rotate(0);
		        //transform.translate(-495, -325);
		        //event.gc.setTransform(transform);
	        	event.gc.drawImage(img, -p.get_x(), -p.y);
		        
		        Iterator<Bullet> bullet = bullets.iterator();
		        while(bullet.hasNext()){
		        	Bullet b = bullet.next();
		        	event.gc.drawImage(b.img, b.x + 470 - p.get_x(), (int)(b.y) + 300 - p.y);
	            }
	          
		        //event.gc.drawImage(p.img, 300, 300);
	          
		        //double sin = Math.sin(p.direction);
	            if (!(p.killed)){
			        Transform transform = new Transform(display);
			        transform.translate(495, 325);
			        double dir = 0.5*(p.direction/Math.PI)*360;
			        transform.rotate((float) dir + DEGREE);
			        transform.translate(-495, -325);
			        event.gc.setTransform(transform);
			        event.gc.drawImage(p.img, 470, 300);
	            }//else{
//	            	if (p.xo > 0){
//	            		Color c1 = new Color(event.display, 250, 0, 0);
//	            		event.gc.setBackground(c1);
//	            		event.gc.fillOval(470, 300, p.xo, p.xo);
//	            	}
//	            }
              //System.out.println(p.y);
		        //display.timerExec(50, this);
		        Iterator<Enemy> enemy = enemies.iterator();
//		        while(enemy.hasNext()){
//		        	Enemy e = enemy.next();
//		        	if(!(e.killed)){
//
//				        Transform transform1 = new Transform(display);
//				        transform1.translate(-(e.get_x()-p.get_x() + x0)-PICTURE_SIZE, -(e.get_y()-p.get_y() + y0)-PICTURE_SIZE);
//				        double dir1 = 0.5*(e.direction/Math.PI)*360;
//				        transform1.rotate((float) dir1 + DEGREE);
//				        transform1.translate(-(e.get_x()-p.get_x() + x0)-PICTURE_SIZE, -(e.get_y()-p.get_y() + y0)-PICTURE_SIZE);
//				        event.gc.setTransform(transform1);
//				        
//				        
//				        event.gc.drawImage(p.img, e.get_x()-p.get_x() + x0, e.get_y()-p.get_y() + y0);
//				        System.out.println(e.get_x());
//				    }//else{
////				        	if(e.xo>0){
////				        		Color c1 = new Color(event.display, 250, 0, 0);
////				        		event.gc.setBackground(c1);
////				        		event.gc.fillOval(e.x-p.x + x0-30, e.y-p.y + y0-130, e.xo, e.xo);
////				        	}
////				        }
//		        }

	        }
	    };
	
	    canvas.addKeyListener(new KeyAdapter(){
	    	public void keyPressed(KeyEvent e){
	    		int key = e.keyCode;
	    		if (key != SWT.SHIFT){
	    			p.keyPressed(e);
	    		}else{
	    			Enemy enemy = new Enemy(canvas, shell, p);
	    			//enemy.live();
	    			enemies.add(enemy);
	    		}
	    	}
	    });

	      //shell.open();
	      this.canvas.addPaintListener(listener);
	      display.timerExec(TIMER_INTERVAL, runnable);
	      // Kill the timer
	      //display.timerExec(-1, runnable);
	      //display.dispose();
	}
	public void dispose(){
		canvas.removePaintListener(listener);
	}

}
//}