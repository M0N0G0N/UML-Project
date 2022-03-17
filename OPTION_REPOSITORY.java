package com.company;

import java.util.ArrayList;
import java.util.List;

public final class OPTION_REPOSITORY { //Add options here to use them in the REQUESTS_MENU

    public static List<OPTION> Standard_Plane() {
        List<OPTION> Standard_Plane_Options = new ArrayList<>();
        PLANE Standard_Plane = new PLANE("STANDARD");
        Standard_Plane_Options.add(new RUNWAY_OPTION("Allow Landing", "1 Empty Runway", "Plane lands and occupies Runway for stated time", Standard_Plane, 1));
        Standard_Plane_Options.add(new NO_REQUIREMENT_OPTION("Place on Standby", "None", "Airplane joins \"waiting\" planes", Standard_Plane));
        return Standard_Plane_Options;
    }

    public static List<OPTION> Jumbo_Plane() {
        List<OPTION> Jumbo_Plane_Options = new ArrayList<>();
        PLANE Jumbo_Plane = new PLANE("JUMBO");
        Jumbo_Plane_Options.add(new RUNWAY_OPTION("Allow Landing", "1 Empty Runway", "Plane lands and occupies Runway for stated time", Jumbo_Plane, 1));
        Jumbo_Plane_Options.add(new NO_REQUIREMENT_OPTION("Place on Standby", "None", "Airplane joins \"waiting\" planes", Jumbo_Plane));
        return Jumbo_Plane_Options;
    }

    public static List<OPTION> Emergency_Landing() {
        List<OPTION> Emergency_Plane_Options = new ArrayList<>();
        PLANE Emergency_Plane = new PLANE("EMERGENCY");
        Emergency_Plane_Options.add(new RUNWAY_OPTION("Allow Landing", "1 Empty Runway", "Plane lands and occupies Runway for stated time", Emergency_Plane, 1));
        Emergency_Plane_Options.add(new NO_REQUIREMENT_OPTION("Place on Standby", "None", "Airplane joins \"waiting\" planes", Emergency_Plane));
        return Emergency_Plane_Options;
    }

    public static List<OPTION> Funding_Event() {
        List<OPTION> Funding_Event_Options = new ArrayList<>();
        Funding_Event_Options.add(new RUNWAY_OPTION("Empty Random Runway", "1 full runway", "Empties a random runway", true, 1));
        Funding_Event_Options.add(new NO_REQUIREMENT_OPTION("Rescue Team", "None", "Rescue 100 people", -100, null, null));
        Funding_Event_Options.add(new PLANE_OPTION("Air Refueling", "At least one plane in the air", "All waiting airplanes get 2 more hours of fuel", 2, true));
        return Funding_Event_Options;
    }

    public List<OPTION> Bad_Weather() {
        List<OPTION> Bad_Weather_Options = new ArrayList<>();
        Bad_Weather_Options.add(new NO_REQUIREMENT_OPTION("Cross winds", "None", "Remove 1 hour of fuel from all waiting planes in air", null,-1,null));
        Bad_Weather_Options.add(new NO_REQUIREMENT_OPTION("Icy ru ways", "None", "Add 2 hours wait time to all planes waiting in runway", null, null,2));
        Bad_Weather_Options.add(new RUNWAY_OPTION("Ice storm", "At least 1 runway", "Remove a runway",false,-1));
        return Bad_Weather_Options;
    }

    public List<OPTION> Snakes_on_plane() {
    List<OPTION> Snakes_on_plane_Options = new ArrayList<>();
    PLANE Snakes_on_plane = new PLANE("SNAKES");
        Snakes_on_plane_Options.add(new RUNWAY_OPTION("Let them land", "Free run way", "Plane will occupy runway for 7 hours", 7,1));
        Snakes_on_plane_Options.add(new NO_REQUIREMENT_OPTION("Refuse them", "None", "Counts as letting 50 people die", -50,null,null));
        return Snakes_on_plane_Options;
    }
}
