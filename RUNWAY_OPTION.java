package com.company;

import java.util.ArrayList;
import java.util.List;

public class RUNWAY_OPTION extends OPTION{
    boolean Needs_To_Be_Empty; //If true, the Option will check if the Runway is empty, else, it will check if it's full.
    int Runways_Affected; //Numbers of Runways that will be affected.
    PLANE Affected_Plane; //Plane Affected by that choice. If null, will look for the following statements:
    boolean Empty_Runway; //If true, then it empties a random runway. Else, it will bar a runway from being available again.

    public RUNWAY_OPTION(String option_Desc, String requirement, String consequences, PLANE affected_Plane) { //Use this constructor when you want to land a plane.
        super(option_Desc, requirement, consequences);
        Affected_Plane = affected_Plane;
    }

    public RUNWAY_OPTION(String option_Desc, String requirement, String consequences, boolean empty_Runway) { //Use this constructor when you want to free or occupy a random Runway as an event.
        super(option_Desc, requirement, consequences);
        Empty_Runway = empty_Runway;
    }

    public void Consequence() { //Simply use this when the option is chosen, the method will do the rest.
        List<Integer> Affected_Runways = new ArrayList<>();
        Affected_Runways = RUNWAY_MENU.Call_For_Available(Needs_To_Be_Empty, Runways_Affected);
        for (Integer runway_Indexes : Affected_Runways) {
            if (Affected_Plane != null) {
                try {
                    WAITING_PLANES_MENU.Pass_To_Runway(Affected_Plane); //If the plane in question was in the waiting planes
                } catch (Exception exception) {
                    RUNWAY_MENU.Runways.get(runway_Indexes).Receive_Plane(Affected_Plane);
                }
            }
            else if (Empty_Runway) {
                RUNWAY_MENU.Runways.get(runway_Indexes).Free_Runway();
            }
            else {
                RUNWAY_MENU.Delete_Runway(runway_Indexes);
            }
        }
    }

    public boolean IsValid() {   // Option valid if there are runway_number number of runways either empty or full [Is_Empty == True -> Empty Runways]
        return RUNWAY_MENU.Call_For_Available(Needs_To_Be_Empty, Runways_Affected).size() >= Runways_Affected;
    }
}
