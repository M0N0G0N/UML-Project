package com.company;

import java.util.*;

import static java.lang.Integer.parseInt;

public class REQUESTS_MENU extends MENU {
    static List<REQUEST> Request_List = new ArrayList<>(); //Total list of possible Requests
    static List<REQUEST> Chosen_Request = new ArrayList<>(); //Requests that you can choose from this current hour
    static List<REQUEST> Next_Hour_Request = new ArrayList<>(); //Requests that are stored for the next hour.
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
        Choose_Request();
    }

    public static void Create_Requests(boolean First_Time) { //Is used to randomise and create Requests in the list
        if (First_Time) {
            Request_List.add(new REQUEST(10, "FUNDING EVENT", "An increase in funding allows for one of the following bonuses:", OPTION_REPOSITORY.Funding_Event()));
            Request_List.add(new REQUEST(10, "BAD WEATHER", "Select a bad weather event", OPTION_REPOSITORY.Bad_Weather()));
            Request_List.add(new REQUEST(5, "PROTESTS", "A group of protestors are blocking the runway claiming that your airplanes are dropping chem-trails,\n which has caused the the following health issues: \n\"makes their toothpaste taste like mint.\"", OPTION_REPOSITORY.Protests()));
            Request_List.add(new REQUEST(5, "JOHN MCCLAIN", "Security reports of a man hijacking a plane on the runway.\n He claims he needs to stop the terrorists from stealing christmas.\n Do you lock down the runway or let them go?", OPTION_REPOSITORY.John_Mcclain()));
            Request_List.add(new REQUEST(10, "SNAKES ON PLANE", "A pilot is reporting that their plane is being overrun by snakes.\n They have to land at your airport.", OPTION_REPOSITORY.Snakes_on_plane()));
            Request_List.add(new REQUEST(15, "JUMBO JET", "A Large Aircraft Carrying a lot of passengers wishes to land.", OPTION_REPOSITORY.Jumbo_Plane()));
            Request_List.add(new REQUEST(5, "EMERGENCY LANDING", "A plane has very low amount of fuel and needs to land in the most brief delays.", OPTION_REPOSITORY.Emergency_Landing()));
            Request_List.add(new REQUEST(40, "PLANE LANDING", "A plane needs to land at your airport.", OPTION_REPOSITORY.Standard_Plane()));
        }
        Request_List.remove(7); //Removes the Standard plane so it is randomized again
        Request_List.remove(6); //Removes the Emergency plane so it is randomized again
        Request_List.remove(5); //Removes the Jumbo Jet option so it is randomized again
        Request_List.remove(4); //Removes the Snakes on plane so it is randomized again
        Request_List.add(new REQUEST(10, "SNAKES ON PLANE", "A pilot is reporting that their plane is being overrun by snakes.\n They have to land at your airport.", OPTION_REPOSITORY.Snakes_on_plane())); //Randomizes the snake plane inside
        Request_List.add(new REQUEST(15, "JUMBO JET", "A Large Aircraft Carrying a lot of passengers wishes to land.", OPTION_REPOSITORY.Jumbo_Plane())); //Randomizes the jumbo plane inside
        Request_List.add(new REQUEST(5, "EMERGENCY LANDING", "A plane has very low amount of fuel and needs to land in the most brief delays.", OPTION_REPOSITORY.Emergency_Landing())); //Randomizes the Emergency plane inside
        Request_List.add(new REQUEST(40, "PLANE LANDING", "A plane needs to land at your airport.", OPTION_REPOSITORY.Standard_Plane()));
    }

    public static void Display_requests_menu() { //Menu for the Request_Menu.
        for (REQUEST chosen_requests : Chosen_Request) {
            System.out.println(chosen_requests); //Prints out all the requests
        }
        Take_Care_Of_Requests();
    }

    public boolean Can_Be_Displayed() {
        return Chosen_Request.size() != 0;
    }

    public static void Choose_Request() { //That one is funny
        List<Integer> weights = new ArrayList<>(); //We initialize an empty ArrayList
        for (int i = 0; i < Request_List.size(); i++) { //For every Request Available
            for (int j = 0; j != Request_List.get(i).getRarity(); j++) { //For every rarity
                weights.add(i); //We add a spot in the list, e.g: for rarity of 5, there will be 5 spots in the list, and the spot in th list will have the index of the Request.
            }
        }
        Random random = new Random();
        for (int k = -1; k < random.nextInt(3); k++) {//This chooses between 1 and 3 tasks
            Create_Requests(false); //This randomizes the available options
            Chosen_Request.add(Request_List.get(weights.get(random.nextInt(weights.size())))); //So this picks a random spot in list, reads the index in the spot, and picks the request associated with that spot, effectively creating a weighted random pick.
        }
        Swap_To_Chosen_Requests();
    }

    public static void Swap_To_Next_Hour(REQUEST Requests_To_Swap) {
        Next_Hour_Request.add(Requests_To_Swap);
        Chosen_Request.remove(Requests_To_Swap);
    }

    public static void Swap_To_Chosen_Requests() {
        Chosen_Request.addAll(Next_Hour_Request); //We move ALL requests from the Next_Hour_Request list to the Chosen_Hour_Request list.
        Next_Hour_Request.clear(); //We clear the Next_Hour_Request list.
    }

    public static void Take_Care_Of_Requests(){
        Scanner scanner = new Scanner(System.in);
        String Request_choice;
        boolean Verified_Input = false; //We use this one to show the user if the command was correct or not
        do { //We await a valid name input
            System.out.println("Please input the name of the request you wish to take care of. If you wish to go back to the main menu, type \"EXIT\": ");
            Request_choice = scanner.nextLine();
            for (REQUEST chosen_requests : Chosen_Request) { //For each Request
                if (Objects.equals(Request_choice, chosen_requests.Title)) { //We see if the input matches the name of the Request
                    Verified_Input = true;
                    do {
                        System.out.println("Please input the number of the option you wish to choose. Type \"CANCEL\" to cancel: "); //If it works, then we look into the available options
                        Request_choice = scanner.nextLine(); 
                        
                        try { //We're going to try to see if: the input is a number || the number is part of the array.
                            if (chosen_requests.Requests_Options.get(parseInt(Request_choice)).IsValid()) { //If the command is valid && Syntactically correct,
                                boolean Is_For_Next_Hour = chosen_requests.Requests_Options.get(parseInt(Request_choice)).Consequences(); //Then we trigger the consequences
                                if (Is_For_Next_Hour) { //If we need to put it in the next requirement list
                                    Swap_To_Next_Hour(chosen_requests);
                                } else { //Otherwise, we just toss it.
                                    Chosen_Request.remove(chosen_requests);
                                }
                                System.out.println("Request successfully taken care of.");
                                Request_choice = "CANCEL";
                            } else {
                                System.out.println("The option you have chosen does not meet the requirements. Please choose another option.");
                            }
                        } catch (NumberFormatException numberFormatException) { //If we get a string instead of a number
                            if (!Objects.equals(Request_choice, "CANCEL")) { //If it's not CANCEL:
                                System.out.println("ERROR: INPUT IS NOT A NUMBER. PLEASE TRY AGAIN.");
                            }
                        } catch (IndexOutOfBoundsException indexOutOfBoundsException) { //If we get an out of bounds
                            System.out.println("ERROR: THIS NUMBER ISN'T IN THE LIST OF OPTIONS. PLEASE TRY AGAIN.");
                        }
                    } while (!Objects.equals(Request_choice, "CANCEL"));
                    break; //We have to break there, else the `for` continues iterating, creating an exception because we loop through when we erased an index in it.
                }
            }
            if (!Verified_Input && !Objects.equals(Request_choice, "EXIT")) //If the command wasn't correct
                System.out.println("ERROR: INPUT NOT RECOGNIZED. PLEASE TRY AGAIN.");
            Verified_Input = false;
        } while (!Objects.equals(Request_choice, "EXIT"));
    }
}
