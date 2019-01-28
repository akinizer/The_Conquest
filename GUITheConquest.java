import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import javafx.scene.media.*;
import javafx.embed.swing.JFXPanel;

public class GUITheConquest extends JFrame implements ActionListener{
	//properties
    army a1,a2;    
    player p1,p2;
    playerBag bag;
    land l1,l2;
    String name1, name2;
    
    JLabel title,timeLabel,buy1,m1,m2,n1,n2,pg1,pg2,attack1,buy2,m3,m4,n3,n4,pg3,pg4,attack2,tg1,tg2,labels[];
    JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,texts[];
    JButton ok1,ok2,ok3,ok4,ap1,ap2,how,sound;
    JPanel panel1,panel2,panel3,panel4,panel5;
    boolean timeControl = false;
    Timer time;
    Image image;
    ImageIcon icon;
    Integer [] number = {0,1,2,3,4,5};
    JComboBox<Integer> combo1;
    JComboBox<Integer> combo2;
    ActionEvent event; 
    private int a=100,b=100,c=0,d=0,e=0,f=0,g=0,h=0,m=0,n=0,k=0,r=0,t=0,X,Y,b1,b2,b3,b4,b5,b6,count=0,turnA=0,turnB=0,j=0,w=0,pwr1=0,pwr2=0,sayac=120,look = 1;
    RegionOval[] regions = new RegionOval[42];
    Picture pic = new Picture(regions);
    JFXPanel fxPanel;
    MediaPlayer mediaPlayer;
    	
