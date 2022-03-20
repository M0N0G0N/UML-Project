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

    public String toString() {
        StringBuilder Options = new StringBuilder();
        for (int i = 0; i < Requests_Options.size(); i++) {
            Options.append("                                           * ---------------------------------------- *\n");
            Options.append("                                           |                 OPTION ").append(i).append("                 |\n");
            Options.append(Requests_Options.get(i));
        }
        return "-".repeat(Title.length() * 2) + " *\n"
                + Title + "\n"
                + "-".repeat(Title.length()) + " *\n"
                + Description + "\n"
                + "-".repeat(Title.length() * 2) + " *\n"
                + Options + "\n"
                + "#".repeat(Title.length() * 30) + "\n";
    }






}
