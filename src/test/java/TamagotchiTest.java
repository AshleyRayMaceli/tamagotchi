import org.junit.*;
import static org.junit.Assert.*;

public class TamagotchiTest {

  @Test
  public void tamagotchi_instantiatesCorrectly() {
    Tamagotchi myPet = new Tamagotchi("little whale");
    assertEquals("little whale", myPet.getName());
    assertEquals(10, myPet.getFoodLevel());
    assertEquals(10, myPet.getSleepLevel());
    assertEquals(10, myPet.getActivityLevel());
    assertEquals(0, myPet.getPoopLevel());
  }

  @Test
  public void timePasses_foodDecreasesByOne_9() {
    Tamagotchi myPet = new Tamagotchi("little whale");
    myPet.timePasses();
    assertEquals(9, myPet.getFoodLevel());
  }

  @Test
  public void timePasses_allAttributesProgressByOne_int() {
    Tamagotchi myPet = new Tamagotchi("little whale");
    myPet.timePasses();
    assertEquals(9, myPet.getFoodLevel());
    assertEquals(9, myPet.getSleepLevel());
    assertEquals(9, myPet.getActivityLevel());
    assertEquals(1, myPet.getPoopLevel());
  }

  @Test
  public void isAlive_foodLevelAbove0_true() {
    Tamagotchi myPet = new Tamagotchi("little whale");
    assertEquals(true, myPet.isAlive());
  }

  @Test
  public void isAlive_foodLevelBelow1_false() {
    Tamagotchi myPet = new Tamagotchi("little whale");
    myPet.setFoodLevel(0);
    assertEquals(false, myPet.isAlive());
  }


}
