import javax.swing.JFrame;

/**
* Pokemon GUI.
* @author Nanami Kimoto
* @since 4/28/19
*/


public class PokemonGUI {
   /** main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
      //setup basic JFrame
        
      JFrame frm = new JFrame("Pokemon-Panel");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add StudentPanel object to Frame
      frm.getContentPane().add(new PokemonPanel());
      //Display to screen
      frm.pack();
      frm.setVisible(true);
      
   }
}