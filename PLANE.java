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

    public void Add_Fuel(int Fuel_Added){ //Adds or Remove fuel to the plane, calls Kill_Plane to see if there's still fuel
        Fuel_Left = Fuel_Left + Fuel_Added;
        Kill_Plane(true);
    }

    public void Kill_Passengers(int Killed_Passengers) { //Kill Passengers, and calls Kill_Plane to check if they're all dead
        Dead_Passengers = Dead_Passengers + Killed_Passengers;
        ADVANCE_HOUR_MENU.setPassengers(Killed_Passengers);
        ADVANCE_HOUR_MENU.Collect_Events(Killed_Passengers + " passengers died.");
        Kill_Plane(false);
    }

    public void Kill_Plane(boolean Kill){ //If everyone is dead or there is no fuel left, kill the plane.
        if (Total_Passengers == Dead_Passengers) {
            //TODO: print warning that a plane died because every passenger is dead
            ADVANCE_HOUR_MENU.Collect_Events("Plane " + name + " died because there were no more alive passengers in it");
            WAITING_PLANES_MENU.Remove_Plane(name);
        }
        else if (Fuel_Left == 0) {
            //TODO: print warning that a plane died because there is no fuel left
            ADVANCE_HOUR_MENU.Collect_Events("Plane " + name + " died because there was no fuel left.");
            if (Kill) {
                ADVANCE_HOUR_MENU.setPassengers(Total_Passengers - Dead_Passengers);
                ADVANCE_HOUR_MENU.Collect_Events(Total_Passengers - Dead_Passengers + " passengers died.");
            }
            WAITING_PLANES_MENU.Remove_Plane(name);
        }
    }
}
