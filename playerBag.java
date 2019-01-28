/**
 * @(#)playerBag.java
 *
 *
 * @author 
 * @version 1.00 2015/7/28
 */


public class playerBag {
	
	public player[] bag;

     playerBag() {
     	bag = new player[2];
    	army a = new army(0,0,0,0);
    	land l = new land(0,0);
    	bag[0] = new player("",0,a,l);
    	bag[1] = new player("",0,a,l);
    }
    //Selection sort
    public void sort(){
    	
    		int min;
    	player temp;
    	
    	for ( int index = 0; index < bag.length -1; index++){
    		min = index;
    		for( int scan = index + 1; scan < bag.length; scan++)
    			if(bag[scan].compareTo(bag[min]) < 0)
    				min = scan;
    	
    	//Swap the values
    	temp = bag[min];
    	bag[min] = bag[index];
    	bag[index] = temp; 
    	}
    }
    public void addPlayer(player p){
    	
    	if(bag.length < 2)
    		bag[bag.length -1] = p;
    		
    	else{
    		player[] temp = new player[bag.length+1];
    		
    		for(int i = 0; i < bag.length; i++){
    			
    			temp[i] = bag[i];
    		}
    		bag = temp;
    		bag[bag.length -1] = p;
    	}
    	sort();	
    }
    
}