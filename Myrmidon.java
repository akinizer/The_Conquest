


public class Myrmidon implements Soldier{
	private int count=1;
	private boolean passable;
    private final int soldierPow=5;
	private final int soldierPrice=7;
    
    public Myrmidon() {
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
    public int getType(){
    	return 1;
    }
    public int getCount(){
    	return count;
    }
    public String toString(){
    	return ""+count;
    }
}