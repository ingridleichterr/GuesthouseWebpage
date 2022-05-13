package com.example.GuesthouseWebpage.menu;

import com.example.GuesthouseWebpage.model.Extras;
import com.example.GuesthouseWebpage.model.Meal;
import com.example.GuesthouseWebpage.model.MealType;
import com.example.GuesthouseWebpage.service.ExtrasService;

import java.util.Scanner;

public class MenuExtras {
    ExtrasService extrasService = new ExtrasService();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Add new Extra");
        System.out.println("2: Update extras price by extrasId");
        System.out.println("3: List all Extras");
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
                    saveNewExtra(input);
                    break;
                case 2:
                    updateExtrasPriceByExtrasId(input);
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
    public void saveNewExtra (Scanner input){
        Extras extras = new Extras();
        System.out.println("Menu register new extra");
        System.out.print("Type name of the extra: ");
        extras.setName(input.next());

        System.out.print("Type extra description: ");
        extras.setDescription(input.next());

        System.out.print("Type price of the extra: ");
        extras.setPrice(input.nextDouble());


        extrasService.saveExtra(extras);
        System.out.println("New meal saved with success!");

    }
    //case 2
    public void updateExtrasPriceByExtrasId(Scanner input){

        System.out.println("Menu update extras price by extras id");
        System.out.print("Type extras id: ");
        int extrasId = input.nextInt();


        Extras extras = extrasService.findExtraById(extrasId);

        if(extras !=null){
            System.out.print("Type new price: ");
            double newPrice=input.nextDouble();
            extrasService.updateExtrasPrice(newPrice, extrasId);
            System.out.println("Extras price updated successfully!");
        }else {
            System.out.println("Extra with this Id doesn't exist in the system.\nPlease enter valid extras Id!");
        }


    }
}

