package com.napier.sem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Purpose: This is the Entry Class of the Program and is the main user interface for the user.
 * Author: Jack Iain Bryce (40400117)
 * Last Date of Modification: 31/01/2020
 */
public class App {
    //Instance Variables.
    private static int capitalCities, cities, countries;

    /*
     * Purpose: Entry Point of the Program.
     * Parameters: args - This is the arguments from the command line.
     */
    public static void main(String[] args) {
        //Initialise the QueryHandler to display the appropriate inputs to the user.
        QueryHandler queryHandler = new QueryHandler("db/test_db/world.sql");
        ArrayList<String> Continents;
        Continents = queryHandler.getContinents();
        for(int i = 0; i < Continents.size(); i++){
            System.out.println(Continents.get(i));
        }
    }
}
