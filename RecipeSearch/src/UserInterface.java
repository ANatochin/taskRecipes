import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;


public class UserInterface {
    private ArrayList<Recipe> recipesList;

    public UserInterface() {
        this.recipesList = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File to read: ");
        String fileToRead = scanner.nextLine();

        try (Scanner scan = new Scanner(Paths.get(fileToRead))) {

            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                int time = Integer.parseInt(scan.nextLine());
                ArrayList<String> ingds = new ArrayList<>();
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    if (line.isEmpty()) {
                        break;
                    }
                    ingds.add(line);
                }
                this.recipesList.add(new Recipe(name, time, ingds));

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Commands:\n"
                + "list - lists the recipes\n"
                + "stop - stops the program\n"
                + "find name - searches recipes by name\n"
                + "find cooking time - searches recipes by cooking time\n"
                + "find ingredient - searches recipes by ingredient");
        while (true) {
            System.out.println("");
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            if (command.equals("list")) {
                System.out.println("Recipes:");
                for (Recipe recipeList : recipesList) {
                    System.out.println(recipeList);

                }
            } else if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String searchedName = scanner.nextLine();
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipeList : recipesList) {
                    if (recipeList.getName().contains(searchedName)) {
                        System.out.println(recipeList);
                    }
                }
            } else if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxCookingTime = Integer.parseInt(scanner.nextLine());
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipeList : recipesList) {
                    if (recipeList.getCookingTime() <= maxCookingTime) {
                        System.out.println(recipeList);
                    }
                }
            } else if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingridient = scanner.nextLine();
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipe : recipesList) {
                    if (recipe.recipeContent(ingridient)) {
                        System.out.println(recipe);
                    }
                }
            }
        }
    }
}
