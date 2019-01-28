
import java.awt.*;
import javax.swing.*;

public class player extends JPanel{
	
	public int rankPoint;
	private String name;
	private int gold = 40;
	Soldier[] sol1,sol2;
    army ar;
	land [] lnd1 = new land[42];
	land [] lnd2 = new land[42];
	JLabel labelName, labelGold, labelSoldiers;
    
    public player(String name, int gold, army ar, land l) {
    	this.name=name;
    	this.gold=gold;
    	rankPoint = 0;
    	
	
	    labelName = new JLabel(name);
	    labelGold = new JLabel("Gold: "+gold);
	    
	    
	    labelName.setBackground(Color.yellow);
	    labelName.setForeground(Color.green);
	    labelName.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,35));
	    labelGold.setBackground(Color.CYAN);
	    labelGold.setForeground(Color.green);
	    labelGold.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,28));
	    
	    add(labelName);
	    add(labelGold);
	    setBackground(new Color(100,70,50));
	    setPreferredSize(new Dimension(240,750));
    }
    public void setName(String a)
    {
    	name = a;
    }
    
    /*public void setArmy(army ar)
    {
    	this.ar=ar;
    }*/
    /*public void setLand(land l)
    {
    	lnd[0]=l;
    }*/
    public String getName()
    {
    	return name;
    }
    public void setGold(land la){
    	gold = la.getStrategical()*4+la.getNormal()*2+20;
    }
    public int getGold()
    {
    	return gold;
    }
    public army getArmy()
    {
    	return ar;
    }
    /*public land getLand()
    {
    	return lnd[0];
    }*/

    public String toString(){
    	return "name: " + name + "\ngold: <html>" + gold + "\narmy: " /*+ ar*/;
    }
	 public int getRankPoint(){
        return rankPoint;
    }
    public void addRankPoint(){
        
        rankPoint = rankPoint + 50;
    }
    public void reduceRankPoint(){
        
        rankPoint = rankPoint - 40;
    }
    public int compareTo(player p1){
        
        if(this.getRankPoint() < p1.getRankPoint())
            return -1;
        
        else if(this.getRankPoint() > p1.getRankPoint())
            return 1;
        
        return 0;
    }
    
    
}