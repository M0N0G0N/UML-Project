package com.company;
import javax.naming.Name;
import java.util.* ;

public class RUNWAY {
    int Runway_Number;
    PLANE Landed_Plane;
    int Occupied_Time_Remaining;

    public RUNWAY(int runway_Number, PLANE landed_Plane, int occupied_Time_Remaining) {
        Runway_Number = runway_Number;
        Landed_Plane = landed_Plane;
        Occupied_Time_Remaining = occupied_Time_Remaining;
    }

    public void Add_Occupied_Time(int Time) { //Adds or subtracts time to Occupied_Time_Remaining, then calls Is_Free in case the time is up.
        Occupied_Time_Remaining = Occupied_Time_Remaining + Time;
        Is_Free();
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

    public void Receive_Plane(PLANE Plane) { //Receives a plane to occupy the Runway.
        Landed_Plane = Plane;
        Occupied_Time_Remaining = Plane.Refuel_Time;
    }

    public void setRunway_Number(int runway_Number) {
        Runway_Number = runway_Number;
    }

    public PLANE getLandedPlane() {
        return Landed_Plane;
    }

    public int getOccupied_Time_Remaining() {
        return Occupied_Time_Remaining;
    }
}