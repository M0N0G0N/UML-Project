package com.company;
import java.util.* ; 

public class Main {

    public static void main(String[] args) {
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
        
        System.out.println("Option chosen : " + requests_Options[option ]) ; 




        
        //Random rn = new Random();
        //int nb_of_request = rn.nextInt(3-1) + 1;   // user receive a random number of requests (1-3)




    }
}
