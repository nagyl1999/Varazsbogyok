package game;

import java.awt.Polygon;

public class Circle {
	private static int radius = 10;
	private static int points = 21;
	private Polygon c;
	private Vec2 center;
	public Circle(Vec2 center) {
		c=new Polygon();
		this.center = center;
		makeCircles();
	}
	
	private void makeCircles(){
	    for (int i = 0; i < points; i++) {
		    int xval = (int) (center.getX() + radius * Math.cos(i * 2 * Math.PI / points));
		    int yval = (int) (center.getY() + radius * Math.sin(i * 2 * Math.PI / points));
		    c.addPoint(xval,yval);}
	    }
	public Polygon getCircle() {return c;}
	
}
