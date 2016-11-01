import java.util.*;

public class Bear{

  private String name;
  private ArrayList<Edible> belly;
                 // salmon is class like String etc, belly is variable
  public Bear(String name){
    this.name = name;
    this.belly = new ArrayList<Edible>();
  }

  public String getName(){
    return this.name;
  }

  public int foodCount(){
    return this.belly.size();
  }
  // if pass human object won't be able to pass in salmon, edible acts as polymorphism and implments both

  public void eat(Edible food){
    this.belly.add(food);
  } 

 // public boolean bellyFull(){
 //   return foodCount() == belly.length;
 // }

  public Edible spew(){
    if (foodCount() > 0){
      return this.belly.remove(0);
    } 
    return null;
  }
  // remove specifies where you can take item from array
  // return null gives additional information, there was nothing to give you this time.

  public int totalNutrition(){
    int totalNutrition = 0;

    for (Edible food : belly){
      totalNutrition += food.nutritionValue();
    }
    return totalNutrition;
  }

  
   

  public void sleep(){
   this.belly.clear(); 
 }
}

