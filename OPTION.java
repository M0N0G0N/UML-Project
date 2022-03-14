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

    public boolean IsValid() {
        return bool  ; 
    }

    public boolean IsValid(int free_runway) {   // Option valid if there are free_runway number of runways empty
        return RUNWAY_MENU.Call_For_Available(true, free_runway).size() >= free_runway;
    }

    public boolean IsValid(PLANE Planes) {
        return bool ; 
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
