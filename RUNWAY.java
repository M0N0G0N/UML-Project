package com.company;
import javax.naming.Name;
import java.util.* ;

public class RUNWAY {
    int Runway_Number;
    static PLANE Landed_Plane;
    static int Occupied_Time_Remaining;

    public RUNWAY(int runway_Number, PLANE name_Of_Occupant, int occupied_Time_Remaining) {
        Runway_Number = runway_Number;
        Landed_Plane = name_Of_Occupant;
        Occupied_Time_Remaining = occupied_Time_Remaining;
    }

    public void Is_Free() { //Checks if the runway has to be emptied
        if (Occupied_Time_Remaining == 0 || Landed_Plane == null) {
            Free_Runway();
        }
    }

    public void Free_Runway() { //Empties the runway
        Landed_Plane = null;
        Occupied_Time_Remaining = 0;
    }

    public static void Receive_Plane(PLANE Plane) { //Receives a plane to occupy the Runway.
        Landed_Plane = Plane;
        Occupied_Time_Remaining = Plane.Refuel_Time;
    }

    public void setRunway_Number(int runway_Number) {
        Runway_Number = runway_Number;
    }

    public PLANE getName_Of_Occupant() {
        return Landed_Plane;
    }








}