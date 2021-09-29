import java.util.Random;
/**
* Pokemon object class (new ics 211).
* @author Nanami Kimoto
* @since 1/18/2019
*/

public class PokemonObjectClassNKimoto {

   //========= instance variables =========
   //each one has a Javadoc comment
   
   /** The pokemon's species. */
   private String species = "";
   /** The pokemon's name. */
   private String name = "";
   /** The Pokemon's pokedex number. */
   private int number = 0;
   /** The Pokemon's hitpoints. */
   private int hitpnts = 0;
   /** string type 1. */
   private String type1 = "";
   /** string type2. */
   private String type2 = "";
   /** compwr. */
   private int compwr = 0;
   
   //========== Constructor 1===========
   /**
  * Constructs a Pokemon object.
   * @param Species the Pokemon's species
   * @param Name the Pokemon's name
   * @param Number the Pokemon's pokedex number
   * @param HitPnts the Pokemon's hp //automatic
   * @param Type1
   * @param Type2
   * @param Compwr //automatic
   */ 
   public PokemonObjectClassNKimoto(String Species, String Name, int Number,
      int HitPnts, String Type1, String Type2) {
      this.species = (Species);
      this.name = (Name);
      this.number = (Number);
      this.hitpnts = (HitPnts);
      this.type1 = (Type1);
      this.type2 = (Type2);
   } //close constructor 1
   
   //============Constructor 2===========
   /**
   * @param Species the Pokemon's species
   * @param Number the Pokemon's pokedex number
   * @param Type1
   * @param Type2
   */
   public PokemonObjectClassNKimoto(String Species, int Number, String Type1, String Type2) {
      this.species = (Species);
      this.type1 = (Type1);
      this.number = (Number);
      this.type2 = (Type2);
      
   } //close constructor 2
   /**
   * variable declaration.
   * no parameters. 
   */
   //initialize for hitpoints and compower.   
      private void Hitpointscompwr(){
      Random ran = new Random();
      double min1 = 1.00;
      double max1 = 3.00;
      int max2 = 150;
      int min2 = 10;
      double multiplier;
   //multiplier hint from assignment put into use.
      multiplier = min1 + (max1 - min1) * ran.nextDouble();
      this.hitpnts = ran.nextInt(max2 - min2 + 1) + 10;   
      this.compwr = (int) (this.hitpnts * multiplier);
   }
    //============= toString ==================
   
   /**
   * toString method.
   * @return a String representation of the pokemon object
   */
   
   public String toString() {
      String s = "";
      s = "Species: " + this.species;
      s = s + "\nName: " + this.name;
      s = s + "\nNumber: " + this.number;
      s = s + "\nHitPnts: " + this.hitpnts;
      s = s + "\nTyp1: " + this.type1;
      s = s + "\nType2: " + this.type2;
      s = s + "\nComPwr: " + this.compwr;
      
      return s;
   }
   
    //=========== get methods =================
   
   /**
   * gets the Pokemon's species.
   *@return the Pokemon's species
   */
   public String getSpecies() {
   
      return this.species;
   }
   
   /**
   * gets the Pokemon's name.
   *@return the NAME
   */
   public String getName() {
      return this.name;
   }
   /**
   * gets the Pokemon type 1.
   *@return Type 1.
   */
   public String getType1() {
      return this.type1;
   }
   
   /**
   * gets the Pokemon type 2.
   *@return Type 2.
   */
   
   public String getType2() {
      return this.type2;
   }
   
   /**
   * gets the Pokemon's pokedex number.
   *@return the Pokedex number
   */
   public int getNumber() {
      return this.number;
   }
   
   /**
   * gets the Pokemon's hp number.
   *@return the hp
   */
   public int getHitPnts() {
      return this.hitpnts;
   } 
   /**
   * gets the Pokemon compwr.
   *@return the compwr.
   */
   
   public int getComPwr() {
      return this.compwr;
   }
    //========== set method ==============
   /**
   * Sets the Pokemon's name.
   * @param newName the new name
   */ //keep public
   public void setName(String newName) {
      this.name = newName;
   }
   //=========== power up method============
    /**
   * no parameters.
   */
   //no parameters required.
   //import same from initialized variables.
   //implement new hint formula from assignment. 
   public void powerUp() {
      Random ran = new Random();
      int hitnts;
      int compwr; 
      double multiplier;
      double min1 = 1.00;
      double max1 = 3.00;
      multiplier = min1 + (max1 - min1) * ran.nextDouble();
      this.hitpnts = (int) (this.hitpnts + 1.15 + (0.2 * this.hitpnts));
   //if statement for restrictions.
      if (this.hitpnts * multiplier > this.compwr) {
         this.compwr = (int) (this.hitpnts * multiplier);
   
      } //close power up
   }
}