import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class WartortleTest {

   static final int BASE_ATTACK = 144;
   static final int BASE_DEFENSE = 176;
   static final int BASE_STAMINA = 118;
   
   static final String[] WARTORTLE_FAST_ATTACKS = {"Bubble", "Splash", "Water Gun"};
   static final String[] WARTORTLE_SPECIAL_ATTACKS = {"Aqua Jet", "Aqua Tail", "Brine","Bubble Beam", "Hydro Pump", 
   "Scald", "Water Pulse"};

   public static final double[] cpMultiplier = {0.094,  0.16639787,  0.21573247,  0.25572005,  0.29024988,
        0.3210876 ,  0.34921268,  0.37523559,  0.39956728,  0.42250001,
        0.44310755,  0.46279839,  0.48168495,  0.49985844,  0.51739395,
        0.53435433,  0.55079269,  0.56675452,  0.58227891,  0.59740001,
        0.61215729,  0.62656713,  0.64065295,  0.65443563,  0.667934  ,
        0.68116492,  0.69414365,  0.70688421,  0.71939909,  0.7317    ,
        0.73776948,  0.74378943,  0.74976104,  0.75568551,  0.76156384,
        0.76739717,  0.7731865 ,  0.77893275,  0.78463697,  0.79030001};

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /* Constructor no nickName test - nickName same as name if not specified **/
   @Test public void noNickNameTest(){
      Pokemon p = new Wartortle();
      Assert.assertEquals("Name and nickName should be the same but aren't.", p.getName(), "Wartortle");
   
   }
   
   /* Is fast attack in allowed attack list? */
   @Test public void fastAttackAssignmentTest(){
      Pokemon p = new Wartortle();
      String atk = p.getFastAttack();
      boolean isInList = false;
      int i = 0;
      while((!isInList) && (i < WARTORTLE_FAST_ATTACKS.length)){
            isInList = atk.equals(WARTORTLE_FAST_ATTACKS[i]);
            i++;
      }
      Assert.assertTrue("Wartortle fast attack " + atk + " isn't water type", isInList);
   }
   
   /* Is special attack in allowed attack list? */
   @Test public void specialAttackAssignmentTest(){
      Pokemon p = new Wartortle();
      String atk = p.getSpecialAttack();
      boolean isInList = false;
      int i = 0;
      while((!isInList) && (i < WARTORTLE_SPECIAL_ATTACKS.length)){
            isInList = atk.equals(WARTORTLE_SPECIAL_ATTACKS[i]);
            i++;
      }
      Assert.assertTrue("Wartortle special attack " + atk + " isn't water type", isInList);
   }
   
   /* testing toString method
   * checks that toString is properly formatted.
   */
   @Test
   public void toStringTest(){
      Pokemon p = new Wartortle();
      int hP = p.getHP();
      int cP = p.getCP();
      Assert.assertEquals("toString format isn't correct",  
         "Species: Wartortle\nNumber: 008\nHeight: 1.0\nWeight: 22.5\nType: Water\nHP: "+hP+"\nCP: "+cP, p.toString());
   }
   
   @Test public void toStringTest2(){
      Pokemon p = new Wartortle("Wally");
      int hP = p.getHP();
      int cP = p.getCP();
      Assert.assertEquals("toString format isn't correct",  
         "Species: Wartortle\nName: Wally\nNumber: 008\nHeight: 1.0\nWeight: 22.5\nType: Water\nHP: "+hP+"\nCP: "+cP, p.toString());

   }
   
   /* Check that string output from fast attack on Wartortle is correct
   * Attacking another Wartortle/firetype
   */
   @Test public void performFastAttackTest1(){
      Pokemon p = new Wartortle();
      Pokemon p2 = new Wartortle();
      String pFA = p.getFastAttack();

      Assert.assertEquals("Fast Attack result String isn't correct",  
      "Wartortle performed " + pFA + " on Wartortle\n It was not very effective.",
       p.performFastAttack(p2));

   }
   /* Check that string output from fast attack on Wartortle is correct
   * Attacking a water type
   */
   @Test public void performFastAttackTest2(){
      Pokemon p = new Wartortle();
      Pokemon p2 = new Charmander();
      String pFA = p.getFastAttack();

      Assert.assertEquals("Fast Attack result String isn't correct",  
      "Wartortle performed " + pFA + " on Charmander\n It was super effective!",
       p.performFastAttack(p2));

   }
   
   /* Check that string output from fast attack on Bulbasaur is correct
   * Attacking a grass type
   */
   @Test public void performFastAttackTest3(){
      Pokemon p = new Wartortle();
      Pokemon p2 = new Bulbasaur();
      String pFA = p.getFastAttack();

      Assert.assertEquals("Fast Attack result String isn't correct",  
      "Wartortle performed " + pFA + " on Bulbasaur\n It was not very effective.",
       p.performFastAttack(p2));

   }

   /* Check that string output from special attack on Wartortle is correct
   * Attacking another Wartortle/firetype
   */
   @Test public void performSpecialAttackTest1(){
      Pokemon p = new Wartortle();
      Pokemon p2 = new Wartortle();
      String pFA = p.getSpecialAttack();

      Assert.assertEquals("Special Attack result String isn't correct",  
      "Wartortle performed " + pFA + " on Wartortle\n It was not very effective.",
       p.performSpecialAttack(p2));

   }
   /* Check that string output from special attack on Wartortle is correct
   * Attacking a water type
   */
   @Test public void performSpecialAttackTest2(){
      Pokemon p = new Wartortle();
      Pokemon p2 = new Charmander();
      String pFA = p.getSpecialAttack();

      Assert.assertEquals("Special Attack result String isn't correct",  
      "Wartortle performed " + pFA + " on Charmander\n It was super effective!",
       p.performSpecialAttack(p2));

   }
   
   /* Check that string output from special attack on Bulbasaur is correct
   * Attacking a grass type
   */
   @Test public void performSpecialAttackTest3(){
      Pokemon p = new Wartortle();
      Pokemon p2 = new Bulbasaur();
      String pFA = p.getSpecialAttack();

      Assert.assertEquals("Special Attack result String isn't correct",  
      "Wartortle performed " + pFA + " on Bulbasaur\n It was not very effective.",
       p.performSpecialAttack(p2));

   }
   
   /*HP constructor test
   * Checks that HP in range
   * HP is base stamina (90) + a random
   * Run it 5 times to check due to randomness
   */
   @Test public void hpRangeTest1(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Wartortle();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP())); 
   }
   @Test public void hpRangeTest2(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Wartortle();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP()));  
   }
   @Test public void hpRangeTest3(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Wartortle();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP()));  
   }
   @Test public void hpRangeTest4(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Wartortle();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP())); 
  }
   @Test public void hpRangeTest5(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Wartortle();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP())); 
   }
   
   /*CP constructor test
   * Checks that CP in range*
   * Run it 5 times to check due to randomness
   */
   @Test public void cpRangeTest1(){
      int minCP = 10;
      Pokemon p = new Wartortle();
      Assert.assertTrue("CP " + p.getCP()+" not >= " + minCP,(minCP <= p.getCP())); 
   }
   @Test public void cpRangeTest2(){
      int minCP = 10;
      Pokemon p = new Wartortle();
      Assert.assertTrue("CP " + p.getCP()+" not >= " + minCP,(minCP <= p.getCP()));  }  
   @Test public void cpRangeTest3(){
      int minCP = 10;
      Pokemon p = new Wartortle();
      Assert.assertTrue("CP " + p.getCP()+" not >= " + minCP,(minCP <= p.getCP())); 
   }   
   @Test public void cpRangeTest4(){
      int minCP = 10;
      Pokemon p = new Wartortle();
      Assert.assertTrue("CP " + p.getCP()+" not >= " + minCP,(minCP <= p.getCP())); 
   }
   @Test public void cpRangeTest5(){
      int minCP = 10;
      Pokemon p = new Wartortle();
      Assert.assertTrue("CP " + p.getCP()+" not >= " + minCP,(minCP <= p.getCP())); 
   }
}
