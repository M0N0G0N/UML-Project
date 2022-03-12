package com.company;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class PLANE_BANK { //This class is used so we can generate a name, a number of passengers, and the amount of fuel and refuel time.
    static final String[] Suffix = {"AIR", "JET", "COMPANY", "CORPORATION", "ALLIANCE", "STAR", "BIRD", "IN THE AIR", "ECONOMY", "BUSINESS", "FIRST CLASS", "AIRLINES", "PRIVATE", "PREMIUM"};
    static final String[] Countries = {"CANADA", "FRANCE", "USA", "MEXICO", "BRAZIL", "GERMANY", "EGYPT", "CHINA", "JAPAN", "INDIA", "AUSTRALIA", "LIGMA", "COSMOS", "GALAXY", "APERTURE"};
    static final char[] Letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String Get_Random_Name() { //A name is constructed as follows: COUNTRY + SUFFIX + LETTER + INTEGER[1;5000].
        return Countries[ThreadLocalRandom.current().nextInt(0, Countries.length + 1)]+ " " + Suffix[ThreadLocalRandom.current().nextInt(0, Suffix.length + 1)] + " " + Letters[ThreadLocalRandom.current().nextInt(0, Letters.length + 1)] + ThreadLocalRandom.current().nextInt(1, 5000 + 1);
    }

    public static int Gen_Total_Passengers(String PLANE_TYPE) { //Depending on the plane type, this method generates a number of total passengers.
        if (Objects.equals(PLANE_TYPE, "JUMBO")) {
            return ThreadLocalRandom.current().nextInt(300, 600);
        }
        else {
            return ThreadLocalRandom.current().nextInt(100, 500);
        }
    }

    public static int Gen_Fuel_Left(String PLANE_TYPE) { //Depending on the plane type, this method generates a number of fuel left in the plane's tank.
        if (Objects.equals(PLANE_TYPE, "JUMBO")) {
            return ThreadLocalRandom.current().nextInt(4, 6 + 1);
        }
        else if (Objects.equals(PLANE_TYPE, "EMERGENCY")){
            return ThreadLocalRandom.current().nextInt( 1, 3+ 1);
        }
        else {
            return ThreadLocalRandom.current().nextInt( 3, 5 + 1);
        }
    }

    public static int Gen_Refuel_Time(String PLANE_TYPE) { //Depending on the plane type, this method generates a number of Runway time needed to refuel the plane.
        if (Objects.equals(PLANE_TYPE, "JUMBO")) {
            return 0;
        }
        else if (Objects.equals(PLANE_TYPE, "EMERGENCY")) {
            return ThreadLocalRandom.current().nextInt( 3, 5 + 1);
        }
        else {
            return ThreadLocalRandom.current().nextInt( 1, 4 + 1);
        }
    }
}
