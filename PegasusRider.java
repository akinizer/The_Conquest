

public class PegasusRider implements Soldier{
	private int count=1;
	private boolean passable;
	private int soldierPow=20;
	private int soldierPrice=23;
    
    public PegasusRider() {
    }
    public int getPow(){
    	return soldierPow;
    }
    public int getPrice(){
    	return soldierPrice;
    }
    public boolean borderCrosser(){
     return passable;	
    }
    public void addSoldier(int i){
    	count+=i;
    }
    public int getCount(){
    	return count;
    }
    public int getType(){
    	return 3;
    }
    public String toString(){
    	return ""+count;
    }
}