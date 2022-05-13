package com.example.GuesthouseWebpage.menu;

import com.example.GuesthouseWebpage.model.GuestHouse;
import com.example.GuesthouseWebpage.service.GuestHouseService;

import java.util.List;
import java.util.Scanner;

public class MenuGuestHouse {
    GuestHouseService guestHouseService = new GuestHouseService();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: See Guesthouse information");
        //System.out.println("2: See Guesthouse history");
        //System.out.println("3: See Guesthouse gallery");
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
                    showGuestHouseInfo();
                    break;
                case 2:
                    break;
                case 3:
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

    // case 1 - show questHouse info
    private void showGuestHouseInfo() {
        List<GuestHouse> guestHouseInfo = GuestHouseService.showGuestHouseInfo();
            if (guestHouseInfo.size()>0){
                for (GuestHouse gh : guestHouseInfo) {
                    System.out.println(gh.toString());
                }
            } else {
                System.out.println("\nSorry, currently there is no info available!\n");
            }
        }


    }

