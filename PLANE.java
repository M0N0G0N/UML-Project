package com.company;

public class PLANE {
    String name;
    int Total_Passengers;
    int Dead_Passengers;
    int Fuel_Left;
    int Refuel_Time;

    public PLANE() {
        //TODO: make a name randomizer
        //TODO: make a Total Passenger randomizer
        Dead_Passengers = 0;
        //TODO: make a Fuel_Left randomizer
        //TODO: make a Refuel_Time randomizer
    }

    public void Add_Fuel(int Fuel_Added){
        Fuel_Left = Fuel_Left + Fuel_Added;
        Kill_Plane(true);
    }

    public void Kill_Passengers(int Killed_Passengers) { //Kill Passengers
        Dead_Passengers = Dead_Passengers - Killed_Passengers;
        Kill_Plane(false);
    }

    public void Kill_Plane(boolean Kill){
        if (Total_Passengers == Dead_Passengers) {
            //TODO: print warning that a plane died because every passenger is dead
        }
        else if (Fuel_Left == 0) {
            //TODO: print warning that a plane died because there is no fuel left
            Dead_Passengers = Total_Passengers;
            ADVANCE_HOUR_MENU.setPassengers(Total_Passengers);
        }
    }
}
