package com.company;

public class MAIN_MENU {
    RUNWAY_MENU Runway = null;
    WAITING_PLANES_MENU Waiting_Planes = null;
    ADVANCE_HOUR_MENU Advance_Hour = null;
    REQUESTS_MENU Requests_menu = null;

    public MAIN_MENU(RUNWAY_MENU runway, WAITING_PLANES_MENU waiting_Planes, ADVANCE_HOUR_MENU advance_Hour, REQUESTS_MENU requests_menu) {
        Runway = runway;
        Waiting_Planes = waiting_Planes;
        Advance_Hour = advance_Hour;
        Requests_menu = requests_menu;
    }

    public void Display_Info() {

    }

    public void Advance_Hour() {

    }

}
