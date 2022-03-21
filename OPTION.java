package com.company;

//FAIRE DES SOUS CLASSES

public class OPTION {
    String Option_Desc;
    String Requirement;
    String Consequences;

    public OPTION(String option_Desc, String requirement, String consequences) {
        Option_Desc = option_Desc;
        Requirement = requirement;
        Consequences = consequences;
    }

    public boolean IsValid() { //Apparently we need this, because the IDE doesn't look into the extensions otherwise.
        return true;
    }

    public boolean Consequences() { //We have to create this, so the Java has something to overwrite.
        return false; //Returns false if the choice makes the request disappear, true if the  choice makes the request wait for next hour.
    }

    public PLANE getAffectedPlane() {
        return null;
    }

    public String toString() {
        String LeftAlignFormat = "| %-40s | %-40s | %-60s |\n";
        return  "* ---------------------------------------- * ---------------------------------------- * ------------------------------------------------------------ *\n" +
                "|                  TITLE                   |               REQUIREMENTS               |                        CONSEQUENCES                          |\n" +
                "* ---------------------------------------- * ---------------------------------------- * ------------------------------------------------------------ *\n" +
                String.format(LeftAlignFormat, Option_Desc, Requirement, Consequences) +
                "* ---------------------------------------- * ---------------------------------------- * ------------------------------------------------------------ *\n\n\n";
    }
}
