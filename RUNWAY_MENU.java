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

    public static void Display_Index() {
        System.out.println("Current occupied runway: " + Runways.size());
        System.out.println("Name of the runway");
        int Biggest_Name = 0;
        for (RUNWAY runways : Runways) {
            try {
                if (Biggest_Name < runways.getLandedPlane().getName().length())
                    Biggest_Name = runways.getLandedPlane().getName().length();
            } catch (Exception ignore){
            }
        }
        if (Biggest_Name % 2 != 0)
            Biggest_Name++;
        System.out.println("* -" + " -".repeat((84 + Biggest_Name) / 2) + " *");
        System.out.println("| NUMBER OF RUNWAYS LEFT : " + Runways.size() + "  ".repeat(((62 + Biggest_Name) / 2) - String.valueOf(Runways.size()).length()) + "|");
        System.out.println("* -" + " -".repeat((84 + Biggest_Name) / 2) + " *");
        System.out.println("| RUNWAY INDEX | OCCUPYING PLANE " + " ".repeat(Math.abs(Biggest_Name - 15)) + "| NUMBER OF HOURS LEFT | NUMBER OF DEAD PASSENGERS | TOTAL PASSENGERS |");
        System.out.println("* -" + " -".repeat((84 + Biggest_Name) / 2) + " *");
        for (int i = 0; i < Runways.size(); i++) {
            try {
                System.out.println("| " + i + " ".repeat(13 - String.valueOf(i).length())
                        + "| " + Runways.get(i).getLandedPlane().name + " ".repeat(Biggest_Name - Runways.get(i).getLandedPlane().name.length() + 1)
                        + "| " + Runways.get(i).getOccupied_Time_Remaining() + " ".repeat(21 - String.valueOf(Runways.get(i).getOccupied_Time_Remaining()).length())
                        + "| " + Runways.get(i).getLandedPlane().Dead_Passengers + " ".repeat(26 - String.valueOf(Runways.get(i).getLandedPlane().Dead_Passengers).length())
                        + "| " + Runways.get(i).getLandedPlane().Total_Passengers +  " ".repeat(17 - String.valueOf(Runways.get(i).getLandedPlane().Total_Passengers).length())
                        + "|");
                System.out.println("* -" + " -".repeat((84 + Biggest_Name) / 2) + " *");
            } catch (Exception ignore) {
            }
        }
    }

    public void Delete_Runway (int To_Delete) { //To_Delete is the index of the Runway we want to delete
        Runways.get(To_Delete).Free_Runway();
        Runways.get(To_Delete).Add_Occupied_Time(72);//Removes the runway at a specific index
        ADVANCE_HOUR_MENU.Collect_Events("RUNWAY " + To_Delete + " HAS BEEN FROZEN, AND IS NOW UNUSABLE.");
    }

    public static List<Integer> Call_For_Available(boolean Free, int Number_Of_Runways) { //If free is true, then we look to see if there's Number_Of_Runways runways that's freed of any plane. If false, then we look to see for the first runways that's occupied.
        List<Integer> All_Runways = new ArrayList<>();
        for (int i = 0; i < Runways.size(); i++) {
            if (Runways.get(i).getLandedPlane() == null && Free) { //If free is true and there's nothing here, we return the whole list
                All_Runways.add(i);
                if (All_Runways.size() == Number_Of_Runways)
                    return All_Runways;
            }
            else if (Runways.get(i).getLandedPlane() != null && !Free) { //If free is false and there's a plane here, we return whole list
                All_Runways.add(i);
                if (All_Runways.size() == Number_Of_Runways)
                    return All_Runways;
            }
        }
        return All_Runways; //If nothing was found then we return an empty list.
    }

    /*
    public boolean there_is_free_runway() {
    }
    */

    public static void Advance_hour_Runway() {
        for (RUNWAY runways : Runways) {
            runways.Add_Occupied_Time(-1);
        }
    }

}
