
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> recipes = new ArrayList<>();

        System.out.print("File to read: ");
        String file = scanner.nextLine();
        try (Scanner scan = new Scanner(Paths.get(file))) {
            String ingredients;
            while (scan.hasNextLine()) {
                ingredients = scan.nextLine();
                recipes.add(ingredients);
            }

            while (true) {
                System.out.println();
                System.out.println("Commands:");
                System.out.println("list - list the recipes");
                System.out.println("stop - stop the program");
                System.out.println("find name - searched recipes by name");
                System.out.println("find cooking time - searches recipes by cooking time");
                System.out.println("find ingredient - searches recipes by ingredient");
                System.out.println();
                System.out.print("Enter command: ");
                String input = scanner.nextLine();

                if (input.equals("stop")) {
                    break;
                }

                if (input.equals("list")) {
                    System.out.println("Recipes:");
                    System.out.print(recipes.get(0) + ", cooking time: " + recipes.get(1));
                    System.out.println();

                    for (int i = 0; i < recipes.size(); i++) {
                        if (recipes.get(i).equals("")) {
                            System.out.print(recipes.get(i + 1) + ", cooking time: " + recipes.get(i + 2));
                            System.out.println("");
                        }
                    }

                }
                if (input.equals("find name")) {
                    System.out.print("Searched word: ");
                    String searchedWord = scanner.nextLine();
                    System.out.println();
                    System.out.println("Recipes:");
                    if (recipes.get(0).contains(searchedWord)) {
                        System.out.print(recipes.get(0) + ", cooking time: " + recipes.get(1));
                        System.out.println("");
                    }

                    for (int i = 0; i < recipes.size(); i++) {

                        if (recipes.get(i).equals("")) {
                            if (recipes.get(i + 1).contains(searchedWord)) {
                                System.out.print(recipes.get(i + 1) + ", cooking time: " + recipes.get(i + 2));
                                System.out.println("");
                            }
                        }
                    }

                }
                if (input.equals("find cooking time")) {
                    System.out.print("Max cooking time: ");
                    int cookTimer = Integer.valueOf(scanner.nextLine());
                    System.out.println();

                    System.out.println("Recipes:");
                    int timeCook = Integer.valueOf(recipes.get(1));
                    if (timeCook <= cookTimer) {
                        System.out.print(recipes.get(0) + ", cooking time: " + recipes.get(1) + "\n");
                    }

                    for (int i = 0; i < recipes.size(); i++) {
                        if (recipes.get(i).equals("")) {
                            if (Integer.valueOf(recipes.get(i + 2)) <= cookTimer) {
                                System.out.print(recipes.get(i + 1) + ", cooking time: " + recipes.get(i + 2));
                                System.out.println();
                            }
                        }
                    }

                }
                if (input.equals("find ingredient")) {
                    int counter = 0;
                    System.out.print("Ingredient: ");
                    String ingredient = scanner.nextLine();
                    ArrayList<String> ingredientFound = new ArrayList<>();

                    String output = "";
                    System.out.println();

                    System.out.println("Recipes:");
                    for (int i = 0; i < recipes.size(); i++) {
                        if (recipes.get(i).equals(ingredient)) {
                            counter++;

                            for (int j = i; j >= 0; j--) {
                                if (recipes.get(j).matches("[0-9]+")) {
                                    output += recipes.get(j - 1) + ", cooking time: " + recipes.get(j) + "\n";
                                    ingredientFound.add(output);
                                }
                            }
                        }
                    }

                    if (counter == 1) {
                        System.out.println(ingredientFound.get(0));

                    }
                    if (counter == 2) {
                        System.out.println(ingredientFound.get(1));

                    }
                    if (counter == 3) {
                        System.out.println(ingredientFound.get(2));

                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
