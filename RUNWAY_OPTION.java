package com.company;

public class RUNWAY_OPTION extends OPTION{
    String Requirement;
    String Consequences;

    public RUNWAY_OPTION(String option_Desc, String requirement, String consequences) {
        super(option_Desc, requirement, consequences);
    }

    public void Consequence() {

    }

    public boolean IsValid(int runway_number, boolean Is_Empty) {   // Option valid if there are runway_number number of runways either empty or full [Is_Empty == True -> Empty Runways]
        return RUNWAY_MENU.Call_For_Available(Is_Empty, runway_number).size() >= runway_number;
    }
}
