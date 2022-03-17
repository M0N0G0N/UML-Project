package com.company;

import jdk.incubator.foreign.Addressable;

public class NO_REQUIREMENT_OPTION extends OPTION{
    PLANE Plane; //The plane that will wait in the air if chosen.
    Integer Save_And_Kill_People; //Leave null if unused. Will kill or save people (negative: save, positive: kill).
    Integer Add_Fuel; //Leave null if unused. Will remove or add fuel to planes (negative: remove fuel, positive: add fuel)
    Integer Add_Wait_Time; //Leave null if unused. Will add wait time to planes on runways (negative: remove wait time, positive: add wait time)


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

    public void Consequences() {
        if (Plane != null) {
            WAITING_PLANES_MENU.Add_Plane(Plane);
        }
        if (Save_And_Kill_People != null) {
            ADVANCE_HOUR_MENU.setPassengers(ADVANCE_HOUR_MENU.Passengers + Save_And_Kill_People);
        }
        if (Add_Fuel != null && WAITING_PLANES_MENU.Planes != null) { //We have to have planes in the air to give them fuel
            for (PLANE planes : WAITING_PLANES_MENU.Planes) {
                planes.Add_Fuel(Add_Fuel);
            }
        }
        if (Add_Wait_Time != null && RUNWAY_MENU.Call_For_Available(true, 1).size() > 0) {
            for (RUNWAY runways : RUNWAY_MENU.Runways) {
                runways.Add_Occupied_Time(Add_Wait_Time);
            }
        }
    }
}
