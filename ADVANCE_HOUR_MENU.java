package com.company;

import java.util.ArrayList;
import java.util.List;

public class ADVANCE_HOUR_MENU extends MENU{
    static int Passengers;
    int Current_Time;
    static List<String> Past_Hour_Events = new ArrayList<>();
    int Request_Number;

    public ADVANCE_HOUR_MENU(){
        
    }

    public ADVANCE_HOUR_MENU(int passengers, int current_Time, int request_Number) {
        Passengers = passengers;
        Current_Time = current_Time;
        Request_Number = request_Number;
    }

    public boolean Can_Be_Displayed() {
        return Request_Number == 0;
    }

    public void Display_Menu() {
        //TODO: Find a pretty way of displaying this menu
    }

    public boolean Display_Game_Over() {
        //TODO: Find a pretty way of displaying the Game Over screen
    }

    public boolean Display_Victory() {
        //TODO: Find a pretty way of displaying the Victory screen
    }

    public static void Collect_Events(String Event_Desc) {
        Past_Hour_Events.add(Event_Desc);
    }

    public static void setPassengers(int passengers) {
        Passengers = passengers + Passengers;
    }
}
