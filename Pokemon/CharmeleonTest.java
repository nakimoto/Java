import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CharmeleonTest {


   static final int BASE_ATTACK = 160;
   static final int BASE_DEFENSE = 140;
   static final int BASE_STAMINA = 116;
   
   static final String[] CHARM_FAST_ATTACKS = {"Ember", "Fire Fang"};
   static final String[] CHARM_SPECIAL_ATTACKS = {"Fire Blast", "Fire Punch", "Flame Burst","Flame Charge", 
   "Flame Wheel", "Flame Thrower", "Heat Wave"};

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
      Pokemon p = new Charmeleon();
      Assert.assertEquals("Name and nickName should be the same but aren't.", p.getName(), "Charmeleon");
   
   }
   
   /* Is fast attack in allowed attack list? */
   @Test public void fastAttackAssignmentTest(){
      Pokemon p = new Charmeleon();
      String atk = p.getFastAttack();
      boolean isInList = false;
      int i = 0;
      while((!isInList) && (i < CHARM_FAST_ATTACKS.length)){
            isInList = atk.equals(CHARM_FAST_ATTACKS[i]);
            i++;
      }
      Assert.assertTrue("Charmeleon fast attack " + atk + " isn't fire type", isInList);
   }
   
   /* Is special attack in allowed attack list? */
   @Test public void specialAttackAssignmentTest(){
      Pokemon p = new Charmeleon();
      String atk = p.getSpecialAttack();
      boolean isInList = false;
      int i = 0;
      while((!isInList) && (i < CHARM_SPECIAL_ATTACKS.length)){
            isInList = atk.equals(CHARM_SPECIAL_ATTACKS[i]);
            i++;
      }
      Assert.assertTrue("Charmeleon special attack " + atk + " isn't fire type", isInList);
   }
   
   /* testing toString method
   * checks that toString is properly formatted.
   */
   @Test
   public void toStringTest(){
      Pokemon p = new Charmeleon();
      int hP = p.getHP();
      int cP = p.getCP();
      Assert.assertEquals("toString format isn't correct",  
         "Species: Charmeleon\nNumber: 005\nHeight: 1.1\nWeight: 19.0\nType: Fire\nHP: "+hP+"\nCP: "+cP, p.toString());
   }
   
   @Test public void toStringTest2(){
      Pokemon p = new Charmeleon("Bob");
      int hP = p.getHP();
      int cP = p.getCP();
      Assert.assertEquals("toString format isn't correct",  
         "Species: Charmeleon\nName: Bob\nNumber: 005\nHeight: 1.1\nWeight: 19.0\nType: Fire\nHP: "+hP+"\nCP: "+cP, p.toString());
   }
   
   /* Check that string output from fast attack on Charmeleon is correct
   * Attacking another Charmeleon/firetype
   */
   @Test public void performFastAttackTest1(){
      Pokemon p = new Charmeleon();
      Pokemon p2 = new Charmeleon();
      String pFA = p.getFastAttack();

      Assert.assertEquals("Fast Attack result String isn't correct",  
      "Charmeleon performed " + pFA + " on Charmeleon\n It was not very effective.",
       p.performFastAttack(p2));

   }
   /* Check that string output from fast attack on Squirtle is correct
   * Attacking a water type
   */
   @Test public void performFastAttackTest2(){
      Pokemon p = new Charmeleon();
      Pokemon p2 = new Squirtle();
      String pFA = p.getFastAttack();

      Assert.assertEquals("Fast Attack result String isn't correct",  
      "Charmeleon performed " + pFA + " on Squirtle\n It was not very effective.",
       p.performFastAttack(p2));

   }
   
   /* Check that string output from fast attack on Bulbasaur is correct
   * Attacking a grass type
   */
   @Test public void performFastAttackTest3(){
      Pokemon p = new Charmeleon();
      Pokemon p2 = new Bulbasaur();
      String pFA = p.getFastAttack();

      Assert.assertEquals("Fast Attack result String isn't correct",  
      "Charmeleon performed " + pFA + " on Bulbasaur\n It was super effective!",
       p.performFastAttack(p2));

   }

   /* Check that string output from special attack on Charmeleon is correct
   * Attacking another Charmeleon/firetype
   */
   @Test public void performSpecialAttackTest1(){
      Pokemon p = new Charmeleon();
      Pokemon p2 = new Charmeleon();
      String pFA = p.getSpecialAttack();

      Assert.assertEquals("Special Attack result String isn't correct",  
      "Charmeleon performed " + pFA + " on Charmeleon\n It was not very effective.",
       p.performSpecialAttack(p2));

   }
   /* Check that string output from special attack on Squirtle is correct
   * Attacking a water type
   */
   @Test public void performSpecialAttackTest2(){
      Pokemon p = new Charmeleon();
      Pokemon p2 = new Squirtle();
      String pFA = p.getSpecialAttack();

      Assert.assertEquals("Special Attack result String isn't correct",  
      "Charmeleon performed " + pFA + " on Squirtle\n It was not very effective.",
       p.performSpecialAttack(p2));

   }
   
   /* Check that string output from special attack on Bulbasaur is correct
   * Attacking a grass type
   */
   @Test public void performSpecialAttackTest3(){
      Pokemon p = new Charmeleon();
      Pokemon p2 = new Bulbasaur();
      String pFA = p.getSpecialAttack();

      Assert.assertEquals("Special Attack result String isn't correct",  
      "Charmeleon performed " + pFA + " on Bulbasaur\n It was super effective!",
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
      Pokemon p = new Charmeleon();
      Assert.assertTrue("HP >= " + minHP,(minHP <= p.getHP())); 
   }
   @Test public void hpRangeTest2(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Charmeleon();
      Assert.assertTrue("HP >= " + minHP,(minHP <= p.getHP()));  
   }
   @Test public void hpRangeTest3(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Charmeleon();
      Assert.assertTrue("HP >= " + minHP,(minHP <= p.getHP()));  
   }
   @Test public void hpRangeTest4(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Charmeleon();
      Assert.assertTrue("HP >= " + minHP,(minHP <= p.getHP())); 
  }
   @Test public void hpRangeTest5(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Charmeleon();
      Assert.assertTrue("HP >= " + minHP,(minHP <= p.getHP())); 
   }
   
   /*CP constructor test
   * Checks that CP in range*
   * Run it 5 times to check due to randomness
   */
   @Test public void cpRangeTest1(){
      int minCP = 10;
      Pokemon p = new Charmeleon();
      Assert.assertTrue("CP " + p.getCP()+" <= " + minCP,(minCP <= p.getCP())); 
   }
   @Test public void cpRangeTest2(){
      int minCP = 10;
      Pokemon p = new Charmeleon();
      Assert.assertTrue("CP " + p.getCP()+" <= " + minCP,(minCP <= p.getCP()));  }  
   @Test public void cpRangeTest3(){
      int minCP = 10;
      Pokemon p = new Charmeleon();
      Assert.assertTrue("CP " + p.getCP()+" <= " + minCP,(minCP <= p.getCP())); 
   }   
   @Test public void cpRangeTest4(){
      int minCP = 10;
      Pokemon p = new Charmeleon();
      Assert.assertTrue("CP " + p.getCP()+" <= " + minCP,(minCP <= p.getCP())); 
   }
   @Test public void cpRangeTest5(){
      int minCP = 10;
      Pokemon p = new Charmeleon();
      Assert.assertTrue("CP " + p.getCP()+" <= " + minCP,(minCP <= p.getCP())); 
   }

}
