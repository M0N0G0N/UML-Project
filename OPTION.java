package com.company;

import java.util.ArrayList;

//FAIRE DES SOUS CLASSES

public class OPTION {
    String Option_Desc;
    String Requirement;
    String Consequences;

    public OPTION(String option_Desc, String requirement, String consequences) {
        Option_Desc = option_Desc;
        Requirement = requirement;
        Consequences = consequences;
    }

    public void Display_Option() {

    }

    public String toString() {
        return "\nOPTION \n"
                + "   Description = " + Option_Desc +
                "\n   Requirement = " + Requirement +
                "\n   Consequence = " + Consequences +
                "\n" ;  
    }


}
