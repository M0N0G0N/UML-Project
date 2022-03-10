package com.company;

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
}
