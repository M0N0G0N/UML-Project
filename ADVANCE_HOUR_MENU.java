package com.company;

import java.util.ArrayList;
import java.util.List;

public class ADVANCE_HOUR_MENU extends MENU{
    static int Passengers; //Dead people that the player killed by negligence and poor planning skills.
    static int Current_Time; //Current hour.
    static List<String> Past_Hour_Events = new ArrayList<>(); //Everything that happened in the last hour.
    static int Request_Number; //Number of requests available.

    public ADVANCE_HOUR_MENU(){
        
    }

    public static void Display_Advance_Hour_Menu() {

    }

    public void Advance_Hour() {
        Current_Time++;
        RUNWAY_MENU.Advance_hour_Runway();
        WAITING_PLANES_MENU.Advance_hour_Waiting_Planes();
        System.out.println("YOU SURVIVED HOUR " + (--Current_Time) + " !");
        System.out.println("NOW ENTERING HOUR " + Current_Time + "...");
        System.out.println("HERE'S WHAT HAPPENED LAST HOUR...");
        for (String Events : Past_Hour_Events) {
            System.out.println(Events);
        }
        Past_Hour_Events.clear();
        REQUESTS_MENU.Choose_Request();
        Request_Number = REQUESTS_MENU.Request_List.size();
        System.out.println("YOU HAVE NOW " + Request_Number + " NEW REQUESTS.");
        System.out.println("THERE ARE NOW " + Passengers + " DEAD PASSENGERS. ");
        Display_Game_Over();
        Display_Victory();
        System.out.println("YOU CAN DO IT!");
    }

    public ADVANCE_HOUR_MENU(int passengers, int current_Time, int request_Number) {
        Passengers = passengers;
        Current_Time = current_Time;
        Request_Number = request_Number;
    }

    public static boolean Can_Be_Displayed() {
        return Request_Number == 0;
    }

    public void Display_Game_Over() {
            if (Passengers >= 350){
                System.out.println("-----------GAME OVER ...----------\n") ;
                System.exit(0);
        }
    }

    public void Display_Victory() {
        if (Current_Time >= 24){
            System.out.println("-----------VICTORY !----------\n") ;
            System.exit(0);
        }
    }

    public static void Collect_Events(String Event_Desc) {
        Past_Hour_Events.add(Event_Desc);
    }

    public static void setPassengers(int passengers) {
        Passengers = passengers + Passengers;
    }
}
