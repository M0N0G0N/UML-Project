package com.company;

public class MAIN_MENU {
    RUNWAY_MENU Runway;
    WAITING_PLANES_MENU Waiting_Planes;
    ADVANCE_HOUR_MENU Advance_Hour;
    REQUESTS_MENU Requests_menu;

    public MAIN_MENU(RUNWAY_MENU runway, WAITING_PLANES_MENU waiting_Planes, ADVANCE_HOUR_MENU advance_Hour, REQUESTS_MENU requests_menu) {
        Runway = runway;
        Waiting_Planes = waiting_Planes;
        Advance_Hour = advance_Hour;
        Requests_menu = requests_menu;
    }

    public static void Display_Info() {
        System.out.println("NUMBER OF DEAD PASSENGERS: " + ADVANCE_HOUR_MENU.Passengers + "\n");
        System.out.println("HOURS ELAPSED: " + ADVANCE_HOUR_MENU.Current_Time + "\n");
    }

    public void Advance_Hour() {

    }

}
