package com.company;
import javax.naming.Name;
import java.util.* ;

public class RUNWAY {
    int Runway_Number;
    static PLANE Name_Of_Occupant;
    static int Occupied_Time_Remaining;

    public RUNWAY(int runway_Number, PLANE name_Of_Occupant, int occupied_Time_Remaining) {
        Runway_Number = runway_Number;
        Name_Of_Occupant = name_Of_Occupant;
        Occupied_Time_Remaining = occupied_Time_Remaining;
    }

    public void Add_Occupied_Time(int Time) { //Adds or subtracts time to Occupied_Time_Remaining, then calls Is_Free in case the time is up.
        Occupied_Time_Remaining = Occupied_Time_Remaining + Time;
        Is_Free();
    }

    public void Is_Free() { //Checks if the runway has to be emptied
        if (Occupied_Time_Remaining == 0 || Name_Of_Occupant == null) {
            Free_Runway();
        }
    }

    public void Free_Runway() { //Empties the runway
        Name_Of_Occupant = null;
        Occupied_Time_Remaining = 0;
    }

    public static void Receive_Plane(PLANE Plane) { //Receives a plane to occupy the Runway.
        Name_Of_Occupant = Plane;
        Occupied_Time_Remaining = Plane.Refuel_Time;
    }

    public void setRunway_Number(int runway_Number) {
        Runway_Number = runway_Number;
    }

    public PLANE getName_Of_Occupant() {
        return Name_Of_Occupant;
    }








}