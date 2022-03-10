package com.company;
import java.util.ArrayList;
import java.util.List;

public class WAITING_PLANES_MENU extends MENU{
    List<PLANE> Planes = new ArrayList<>();

    public WAITING_PLANES_MENU(int Number_Of_Planes) {
        for (int i = 0; i < Number_Of_Planes; i++) {
            Planes.add(new PLANE());
        }
    }

    public void Create_Plane() {
        Planes.add(new PLANE());
    }

    public void Display_Index() {
    }

    public void Remove_Plane(String Plane_Name) {

    }

    public boolean Can_Plane_Land() {
        return bool;
    }
}
