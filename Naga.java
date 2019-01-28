


public class Naga implements Soldier{
	private int count=1;
	private boolean passable;
    private int soldierPow=9;
	private int soldierPrice=10;
    
    public Naga() {
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
    	return 2;
    }
    public String toString(){
    	return ""+count;
    }
    
}