package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WAITING_PLANES_MENU extends MENU{
    static List<PLANE> Planes = new ArrayList<>();

    public WAITING_PLANES_MENU() { //The constructor starts with no planes, but will add more once Create_Plane is called.

    }

    public static void Add_Plane(PLANE NEW_PLANE) {
        Planes.add(NEW_PLANE);
    }

    public void Display_Index() {
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
    public boolean Can_Plane_Land() { //Return False if -1 is returned.
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

    public static void display_Waiting_menu() {//TODO: rajouter nombre de passagers total, nombre de passagers morts, Runway time
        System.out.println("----------Waiting planes--------");
        System.out.println("Plane name      | Fuel left         ");
        for (PLANE plane : Planes) {
            System.out.println(plane.name + "       | " + plane.Fuel_Left + "\n");
        }
        System.out.println("\n"); 
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
