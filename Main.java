package com.company;
import java.util.* ; 

public class Main {

    public static void main(String[] args) {
                
        //Random rn = new Random();
        //int nb_of_request = rn.nextInt(3-1) + 1;   // user receive a random number of requests (1-3)

        //---------TEST REQUEST ----------------
        System.out.println("Hello World");
       
        OPTION option1 = new OPTION("Allow landing", "1 empty runway", "Plane lands and occupies the runway for stated time") ; 
        OPTION option2 = new OPTION("Place on standby", "None", "Airplane joins “waiting” planes.") ; 
        OPTION[] requests_Options = {option1, option2 } ; 
        REQUEST request1 = new REQUEST(40, "Plane Landing", "Plane requests to land. It has [3-5] hours of fuel left to wait. It needs [1-4] hours of runway time. It has [100-500] passengers", 
        requests_Options) ; 
        
        System.out.println(request1.toString() + "\n -------------------------------\n ");
        System.out.println("Choose one option : ") ; 
        Scanner input = new Scanner(System.in) ; 
        int option = input.nextInt() ; 
        
        System.out.println("Option chosen : " + requests_Options[option]) ; 
        // ---------------------------------------



        RUNWAY_MENU runway_Menu = new RUNWAY_MENU(8); 
        WAITING_PLANES_MENU waiting_Planes_menu = new WAITING_PLANES_MENU() ; 
        ADVANCE_HOUR_MENU advance_Hour = new ADVANCE_HOUR_MENU() ; 
        REQUESTS_MENU requests_menu = new REQUESTS_MENU() ; 
        
        MAIN_MENU main_Menu = new MAIN_MENU(runway_Menu, waiting_Planes_menu, advance_Hour, requests_menu) ;

        boolean exit = false ; 

        do {
            int menu = 1 ; 
            /*
                MENU LIST : 
                1) MAIN_MENU
                2) RUNWAY MENU
                3) WAITING PLANES MENU
                4) REQUEST MENU 
                5) ADVANCE HOUR MENU
            */
            switch(menu){
                case 1 : // main_menu 
                    System.out.println("-----------MAIN MENU----------\n") ; 
                    System.out.println("-----------Menu Options----------\n") ; 
                    if (requests_menu.Can_Be_Displayed()) {
                        System.out.println("  Request Menu");
                    }                    
                    System.out.println("  Waiting Planes Menu");
                    if (!requests_menu.Can_Be_Displayed()) {
                        System.out.println("  Advance to the next hour");
                    }
                    System.out.print("Go to  : " ) ; 
                    String choice = input.next() ; 
                    choice = choice.toUpperCase() ; 
                    
                    // !!!!!!!! securité : supprimer les espaces devant et derrriere 
                    switch (choice) {
                        case "REQUEST MENU" -> menu = 4;
                        case "WAITING PLANES" -> menu = 3;
                        case "ADVANCE HOUR" -> menu = 5;
                    }

                    break;
                
                case 2 : //runway menu
                    System.out.println("-----------RUNWAY MENU----------\n") ; 
                
                case 3 :  //waiting planes menu
                    /*
                    ● Shows an index tabled, each row contains the following:
                        ○ Plane name
                        ○ Fuel left
                    ● Option to select a plane to land
                        ○ A plane can only land when a runway is open 
                    ● Option to return to main menu

                    */

                    System.out.println("-----------WAITING PLANES MENU----------\n") ; 
                    waiting_Planes_menu.display_Waiting_menu();
                    
                    System.out.println("What do you want ? ") ;                    
                    if(RUNWAY_MENU.Call_For_Available(true, 1).size() != 0){
                        System.out.println("  Select a plane to land") ; 
                    };
                    System.out.println("  Return to main menu ") ; 
                    
                    System.out.print("You want to : " ) ; 
                    choice = input.next() ; 
                    choice = choice.toUpperCase() ; 
                    
                    // !!!!!!!! securité : supprimer les espaces devant et derrriere 
                    if(Objects.equals(choice, "SELECT A PLANE TO LAND")){
                        //code here 
                    }
                    else if(Objects.equals(choice, "RETURN TO MAIN MENU")){
                        menu = 1 ;  
                    }


                    break;
                
                case 4 : //request menu
                    System.out.println("-----------REQUESTS MENU----------\n") ; 
                
                case 5 : //advance hour menu
                    System.out.println("-----------ADVANCE HOUR MENU----------\n") ;    

                default:
                    // code block
            
            }

        }while (!exit) ;



        
        //Random rn = new Random();
        //int nb_of_request = rn.nextInt(3-1) + 1;   // user receive a random number of requests (1-3)




    }
}
