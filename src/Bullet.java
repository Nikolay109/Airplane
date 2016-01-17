import java.awt.Rectangle;

import org.eclipse.swt.graphics.Image;



public class Bullet {
	int x;
	int y;
	int s = 0;
	final int v = 60;
	double direction;
	public Rectangle getRect(){
		return new Rectangle(x, y, 2, 2);
	}
	
	public Bullet(int x, int y, double direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	Image img = new Image(null, "res/bullet.jpg");
	
	double vx;
	double vy;
	
	public void move(){
		vx = v*Math.cos(direction);
		vy = v*Math.sin(direction);
		x += (int) (vx);
		y += vy;
		//System.out.println(vx);
		s += v;
	}
	
}