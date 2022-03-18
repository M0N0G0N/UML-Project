package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Random rn = new Random();
        //int nb_of_request = rn.nextInt(3-1) + 1;   // user receive a random number of requests (1-3)

        //---------TEST REQUEST ----------------

        /*
        OPTION option1 = new OPTION("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time");
        OPTION option2 = new OPTION("Place on standby", "None", "Airplane joins “waiting” planes.");
        OPTION[] requests_Options = {option1, option2};
        REQUEST request1 = new REQUEST(40, "Plane Landing", "Plane requests to land. It has [3-5] hours of fuel left to wait. It needs [1-4] hours of runway time. It has [100-500] passengers",
                requests_Options);

        System.out.println(request1.toString() + "\n -------------------------------\n ");
        System.out.println("Choose one option : ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        System.out.println("Option chosen : " + requests_Options[option]);
        // ---------------------------------------
        */

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
                    System.out.println("-----------MAIN MENU----------\n");
                    MAIN_MENU.Display_Info();
                    System.out.println("-----------Menu Options----------\n");
                    if (requests_menu.Can_Be_Displayed()) {
                        System.out.println("  Display Requests: input \"REQUEST MENU\"");
                    } else if (ADVANCE_HOUR_MENU.Can_Be_Displayed()) {
                        System.out.println("  Advance to the next hour: input \"ADVANCE HOUR\"");
                    }
                    System.out.println("  Waiting Planes Menu: input \"WAITING PLANES\"");
                    System.out.println("  Runway Menu: input \"RUNWAY MENU\"");
                    System.out.println("  Exit: input \"Exit\"");
                    System.out.print("INPUT : ");
                    menu = input.nextLine();
                    menu = menu.toUpperCase();
                }
                case "RUNWAY MENU" -> {
                    System.out.println("-----------RUNWAY MENU-----------\n");
                    RUNWAY_MENU.Display_Index();
                    menu = "MAIN MENU";
                }
                case "REQUEST MENU" -> {
                    if (!requests_menu.Can_Be_Displayed()) {
                        System.out.println("ERROR: UNABLE TO PROCEED WITH COMMAND");
                    } else {
                        System.out.println("-----------REQUESTS MENU-----------\n");
                        REQUESTS_MENU.Display_requests_menu();
                    }
                    menu = "MAIN MENU";
                }
                case "WAITING PLANES" -> {
                    System.out.println("-----------WAITING PLANES MENU-----------\n");
                    WAITING_PLANES_MENU.display_Waiting_menu();
                    menu = "MAIN MENU";
                }
                case "ADVANCE HOUR" -> {
                    if (!ADVANCE_HOUR_MENU.Can_Be_Displayed()) {
                        System.out.println("ERROR: UNABLE TO PROCEED WITH COMMAND");
                    } else {
                        System.out.println("-----------ADVANCE HOUR MENU-----------\n");
                        ADVANCE_HOUR_MENU.Display_Advance_Hour_Menu();
                    }
                    menu = "MAIN MENU";
                }
                case "EXIT" -> {
                    exit = true;
                    menu = "MAIN MENU";
                }
                default -> {
                    System.out.println("ERROR: COMMAND NOT RECOGNIZED");
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