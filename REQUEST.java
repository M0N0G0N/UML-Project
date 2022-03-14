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

    public void Choose_Option(int Option) {
        


    }


    public String toString() {
        String list ="" ; 
        for (int i = 0 ; i <Requests_Options.length ; i ++){
            
            list = list + Integer.toString(i) + ")" + Requests_Options[i].toString() ; 
        }
        return "\n---------REQUEST---------  \n"
                + "   Rarety = " + Rarity +
                "\n   Title = " + Title +
                "\n   Description = " + Description + "\n\n" + 
                list ; 
    }






}
