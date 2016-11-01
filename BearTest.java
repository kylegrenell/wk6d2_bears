import static org.junit.Assert.*;
import org.junit.*;

public class BearTest{
  Bear bear;
  Salmon salmon;
  Human human;
  Chicken chicken;

  @Before 
  public void before() {
    bear = new Bear("Baloo");
    salmon = new Salmon(); 
    human = new Human();
    chicken = new Chicken();
  }

  @Test
  public void hasName(){
    assertEquals( "Baloo", bear.getName() ); 
  }

  @Test
  public void bellyStartsEmpty(){
    assertEquals( 0, bear.foodCount() );
  }

  @Test
  public void canEatSalmon(){
    bear.eat(salmon);
    assertEquals( 1, bear.foodCount() );
  }

  @Test
  public void canEatHuman(){
    bear.eat(human);
    assertEquals( 1, bear.foodCount() );
  }

  @Test
  public void canSpew(){
    bear.eat(salmon);
    Edible food = bear.spew();
    assertNotNull(food);
  }

  @Test
  public void canGetChickenBack(){
    bear.eat(chicken);
    Edible food = bear.spew();
    Chicken original = (Chicken) food;
    assertEquals("swimming", original.swim());
  }

  @Test
  public void canGetSalmonBack(){
    bear.eat(salmon);
    Edible food = bear.spew();
    Salmon original = (Salmon) food; // this is going to convert htis to a salmon type variable, (salmon) is casting
    assertEquals( "swimming", original.swim() );
  }

  @Test
  public void edibleCanSwim(){
    bear.eat(salmon);
    Edible food = bear.spew();
    assertEquals( "swimming", food.swim() );
  }

  @Test
  public void edibleCanSpeak(){
    bear.eat(chicken);
    Edible food = bear.spew();
    assertEquals( "cluck", food.speak() );
  }

  @Test
  public void canEatChicken(){
    bear.eat(chicken);
    assertEquals( 1, bear.foodCount() );
  }

  @Test
  public void totalNutritionInBear(){
    bear.eat(chicken);
    bear.eat(salmon);
    assertEquals(21, bear.totalNutrition() );
  }

  // @Test
  // public void bellyIsFull(){
  //   for(int i = 0; i<5; i++){
  //     bear.eat(salmon);
  //   }
  //   assertEquals(bear.bellyFull(), true);
  // }

  // @Test
  // public void canNotEatSalmonWhenBellyFull(){
  //   for(int i = 0; i<10; i++){
  //     bear.eat(salmon);
  //   }
  //   assertEquals(bear.foodCount(), 5);
  // }

  @Test
  public void shouldEmptyBellyAfterSleeping(){
    bear.eat(salmon);
    bear.eat(human);
    bear.sleep();
    assertEquals(bear.foodCount(), 0);
  }
}





