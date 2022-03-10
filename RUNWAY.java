package com.company;

public class RUNWAY {
    int Runway_Number;
    PLANE Name_Of_Occupant;
    int Occupied_Time_Remaining;

    public RUNWAY(int runway_Number, PLANE name_Of_Occupant, int occupied_Time_Remaining) {
        Runway_Number = runway_Number;
        Name_Of_Occupant = name_Of_Occupant;
        Occupied_Time_Remaining = occupied_Time_Remaining;
    }

    public void Add_Occupied_Time(int Time) {
        this.Occupied_Time_Remaining = this.Occupied_Time_Remaining + Time;
    }

    public void Free_Runway() {
        this.Name_Of_Occupant = null;
        this.Occupied_Time_Remaining = 0;
    }

    public void setRunway_Number(int runway_Number) {
        Runway_Number = runway_Number;
    }

    public PLANE getName_Of_Occupant() {
        return Name_Of_Occupant;
    }
}