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
    private static QueryHandler queryHandler;
    private static JFrame frame;
    private static int capitalCities, cities, countries;

    /*
     * Purpose: Entry Point of the Program.
     * Parameters: args - This is the arguments from the command line.
     */
    public static void main(String[] args) {
        //Initialise the QueryHandler to display the appropriate inputs to the user.
        queryHandler = new QueryHandler("db/world.sql");

        //Initialise the frame and set its parameters.
        frame = new JFrame("Software Engineering Methods Coursework");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 200);
        frame.setLocation(0, 0);
        frame.setLayout(null);

        //Initialise and add a Panel to the frame.
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setVisible(true);
        panel.setSize(550, 200);
        panel.setLocation(0, 0);
        panel.setLayout(null);

        //Add the report label to the panel.
        JLabel lblReport = new JLabel("Available Reports: ");

        panel.add(lblReport);

        lblReport.setSize(150,20);
        lblReport.setLocation(25,25); // */

        //Add the Dropdown list for the Reports.
        String[] reportChoices = {"","Countries","Cities","Capital Cities","Population"};

        JComboBox<String> reportDropdown = new JComboBox<String>(reportChoices);
        panel.add(reportDropdown);

        reportDropdown.setSize(350, 20);
        reportDropdown.setLocation(175, 25);
        reportDropdown.setVisible(true); //*/

        //Add the label for the individual queries dropdown.
        JLabel lblQueries = new JLabel("Possible Queries: ");
        panel.add(lblQueries);

        lblQueries.setSize(150, 20);
        lblQueries.setLocation(25, 75);
        lblQueries.setVisible(true); //*/

        //Add the dropdown list for the individual queries.
        String[] queryChoices = {"",
                "All the countries in the world organised by largest population to smallest.",
                "All the countries in a continent organised by largest population to smallest.",
                "All the countries in a region organised by largest population to smallest.",
                "The top N populated countries in the world.",
                "The top N populated countries in a continent.",
                "The top N populated countries in a region.",
                "All the cities in the world organised by largest population to smallest.",
                "All the cities in a continent organised by largest population to smallest.",
                "All the cities in a region organised by largest population to smallest.",
                "All the cities in a country organised by largest population to smallest.",
                "All the cities in a district organised by largest population to smallest.",
                "The top N populated cities in the world.",
                "The top N populated cities in a continent.",
                "The top N populated cities in a region.",
                "The top N populated cities in a country.",
                "The top N populated cities in a district.",
                "All the capital cities in the world organised by largest population to smallest.",
                "All the capital cities in a continent organised by largest population to smallest.",
                "All the capital cities in a region organised by largest to smallest.",
                "The top N populated capital cities in the world.",
                "The top N populated capital cities in a continent.",
                "The top N populated capital cities in a region.",
                "The population of people, people living in cities, and people not living in cities in each continent.",
                "The population of people, people living in cities, and people not living in cities in each region.",
                "The population of people, people living in cities, and people not living in cities in each country."
        };

        JComboBox<String> queryDropdown = new JComboBox<String>(queryChoices);
        panel.add(queryDropdown);

        queryDropdown.setSize(350, 20);
        queryDropdown.setLocation(175, 75);
        queryDropdown.setVisible(true); // */

        //Add the Query Button.
        JButton queryBtn = new JButton("Query");
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Make sure that both of the dropdown menus are not empty.
                if (queryDropdown.getSelectedItem() != "" || reportDropdown.getSelectedItem() != "") {
                    //Retrieve the data from the appropriate dropdown menus.
                    if (queryDropdown.getSelectedItem() == "") {
                        String value = reportDropdown.getSelectedItem().toString();

                        //Call the correct query.
                        if (value == "Population") {

                        } else if (value == "Capital Cities") {

                        } else if (value == "Cities") {

                        } else {

                        }
                    } else  {
                        String value = queryDropdown.getSelectedItem().toString();
                        collectInputs(value);

                        //Call the correct query.
                        if (value.contains("continent")) {
                            queryContinent(value);
                        } else if (value.contains("region")) {
                            queryRegion(value);
                        } else if (value.contains("country")) {
                            queryCountry(value);
                        } else if (value.contains("district")) {
                            //We need to receive the user input for which district they want to use in the query.
                            String input = JOptionPane.showInputDialog("Enter which district you wish to use: ");

                            //Handle the input to see if the district exists.

                        } else if (value.contains("world")) {
                            //There is no need to receive an input from the user.

                        }
                    }
                }
            }
        });

        panel.add(queryBtn);

        queryBtn.setSize(75, 20);
        queryBtn.setLocation(275, 125);
        queryBtn.setVisible(true); // */
    }

    /*
     * Purpose: This handles trying to find the continent the user wants to query with.
     * Parameters: value - This is the query that the user selected.
     */
    private static void queryContinent(String value) {
        if (value.contains("each")) {
            //Since the user selected a query with each in it, we do not need them to enter a value.

        } else {
            //Query the database to find the continents the user can select from.
            ArrayList<String> continents = queryHandler.getContinents();

            //Since the user selected a query without each in it, we need them to enter a value.
            String input = JOptionPane.showInputDialog(null, "Enter which continent you wish to use: ", "", JOptionPane.QUESTION_MESSAGE, null, continents.toArray(), "").toString();

            //Call the query.
            if (input != "") {

            } else {
                queryContinent(value);
            }
        }
    }

    /*
     * Purpose: This handles trying to find the region the user wants to query with.
     * Parameters: value - This is the query that the user selected.
     */
    private static void queryRegion(String value) {
        if (value.contains("each")) {
            //Since the user selected a query with each in it, we do not need them to enter a value.

        } else {
            //Query the database to find the list of regions.
            ArrayList<String> regions = queryHandler.getRegions();

            //Since the user selected a query without each in it, we need them to enter a value.
            String input = JOptionPane.showInputDialog(null, "Enter which region you wish to use: ", "", JOptionPane.QUESTION_MESSAGE, null, regions.toArray(), "").toString();

            //Call the query.
            if (input != "") {

            } else {
                queryRegion(value);
            }
        }
    }

    /*
     * Purpose: This handles trying to find the country the user wants to query with.
     * Parameters: value - This is the query that the user selected.
     */
    private static void queryCountry(String value) {
        if (value.contains("each")) {
            //Since the user selected a query with each in it, we do not need them to enter a value.

        } else {
            //Query the database to find the list of countries in the world.
            ArrayList<String> countries = queryHandler.getCountries();

            //Since the user selected a query without each in it, we need them to enter a value.
            String input = JOptionPane.showInputDialog(null, "Enter which country you wish to use: ", "", JOptionPane.QUESTION_MESSAGE, null, countries.toArray(), "").toString();

            //Call the query.
            if (input != "") {

            } else {
                queryCountry(value);
            }
        }
    }

    /*
     * Purpose: This checks if the string contains a non-integer.
     * Parameters: str - This is the string we are checking.
     */
    private static boolean checkString(String str) {
        //Return true if it contains a non-numerical value.
        List<String> numericalValues = Arrays.asList( new String[]{"0","1","2","3","4","5","6","7","8","9"} );

        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);

            //Check if val is non-numerical, if yes then return true.
            String _val = Character.toString(str.charAt(i));
            if (!numericalValues.contains(_val)) {
                //This is when the character is non-numerical.
                return true;
            }
        }


        return false;
    }

    /*
     * Purpose: This collects the appropriate pieces of data from the user.
     * Parameters: N/A
     */
    private static void collectInputs(String value) {
        //Retrieve the appropriate values based upon the specific query through an JOptionPane.
        //Retrieve the value for capitalCities.
        if (value.contains("capital cities")) {
            while (true) {
                //Check if the input contains a non-integer.
                String str = JOptionPane.showInputDialog("Enter the number of capital cities you want from the query: ");

                if (!checkString(str)) {
                    capitalCities = Integer.parseInt(str);
                    break;
                }
            }
        } else {
            capitalCities = -1;
        }

        //Retrieve the value for cities.
        if (value.contains("cities")) {
            while (true) {
                String str = JOptionPane.showInputDialog("Enter the number of cities you want from the query: ");

                if (!checkString(str)) {
                    cities = Integer.parseInt(str);
                    break;
                }
            }
        } else {
            cities = -1;
        }

        //Retrieve the value for countries.
        if (value.contains("countries")) {
            while (true) {
                String str = JOptionPane.showInputDialog("Enter the number of countries you want from the query: ");

                if (!checkString(str)) {
                    countries = Integer.parseInt(str);
                    break;
                }
            }
        } else {
            countries = -1;
        }
    }
}
