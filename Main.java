package com.company;

import java.util.*;

//THIBAUD DANDOY + JEANNE DESCOURTIS + JUSTINE WANG + NOUHEYLA CHERABBI

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        RUNWAY_MENU runway_Menu = new RUNWAY_MENU(8);
        WAITING_PLANES_MENU waiting_Planes_menu = new WAITING_PLANES_MENU();
        REQUESTS_MENU requests_menu = new REQUESTS_MENU();
        ADVANCE_HOUR_MENU advance_Hour = new ADVANCE_HOUR_MENU();
        new MAIN_MENU(runway_Menu, waiting_Planes_menu, advance_Hour, requests_menu);
        String menu = "MAIN MENU";
        boolean exit = false;
        do {
            /*
                MENU LIST :
                1) MAIN_MENU
                2) RUNWAY MENU
                3) WAITING PLANES MENU
                4) REQUEST MENU
                5) ADVANCE HOUR MENU
            */
            switch (menu) {
                case "MAIN MENU" -> {
                    System.out.println("\n-----------MAIN MENU----------\n");
                    MAIN_MENU.Display_Info();
                    System.out.println("-----------Menu Options----------\n");
                    if (requests_menu.Can_Be_Displayed()) {
                        System.out.println("  Display Requests: input \"REQUEST MENU\"");
                    } else if (ADVANCE_HOUR_MENU.Can_Be_Displayed()) {
                        System.out.println("\n  Advance to the next hour: input \"ADVANCE HOUR\"");
                    }
                    System.out.println("\n  Waiting Planes Menu: input \"WAITING PLANES\"");
                    System.out.println("\n  Runway Menu: input \"RUNWAY MENU\"");
                    System.out.println("\n  Exit: input \"Exit\"");
                    System.out.print("\nINPUT : ");
                    menu = input.nextLine();
                    menu = menu.toUpperCase();
                }
                case "RUNWAY MENU" -> {
                    System.out.println("\n-----------RUNWAY MENU-----------\n");
                    RUNWAY_MENU.Display_Index();
                    menu = "MAIN MENU";
                }
                case "REQUEST MENU" -> {
                    if (!requests_menu.Can_Be_Displayed()) {
                        System.out.println("\nERROR: UNABLE TO PROCEED WITH COMMAND");
                    } else {
                        System.out.println("\n-----------REQUESTS MENU-----------\n");
                        REQUESTS_MENU.Display_requests_menu();
                    }
                    menu = "MAIN MENU";
                }
                case "WAITING PLANES" -> {
                    System.out.println("\n-----------WAITING PLANES MENU-----------\n");
                    WAITING_PLANES_MENU.call_Waiting_menu();
                    menu = "MAIN MENU";
                }
                case "ADVANCE HOUR" -> {
                    if (!ADVANCE_HOUR_MENU.Can_Be_Displayed()) {
                        System.out.println("\nERROR: UNABLE TO PROCEED WITH COMMAND");
                    } else {
                        System.out.println("\n-----------ADVANCE HOUR MENU-----------\n");
                        ADVANCE_HOUR_MENU.Display_Advance_Hour_Menu();
                        ADVANCE_HOUR_MENU.Advance_Hour();
                    }
                    menu = "MAIN MENU";
                }
                case "EXIT" -> {
                    exit = true;
                    menu = "MAIN MENU";
                }
                default -> {
                    System.out.println("\nERROR: COMMAND NOT RECOGNIZED");
                    menu = "MAIN MENU";
                }
            }
                    /*
                    ● Shows an index tabled, each row contains the following:
                        ○ Plane name
                        ○ Fuel left
                    ● Option to select a plane to land
                        ○ A plane can only land when a runway is open
                    ● Option to return to main menu

                    */
            //Random rn = new Random();
            //int nb_of_request = rn.nextInt(3-1) + 1;   // user receive a random number of requests (1-3)
        } while (!exit);
    }
}