package com.company;

import jdk.incubator.foreign.Addressable;

import java.util.Random;

public class NO_REQUIREMENT_OPTION extends OPTION{
    PLANE Plane; //The plane that will wait in the air if chosen.
    Integer Save_And_Kill_People; //Leave null if unused. Will kill or save people (negative: save, positive: kill).
    Integer Add_Fuel; //Leave null if unused. Will remove or add fuel to planes (negative: remove fuel, positive: add fuel)
    Integer Add_Wait_Time; //Leave null if unused. Will add wait time to planes on runways (negative: remove wait time, positive: add wait time)
    boolean Waiting_plane = false; //If true, checks if there are any waiting planes in the air. Remove a random waiting plane


    public NO_REQUIREMENT_OPTION(String option_Desc, String requirement, String consequences, PLANE plane) {
        super (option_Desc, requirement, consequences);
        Plane = plane;
    }

    public NO_REQUIREMENT_OPTION(String option_Desc, String requirement, String consequences, Integer save_And_Kill_People, Integer add_Fuel, Integer add_Wait_Time) {
        super (option_Desc, requirement, consequences);
        Save_And_Kill_People = save_And_Kill_People;
        Add_Fuel = add_Fuel;
        Add_Wait_Time = add_Wait_Time;
    }

    public NO_REQUIREMENT_OPTION(String option_Desc, String requirement, String consequences, Integer save_And_Kill_People) {
        super (option_Desc, requirement, consequences);
        Save_And_Kill_People = save_And_Kill_People;
        Waiting_plane = true ;
    }

    public boolean Consequences() {
        if (Plane != null) { //If we passed a plane here, then it means that we have to let it wait. And then we have to give this one to Next_Hour_Requests
            WAITING_PLANES_MENU.Add_Plane(Plane);
            return true;
        }
        if (Save_And_Kill_People != null) { //If we have any people to save or kill, then it means we do it there
            ADVANCE_HOUR_MENU.setPassengers(ADVANCE_HOUR_MENU.Passengers + Save_And_Kill_People);
        }
        if (Add_Fuel != null && WAITING_PLANES_MENU.Planes != null) { //We have to have planes in the air to give them fuel
            for (PLANE planes : WAITING_PLANES_MENU.Planes) {
                planes.Add_Fuel(Add_Fuel); //We add or take away fuel
            }
        }
        if (Add_Wait_Time != null && RUNWAY_MENU.Call_For_Available(true, 1).size() > 0) { //If we have *any* runway occupied
            for (RUNWAY runways : RUNWAY_MENU.Runways) {
                runways.Add_Occupied_Time(Add_Wait_Time); //We mess with their fuel ÒwÓ
            }
        }
        if (Waiting_plane){
           if (WAITING_PLANES_MENU.Call_For_Waiting_Planes()>0){
                Random random = new Random();
                int rd = random.nextInt(WAITING_PLANES_MENU.Call_For_Waiting_Planes()) ;
                WAITING_PLANES_MENU.Planes.remove(rd); 
           }
        }
        return false;
    }
}
