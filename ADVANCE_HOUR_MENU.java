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

    public void Advance_Hour() {
        Current_Time++;
        RUNWAY_MENU.Advance_hour_Runway();
        WAITING_PLANES_MENU.Advance_hour_Waiting_Planes();
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

    public void Display_Game_Over(int Passengers) {
            if (Passengers >= 350){
                System.out.println("-----------GAME OVER ...----------\n") ;
        }
    }

    public void Display_Victory(int current_Time) {
        if (current_Time >= 24){  //24h
            System.out.println("-----------VICTORY !----------\n") ;
        }
    }

    public static void Collect_Events(String Event_Desc) {
        Past_Hour_Events.add(Event_Desc);
    }

    public static void setPassengers(int passengers) {
        Passengers = passengers + Passengers;
    }
}
