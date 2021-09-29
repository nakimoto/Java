import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //add this for the listener
import java.util.*;

/**
* Pokemon GUI.
* @author Nanami Kimoto
* @since 4/28/19
*/

public class PokemonPanel extends JPanel {

  /********* label. ************/
   private JLabel lTitle = new JLabel("Pokemon GUI");
   /********* label. ************/
   private JLabel  HuntPokemon = new JLabel();
  /******* button. ****************/
   private JButton bDone = new JButton(" Add ");
   /******* button. ****************/
   private JButton bClear = new JButton(" Clear ");
  
  /********* sub-panel. *********/
   private JPanel topSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel centerSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel bottomSubPanel = new JPanel();
  /** we can declare and initialize ActionListener obj. */
   //private GUIListener listener = new GUIListener();
  
  /******** text field for user entry. *******/
   private JTextField tfName = new JTextField(25);
  /******** text field for user entry. *******/
   private JTextField tfID = new JTextField(10);
  
  
  /******** student. *********/
   private Pokemon p;
   /******* capacity of Student array. ****/
   private final int capacity = 10;
   /******** Array of Students. ***************/
   private Pokedex[ ] pkArr = new Pokedex[capacity];
   /******** counter for Students. ***************/
   private int count = 0;
   
  /******** String for holding Student for display. */ 
   private String sOut = new String("");
  /****** text are for displaying Student.toString()s. */
   private JTextArea pokedexText = new JTextArea(); //pokedex
    /****** text are for displaying Student.toString()s. */
   private JTextArea backpackText = new JTextArea(); //backpack
  /** Make TextArea scrollable. **********************/
   private JScrollPane scroll = new JScrollPane(pokedexText, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
  /********* Binary Tree. ************/
  private PokeTree tree = new PokeTree();
  
  /********* Arraylist. ************/
  private ArrayList<Pokemon> pokeArray = new ArrayList<>();
  
  /********* Priority queue. ************/
  private PriorityQueue<Pokemon> pokeQueue = new PriorityQueue<>();
  
  /********* Pokemon. ************/
  private Pokemon p1 = new Bulbasaur();
  
  /********* boolean. ************/
  private boolean firstClick = false;
  
  /********* boolean. ************/
  private boolean catchAttempt = false;
  
  /********* boolean. ************/
  private boolean catchSuccess = false;
  
    /********* drop down menu. ************/
  private Choice backpackChoice = new Choice();
  /********** Choice drop down menu. **/
   private Choice recent = new Choice();
    /********** Choice drop down menu. **/
   private Choice chMENU = new Choice();
  /**
  * Constructor holds everything.
  */
   public PokemonPanel() {
    
      setLayout(new BorderLayout()); //Border panel layout
      setPreferredSize(new Dimension(700, 800));
      topSubPanel.setBackground(Color.green); //north area color
      centerSubPanel.setBackground(Color.red); //center area color
      bottomSubPanel.setBackground(Color.white); //bottomSubPanel area color
     
     //adding title to the topSubPanel
      topSubPanel.add(lTitle);
      add("North", topSubPanel); //adding top sub-panel to North
   
     
     //labels initialized
      JLabel lCatch = new JLabel("Catch ");
      JLabel lHunt = new JLabel("Hunt ");
      JLabel lPokedex = new JLabel("Pokedex ");
      JLabel lBackpack = new JLabel("Backpack ");

     
     //add choices to the choice dropdown list
      chMENU.add("Number");
      chMENU.add("Recent");
      
     
     //add labels, textFields and choice
   //   centerSubPanel.add(Catch);
   //   centerSubPanel.add(Hunt);
   //   centerSubPanel.add(backpackchoice);
  //    centerSubPanel.add(recent);
  //    centerSubPanel.add(pokedex);
  //    centerSubPanel.add(number);

      
      
     // }
      pokedexText.setText(sOut);
      pokedexText.setEditable(false);
      centerSubPanel.add(scroll);  //add scrollPane, pokedexText inside.        
     
      //add the center sub-panel to Center of main panel
      add("Center", centerSubPanel);
     
     //adding message and buttons to the bottomSubPanel sub-panel
    //  bottomSubPanel.add(lMsg);
      bottomSubPanel.add(bDone);
     // bDone.addActionListener(listener); //add listener to button
      bottomSubPanel.add(bClear);
     // bClear.addActionListener(listener); //add listener to button 
     //add bottomSubPanel sub-panel to South area of main panel      
      add("South", bottomSubPanel);     
   } //close StudentPanel constructor
 
 /**
 * Private ActionListener class.
 */
 //bottom half
 //  private class GUIListener implements ActionListener {
   
   /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
 //      public void actionPerformed(ActionEvent event) {
//       
//       Random randNum = new Random();
//       
      //if "clear" button clicked, run cleaner method  
      //    if (event.getSource() == bHunt) {
//             int ranChoice = randNum.nextInt(9);
//             switch (ranChoice) {
//                default:
//                break;
//                
//             case "1":
//                p = new Bulbasaur();
//                     
//              HuntPokemon.setText(p.toString());
//              //HuntPokemon is JLabel for text
//              //what pokemon randomly appears
//               
//                break;
//                   
//             case "2":
//                p = new Ivysaur();
//                
//               HuntPokemon.setText(p.toString());
//                break;
//                   
//             case "3":
//                p = new Venusaur();
//                
//                HuntPokemon.setText(p.toString());
//                break;
//                   
//             case "4":
//                p = new Charmander();
//                
//                HuntPokemon.setText(p.toString());
//                break;
//                   
//             case "5":
//                p = new Charmeleon();
//                
//                HuntPokemon.setText(p.toString());
//                break;
//                   
//             case "6":
//                p = new Charizard();
//                
//                HuntPokemon.setText(p.toString());
//                break;
//                   
//             case "7":
//                p = new Squirtle();
//                
//               HuntPokemon.setText(p.toString());
//                break;
//                      
//             case "8":
//                p = new Wartortle();
//                HuntPokemon.setText(p.toString());
//                
//                break;
//                   
//             case "9":
//                p = new Blastoise();
//                
//                HuntPokemon.setText(p.toString());
//                break;
//           }//end of switch
//           
//         firstClick = true; //initial click
//         catchAttempt = false; //reset
//         catchSuccess = false; //successful pokemon catch
//         
//      } //close if statement for hunt
//          
            
               
            
        
      //if "done" button clicked
      //get the input from the text boxes
      //post error messages if input not valid
      //add student to array if valid
     //     if (event.getSource()  == bCatch) { 
//          
//            int chanceCaught = randCaught.nextInt(10);//randomied whether pokemon is caught
//            
//             if (!firstClick) {
//                HuntPokemon.setText("Pokemon unavailable!");
//                } else if (chanceCaught == 0 && !catchAttempt) {
//                  HuntPokemon.setText(p.getName() + " has escaped!");
//                  catchAttempt = true;
//                  catchSuccess = false;
//                  } else if(chanceCaught > 0 && !catchAttempt) {
//                   HuntPokemon.setText(p.getName() + " has been caught!");
//                   catchAttempt = true;
//                   catchSuccess = true;
//                   
//                   tree.add(p);
//                   ArrayList.add(p);
//                   
//                   } else if(catchAttempt && !catchSuccess) {
//                    HuntPokemon.setText("Pokemon already escaped!");
//                    
//                    } else {
//                      HuntPokemon.setText("Pokemon already caught!");
//                      
//                      
//                   }//close if statement
//                   
//                }//close catch button
//                
      //         if (event.getSource()  == bPokedex) { //pokedex button
//                 if (ArrayList.size() != 0) {
//                  pokedexTextArea.setText(tree.toString() + "\n ");
//                  }
//                  
//                 }
//                 if (event.getSource() == bBackpack) { //backpack button
//                 String data = "";
//                  if (backpackChoice.getSelectedIndex() == 0) {
//                   for (int i = 0; i < ArrayList.size(); i++) {
//                   data += "\n" + ArrayList.get(i).toString() + "\n"; //get pokemon in array size
//                   backpackText.setText(data);
//                   
//                   }//close for loop
//                   
//                 } else { 
//                   for (int i = 0; ArrayList.size(); i++) {
//                   pokeQueue.add(ArrayList.get(i)); //priority queue
//                   
//                   }
//                   
//                   while (pokeQueue.size() > 0) {
//                       
//                   data += "\n" + pokeQueue.poll().toString() + "\n"; //get pokemon in array size
//                   backpackText.setText(data);
// 
//                   } //while
//                   
//                 }//close else
//                 
//                 }  
//                  }
//                  
                  
    
   
 //  } // end GUIListener private class
 
 
} //end SchoolPanel class