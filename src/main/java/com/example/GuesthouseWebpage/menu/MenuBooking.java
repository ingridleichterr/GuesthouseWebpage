package com.example.GuesthouseWebpage.menu;

import com.example.GuesthouseWebpage.model.*;
import com.example.GuesthouseWebpage.service.BookingService;

import java.util.List;
import java.util.Scanner;

public class MenuBooking {
    BookingService bookingService = new BookingService();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Add new Booking");
        System.out.println("2: Count bookings by date ");
        System.out.println("3: Show all bookings in a specified date");
        System.out.println("4: Show all bookings on one room");
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
                    saveNewBooking(input);
                    break;
                case 2:
                    countTotalBookingsByDate();
                    break;
                case 3:
                    listAllBookingsInEnteredDate(input);
                    break;
                case 4:
                    menuListAllBookingsByRoomId(input);
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

    //case 1 add new booking
    public void saveNewBooking(Scanner input) {
        Booking booking = new Booking();
        System.out.println("Menu register new booking");

        System.out.print("Type arrival date (yyyy-mm-dd): ");
        booking.setArrivalDate(input.next());

        System.out.print("Type leaving date (yyyy-mm-dd): ");
        booking.setLeavingDate(input.next());

        System.out.print("Type number of people visiting: ");
        booking.setNumberOfPeople(input.nextInt());

        System.out.print("Type full name of the booker: ");
        booking.setBookerName(input.next());

        System.out.print("Type email of the booker: ");
        booking.setBookerEmail(input.next());

        System.out.print("Type phone number of the booker: ");
        booking.setBookerPhoneNumber(input.next());

        System.out.print("Type bookingPaymentId of the booking: ");
        BookingPayment bookingPaymentObject = new BookingPayment();
        bookingPaymentObject.setBookingPaymentId(input.nextInt());
        booking.setBookingPaymentId(bookingPaymentObject);

        System.out.print("Type roomId you wish to book: ");
        Room roomObject = new Room();
        roomObject.setRoomId(input.nextInt());
        booking.setRoom(roomObject);

        System.out.print("Type mealId you wish to have: ");
        Meal mealObject = new Meal();
        mealObject.setMealId(input.nextInt());
        booking.setMeal(mealObject);

        System.out.print("Type extraId you wish to have: ");
        Extras extraObject = new Extras();
        extraObject.setExtraId(input.nextInt());
        booking.setExtras(extraObject);

        System.out.print("Type userId: ");
        User userObject = new User();
        userObject.setUserId(input.nextInt());
        booking.setUser(userObject);

        bookingService.saveBooking(booking);
        System.out.println("Booking is saved successfully!" +
                "\nPlease wait for booking confirmation, " +
                "which will be sent to entered e-mail.");

    }

    //case 2 - count bookings by date
    public void countTotalBookingsByDate (){
        List<CountBooking>bookingList = BookingService.bookingsByDate();
        if (bookingList.size()>0){
            for (CountBooking book:bookingList) {
                System.out.println(book.toString());
        }
        }else {
            System.out.println("\nSorry, currently are no bookings registered!\n");

        }
    }

    //case 3 - list all bookings in one date entered
    public void listAllBookingsInEnteredDate(Scanner input)  {
        System.out.print("Please enter a date for which you want to see bookings (yyyy-mm-dd) : ");
        List<ShowBookingsOnADate>bookingList = BookingService.bookingsOnADate(input.next());
        if (bookingList.size()>0){
            for (ShowBookingsOnADate book:bookingList) {
                System.out.println(book.toString());
            }
        }else{
            System.out.println("\nSorry, currently are no customers registered to this date!\n");
            //menuOptions(input);//if this is uncommented asks twice for enter in menu
        }
    }

    //case 4 - list all bookings for one room, order by arrivalDate ascending
    public void menuListAllBookingsByRoomId(Scanner input){
        System.out.print("Please enter a roomId for which you want to see bookings : ");
        List<ShowBookingsOfARoom>bookingList = BookingService.bookingsOfARoom(input.nextInt());
        if (bookingList.size()>0){
            for (ShowBookingsOfARoom book:bookingList) {
                System.out.println(book.toString());
            }
        }else{
            System.out.println("\nSorry, currently are no bookings registered to this room!\n");
            //menuOptions(input); //if this is uncommented asks twice for enter in menu
        }
    }

}
