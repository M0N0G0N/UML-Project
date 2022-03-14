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

    public boolean IsValid(int free_runway, ArrayList<RUNWAY> runway) {   // Option valid if there are free_runway number of runways empty 
        int count = 0 ; 
        for ( int i = 0 ; i<runway.size()-1 ; i++ ){
            if (runway.get(i).is_Free_Runway()){  
                count ++ ; 
            }
        }
        if(count >= free_runway ){
            return true ; 
        }
        else{
            return false  ; 
        } 

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
