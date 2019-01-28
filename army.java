import java.awt.*;
import javax.swing.*;


public class army extends JPanel{
	//properties
    Myrmidon m; Naga n; PegasusRider p;	
	private int count=0,myrmidons,nagas,pegasusRiders, gold,totalPower,allPower=0;
	JLabel labelSoldiers;
	//constructor with 4 parameter
    public army(int myrmidons, int nagas, int pegasusRiders, int allPower ) {
    	this.myrmidons=myrmidons;
    	this.nagas=nagas;
    	this.pegasusRiders=pegasusRiders;
    	this.allPower=allPower;
    	m = new Myrmidon();
    	n = new Naga();
		p = new PegasusRider();
    	totalPower = myrmidons*m.getPow()+nagas*n.getPow()+pegasusRiders*p.getPow()+allPower;
    
    	//labelSoldiers shows the soldier numbers and the power
    	labelSoldiers = new JLabel("<html>Army<br>Myrmidon: "+myrmidons+"<html><br>Naga: <html>"+nagas+"<html><br>Pegasus Rider: <html>"+pegasusRiders+"<html><br>Power: <html>"+totalPower);
    	labelSoldiers.setForeground(Color.BLACK);
    	labelSoldiers.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,15));
    	add(labelSoldiers);
    }
    //buySoldier buys soldier and returns used gold
    public int buySoldier(int myr  , int naga, int pega ){
    	myrmidons+=myr;
    	nagas += naga;
    	pegasusRiders+=pega;
    	m.addSoldier(myr);
		n.addSoldier(naga);
		p.addSoldier(pega);
    	return myr*m.getPrice()+naga*n.getPrice()+pega*p.getPrice();    	
    }
    
    //getters for the soldier numbers, total number and the attack power
    public int getMyrmidon()
    {
    	return myrmidons;
    }
    public int getNaga()
    {
    	return nagas;
    }
    public int getPegasusRider()
    {
    	return pegasusRiders;
    }
    public int getTotalPower(){
    	return totalPower;
    }
    public int getAttackPower(int a,int b,int c){
    	return a*m.getPow()+b*n.getPow()+c*p.getPow();
    }
    
}