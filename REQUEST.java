package com.company;
import java.lang.* ;
import java.util.List;

public class REQUEST {
    int Rarity;
    String Title;
    String Description;
    List<OPTION> Requests_Options;

    public REQUEST(int rarity, String title, String description, List<OPTION> requests_Options) {
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

    public List<OPTION> getRequests_Options() {
        return Requests_Options;
    }

    public void Choose_Option(int Option) {

    }


    public String toString() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < Requests_Options.size(); i ++){
            
            list.append(Integer.toString(i)).append(")").append(Requests_Options.get(i).toString());
        }
        return "\n---------REQUEST---------  \n"
                + "   Rarity = " + Rarity +
                "\n   Title = " + Title +
                "\n   Description = " + Description + "\n\n" + 
                list ; 
    }






}
