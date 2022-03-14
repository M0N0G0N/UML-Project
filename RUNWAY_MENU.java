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

    public static List<Integer> Call_For_Available(boolean Free, int Number_Of_Runways) { //If free is true, then we look to see if there's Number_Of_Runways runways that's freed of any plane. If false, then we look to see for the first runways that's occupied.
        List<Integer> All_Runways = new ArrayList<>();
        for (int i = 0; i < Runways.size(); i++) {
            if (Runways.get(i).getName_Of_Occupant() == null && Free) { //If free is true and there's nothing here, we return the whole list
                All_Runways.add(i);
                if (All_Runways.size() == Number_Of_Runways)
                    return All_Runways;
            }
            else if (Runways.get(i).getName_Of_Occupant() != null && !Free) { //If free is false and there's a plane here, we return whole list
                All_Runways.add(i);
                if (All_Runways.size() == Number_Of_Runways)
                    return All_Runways;
            }
        }
        return All_Runways; //If nothing was found then we return an empty list.
    }

    public static void Advance_hour_Runway() {
        for (RUNWAY runways : Runways) {
            runways.Add_Occupied_Time(-1);
        }
    }

}
