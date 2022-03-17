package com.company;

import java.security.cert.CRLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class REQUESTS_MENU extends MENU {
    static List<REQUEST> Request_List = new ArrayList<>();
    static List<REQUEST> Chosen_Request = new ArrayList<>();

    public REQUESTS_MENU() {
        Create_Requests(true);
    }

    public void Create_Requests (boolean First_Time) { //Is used to randomise and create Requests in the list
        if (First_Time) {

        }
    }

    public static void Display_requests_menu() {

    }


    public REQUESTS_MENU(List<REQUEST> request_List) {
        Request_List = request_List;
    }

    public boolean Can_Be_Displayed() {
        return Request_List != null && Request_List.size() != 0;
    }

    public static void Choose_Request() { //That one is funny
        List<Integer> weights = new ArrayList<>(); //We initialize an empty ArrayList
        for (int i = 0; i < Request_List.size(); i++) { //For every Request Available
            for (int j = 0; j != Request_List.get(i).getRarity(); j++) { //For every rarity
                weights.add(i); //We add a spot in the list, e.g: for rarity of 5, there will be 5 spots in the list, and the spot in th list will have the index of the Request.
            }
        }
        Chosen_Request.clear(); //This lines empties the Chosen_Request ArrayList
        Random random = new Random();
        for (int k = -1; k < random.nextInt(3); k++) { //This chooses between 1 and 3 tasks
            Chosen_Request.add(Request_List.get(weights.get(random.nextInt(weights.size())))); //So this picks a random spot in list, reads the index in the spot, and picks the request associated with that spot, effectively creating a weighted random pick.
        }
    }

    public static void Display_Requests() {

    }


    public void Choose_Request(int Request_Choice){

    }
}
