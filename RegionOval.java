import java.awt.event.*;

public class RegionOval{
	private int x, y, width, height,k,m;
    
    public RegionOval(int x, int y, int width, int height) {
    	this.x=x;
    	this.y=y;
    	this.width=width;
    	this.height=height;
    }
    
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public void setX(int x){
    	this.x=x;
    }
    public void setY(int y){
    	this.y=y;
    }
    public boolean contains( int k, int m){
		this.k=k;
		this.m=m;
		if(Math.pow((x-k),2)+Math.pow((y-m),2)<Math.pow(10,2))
			return true;
		return false;
	}
	public boolean isCaptured(){
    		return true;
    }
    public boolean isStrategical(){
    	return true;
    }
	public String toString(){
		return "\nXcoo: "+x+" Ycoo: "+y;
	}
    
    
}