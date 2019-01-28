import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Picture extends JPanel{
	private RegionOval[] oval;
	private int[] landPowers;
	Image image;
	RegionOval[] captured = new RegionOval[42];
    ArrayList<Integer> cptrd1 = new ArrayList<Integer>();
    ArrayList<Integer> cptrd2 = new ArrayList<Integer>();
	int a,b,c=0;
    public Picture(RegionOval[] captured) {
    	this.captured = captured;
    	addMouseListener (new DotsListener());
    	landPowers = new int[42];
   		landPowers[0]=100;landPowers[7]=100;landPowers[14]=100;landPowers[21]=45;landPowers[28]=20;landPowers[35]=80;
   		landPowers[1]=10;landPowers[8]=75;landPowers[15]=250;landPowers[22]=80;landPowers[29]=10;landPowers[36]=25;
   		landPowers[2]=30;landPowers[9]=150;landPowers[16]=80;landPowers[23]=60;landPowers[30]=100;landPowers[37]=45;
   		landPowers[3]=100;landPowers[10]=40;landPowers[17]=200;landPowers[24]=40;landPowers[31]=55;landPowers[38]=150;
   		landPowers[4]=20;landPowers[11]=200;landPowers[18]=50;landPowers[25]=45;landPowers[32]=150;landPowers[39]=300;
   		landPowers[5]=45;landPowers[12]=300;landPowers[19]=25;landPowers[26]=500;landPowers[33]=75;landPowers[40]=75;
   		landPowers[6]=500;landPowers[13]=200;landPowers[20]=45;landPowers[27]=30;landPowers[34]=60;landPowers[41]=25;
   		oval = new RegionOval[42];
    	oval[0] = new RegionOval(755, 118, 10, 10);
	 	oval[1] = new RegionOval(674, 109, 10, 10);
	 	oval[2] = new RegionOval(604, 113, 10, 10);
	 	oval[3] = new RegionOval(538, 144, 10, 10);
	 	oval[4] = new RegionOval(595, 160, 10, 10);
	 	oval[5] = new RegionOval(591, 205, 10, 10);
	 	oval[6] = new RegionOval(550, 225, 10, 10);
	 	oval[7] = new RegionOval(488, 248, 10, 10);
	 	oval[8] = new RegionOval(625, 262, 10, 10);
	 	oval[9] = new RegionOval(588, 292, 10, 10);
	 	oval[10] = new RegionOval(638, 317, 10, 10);
	 	oval[11] = new RegionOval(462, 120, 10, 10);
	 	oval[12] = new RegionOval(472, 175, 10, 10);
	 	oval[13] = new RegionOval(434, 197, 10, 10);
	 	oval[14] = new RegionOval(393, 248, 10, 10);
	 	oval[15] = new RegionOval(454, 221, 10, 10);
	 	oval[16] = new RegionOval(284, 25, 10, 10);
		oval[17] = new RegionOval(22, 99, 10, 10);
	 	oval[18] = new RegionOval(73, 99, 10, 10);
	 	oval[19] = new RegionOval(98, 155, 10, 10);
	 	oval[20] = new RegionOval(135, 157, 10, 10);
	 	oval[21] = new RegionOval(232, 140, 10, 10);
	 	oval[22] = new RegionOval(191, 201, 10, 10);
	 	oval[23] = new RegionOval(125, 207, 10, 10);
	 	oval[24] = new RegionOval(147, 286, 10, 10);
	 	oval[25] = new RegionOval(397, 275, 10, 10);
	 	oval[26] = new RegionOval(455, 295, 10, 10);
	 	oval[27] = new RegionOval(239, 360, 10, 10);
	 	oval[28] = new RegionOval(291, 405, 10, 10);
	 	oval[29] = new RegionOval(250, 425, 10, 10);
	 	oval[30] = new RegionOval(254, 486, 10, 10);
	 	oval[31] = new RegionOval(457, 423, 10, 10);
	 	oval[32] = new RegionOval(465, 342, 10, 10);
	 	oval[33] = new RegionOval(442, 380, 10, 10);
	 	oval[34] = new RegionOval(656, 386, 10, 10);
	 	oval[35] = new RegionOval(730, 392, 10, 10);
	 	oval[36] = new RegionOval(689, 465, 10, 10);
	 	oval[37] = new RegionOval(738, 460, 10, 10);
	 	oval[38] = new RegionOval(365, 136, 10, 10);
	 	oval[39] = new RegionOval(394, 181, 10, 10);
	 	oval[40] = new RegionOval(740, 236, 10, 10);
	 	oval[41] = new RegionOval(520, 444, 10, 10);
    	setBackground(new Color(222,170,150));
   		setPreferredSize(new Dimension(900,750));
    }
       public void paintComponent(Graphics page){ 
   		super.paintComponent(page);
   		//drawing the map
   		Toolkit t = Toolkit.getDefaultToolkit();
		image = t.getImage("ddWorldMap.jpg");
   		page.drawImage(image, 0, 0, null);
   		
   		//drawing the points on the map
	 	page.fillOval(755, 118, 10, 10);
	 	page.fillOval(674, 109, 10, 10);
	 	page.fillOval(604, 113, 10, 10);
	 	page.fillOval(538, 144, 10, 10);
	 	page.fillOval(595, 160, 10, 10);
	 	page.fillOval(591, 205, 10, 10);
	 	page.fillOval(550, 225, 10, 10);	
	 	page.fillOval(488, 248, 10, 10);
	 	page.fillOval(625, 262, 10, 10);
	 	page.fillOval(588, 292, 10, 10);
	 	page.fillOval(638, 317, 10, 10);
	 	page.fillOval(462, 120, 10, 10);
	 	page.fillOval(472, 175, 10, 10);
	 	page.fillOval(434, 197, 10, 10);
	 	page.fillOval(393, 248, 10, 10);
	 	page.fillOval(454, 221, 10, 10);
	 	page.fillOval(284, 25, 10, 10);
	 	page.fillOval(22,99, 10, 10);
	 	page.fillOval(73,99, 10, 10);
	 	page.fillOval(98,155, 10, 10);
	 	page.fillOval(135, 157, 10, 10);
	 	page.fillOval(232, 140, 10, 10);
	 	page.fillOval(191, 201, 10, 10);
	 	page.fillOval(125, 207, 10, 10);
	 	page.fillOval(147, 286, 10, 10);
	 	page.fillOval(397, 275, 10, 10);
	 	page.fillOval(455, 295, 10, 10);
	 	page.fillOval(239, 360, 10, 10);
	 	page.fillOval(291, 405, 10, 10);
	 	page.fillOval(250, 425, 10, 10);
	 	page.fillOval(254, 486, 10, 10);
	 	page.fillOval(457, 423, 10, 10);
	 	page.fillOval(465, 342, 10, 10);
	 	page.fillOval(442, 380, 10, 10);
	 	page.fillOval(656, 386, 10, 10);
	 	page.fillOval(730, 392, 10, 10);
	 	page.fillOval(689, 465, 10, 10);
	 	page.fillOval(738, 460, 10, 10);
	 	page.fillOval(365, 136, 10, 10);
	 	page.fillOval(394, 181, 10, 10);
	 	page.fillOval(740, 236, 10, 10);
	 	page.fillOval(520, 444, 10, 10);
	 	
	 	//drawing lines on the map
	 	Graphics2D g2 = (Graphics2D) page;
	 	g2.setStroke(new BasicStroke(3));
	 	page.drawLine(215, 94, 257, 57);
	 	page.drawLine(346, 98, 370, 133);
	 	page.drawLine(380, 149, 445, 138);
	 	page.drawLine(319, 400, 381, 346);
	 	page.drawLine(670, 353, 681, 374);
	 	//page.drawLine(692, 383, 720, 390);
	 	page.drawLine(687, 419, 710, 437);
	 	//page.drawLine(715, 263, 724, 266);
	 	//page.drawLine(750, 429, 750, 418);
	 	//page.drawLine(730, 431, 734, 413);
	 	//page.drawLine(757, 229, 783, 197);
	 	//page.drawLine(742, 203, 749, 230);
	 	//page.drawLine(506, 452, 519, 451);
	 	//page.drawLine(600, 356, 640, 377);
	 	//page.drawLine(369, 152, 397, 177);
	 	//page.drawLine(414, 204, 423, 202);
	 	//page.drawLine(408, 176, 430, 167);
	 	page.drawLine(12, 114, 0, 114);
	 	page.drawLine(868, 136, 858, 136);
	 	//page.drawLine(271, 149, 297, 132);
	 	
	 	
	 	//drawing the land powers
	 	for(int i = 0 ; i<7 ; i++){
	 		page.drawString(""+landPowers[i],oval[i].getX()+10,oval[i].getY()+10);
	 		page.setColor(Color.WHITE);
	 	}
	 	for(int i = 8 ; i<42 ; i++){
	 		page.drawString(""+landPowers[i],oval[i].getX()+10,oval[i].getY()+10);
	 		page.setColor(Color.WHITE);
	 	}
	 	
	 	
	 	for (int i = 0 ; i < 42 ; i++){
	 		captured[i]=oval[i];
	 		if(cptrd1.contains(i))
	 			page.drawImage(t.getImage("blue.png"), captured[i].getX(),captured[i].getY()+15, null);
	 		if(cptrd2.contains(i))
	 			page.drawImage(t.getImage("red.gif"), captured[i].getX(),captured[i].getY()+15, null);
	 		if(cptrd1.contains(7))
	 		{
	 			page.drawImage(t.getImage("blue.png"), captured[7].getX(),captured[7].getY()+15, null);
	 			page.drawString("Blue Team is the WINNER!",10,90);
	 			page.setColor(Color.BLUE);
	 			page.setFont(new Font("TimesRoman", Font.PLAIN, 70)); 
	 		}
	 		else if(cptrd2.contains(7))
	 		{	
	 			page.drawImage(t.getImage("red.gif"), captured[7].getX(),captured[7].getY()+15, null);
	 			page.drawString("Red Team is the WINNER!",10,90);
	 			page.setColor(Color.RED);
	 			page.setFont(new Font("TimesRoman", Font.PLAIN, 70));
	 		}
	 		else
	 			page.drawImage(t.getImage("star.png"), oval[7].getX()+15,oval[7].getY()+15, null);
	 	}
	 	//current clicked land
	 	page.setColor(Color.cyan);
	 	for(int i = 0; i < 42 ; i++){
	 		if(oval[i].contains(a,b))
	 			page.fillOval(oval[i].getX(), oval[i].getY(), 10 ,10);
	 	}
	 	repaint();
    }//end of the constructor
    
   	//setCaptured methods add the captured lands to players
    public void setCaptured1(int i){
    	cptrd1.add(i);
    }
    public void setCaptured2(int i){
    	cptrd2.add(i);
    }
    
    //getCaptured methods are  to determine the number of the captured lands
    public int getCaptured1(){
    	return cptrd1.size();
    }
    public int getCaptured2(){
    	return cptrd2.size();
    }
    
    //these method are for the ap buttons
    public boolean isCaptured1(int i){
    	if(cptrd1.contains(i))
    		return true;
    	return false;
    }
    public boolean isCaptured2(int i){
    	if(cptrd2.contains(i))
    		return true;
    	return false;
    }
    
    //getAllPowers methods are for the ap buttons
    public int getAllPowers1(){
    	int a=0;
    	for(int i = 0 ; i < 42 ; i++)
    		if(cptrd1.contains(i))
    			a += landPowers[i];
    	return a;
    }
    public int getAllPowers2(){
    	int a=0;
    	for(int i = 0 ; i < 42 ; i++)
    		if(cptrd2.contains(i))
    			a += landPowers[i];
    	return a;
    }
    //we are geetting region powers from picture to GUI calss
   	public int getRegionPowerFromPicture(int i){
   		return landPowers[i];
   	}
   	public RegionOval getOvalFromPicture(int i){
   		return oval[i];
   	}
   	//the changeRegionPower and the changeFlag methods are working after the conquest or losing the war
   	public void changeRegionPower(int i,int a){
   		landPowers[i]=a;
   	}
   	public void changeFlag1(int i){
   		if(cptrd1.contains(i)){
   			cptrd1.remove(cptrd1.indexOf(i));
   		}
   	}
   	public void changeFlag2(int i){
   		if(cptrd2.contains(i)){
   			cptrd2.remove(cptrd2.indexOf(i));
   		}
   	}
   	
   	//Getting X and Y coordinates
   	public int getXFromPicture(){
   		return a;
   	}
   	public int getYFromPicture(){
   		return b;
   	}
    protected class DotsListener implements MouseListener
   {
      public void mousePressed (MouseEvent event)
      {
          
         a=event.getX();
         b=event.getY();
			System.out.println(a+" "+b);
      }
      public void mouseClicked (MouseEvent event) {}
      public void mouseReleased (MouseEvent event) {}
      public void mouseEntered (MouseEvent event) {}
      public void mouseExited (MouseEvent event) {}
   }
}