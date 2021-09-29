import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BulbasaurTest {

   static final int BASE_ATTACK = 126;
   static final int BASE_DEFENSE = 126;
   static final int BASE_STAMINA = 90;
   
   static final String[] BULBA_FAST_ATTACKS = {"Razor Leaf", "Vine Whip","Acid", "Poison Jab", "Poison Sting"};
   static final String[] BULBA_SPECIAL_ATTACKS = {"Leaf Blade", "Petal Blizzard", "Power Whip","Seed Bomb", 
      "Solar Beam","Cross Poison", "Gunk Shot", "Poison Fang","Sludge", "Sludge Bomb",
    "Sludge Wave"};

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
      Pokemon p = new Bulbasaur();
      Assert.assertEquals("Name and nickName should be the same.", p.getName(), "Bulbasaur");
   
   }
   
   /* Is fast attack in allowed attack list? */
   @Test public void fastAttackAssignmentTest(){
      Pokemon p = new Bulbasaur();
      String atk = p.getFastAttack();
      boolean isInList = false;
      int i = 0;
      while((!isInList) && (i < BULBA_FAST_ATTACKS.length)){
            isInList = atk.equals(BULBA_FAST_ATTACKS[i]);
            i++;
      }
      Assert.assertTrue("Bulbasaur fast attack " + atk + " should be grass or poison, is not", isInList);
   }
   
   /* Is special attack in allowed attack list? */
   @Test public void specialAttackAssignmentTest(){
      Pokemon p = new Bulbasaur();
      String atk = p.getSpecialAttack();
      boolean isInList = false;
      int i = 0;
      while((!isInList) && (i < BULBA_SPECIAL_ATTACKS.length)){
            isInList = atk.equals(BULBA_SPECIAL_ATTACKS[i]);
            i++;
      }
      Assert.assertTrue("Bulbasaur special attack " + atk + " should be grass or poison, is not", isInList);
   }
   
   /* testing toString method
   * checks that toString is properly formatted.
   */
   @Test
   public void toStringTest(){
      Pokemon p = new Bulbasaur();
      int hP = p.getHP();
      int cP = p.getCP();
      Assert.assertEquals("toString format is incorrect.",  
         "Species: Bulbasaur\nNumber: 001\nHeight: 0.71\nWeight: 6.9\nType: Grass | Poison\nHP: "+hP+"\nCP: "+cP,
          p.toString());
   }
   
   @Test public void toStringTest2(){
      Pokemon p = new Bulbasaur("Bob");
      int hP = p.getHP();
      int cP = p.getCP();
      Assert.assertEquals("toString format is incorrect.",  
         "Species: Bulbasaur\nName: Bob\nNumber: 001\nHeight: 0.71\nWeight: 6.9\nType: Grass | Poison\nHP: "+hP+"\nCP: "+cP,
          p.toString());
   }
   
   /* Check that string output from fast attack on Bulbasaur is correct */
   @Test public void performFastAttackTest1(){
      String[] gFastAtks = {"Razor Leaf", "Vine Whip"};
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Bulbasaur();
      String pFA = p.getFastAttack();
      int i = 0;
      boolean pAtkGrass = false;
      while((!pAtkGrass) && (i < gFastAtks.length)){
            pAtkGrass = pFA.equals(gFastAtks[i]);
            i++;
      }
      if(pAtkGrass){
         Assert.assertEquals("String output from fast attack on Bulbasaur is not as expected",  
         "Bulbasaur performed " + pFA + " on Bulbasaur\n It was not very effective.",
          p.performFastAttack(p2));
     }else{
         Assert.assertEquals("String output from fast attack on Bulbasaur is not as expected",  
         "Bulbasaur performed " + pFA + " on Bulbasaur\n It was super effective!", p.performFastAttack(p2));
     }
   }
   
    @Test public void performFastAttackTest2(){
      String[] gFastAtks = {"Razor Leaf", "Vine Whip"};
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Squirtle();
      String pFA = p.getFastAttack();
      int i = 0;
      boolean pAtkGrass = false;
      while((!pAtkGrass) && (i < gFastAtks.length)){
            pAtkGrass = pFA.equals(gFastAtks[i]);
            i++;
      }
      if(pAtkGrass){
         Assert.assertEquals("String output from fast attack on Water Type is not as expected",  
         "Bulbasaur performed " + pFA + " on Squirtle\n It was super effective!",
          p.performFastAttack(p2));
     }else{
         Assert.assertEquals("String output from fast attack on Water Type is not as expected",  
         "Bulbasaur performed " + pFA + " on Squirtle", p.performFastAttack(p2));
     }
   }
   /*performFastAttack on Charmander/fire type */
    @Test public void performFastAttackTest3(){
      String[] gFastAtks = {"Razor Leaf", "Vine Whip"};
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Charmander();
      String pFA = p.getFastAttack();
      int i = 0;
      boolean pAtkGrass = false;
      while((!pAtkGrass) && (i < gFastAtks.length)){
            pAtkGrass = pFA.equals(gFastAtks[i]);
            i++;
      }
      if(pAtkGrass){
         Assert.assertEquals("String output from fast attack on Fire Type is not as expected",  
         "Bulbasaur performed " + pFA + " on Charmander\n It was not very effective.",
          p.performFastAttack(p2));
     }else{
         Assert.assertEquals("String output from fast attack on Fire Type is not as expected",  
         "Bulbasaur performed " + pFA + " on Charmander", p.performFastAttack(p2));
     }
   }

   /* Check that string output from special attack on Bulbasaur is correct */
   @Test public void performSpecialAttackTest1(){
      String[] gSpecialAtks = {"Leaf Blade", "Petal Blizzard", "Power Whip","Seed Bomb", "Solar Beam"};
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Bulbasaur();
      String pSA = p.getSpecialAttack();
      int i = 0;
      boolean pAtkGrass = false;
      while((!pAtkGrass) && (i < gSpecialAtks.length)){
            pAtkGrass = pSA.equals(gSpecialAtks[i]);
            i++;
      }
      if(pAtkGrass){
         Assert.assertEquals("String output from special attack on Bulbasaur is not as expected",  
         "Bulbasaur performed " + pSA + " on Bulbasaur\n It was not very effective.",
          p.performSpecialAttack(p2));
     }else{
         Assert.assertEquals("String output from special attack on Bulbasaur is not as expected",  
         "Bulbasaur performed " + pSA + " on Bulbasaur\n It was super effective!", p.performSpecialAttack(p2));
     }
   }
   /* perform special attack on Squirtle/water type */
   @Test public void performSpecialAttackTest2(){
      String[] gSpecialAtks = {"Leaf Blade", "Petal Blizzard", "Power Whip","Seed Bomb", "Solar Beam"};
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Squirtle();
      String pSA = p.getSpecialAttack();
      int i = 0;
      boolean pAtkGrass = false;
      while((!pAtkGrass) && (i < gSpecialAtks.length)){
            pAtkGrass = pSA.equals(gSpecialAtks[i]);
            i++;
      }
     if(pAtkGrass){
         Assert.assertEquals("String output from special attack on Water Type is not as expected",  
         "Bulbasaur performed " + pSA + " on Squirtle\n It was super effective!",
          p.performSpecialAttack(p2));
     }else{
         Assert.assertEquals("String output from special attack on Water Type is not as expected",  
         "Bulbasaur performed " + pSA + " on Squirtle", p.performSpecialAttack(p2));
     }
   }
   /* perform special attack on Charmander/fire type */
   @Test public void performSpecialAttackTest3(){
      String[] gSpecialAtks = {"Leaf Blade", "Petal Blizzard", "Power Whip","Seed Bomb", "Solar Beam"};
      Pokemon p = new Bulbasaur();
      Pokemon p2 = new Charmander();
      String pSA = p.getSpecialAttack();
      int i = 0;
      boolean pAtkGrass = false;
      while((!pAtkGrass) && (i < gSpecialAtks.length)){
            pAtkGrass = pSA.equals(gSpecialAtks[i]);
            i++;
      }
      if(pAtkGrass){
         Assert.assertEquals("String output from special attack on Fire Type is not as expected",  
         "Bulbasaur performed " + pSA + " on Charmander\n It was not very effective.",
          p.performSpecialAttack(p2));
     }else{
         Assert.assertEquals("String output from special attack on Fire Type is not as expected",  
         "Bulbasaur performed " + pSA + " on Charmander", p.performSpecialAttack(p2));
     }
   }
   /*HP constructor test
   * Checks that HP in range
   * HP is base stamina (90) + a random
   * Run it 5 times to check due to randomness
   */
   @Test public void hpRangeTest1(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP())); 
   }
   @Test public void hpRangeTest2(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP()));  
   }
   @Test public void hpRangeTest3(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP()));  
   }
   @Test public void hpRangeTest4(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP())); 
  }
   @Test public void hpRangeTest5(){
      double cpMult = cpMultiplier[0];
      int minHP = (int)(BASE_STAMINA * cpMult);
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("HP not >= " + minHP,(minHP <= p.getHP())); 
   }
   
   /*CP constructor test
   * Checks that CP in range*
   * Run it 5 times to check due to randomness
   */
   @Test public void cpRangeTest1(){
      int minCP = 10;
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("CP " + p.getCP()+" not <= " + minCP,(minCP <= p.getCP())); 
   }
   @Test public void cpRangeTest2(){
      int minCP = 10;
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("CP " + p.getCP()+" not <= " + minCP,(minCP <= p.getCP()));  }  
   @Test public void cpRangeTest3(){
      int minCP = 10;
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("CP " + p.getCP()+" not <= " + minCP,(minCP <= p.getCP())); 
   }   
   @Test public void cpRangeTest4(){
      int minCP = 10;
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("CP " + p.getCP()+" not <= " + minCP,(minCP <= p.getCP())); 
   }
   @Test public void cpRangeTest5(){
      int minCP = 10;
      Pokemon p = new Bulbasaur();
      Assert.assertTrue("CP " + p.getCP()+" not <= " + minCP,(minCP <= p.getCP())); 
   }
   
}
