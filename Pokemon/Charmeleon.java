/**
* Charmeleon object class extends Charmander. 
* @author Nanami Kimoto
* @since 2/10/2019
*/
public class Charmeleon extends Charmander {
 //used hidden class to calculate the powers
   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 158;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 129;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 116;
   
   /** Constructor with no name. */
   public Charmeleon() {
      super("Charmeleon", "Charmeleon", 5, 1.1, 19.0, "", BASE_ATTACK_POWER,
       BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Charmeleon(String name) {
         super("Charmeleon", name, 5, 1.1, 19.0, "", BASE_ATTACK_POWER, 
             BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   /** 
   * Constructor with species and name for subclasses.
   *@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon.
   *@param Type2 The type 2 of pokemon. 
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices. 
   */
   protected Charmeleon(String species, String name, int num, double ht, 
       double wt, String Type2, int baseAttackPwr,
       int baseDefensePwr, int baseStaminaPwr) {
      
      super(species, name, num, ht, wt, Type2, baseAttackPwr, 
          baseDefensePwr, baseStaminaPwr);
   }
   

}