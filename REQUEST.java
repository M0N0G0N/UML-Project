package com.company;
import java.util.* ; 
import java.lang.* ; 

public class REQUEST {
    int Rarity;
    String Title;
    String Description;
    OPTION[] Requests_Options;

    public REQUEST(int rarity, String title, String description, OPTION[] requests_Options) {
        Rarity = rarity;
        Title = title;
        Description = description;
        Requests_Options = requests_Options;
    }

    public int getRarity() {
        return Rarity;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public OPTION[] getRequests_Options() {
        return Requests_Options;
    }

    public void Choose_Option(int Option) {

    }


    public String toString() {
        StringBuilder list = new StringBuilder();
        for (int i = 0 ; i <Requests_Options.length ; i ++){
            
            list.append(Integer.toString(i)).append(")").append(Requests_Options[i].toString());
        }
        return "\n---------REQUEST---------  \n"
                + "   Rarity = " + Rarity +
                "\n   Title = " + Title +
                "\n   Description = " + Description + "\n\n" + 
                list ; 
    }






}
