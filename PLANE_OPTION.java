package com.company;

public class PLANE_OPTION extends OPTION{
    boolean Waiting_Planes_In_The_Air; //If true, checks if there are any waiting planes in the air.
    int Refuel_Time; //Hours granted by the refuel time.

    public PLANE_OPTION(String option_Desc, String requirement, String consequences, int refuel_Time, boolean waiting_Planes_In_The_Air) {
        super(option_Desc, requirement, consequences);
        Refuel_Time = refuel_Time;
        Waiting_Planes_In_The_Air = waiting_Planes_In_The_Air;
    }

    public void Consequences() { //Just call the method when needed, it will do the rest.
        for (int i = 0; i < WAITING_PLANES_MENU.Call_For_Waiting_Planes(); i++) {
            WAITING_PLANES_MENU.Planes.get(i).Add_Fuel(Refuel_Time); //Adds fuel in the tank of flying planes.
        }
    }

    public boolean IsValid() { //Checks if the requirements are met.
        if (Waiting_Planes_In_The_Air && WAITING_PLANES_MENU.Call_For_Waiting_Planes() > 0) //Checks if there are flying planes in the air.
            return true;
        else return !Waiting_Planes_In_The_Air && WAITING_PLANES_MENU.Call_For_Waiting_Planes() == 0; //Checks if there aren't any flying planes in the air.
    }
}