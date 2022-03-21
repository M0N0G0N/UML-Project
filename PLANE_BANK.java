package com.company;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class PLANE_BANK { //This class is used so we can generate a name, a number of passengers, and the amount of fuel and refuel time.
    static final String[] Suffix = {"AIR", "JET", "COMPANY", "CORPORATION", "ALLIANCE", "STAR", "BIRD", "IN THE AIR", "ECONOMY", "BUSINESS", "FIRST CLASS", "AIRLINES", "PRIVATE", "PREMIUM"};
    static final String[] Countries = {"CANADA", "FRANCE", "USA", "MEXICO", "BRAZIL", "GERMANY", "EGYPT", "CHINA", "JAPAN", "INDIA", "AUSTRALIA", "LIGMA", "COSMOS", "GALAXY", "APERTURE"};
    static final char[] Letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String Get_Random_Name(String Plane_Type) { //A name is constructed as follows: COUNTRY + SUFFIX + LETTER + INTEGER[1;5000].
        if (!Objects.equals(Plane_Type, "SNAKES") && !Objects.equals(Plane_Type, "PROTEST") && !Objects.equals(Plane_Type, "POLICE") && !Objects.equals(Plane_Type, "SNAKES"))
            return Countries[ThreadLocalRandom.current().nextInt(0, Countries.length)]+ " " + Suffix[ThreadLocalRandom.current().nextInt(0, Suffix.length)] + " " + Letters[ThreadLocalRandom.current().nextInt(0, Letters.length)] + ThreadLocalRandom.current().nextInt(1, 5000 + 1);
        else if (Objects.equals(Plane_Type, "PROTEST"))
            return "PROTESTS";
        else if (Objects.equals(Plane_Type, "POLICE"))
            return "POLICE AND PROTESTORS";
        else
            return "SNAKES " + Suffix[ThreadLocalRandom.current().nextInt(0, Suffix.length)] + " " + Letters[ThreadLocalRandom.current().nextInt(0, Letters.length)] + ThreadLocalRandom.current().nextInt(1, 5000 + 1);

    }

    public static int Gen_Total_Passengers(String PLANE_TYPE) { //Depending on the plane type, this method generates a number of total passengers.
        if (Objects.equals(PLANE_TYPE, "JUMBO")) {
            return ThreadLocalRandom.current().nextInt(300, 600);
        }
        else if (Objects.equals(PLANE_TYPE, "SNAKES")){
            return 50;
        }
        else if (Objects.equals(PLANE_TYPE, "PROTEST") || Objects.equals(PLANE_TYPE, "POLICE")){
            return 100;
        }
        else {
            return ThreadLocalRandom.current().nextInt(100, 500);
        }
    }

    public static int Gen_Fuel_Left(String PLANE_TYPE) { //Depending on the plane type, this method generates a number of fuel left in the plane's tank.
        if (Objects.equals(PLANE_TYPE, "JUMBO")) {
            return ThreadLocalRandom.current().nextInt(4, 6 + 1);
        }
        else if (Objects.equals(PLANE_TYPE, "EMERGENCY")) {
            return ThreadLocalRandom.current().nextInt(1, 3 + 1);
        }
        else if (Objects.equals(PLANE_TYPE, "SNAKES") || Objects.equals(PLANE_TYPE, "PROTESTS") || Objects.equals(PLANE_TYPE, "POLICE")) {
            return 0;
        }
        else {
            return ThreadLocalRandom.current().nextInt( 0, 0 + 1);
        }
    }

    public static int Gen_Refuel_Time(String PLANE_TYPE) { //Depending on the plane type, this method generates a number of Runway time needed to refuel the plane.
        if (Objects.equals(PLANE_TYPE, "JUMBO")) {
            return 0;
        }
        else if (Objects.equals(PLANE_TYPE, "EMERGENCY")) {
            return ThreadLocalRandom.current().nextInt( 3, 5 + 1);
        }
        else if (Objects.equals(PLANE_TYPE, "PROTEST") || Objects.equals(PLANE_TYPE, "SNAKES")){
            return 8;
        }
        else if (Objects.equals(PLANE_TYPE, "POLICE")) {
            return 4;
        }
        else {
            return ThreadLocalRandom.current().nextInt( 1, 4 + 1);
        }
    }
}