    public GUITheConquest() {
    	
    	//Evet delirdim :D
    /*ZEY*/	JOptionPane.showMessageDialog(this, "BE CAREFUL WITH HIGH POINTS OF THE WORLD. ONLY SPECIAL CREATURE CAN FIGHT HERE!");
		JOptionPane.showMessageDialog(this, "BE CAREFUL WITH SEASIDES. ONLY SPECIAL CREATURE CAN ATTACK THERE!");
    	
    	//dialog boxes
        name1 = "";
    	name2 = "";
    	int again;
    	String result;
    	
    	do {
    		
    		name1 = JOptionPane.showInputDialog("Please enter a username for Player 1: ");
    		
    		name2 = JOptionPane.showInputDialog("Please enter a username for Player 2: ");
    		
    		result = "Player 1: " +name1+ "\nPlayer 2: " +name2;
    		
    		JOptionPane.showMessageDialog(null, result);
    		again = JOptionPane.showConfirmDialog(null, "Enter again?");
    		 
    	}while(again == JOptionPane.YES_OPTION);
    	
    	panel1 = new JPanel(); //Panels for buy/transfer/atttack
    	panel2 = new JPanel();
    	panel3 = new JPanel();
    	panel4 = new JPanel();
    	panel5 = new JPanel();
    	
    	panel1.setPreferredSize(new Dimension(170,140));
    	panel2.setPreferredSize(new Dimension(170,140));
    	panel3.setPreferredSize(new Dimension(170,140));
    	panel4.setPreferredSize(new Dimension(170,140));
    	
    	combo1 = new JComboBox<>(number);
    	combo2 = new JComboBox<>(number);
    	
    	for(int i = 0 ; i < 42 ; i++)
    		regions[i]= pic.getOvalFromPicture(i);
    	
    	ok1 = new JButton("ok");//Buttons for buy/get power/atttack
    	ok2 = new JButton("ok");
    	ok3 = new JButton("ok");
    	ok4 = new JButton("ok");
    	ap1 = new JButton("***All Power!***");
    	ap2 = new JButton("***All Power!***");
    	how = new JButton("How To Play?");
    	sound = new JButton("Sound: Off");
    	
    	ok1.setPreferredSize(new Dimension(60,30));
    	ok2.setPreferredSize(new Dimension(60,30));
    	ok3.setPreferredSize(new Dimension(60,30));
    	ok4.setPreferredSize(new Dimension(60,30));
    	
    	p1 = new player(name1,a,a1,l1); //army,player,land 
    	p2 = new player(name2,b,a2,l2);
    	bag = new playerBag();
    	bag.addPlayer(p1);
    	bag.addPlayer(p2);
    	a1 = new army(c,d,e,pwr1);
    	a2 = new army(f,g,h,pwr2);
    	l1 = new land(m,n);
    	l2 = new land(k,r);
		c = a1.getMyrmidon();
    	d = a1.getNaga();
    	e = a1.getPegasusRider();
    	f = a2.getMyrmidon();
    	g = a2.getNaga();
    	h = a2.getPegasusRider();
	    	
    	text1 = new JTextField("0");//Text Field for soldiers
		text2 = new JTextField("0");
		text3 = new JTextField("0");
		text4 = new JTextField("0");
		text5 = new JTextField("0");
		text6 = new JTextField("0");
		text7 = new JTextField("0");
		text8 = new JTextField("0");
		text9 = new JTextField("0");
		text10 = new JTextField("0");
		text11 = new JTextField("0");
		text12 = new JTextField("0");
		
		texts = new JTextField[12];//array to control text fields
		texts[0]=text1;texts[1]=text2;texts[2]=text3;texts[3]=text4;texts[4]=text5;texts[5]=text6;
		texts[6]=text7;texts[7]=text8;texts[8]=text9;texts[9]=text10;texts[10]=text11;texts[11]=text12;
		
		for(int i = 0 ; i < 12 ; i++){
			texts[i].setPreferredSize(new Dimension(30,20));
			texts[i].addActionListener(this);
		}
				
		ok1.addActionListener(this);//adding listeners for buttons
		ok3.addActionListener(this);
		ok2.addActionListener(this);
		ok4.addActionListener(this);
		ap1.addActionListener(this);
		ap2.addActionListener(this);
		how.addActionListener(this);
		sound.addActionListener(new soundListener());
			
		//Title of the game
		title = new JLabel("                                        ****The Conquest****");
		title.setForeground(new Color(10,100,50));
	    title.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,30));
	    title.setOpaque(true);
	    	
	    labels = new JLabel[18];//labels for buying,attacking and transfering
	    	
	    buy1 = new JLabel("Buy Soldier");
	    m1 = new JLabel("Myrmidons: ");
	   	n1 = new JLabel("Nagas: ");
	    pg1 = new JLabel("Pegasus Riders: ");
	   	attack1 = new JLabel("Attack");
	   	m2 = new JLabel("Myrmidons: ");
	    n2 = new JLabel("Nagas: ");
	    pg2 = new JLabel("Pegasus Riders: ");
	    
	   	buy2 = new JLabel("Buy Soldier");
	   	m3 = new JLabel("Myrmidons: ");
	   	n3 = new JLabel("Nagas: ");
	   	pg3 = new JLabel("Pegasus Riders: ");
	   	attack2 = new JLabel("Attack");
	   	m4 = new JLabel("Myrmidons: ");
	   	n4 = new JLabel("Nagas: ");
	   	pg4 = new JLabel("Pegasus Riders: ");
	    //array to control labels
	    labels[0] = m1; labels[1] = n1; labels[2] = pg1; labels[3] = m2; labels[4] = n2; labels[5] = pg2;
	    labels[6] = m3; labels[7] = n3; labels[8] = pg3; labels[9] = m4; labels[10] = n4; labels[11] = pg4;
	    labels[12] = attack1; labels[13] = attack2; labels[14] = buy1; labels[15] =  buy2; 
	    	
	   	for(int i = 0 ; i < 12 ; i++) {
	    	labels[i].setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,14));
	    	labels[i].setForeground(Color.BLUE);
	    }
	    for(int i = 12 ; i < 16 ; i++){
	    	labels[i].setFont(new java.awt.Font("Comic Sans MS",Font.BOLD,18));
	    	labels[i].setForeground(Color.BLUE);
	    	labels[i].setOpaque(true);
	    	labels[i].setBackground(Color.YELLOW);
	   	}
	   	//adding all labels to players
	   	p1.add(ap1); p1.add(a1); p1.add(l1);	panel1.add(buy1); 
	    for(int i = 0 ; i < 3 ; i++){	panel1.add(labels[i]);	panel1.add(texts[i]);	}
	  	  p1.add(panel1);	panel1.add(ok1);
	    	
	    panel2.add(attack1); panel2.add(combo1);
	   	for(int i = 3 ; i < 6 ; i++){	panel2.add(labels[i]);	panel2.add(texts[i]);	}
	   	p1.add(panel2);	panel2.add(ok2);
	    	
	    p2.add(ap2); p2.add(a2);p2.add(l2);	panel3.add(buy2); 	
	    for(int i = 6 ; i < 9 ; i++){	panel3.add(labels[i]);	panel3.add(texts[i]);	}
	    p2.add(panel3);	panel3.add(ok3);
	    	
	   	panel4.add(attack2); panel4.add(combo2);
	   	for(int i = 9 ; i < 12 ; i++){	panel4.add(labels[i]);	panel4.add(texts[i]);	}
	   	p2.add(panel4); panel4.add(ok4);
	    	
		fxPanel = new JFXPanel();
		mediaPlayer = new MediaPlayer(new Media(new File("mars.mp3").toURI().toString()));
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();	    	
	    panel5.setLayout(new BorderLayout());	
	    panel5.add(sound,BorderLayout.WEST);	
    	
    	//timer of the our class
    	timeLabel = new JLabel();
    	panel5.add(timeLabel,BorderLayout.CENTER);
    	time = new Timer();
    	time.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            panel5.remove(timeLabel);
        	sayac--;
        	timeLabel = new JLabel("                                                          Remaining Time: "+sayac);
    		if(sayac==0){
    			if(timeControl)
    				timeControl=false;
    			else
    				timeControl = true;
    			updateView7();
    		}
    		if(pic.isCaptured1(7)||pic.isCaptured2(7))	
    			time.cancel();		
            panel5.add(timeLabel,BorderLayout.CENTER);
            repaint();
            validate();
	        }
	    }, 1000, 1000);
	    	
	    	
	    panel5.add(how,BorderLayout.EAST);
	   	panel5.setPreferredSize(new Dimension(1000,55));
	    	
	   	pic.setCaptured1(30);
	   	pic.setCaptured2(0);
	   	ok3.setEnabled(false);
	    ok4.setEnabled(false);
	    ap2.setEnabled(false);
	    combo2.setEnabled(false);
    	//composing frame
    	setLayout (new BorderLayout());
    	setTitle("The Conquest"); 
		add (pic, BorderLayout.CENTER); 
		add (title, BorderLayout.NORTH);
		add (p2, BorderLayout.EAST);
		add (p1, BorderLayout.WEST);
		add (panel5, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(1365,800)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); 
		setVisible(true);
					
		}
		//button actions
    	public void actionPerformed(ActionEvent event) {
    		this.event= event;
	        //buy buttons    
	        if (event.getSource()==ok1) {
	        	this.b1=b1; this.b2=b2; this.b3=b3;
	        	b1 = Integer.parseInt(text1.getText());
	        	b2 = Integer.parseInt(text2.getText());
	        	b3 = Integer.parseInt(text3.getText());
	        	ok1.setEnabled(false);
	        	turnA=2;
			    	GUITheConquest.this.updateView1(b1,b2,b3);
			}
			if (event.getSource()==ok3) {
	        	this.b4=b4; this.b5=b5; this.b6=b6;
	        	b4 = Integer.parseInt(text7.getText());
	        	b5 = Integer.parseInt(text8.getText());
	        	b6 = Integer.parseInt(text9.getText());
	        	ok3.setEnabled(false);
	        	turnA=1;	
			    	GUITheConquest.this.updateView2(b4,b5,b6);
			    	
			}
			//attack buttons
			while(j < number[combo1.getSelectedIndex()]){//according to combo box number attack button works
				combo1.setEnabled(false);
				int x=0,y=0,z=0,o=0; 
		        x = Integer.parseInt(text4.getText());
			    y = Integer.parseInt(text5.getText());
			    z = Integer.parseInt(text6.getText());
				if (event.getSource()==ok2) {// when attackButton is clicked, following codes are working
					for(int i = 0 ; i<42 ; i++){
						if(regions[i].contains(pic.getXFromPicture(),pic.getYFromPicture())){
	        				//check mountain
							if(i==8|| i==9 || i==15){
								if(a1.getAttackPower(0,0,z)>=pic.getRegionPowerFromPicture(i)){
									m = pic.getCaptured1();
						 			pic.changeFlag2(i);
						 			pic.setCaptured1(i);
						 			pic.changeRegionPower(i,a1.getAttackPower(0,0,z)-pic.getRegionPowerFromPicture(i));
								}
								else{
									JOptionPane.showMessageDialog(this, "Sorry, you cannot decide appropriate strategy formulation.");
								}
							}
							//check seaside
							else if(i==10||i==11||i==16||i==17||i==25||i==28||i==34||i==36||i==38){
								if(a1.getAttackPower(0,y,0)>=pic.getRegionPowerFromPicture(i)){
									m = pic.getCaptured1();
						 			pic.changeFlag2(i);
						 			pic.setCaptured1(i);
						 			pic.changeRegionPower(i,a1.getAttackPower(0,y,0)-pic.getRegionPowerFromPicture(i));
								}
								else{
									JOptionPane.showMessageDialog(this, "Sorry, you cannot decide appropriate strategy formulation.");
								}
							}
							else{//for the following codes the point that is clicked should be valid
							 	if(a1.getAttackPower(x,y,z)>=pic.getRegionPowerFromPicture(i)){//determine whether the land is conquered or not
							 		System.out.println("Conquest!");
							 		m = pic.getCaptured1();
							 		pic.changeFlag2(i);
							 		pic.setCaptured1(i);
							 		pic.changeRegionPower(i,a1.getAttackPower(x,y,z)-pic.getRegionPowerFromPicture(i));
							 	}	
							 	else{
							 		System.out.println("Lost!");
							 		pic.changeRegionPower(i,pic.getRegionPowerFromPicture(i)-a1.getAttackPower(x,y,z));
							 	}
							}//ifelse
					 	}
					}
					event=null;
					j++;
				}
				
				if(j == number[combo1.getSelectedIndex()]){
					combo1.setSelectedIndex(0);
					ok2.setEnabled(false);
					turnB=2;
					timeControl=true;
					j = 0;
				}
				
				GUITheConquest.this.updateView3(m,n,x,y,z);
				event.setSource(ok2);
			}
			
			while(w < number[combo2.getSelectedIndex()]){
				combo2.setEnabled(false);
	        	int x,y,z,o=0;
	        	x = Integer.parseInt(text10.getText());
	        	y = Integer.parseInt(text11.getText());
	        	z = Integer.parseInt(text12.getText());
				if (event.getSource()==ok4) {
	        		for(int i = 0 ; i<42 ; i++){
	        			if(regions[i].contains(pic.getXFromPicture(),pic.getYFromPicture())){
	        				//check mountain
	        				if(i==8|| i==9 || i==15){
								if(a1.getAttackPower(0,0,z)>=pic.getRegionPowerFromPicture(i)){
									m = pic.getCaptured2();
						 			pic.changeFlag1(i);
						 			pic.setCaptured2(i);
						 			pic.changeRegionPower(i,a1.getAttackPower(0,0,z)-pic.getRegionPowerFromPicture(i));
								}

								else{
									JOptionPane.showMessageDialog(this, "Sorry, you cannot decide appropriate strategy formulation.");
								}
	        				}
							//check seaside
							else if(i==10||i==11||i==16||i==17||i==25||i==28||i==34||i==36||i==38){
								if(a1.getAttackPower(0,y,0)>=pic.getRegionPowerFromPicture(i)){
									m = pic.getCaptured2();
						 			pic.changeFlag1(i);
						 			pic.setCaptured2(i);
						 			pic.changeRegionPower(i,a1.getAttackPower(0,y,0)-pic.getRegionPowerFromPicture(i));
								}
								else{
									JOptionPane.showMessageDialog(this, "Sorry, you cannot decide appropriate strategy formulation.");
								}
							}
							else{
						 		if(a2.getAttackPower(x,y,z)>=pic.getRegionPowerFromPicture(i)){
						 			System.out.println("Conquest!");
						 			k = pic.getCaptured2();
						 			pic.changeFlag1(i);
						 			pic.setCaptured2(i);
						 			pic.changeRegionPower(i,a2.getAttackPower(x,y,z)-pic.getRegionPowerFromPicture(i));	
						 		}	
						 		else{
						 			System.out.println("Lost!");
						 			pic.changeRegionPower(i,pic.getRegionPowerFromPicture(i)-a2.getAttackPower(x,y,z));
						 		}
						 	}
				 		}
	        		}
				 	event=null;
			 		w++;
				}
	        	if(w == number[combo2.getSelectedIndex()]){
	        		combo2.setSelectedIndex(0);
	        		ok4.setEnabled(false);
	        		turnB=1;
	        		timeControl=false;
	        		w = 0;
	        	}
			 	GUITheConquest.this.updateView4(k,r,x,y,z);
	        	event.setSource(ok4);
			}
			//these buttons are to attack the wonder of the world
			if (event.getSource()==ap1) { 
		 		pwr1 = pic.getAllPowers1();
				
				 		if(regions[7].contains(pic.getXFromPicture(),pic.getYFromPicture())){
						for(int i = 0 ; i < 42 ; i++)
						 	if(pic.isCaptured1(i))
						 		pic.changeRegionPower(i,0);
				 			if(pwr1>=pic.getRegionPowerFromPicture(7)){
				 				System.out.println("Conquest!");
				 				k = pic.getCaptured2();
				 				pic.setCaptured1(7);
				 			}	
				 			else{
				 				System.out.println("Lost!");
				 			}
				 		}
			 		
		 		updateView5(pwr1);
		 		ap1.setEnabled(false);
			}
			if (event.getSource()==ap2) { 
		 		pwr2 = pic.getAllPowers2();
				
				 		if(regions[7].contains(pic.getXFromPicture(),pic.getYFromPicture())){
						for(int i = 0 ; i < 42 ; i++)
						 	if(pic.isCaptured2(i))
						 		pic.changeRegionPower(i,0);
				 			if(pwr2>=pic.getRegionPowerFromPicture(7)){
				 				System.out.println("Conquest!");
				 				k = pic.getCaptured2();
				 				pic.setCaptured2(7);
				 			
				 				
				 			}	
				 			else{
				 				System.out.println("Lost!");
				 			}
				 		}
			 		
		 		updateView6(pwr2);
		 		ap2.setEnabled(false);
			} 
			//when players click this button they see hot to play the game
			if(event.getSource()==how)  {
				JFrame frame = new JFrame();
				icon = new ImageIcon("how.png");
				JLabel p = new JLabel(icon);
				frame.add(p);
				frame.setPreferredSize(new Dimension(1365,800)); 
			    frame.pack(); 
			    frame.setVisible(true);
			}
    	}
	       
	    //new view methods after button actions
	    public void updateView1(int b1,int b2,int b3) {//updating soldier numbers and the player's gold
	   		this.b1=b1; this.b2=b2; this.b3=b3;
	   			remove(p1);
	   			a = p1.getGold()-a1.buySoldier(b1,b2,b3);
		    	c = a1.getMyrmidon();
		    	d = a1.getNaga();
		    	e = a1.getPegasusRider();
		    	a1 = new army(c,d,e,pwr1);
				p1 = new player(name1 ,a,a1,l1);	
		    if(turnA==2&&turnB==2){	ok3.setEnabled(true);ok4.setEnabled(true);combo2.setEnabled(true);ap2.setEnabled(true);ap1.setEnabled(false);sayac = 120;}
		    p1.add(ap1); p1.add(a1); p1.add(l1);	panel1.add(buy1);
	    	for(int i = 0 ; i < 3 ; i++){texts[i].setText("0");	panel1.add(labels[i]);	panel1.add(texts[i]);	}
	    	p1.add(panel1);	panel1.add(ok1);
	    		
	    	panel2.add(attack1) ;panel2.add(combo1);
	    	for(int i = 3 ; i < 6 ; i++){texts[i].setText("0");	panel2.add(labels[i]);	panel2.add(texts[i]);	}
	    	p1.add(panel2);	panel2.add(ok2);
	   			add (p1, BorderLayout.WEST);
	   			repaint();
	   			revalidate();
		}
		public void updateView2(int b4,int b5,int b6) {//updateing soldier numbers and the player's gold
			this.b4=b4; this.b5=b5; this.b6=b6;
	    		remove(p2);
	    		b = p2.getGold()-a2.buySoldier(b4,b5,b6);
		    	f = a2.getMyrmidon();
		    	g = a2.getNaga();
		    	h = a2.getPegasusRider();
		    	a2 = new army(f,g,h,pwr2);
		    	p2 = new player(name2,b,a2,l2);
		    if(turnA==1&&turnB==1){	ok1.setEnabled(true);ok2.setEnabled(true);combo1.setEnabled(true);ap1.setEnabled(true);ap2.setEnabled(false);sayac = 120;}
		   	p2.add(ap2); p2.add(a2);p2.add(l2);	panel3.add(buy2);
		   	for(int i = 6 ; i < 9 ; i++){texts[i].setText("0");	panel3.add(labels[i]);	panel3.add(texts[i]);	}
		   	p2.add(panel3);	panel3.add(ok3);
		    panel4.add(attack2) ;panel4.add(combo2);
		   	for(int i = 9 ; i < 12 ; i++){texts[i].setText("0");	panel4.add( labels[i]);	panel4.add(texts[i]);	}
		   	p2.add(panel4);	panel4.add(ok4);
		    	add (p2, BorderLayout.EAST);
		    	repaint();
	   			revalidate();
		}
		public void updateView3(int m,int n,int x,int y, int z) {//updating the gold, soldier numbers and the land numbers.
			this.m=m; this.n=n;
	    			remove(p1);
	    			a += m*30+n*80;
			    	c = a1.getMyrmidon()-x;
			    	d = a1.getNaga()-y;
			    	e = a1.getPegasusRider()-z;
			    	a1 = new army(c,d,e,pwr1);
			    	m = pic.getCaptured1();
			    	l1 = new land(m,n);
			    	p1 = new player(name1 ,a,a1,l1);
					
			    if(turnA==2&&turnB==2){	ok3.setEnabled(true);ok4.setEnabled(true);combo2.setEnabled(true);ap2.setEnabled(true);ap1.setEnabled(false); sayac = 120;}	
			    p1.add(ap1); p1.add(a1); p1.add(l1);	panel1.add(buy1);
		    	for(int i = 0 ; i < 3 ; i++){texts[i].setText("0");	panel1.add(labels[i]);	panel1.add(texts[i]);	}
		    	p1.add(panel1);	panel1.add(ok1);
		    	panel2.add(attack1) ;panel2.add(combo1);
		    	for(int i = 3 ; i < 6 ; i++){texts[i].setText("0");	panel2.add(labels[i]);	panel2.add(texts[i]);	}
		    	p1.add(panel2);	panel2.add(ok2);
	    			add (p1, BorderLayout.WEST);
	    			repaint();
	   				revalidate();
		}			
		public void updateView4(int k, int r,int x, int y, int z) {
			this.k=k; this.r=r;
	    			remove(p2);
	    			b += k*10+r*25;
			    	f = a2.getMyrmidon()-x;
			    	g = a2.getNaga()-y;
			    	h = a2.getPegasusRider()-z;
			    	a2 = new army(f,g,h,pwr2);
			    	k = pic.getCaptured2();
			    	l2 = new land(k,r);
			    	p2 = new player(name2 ,b,a2,l2);
			    if(turnA==1&&turnB==1){	ok1.setEnabled(true);ok2.setEnabled(true);combo1.setEnabled(true);ap1.setEnabled(true);ap2.setEnabled(false); sayac = 120;}
		    	p2.add(ap2); p2.add(a2);p2.add(l2);	panel3.add(buy2);
		    	for(int i = 6 ; i < 9 ; i++){texts[i].setText("0");	panel3.add(labels[i]);	panel3.add(texts[i]);	}
		    	p2.add(panel3);	panel3.add(ok3);
		    	panel4.add(attack2) ;panel4.add(combo2);
		    	for(int i = 9 ; i < 12 ; i++){texts[i].setText("0");	panel4.add(labels[i]);	panel4.add(texts[i]);	}
		    	p2.add(panel4);	panel4.add(ok4);
			    	add (p2, BorderLayout.EAST);
			    	repaint();
	   				revalidate();
	    	
		}
		public void updateView5(int pwr1){
			this.pwr1 = pwr1;
			remove(p1);
			    	a1 = new army(c,d,e,pwr1);
			    	l1 = new land(m,n);
			    	p1 = new player(name1 ,a,a1,l1);
					
			    if((turnA==2&&turnB==2)||timeControl){	ok3.setEnabled(true);ok4.setEnabled(true);combo2.setEnabled(true);ap2.setEnabled(true);
			    	ok1.setEnabled(false);ok2.setEnabled(false);combo1.setEnabled(false);ap1.setEnabled(false);sayac = 120;}	
			    p1.add(ap1); p1.add(a1); p1.add(l1);	panel1.add(buy1);
		    	for(int i = 0 ; i < 3 ; i++){texts[i].setText("0");	panel1.add(labels[i]);	panel1.add(texts[i]);	}
		    	p1.add(panel1);	panel1.add(ok1);
		    	panel2.add(attack1) ;panel2.add(combo1);
		    	for(int i = 3 ; i < 6 ; i++){texts[i].setText("0");	panel2.add(labels[i]);	panel2.add(texts[i]);	}
		    	p1.add(panel2);	panel2.add(ok2);	
	    			add (p1, BorderLayout.WEST);
	    			repaint();
	   				revalidate();
			
		}
		public void updateView6(int pwr2) {
			this.pwr2=pwr2;
	    			remove(p2);
			    	a2 = new army(f,g,h,pwr2);
			    	l2 = new land(k,r);
			    	p2 = new player(name2 ,b,a2,l2);
			    if((turnA==1&&turnB==1)||!timeControl){	ok1.setEnabled(true);ok2.setEnabled(true);combo1.setEnabled(true);ap1.setEnabled(true);
			    	ok3.setEnabled(false);ok4.setEnabled(false);combo2.setEnabled(false);ap2.setEnabled(false);sayac = 120;}
		    	p2.add(ap2); p2.add(a2);p2.add(l2);	panel3.add(buy2);
		    	for(int i = 6 ; i < 9 ; i++){texts[i].setText("0");	panel3.add(labels[i]);	panel3.add(texts[i]);	}
		    	p2.add(panel3);	panel3.add(ok3);
		    	panel4.add(attack2) ;panel4.add(combo2);
		    	for(int i = 9 ; i < 12 ; i++){texts[i].setText("0");	panel4.add(labels[i]);	panel4.add(texts[i]);	}
		    	p2.add(panel4);	panel4.add(ok4);
			    	add (p2, BorderLayout.EAST);
			    	repaint();
	   				revalidate();
	    	
		}
		public void updateView7() {
					updateView5(pwr1);
					updateView6(pwr2);
		}
                private class soundListener implements ActionListener {
      	
                    public void actionPerformed (ActionEvent event)
                    {
                    	
	                    if(look==2){
	                        mediaPlayer.setMute(true);
	                        sound.setText("Sound: Off");
	                        mediaPlayer.pause();
	                        look=1;
	                    }
	                    else{
	                        mediaPlayer.setMute(false);
	                        sound.setText("Sound: On");
	                        mediaPlayer.play();
	                        look=2;
	                    }
                    }
                    
                }
		

			
	    public static void main(String[] args) {
	        //main method to play
	       new GUITheConquest();
	       
	        
	    }
            
}
