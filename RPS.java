import java.awt.Color;
import java.awt.Container;
import java.awt.event.*; 
import javax.swing.*;
import java.awt.font.*;
import java.awt.Font;


/*
*@author Nanami Kimoto
*year 2019
***BUGS(1): While monkey testing I noticed sometimes the win is given to the wrong user. It happens randomly, sometimes not at all. 
*It might be an issue with the logic. It seems it's getting crosswired in some places. 
*/

public class RPS{

  
	static int youWin;//constants
   static int tie=0;
	static int win=0;
	static int total=0;
   
  
	public static void main(String[] args){
		rpsPanel();//panel for rps game
		instructPanel();//basic instructions
	}
   //pop-up screen
	private static void instructPanel(){
		String instruct="\t\t\tRock beats scissors, scissors beats paper\n\t\t\tand paper beats rock!\n\n\n\t\t\t\tChoose your option wisely!";
		JOptionPane.showMessageDialog(null,instruct, "How to play 'Rock, Paper, Scissors'",0);
        
      
	}

	private static void rpsPanel(){

		JFrame frame = new JFrame("Rock, Paper, Scissors");//frame

		Container panel = frame.getContentPane();//for the buttons
      panel.setBackground(Color.pink);
		panel.setLayout(null); 
      
      Font font1 = new Font("Allegro", Font.BOLD, 40);
      //all the button sizes and colors
      //I centered mine in the middle of the frame
      JButton b1 = new JButton("Rock");
      b1.setFont(font1);
		b1.setBackground(Color.yellow);
		b1.setBounds(300,100,200,200);


		JButton b2 = new JButton ("Paper");
      b2.setFont(font1);
		b2.setBackground(Color.yellow);
		b2.setBounds(300,300,200,200);

		JButton b3 = new JButton ("Scissors");
      b3.setFont(font1);
		b3.setBackground(Color.yellow);
		b3.setBounds(300,500,200,200);


		JButton b4 = new JButton("Quit");//quit option for user
      b4.setBackground(Color.orange);
      b4.setFont (b4.getFont ().deriveFont (15.0f));
		b4.setBounds(350, 750, 80, 30);
      //this adds all the buttons on to the panel
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);

		b1.addActionListener(//gui listener
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						computeWin(2);//rock
					}
				}
		);

		b2.addActionListener(

				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						computeWin(1);//paper
					}
				}
		);

		b3.addActionListener(

				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						computeWin(3);//scissors
					}
				}
		);

		b4.addActionListener(//when the user quits

				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						String text="Come back anytime to play again!";
						JOptionPane.showMessageDialog(null,text, "Thank you, kind player!",0);
						System.exit(0);
					}
				}
		);

		frame.setSize(900, 900);//frame size
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//game stops when closed
	}

	public static void computeWin(int x){//how the winner is chosen
		int computerChoice=computerRandomChoice();//get random for computer choice
		int humanChoice=x;
		String text,text1="";
      //take smallest and largest values
		String winCombo= ""+Math.min(computerChoice, humanChoice)+Math.max(computerChoice, humanChoice);

		switch(Integer.parseInt(winCombo)){//parse int
      //battle between human and computer
		case 12:
			text = "\nRock wins!";
			if(humanChoice==1) 
         youWin=1;
			break;
		case 13:
			text = "\nPaper wins!";
			if(humanChoice==2)
         youWin=1;
			break;
		case 23:
			text = "\nScissors wins!";
			if(humanChoice==3) 
         youWin=1;
			break;
         
		default: text="Uh oh! ";
		youWin=2;
      
		}

		if(youWin==1){
			text1="You win! ";
			win++;//increment win amount
			total++;//increment total games played
         
         
		}else if(youWin==2){
			text1="\t\tWe've got a tie! ";//you and the computer chose the same option
			youWin=0;	
         tie++;//store tie games
		}else{
			text1="\t\tThe Computer wins! ";//you lose and the computer wins this round
			total++;//store total

		}


		JFrame frame = new JFrame("Rock, Paper, Scissors"); 
		Container panel = frame.getContentPane(); 
      panel.setBackground(Color.orange);
		panel.setLayout(null); 
     

		JLabel l0 = new JLabel(text1+text);
		l0.setBounds(130, 10, 300, 35);
		panel.add(l0);
      //pop-up screen 
		JLabel l1 = new JLabel("Your choice: ");
		l1.setBounds(70, 35, 150, 35);
		panel.add(l1);
      
      JLabel l2 = new JLabel("Computer's choice: ");
		l2.setBounds(215, 35, 150, 35);
		panel.add(l2);
      
     
		//if else to show choice
      if(x==1){
       JLabel y = new JLabel("Rock!");
         y.setFont (y.getFont ().deriveFont (30.0f));
         y.setBounds(100, 100, 170, 60);
		   panel.add(y);
      
      }else if(x==2){
      JLabel w = new JLabel("Paper!");
        w.setFont (w.getFont ().deriveFont (30.0f));
        w.setBounds(100, 100, 170, 60);
        panel.add(w);
         
         }else{
          JLabel z = new JLabel("Scissors!");
            z.setFont (z.getFont ().deriveFont (30.0f));
            z.setBounds(100, 100, 170, 60);
            panel.add(z);
       }	
      
      //computer choice label
      if(computerChoice==1){
       JLabel k = new JLabel("Rock!");
         k.setFont (k.getFont ().deriveFont (30.0f));
         k.setBounds(250, 100, 170, 60);
		   panel.add(k);
         
      }else if(computerChoice==2){
      JLabel m = new JLabel("Paper!");
        m.setFont (m.getFont ().deriveFont (30.0f));
        m.setBounds(250, 100, 170, 60);
        panel.add(m);
         
         }else{
          JLabel n = new JLabel("Scissors!");
            n.setFont (n.getFont ().deriveFont (30.0f));
            n.setBounds(250, 100, 170, 60);
            panel.add(n);
       }


		JLabel l5 = new JLabel("Win ratio: " + win+"/"+total);
		l5.setBounds(175, 25, 150, 350);//text setup
		panel.add(l5);

		JLabel l6 = new JLabel("Tie games: "+tie);
		l6.setBounds(175, 50, 145, 390);//text setup
		panel.add(l6);

		frame.setSize(500, 370); 
		frame.setVisible(true); 		

	}

	public static int computerRandomChoice(){//computers random choice for game
		int result=(int)(Math.random()*3)+1;		
		return result;
   }

}
