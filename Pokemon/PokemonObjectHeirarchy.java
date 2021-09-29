/**
* Pokemon abstract class.
* Built from pokemon assignment.
* @author Nanami Kimoto
* @since 2/7/2018
*/

public class PokemonObjectHeirarchy { //abstract class

   //========= instance variables =========
   //each one has a Javadoc comment
   
   /** The pokemon's species. */
   private String species = "";
   /** The pokemon's name. */
   private String name = "";
   /** The Pokemon's pokedex number. */
   private int number = 0;
   /** The Pokemon's hp. */
   private int hp = 0;
   
   //========== Constructor =========== //go up
   /**
   * Constructs a Pokemon object.
   * @param newSpecies the Pokemon's species
   * @param newName the Pokemon's name
   * @param newNumber the Pokemon's pokedex number
   * @param newHP the Pokemon's hp
   */
   public Pokemon(String newSpecies, String newName, int newNumber, int newHP) {
      this.species = newSpecies;
      this.name = newName;
      this.number = newNumber;
      this.hp = newHP;
   } //close constructor
   
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
      s = s + "\nHP: " + this.hp;
      
      return s;
   }
   
    //=========== get methods =================//develop superclass and subclass
    //different type of pokemon
    //eventually pokemon who are part of several classes
    //all interfaces need to be implemented
   
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
   public int getHP() {
      return this.hp;
   } 
    //========== set methods ==============
   /**
   * Sets the Pokemon's name.
   * @param newName the new name
   */
   public void setName(String newName) {
      this.name = newName;
   }
   
   /**
   * Sets the Pokemon's HP.
   * @param newHP the new HP number
   */
   public void setHP(int newHP) {
      this.hp = newHP;
   }
   
   /**
   * Sets the Pokemon's HP.
   * @param newHP the new HP number
   */
}