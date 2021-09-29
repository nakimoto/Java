/**
* Vaporeon extends Eevee. 
* @author Nanami Kimoto
* @since 2/10/2019
*/
public class Vaporeon extends Eevee Implements WaterType {
 //used hidden class to calculate the powers
   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 205;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 177;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 260;
   
   /** Constructor with no name. */
   public Vaporeon() {
      super("Vaporeon", "Vaporeon", 134, 1.0, 29.0, "", BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Vaporeon(String name) {
         super("Vaporeon", name, 134, 1.0, 29.0,"", BASE_ATTACK_POWER, 
             BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /** 
   * Constructor with species and name for subclasses.
   *@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon. 
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices. 
   */
   protected Vaporeon(String species, String name, int num, double ht, 
       double wt, int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr) {
      
      super(species, name, num, ht, wt, baseAttackPwr, 
          baseDefensePwr, baseStaminaPwr);
   }
   

}