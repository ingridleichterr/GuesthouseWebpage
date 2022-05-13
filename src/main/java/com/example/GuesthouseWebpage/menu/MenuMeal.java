package com.example.GuesthouseWebpage.menu;

import com.example.GuesthouseWebpage.model.Meal;
import com.example.GuesthouseWebpage.model.MealType;
import com.example.GuesthouseWebpage.service.MealService;

import java.util.Scanner;

public class MenuMeal {
    MealService mealService = new MealService();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Add new meal");
        System.out.println("2: Update meal price by mealId");
        System.out.println("3: List all meals");
        System.out.println("4: List breakfasts options");
        System.out.println("5: List all lunch options");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    saveNewMeal(input);
                    break;
                case 2:
                    updateMealPriceByMealId(input);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }

    //case1
    public void saveNewMeal (Scanner input){
        Meal meal = new Meal();
        System.out.println("Menu register new meal");
        System.out.print("Type name of the meal: ");
        meal.setName(input.next());

        System.out.print("Type meal description: ");
        meal.setDescription(input.next());

        System.out.print("Type price of the meal: ");
        meal.setPrice(input.nextDouble());

        //IS foreign key so should be an OBJECT
        System.out.println("Type meal Type ID:\n1-Breakfast, 2-Lunch\n3-Dinner, 4-Snacks");
        //create object and give value
        MealType mealTypeObject = new MealType();
        mealTypeObject.setMealId(input.nextInt());
        //set object value
        meal.setMealType(mealTypeObject);


        mealService.saveMeal(meal);
        System.out.println("New meal saved with success!");

    }
    //case 2
    public void updateMealPriceByMealId(Scanner input){

        System.out.println("Menu update meal price by meal id");
        System.out.print("Type meal id: ");
        int mealId = input.nextInt();


        Meal meal = mealService.findMealById(mealId);

        if(meal !=null){
            System.out.print("Type new price: ");
            double newPrice=input.nextDouble();
            mealService.updateMealPrice(newPrice, mealId);
            System.out.println("Meal price updated successfully!");
        }else {
            System.out.println("Meal with this Id doesn't exist in the system.\nPlease enter valid mealId!");
        }


    }
}
