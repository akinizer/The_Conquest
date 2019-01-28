import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class land extends JPanel{
	
	private boolean captured ;
	private int land, strategicalLand;  
	JTextField text;
	JLabel lnd;
	Image image;
    RegionOval[] regions;
    
    public land(int land,int strategicalLand) {
    	this.regions=regions;
    	this.land = land;
    	this.strategicalLand = strategicalLand;
    	regions = new RegionOval[42];
      	
		lnd = new JLabel("<html>Land<br>Normal Land: "+land+"<html><br>Strategical Land: <html>"+strategicalLand);
   		lnd.setForeground(Color.BLACK);
    	lnd.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,15));
    	add(lnd);
   			
    	TListener listener = new TListener();
		addKeyListener(listener);
    }
	public int getNormal(){
		return land;
	}
	public int getStrategical(){
		return strategicalLand;
	}
	public void setNormal(RegionOval[] regions){
		int i = 0;
		for(int j = 0 ; j < regions.length ; j++)
			if(regions[j].isCaptured()&&!regions[j].isStrategical())
				i++;
		land = 1+i;
	}
	public void setStrategical(RegionOval[] regions){
		int i = 0;
		for(int j = 0 ; j < regions.length ; j++)
			if(regions[j].isCaptured()&&regions[j].isStrategical())
				i++;
		strategicalLand = 1+i;
	}
	
  
   private class TListener implements KeyListener
   {
      public void keyPressed (KeyEvent event){
      	
      	switch (event.getKeyCode())
         {
            case KeyEvent.VK_ENTER:
               text.setEnabled(false);
               break;
            case KeyEvent.VK_DOWN:
               System.out.println("b");
               break;
            
         }

         repaint();
      }
      public void keyTyped(KeyEvent event) {
      	
      }

      public void keyReleased (KeyEvent event) {}
   }
    
    public String toString(){
    	String s=""; int count=0;
    	if(captured)
    		s="myLand:"+count++;
    	s="";
    	return s;
    	
    }
}