package com.company;
import java.util.ArrayList;
import java.util.List;

public class RUNWAY_MENU extends MENU{
    static List<RUNWAY> Runways = new ArrayList<>();

    public RUNWAY_MENU(int Number_Of_Runways) {
        for(int i = 0; i < Number_Of_Runways; i++) {
            Runways.add(new RUNWAY(i, null, 0)); //Uses a for loop to create the number of Runways we want at the start
        }
    }

    public void Display_Index() {

    }

    public void Add_Runway() {
        Runways.add(new RUNWAY(Runways.size(), null, 0)); //Adds a runway at the end of the list
    }

    public void Delete_Runway (int To_Delete) { //To_Delete is the index of the Runway we want to delete
        Runways.remove(To_Delete); //Removes the runway at a specific index
        for (int i = To_Delete; i < Runways.size(); i++) {
            Runways.get(i).setRunway_Number(i); //Changes the number of each runway so there's no hole
        }
    }

    public int Call_For_Available(boolean Free) { //If free is true, then we look to see if there's a runway that's freed of any plane. If false, then we look to see for the first runway that's occupied.
        for (int i = 0; i < Runways.size(); i++) {
            if (Runways.get(i).getName_Of_Occupant() == null && Free) //If free is true and there's nothing here, we return the index
                return i;
            else if (Runways.get(i).getName_Of_Occupant() != null && !Free) //If free is false and there's a plane here, we return the index
                return i;
        }
        return -1; //Else, we return -1 to show that there's no result available.
    }



}
