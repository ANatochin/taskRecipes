import java.util.ArrayList;

public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<String> ingridients;

    public Recipe(String name, int time, ArrayList<String> ingridients) {
        this.name = name;
        this.cookingTime = time;
        this.ingridients = ingridients;
    }

    public String getName() {
        return this.name;
    }
    public int getCookingTime(){
        return this.cookingTime;
    }
    public boolean recipeContent(String ingridient){
        if(this.ingridients.contains(ingridient)){
            return true;
        }
        return false;
    }

    public int ingridientsQuantity() {
        return this.ingridients.size();
    }
    public void ingridientsPrint(){
        for(String ingridient: ingridients){
            System.out.println(ingridient);
        }
    }

    @Override
    public String toString(){
        return this.getName() + ", cooking time: " + this.getCookingTime();
    }

}


