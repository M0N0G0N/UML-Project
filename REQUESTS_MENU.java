package com.company;

import java.security.cert.CRLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class REQUESTS_MENU extends MENU {
    static List<REQUEST> Request_List = new ArrayList<>();
    static List<REQUEST> Chosen_Request = new ArrayList<>();
    /* INDEX DE REQUEST LIST:
     * [0]: Funding event
     * [1]: Bad Weather
     * [2]: Protests
     * [3]: John Mcclain
     * [4]: Snakes On planes
     * [5]: Jumbo Jet
     * [6]: Emergency Plane
     * [7]: Standard Plane
     */

    public REQUESTS_MENU() {
        Create_Requests(true);
    }

    public static void Create_Requests(boolean First_Time) { //Is used to randomise and create Requests in the list
        if (First_Time) { //TODO put every request *but* snakes, jumbo, emergency and standard plane inside the `if`
        Request_List.add(new REQUEST(10, "FUNDING EVENT", "An increase in funding allows for one of the following bonuses:", OPTION_REPOSITORY.Funding_Event()));
        Request_List.add(new REQUEST(10, "BAD WEATHER", "Select a bad weather event", OPTION_REPOSITORY.Bad_Weather()));
        Request_List.add(new REQUEST(5, "PROTESTS", "A group of protestors are blocking the runway claiming that your airplanes are dropping chemtrails which has caused the the following health issues: \"makes their toothpaste taste like mint.\"", OPTION_REPOSITORY.Protests()));
        Request_List.add(new REQUEST(5, "JHON MCCLAIN", "Security reports of a man hijacking a plane on the runway. He claims he needs to stop the terrorists from stealing christmas. Do you lock down the runway or let them go?", OPTION_REPOSITORY.John_Mcclain()));
        }
        Request_List.remove(6); //Removes the Snakes on plane so it is randomized again
        Request_List.remove(5); //Removes the Jumbo Jet option so it is randomized again
        Request_List.remove(6); //Removes the Emergency plane so it is randomized again
        Request_List.remove(7); //Removes the Standard plane so it is randomized again
        Request_List.add(new REQUEST(10, "SNAKES ON PLANE", "A pilot is reporting that their plane is being overrun by snakes. They need to land at your airport.", OPTION_REPOSITORY.Snakes_on_plane())); //Randomizes the snake plane inside
        Request_List.add(new REQUEST(15, "JUMBO JET", "A Large Aircraft Carrying a lot of passengers wishes to land.", OPTION_REPOSITORY.Jumbo_Plane())); //Randomizes the jumbo plane inside
        Request_List.add(new REQUEST(5, "EMERGENCY LANDING", "A plane has very low amount of fuel and needs to land in the most brief delays.", OPTION_REPOSITORY.Emergency_Landing())); //Randomizes the Emergency plane inside
        Request_List.add(new REQUEST(40, "PLANE LANDING", "A plane needs to land at your airport.", OPTION_REPOSITORY.Standard_Plane()));

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
        Random random = new Random();
        for (int k = -1; k < random.nextInt(3); k++)  //This chooses between 1 and 3 tasks
            Create_Requests(false);
            Chosen_Request.add(Request_List.get(weights.get(random.nextInt(weights.size())))); //So this picks a random spot in list, reads the index in the spot, and picks the request associated with that spot, effectively creating a weighted random pick.
    }

    public static void Display_Requests() {

    }


    public void Choose_Request(int Request_Choice){

    }
}
