package com.company;

public class ADVANCE_HOUR_MENU extends MENU{
    static int Passengers;
    int Current_Time;
    String[] Past_Hour_Events;
    int Request_Number;

    public ADVANCE_HOUR_MENU(int passengers, int current_Time, int request_Number) {
        Passengers = passengers;
        Current_Time = current_Time;
        Request_Number = request_Number;
    }

    public boolean Can_Be_Displayed() {

    }

    public void Display_Menu() {

    }

    public boolean Display_Game_Over() {

    }

    public boolean Display_Victory() {

    }

    public String[] Collect_Events(String Event_Desc) {

    }

    public static void setPassengers(int passengers) {
        Passengers = passengers;
    }
}
