package com.company;

import java.util.ArrayList;
import java.util.List;

public final class OPTION_REPOSITORY { //Add options here to use them in the REQUESTS_MENU

    public List<OPTION> Standard_Plane() {
        List<OPTION> Standard_Plane_Options = new ArrayList<>();
        PLANE Standard_Plane = new PLANE("STANDARD");
        Standard_Plane_Options.add(new RUNWAY_OPTION("Allow Landing", "1 Empty Runway", "Plane lands and occupies Runway for stated time", Standard_Plane, 1));
        Standard_Plane_Options.add(new NO_REQUIREMENT_OPTION("Place on Standby", "None", "Airplane joins \"waiting\" planes", Standard_Plane));
        return Standard_Plane_Options;
    }

    public List<OPTION> Jumbo_Plane() {
        List<OPTION> Jumbo_Plane_Options = new ArrayList<>();
        PLANE Jumbo_Plane = new PLANE("JUMBO");
        Jumbo_Plane_Options.add(new RUNWAY_OPTION("Allow Landing", "1 Empty Runway", "Plane lands and occupies Runway for stated time", Jumbo_Plane, 1));
        Jumbo_Plane_Options.add(new NO_REQUIREMENT_OPTION("Place on Standby", "None", "Airplane joins \"waiting\" planes", Jumbo_Plane));
        return Jumbo_Plane_Options;
    }

    public List<OPTION> Emergency_Landing() {
        List<OPTION> Emergency_Plane_Options = new ArrayList<>();
        PLANE Emergency_Plane = new PLANE("EMERGENCY");
        Emergency_Plane_Options.add(new RUNWAY_OPTION("Allow Landing", "1 Empty Runway", "Plane lands and occupies Runway for stated time", Emergency_Plane, 1));
        Emergency_Plane_Options.add(new NO_REQUIREMENT_OPTION("Place on Standby", "None", "Airplane joins \"waiting\" planes", Emergency_Plane));
        return Emergency_Plane_Options;
    }

    public List<OPTION> Funding_Event() {
        List<OPTION> Funding_Event_Options = new ArrayList<>();
        Funding_Event_Options.add(new RUNWAY_OPTION("Empty Random Runway", "1 full runway", "Empties a random runway", true, 1));
        Funding_Event_Options.add(new NO_REQUIREMENT_OPTION("Rescue Team", "None", "Rescue 100 people", -100, null, null));
        Funding_Event_Options.add(new PLANE_OPTION("Air Refueling", "At least one plane in the air", "All waiting airplanes get 2 more hours of fuel", 2, true));
        return Funding_Event_Options;
    }

    public List<OPTION> Bad_Weather() {
    }
}
