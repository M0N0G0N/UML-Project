package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WAITING_PLANES_MENU extends MENU{
    static List<PLANE> Planes = new ArrayList<>();

    public WAITING_PLANES_MENU() { //The constructor starts with no planes, but will add more once Create_Plane is called.

    }

    public static void Create_Plane(PLANE NEW_PLANE) {
        Planes.add(NEW_PLANE);
    }

    public void Display_Index() {
    }

    public static void Remove_Plane(String Plane_Name) {
        for (int i = 0; i < Planes.size(); i++) {
            if (Objects.equals(Plane_Name, Planes.get(i).name)) {
                Planes.remove(i);
                return;
            }
        }
    }

    //FIXME: unnecessary function?
    public boolean Can_Plane_Land() { //Return False if -1 is returned.
        return RUNWAY_MENU.Call_For_Available(true) != -1;
    }

    public void Pass_To_Runway(String name) {
        for (PLANE plane : Planes) {
            if (Objects.equals(name, plane.name)) {
                RUNWAY.Receive_Plane(plane);
                Planes.remove(plane);
                ADVANCE_HOUR_MENU.Collect_Events("PLANE " + plane.name + " HAS LANDED ON A RUNWAY");
                return;
            }
        }
    }
}
