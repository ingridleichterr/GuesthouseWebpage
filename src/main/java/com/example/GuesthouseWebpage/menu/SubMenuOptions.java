package com.example.GuesthouseWebpage.menu;

import java.util.Scanner;

public class SubMenuOptions {
    boolean exit = false;
    private MenuUser menuUser;
    private MenuGuestHouse menuGuestHouse;
    private MenuRoom menuRoom;
    private MenuMeal menuMeal;
    private MenuExtras menuExtras;
    private MenuBooking menuBooking;

    //constructor
    public SubMenuOptions() {
        this.menuUser = new MenuUser();
        this.menuGuestHouse = new MenuGuestHouse();
        this.menuRoom = new MenuRoom();
        this.menuMeal = new MenuMeal();
        this.menuExtras = new MenuExtras();
        this.menuBooking = new MenuBooking();

    }

    private int menuOptions(Scanner input) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Sub Menu - User");
        System.out.println("2: Sub Menu - Guesthouse");
        System.out.println("3: Sub Menu - Rooms");
        System.out.println("4: Sub Menu - Meals");
        System.out.println("5: Sub Menu - Extras");
        System.out.println("6: Sub Menu - Booking");
        System.out.println("100 - Quit");
        System.out.println("***************************************************");

        System.out.println("Type the sub menu option: ");
        return input.nextInt();
    }

    public void menuChoice(Scanner input) {
        while(!exit) {
            int userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuUser.menuChoice(input);
                    break;
                case 2:
                    this.menuGuestHouse.menuChoice(input);
                    break;
                case 3:
                    this.menuRoom.menuChoice(input);
                    break;
                case 4:
                    this.menuMeal.menuChoice(input);
                    break;
                case 5:
                    this.menuExtras.menuChoice(input);
                    break;
                case 6:
                    this.menuBooking.menuChoice(input);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 100:
                    exit = true;
                    System.out.println("System closed!");
                    break;
               default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuChoice(input);
            }
        }
    }

}
