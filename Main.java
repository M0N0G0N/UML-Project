package com.company;
import java.util.* ; 

public class Main {

    public static void main(String[] args) {
                
        //Random rn = new Random();
        //int nb_of_request = rn.nextInt(3-1) + 1;   // user receive a random number of requests (1-3)

        
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


        RUNWAY_MENU runway_Menu = new RUNWAY_MENU(8); 
        WAITING_PLANES_MENU waiting_Planes_menu = new WAITING_PLANES_MENU() ; 
        ADVANCE_HOUR_MENU advance_Hour = new ADVANCE_HOUR_MENU() ; 
        REQUESTS_MENU requests_menu = REQUESTS_MENU() ; 
        
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
                    int index = 1 ; 
                    System.out.println("-----------Menu Options----------") ; 
                    if (requests_menu.Can_Be_Displayed()) {
                        System.out.println(index + ")  Request Menu");
                        i++ ; 
                    }                    
                    System.out.println(index + ")  Waiting Planes Menu");
                    i++ ; 
                    if (requests_menu.Can_Be_Displayed()==false ) {
                        System.out.println(index + ")  Advance to the next hour");
                        i++ ; 
                    }
                    System.out.print("Go to  : " ) ; 
                    menu = input.nextInt() ; 
                    index = 1 ; //reset index
                    break;
                
                case 2 : //runway menu

                
                case 3 :  //waiting planes menu
                    /*
                    ● Shows an index tabled, each row contains the following:
                        ○ Plane name
                        ○ Fuel left
                    ● Option to select a plane to land
                        ○ A plane can only land when a runway is open 
                    ● Option to return to main menu

                    */

                    waiting_Planes_menu.display_Waiting_menu();
                    
                    System.out.println("What do you want ? ") ;                    
                    if(runway_Menu.Call_For_Available(true) != -1){
                        System.out.println(index+ ")  Select a plane to land") ; 
                    };
                    Sytem.out.out.println(index + ")  Return to main menu ") ; 
                    System.out.print("Go to ");
                    int choice = input.nextInt() ; 

                    //PROBLEME : pas tjrs le meme index 
                    break;
                
                

                default:
                    // code block
            
            }

        }while (exit == false) ; 



        
        //Random rn = new Random();
        //int nb_of_request = rn.nextInt(3-1) + 1;   // user receive a random number of requests (1-3)




    }
}
