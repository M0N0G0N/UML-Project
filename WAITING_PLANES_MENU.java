package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WAITING_PLANES_MENU extends MENU{
    static List<PLANE> Planes = new ArrayList<>();

    public WAITING_PLANES_MENU() { //The constructor starts with no planes, but will add more once Create_Plane is called.

    }

    public static void Add_Plane(PLANE NEW_PLANE) {
        Planes.add(NEW_PLANE);
    }

    public static void Display_Index() {
        System.out.println("\n----------Waiting planes--------\n");
        System.out.println("Plane name      | Fuel left      | Number of dead passengers       | Total number of passengers      | ");
        for (PLANE plane : Planes) {
            System.out.println(plane.name + "       | " + plane.Fuel_Left +  "       | "+ plane.Dead_Passengers +  "       | " + plane.Total_Passengers + "\n");
        }
        System.out.println("\n"); 
    }

    public static void Remove_Plane(String Plane_Name) {
        for (int i = 0; i < Planes.size(); i++) {
            if (Objects.equals(Plane_Name, Planes.get(i).name)) {
                Planes.remove(i);
                return;
            }
        }
    }


    //FIXME: unnecessary function?
    public static boolean Can_Plane_Land() { //Return False if -1 is returned.
        return RUNWAY_MENU.Call_For_Available(true, 1).size() != 0;  //TODO : Use "there_is_free_runway" functions
    }

    public static void Pass_To_Runway(String name) {
        for (PLANE plane : Planes) {
            if (Objects.equals(name, plane.getName())) {
                Pass_To_Runway(plane);
                return;
            }
        }
    }

    public static void Pass_To_Runway(PLANE Plane) {
        RUNWAY_MENU.Runways.get(RUNWAY_MENU.Call_For_Available(true, 1).get(0)).Receive_Plane(Plane);
        System.out.println("Occupied Runway: " + RUNWAY_MENU.Call_For_Available(true, 1).get(0));
        Planes.remove(Plane);
        ADVANCE_HOUR_MENU.Collect_Events("PLANE " + Plane.name + " HAS LANDED ON A RUNWAY");
    }

    public static int call_Waiting_menu() {  //return -1 to return to main menu 
        Display_Index() ; 
        String choice ; 
        Scanner input = new Scanner(System.in) ; 
        do {
            System.out.println("INPUT \"SELECT\" to select a plane to land") ; 
            System.out.println("INPUT \"MAIN\" to return to the main menu\n") ; 
            System.out.print("\nINPUT : ");
            choice = input.nextLine();
            //choice = choice.toUpperCase();
    
            if (choice == "SELECT" ){
                System.out.println("\n\n OKKKKKKKKKKK v\n\n") ; 
                if (Can_Plane_Land()){
                    String plane_to_land ; //name of the plane
                    do{
                        System.out.println("INPUT the name of the plane you want to land : ") ;
                        plane_to_land = input.nextLine(); 
                        plane_to_land.toUpperCase() ; 
                        if(Call_for_existing_plane(plane_to_land)!= true ){
                            System.out.println("Plane doesn't exist, please verify your input. \n") ;
                        }
                    }while (Call_for_existing_plane(plane_to_land) != true );
                    Pass_To_Runway(plane_to_land) ; 
                }
                else {
                    System.out.println("There's no plane to land");
                }
                return 0 ; 
            }
            else if (choice == "MAIN"){
                return -1 ; 
            }
            else {
                System.out.println("ERROR INPUT try again \n ");
                return 0 ; 
            }
        }while (choice != "SELECT" && choice !="MAIN" ) ; 

    }

    public static boolean Call_for_existing_plane(String plane_name){
        boolean exist = false ; 
        for (PLANES planes : Planes){
            if (planes.getName == plane_name ){
                exist = true ; 
                break ; 
            }
        }
        return exist ; 
    }

    public static int Call_For_Waiting_Planes() {
        return Planes.size();
    }

    public static void Advance_hour_Waiting_Planes() {
        for (PLANE planes : Planes) {
            planes.Add_Fuel(-1);
        }
    }

}
