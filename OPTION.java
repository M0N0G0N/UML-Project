package com.company;

import java.util.ArrayList;

public class OPTION {
    String Option_Desc;
    String Requirement;
    String Consequences;

    public OPTION(String option_Desc, String requirement, String consequences) {
        Option_Desc = option_Desc;
        Requirement = requirement;
        Consequences = consequences;
    }

    public boolean IsValid() { //PlaceHolder until we can find something better maybe?
        return true;
    }

    public boolean IsValid(int runway_number, boolean Is_Empty) {   // Option valid if there are runway_number number of runways either empty or full [Is_Empty == True -> Empty Runways]
        return RUNWAY_MENU.Call_For_Available(Is_Empty, runway_number).size() >= runway_number;
    }

    public boolean IsValid(int Plane_Number) {
        return WAITING_PLANES_MENU.Call_For_Waiting_Planes() > 0;
    }

    public void Display_Option() {

    }

    public void Consequence() {

    }

    public String toString() {
        return "\nOPTION \n"
                + "   Description = " + Option_Desc+
                "\n   Requirement = " + Requirement +
                "\n   Consequence = " + Consequences + 
                "\n" ;  
    }


}
