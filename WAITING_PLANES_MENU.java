package com.company;
import java.awt.*;
import java.util.*;
import java.util.List;

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
    public static boolean Can_Plane_Land() { //Return False if nothing is returned.
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
    
    public static void call_Waiting_menu() {  //return -1 to return to main menu
        Display_Index() ; 
        String choice ; 
        Scanner input = new Scanner(System.in) ; 
        do {
            System.out.println("INPUT \"SELECT\" to select a plane to land") ; 
            System.out.println("INPUT \"MAIN\" to return to the main menu") ; 
            System.out.print("\n--> : ");
            choice = input.nextLine();
            choice = choice.toUpperCase();
    
            if (Objects.equals(choice, "SELECT")){
                if (Call_For_Waiting_Planes() > 0 && Can_Plane_Land()){ //If there are any planes in the air AND there is a free runway
                    String plane_to_land ; //name of the plane
                    do {
                        System.out.println("INPUT the name of the plane you want to land. Input \"MAIN\" to return to the main menu: ") ;
                        plane_to_land = input.nextLine(); 
                        plane_to_land = plane_to_land.toUpperCase() ;
                        if(Call_for_existing_plane(plane_to_land)){ //If the plane cannot be found
                            System.out.println("Plane doesn't exist, please verify your input. \n") ;
                        } else { //If the plane can be found
                            REQUESTS_MENU.Remote_Validate_Request(plane_to_land);
                        }
                    } while (Can_Plane_Land() && Call_For_Waiting_Planes() > 0 && !Objects.equals(choice, "MAIN"));
                }
                else if (Call_For_Waiting_Planes() < 0) {
                    System.out.println("There's no plane to land. Returning to main Menu...");
                    choice = "MAIN";
                }
                else if (!Can_Plane_Land()) {
                    System.out.println("There are no more runways available.");
                    choice = "MAIN";
                }
            }
            else if (Objects.equals(choice, "MAIN")){
                break;
            }
            else {
                System.out.println("ERROR: COMMAND NOT RECOGNIZED. PLEASE TRY AGAIN \n ");
            }
        } while (!Objects.equals(choice, "MAIN"));
    }

    public static boolean Call_for_existing_plane(String plane_name){
        for (PLANE planes : Planes){
            if (Objects.equals(planes.getName(), plane_name)){
                return false;
            }
        }
        return true;
    }

    public static int Call_For_Waiting_Planes() {
        return Planes.size();
    }

    public static void Advance_hour_Waiting_Planes() {
        Iterator<PLANE> planes = Planes.listIterator();
        while (planes.hasNext()) { //Apparently IntelliJ doesn't like this
            planes.next().Add_Fuel(-1);
        }
    }
}

