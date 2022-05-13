package com.example.GuesthouseWebpage.menu;

import com.example.GuesthouseWebpage.model.GuestHouse;
import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.model.RoomType;
import com.example.GuesthouseWebpage.service.RoomService;

import java.util.Scanner;

public class MenuRoom {

    RoomService roomService = new RoomService();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all rooms");
        //System.out.println("2: List all available rooms");
        System.out.println("3: Add new room");
        System.out.println("4: Update room price by room id");
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
                    //menuListAllRooms(input);
                    break;
                case 2:
                    //menuListAllAvailableRooms(input)
                    break;
                case 3:
                    menuAddNewRoom(input);
                    break;
                case 4:
                    //menuUpdateRoomPrice(input)
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



    public void menuAddNewRoom(Scanner input){ //case3

        Room room = new Room();
        System.out.println("Menu register new room");
        System.out.print("Enter room name: ");
        room.setName(input.next());

        System.out.print("Enter room type: ");
        RoomType roomTypeObject = new RoomType();
        roomTypeObject.setRoomTypeId(input.nextInt());
        room.setRoomType(roomTypeObject);

        System.out.print("Enter room price per night: ");
        room.setPrice(input.nextDouble());

        System.out.print("Enter room availability (1 - YES, 0 - NO): ");
        room.setPrice(input.nextInt());

        System.out.print("Enter GuestHouse ID (always 1): ");
        GuestHouse guestHouseObject = new GuestHouse();
        guestHouseObject.setGuestHouseId(input.nextInt());
        room.setGuestHouse(guestHouseObject);

        roomService.saveRoom(room);
        System.out.println("Room saved successfully!");
    }
}
