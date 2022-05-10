package game;

public class Vec2 {
		//TODO
	  	int x;
	    int y;

	    public Vec2(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	    
	    public double getDistance(Vec2 p) {return Math.sqrt(Math.pow(p.x-this.x,2) + Math.pow(p.y-this.y,2));}
	    public boolean equals(Vec2 p ){return p.x == this.x && p.y == this.y;}
	    public int getX(){return x;}
	    public int getY(){return y;}

}
