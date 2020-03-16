package com.napier.sem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Purpose: This is the Entry Class of the Program and is the main user interface for the user.
 * Author: Jack Iain Bryce (40400117)
 * Last Date of Modification: 31/01/2020
 */
public class App {
    //Instance Variables.
    private static QueryHandler queryHandler;
    private static JFrame frame;
    private static Scanner in;
    private static int capitalCities, cities, countries;

    /*
     * Purpose: Entry Point of the Program.
     * Parameters: args - This is the arguments from the command line.
     */
    public static void main(String[] args) {
        //Initialise the QueryHandler to display the appropriate inputs to the user.
        queryHandler = new QueryHandler("localhost:33060");

        //Store the reports and individual queries into a list.
        String[] inputOptions = {
                "Country Report",
                "Cities Report",
                "Capital Cities Report",
                "Population Report",
                "All the countries in the world organised by largest population to smallest",
                "All the countries in a continent organised by largest population to smallest",
                "All the countries in a region organised by largest population to smallest",
                "The top N populated countries in the world",
                "The top N populated countries in a continent",
                "The top N populated countries in a region",
                "All the cities in the world organised by largest population to smallest",
                "All the cities in a continent organised by largest population to smallest",
                "All the cities in a region organised by largest population to smallest",
                "All the cities in a country organised by largest population to smallest",
                "All the cities in a district organised by largest population to smallest",
                "The top N populated cities in the world",
                "The top N populated cities in a continent",
                "The top N populated cities in a region",
                "The top N populated cities in a country",
                "The top N populated cities in a district",
                "All the capital cities in the world organised by largest population to smallest",
                "All the capital cities in a continent organised by largest population to smallest",
                "All the capital cities in a region organised by largest to smallest",
                "The top N populated capital cities in the world",
                "The top N populated capital cities in a continent",
                "The top N populated capital cities in a region",
                "The population of people, people living in cities, and people not living in cities in each continent",
                "The population of people, people living in cities, and people not living in cities in each region",
                "The population of people, people living in cities, and people not living in cities in each country"
        };

        while (true) {
            //Display the options the user can select from.
            for (int i = 0; i < inputOptions.length; i++) {
                System.out.println(String.valueOf(i+1) + ". " + inputOptions[i]);
            }
            String userInput;
            //Retrieve the user input.
            System.out.println("Please enter the number of the query that you would like to call (or -1 if you want to exit the application): ");
            userInput = System.console().readLine();

            //Break from the while loop if the use entered a break code.
            if (checkToBreak(userInput))
                break;

            //Check if it does not contain any non-numerical values.
            int num = Integer.parseInt(userInput);
            if (checkWithinRange(num, inputOptions.length)) {
                inputProcessing(inputOptions[num-1]);
            }
        }
    }

    /**/
    public static boolean checkWithinRange(int num, int max) {
        if (num >= 1 && num < max)
            return true;
        else
            return false;
    }

    /**/
    public static boolean checkToBreak(String userInput) {
        //Break from the while loop if the use entered a break code.
        if (userInput == "-1")
            return true;
        else
            return false;
    }

    /*
     * Purpose: This handles the query the user selected by getting any extra user inputs
     *          that are actually needed for the one they selected.
     * Parameters: input - This is the query that the user selected.
     */
    public static void inputProcessing(String input) {
        //If the input contains N, then retrieve the appropriate number.
        if (input.contains("N")) {
            collectInputs(input);
        }

        //Call the correct query.
        if (input.contains("Population Report")) {
            OutputLinker.SQLinititate(input, "","", "","","");
        } else if (input.contains("Capital Cities Report")) {
            OutputLinker.SQLinititate(input, "","","","","");
        } else if (input.contains("Cities Report")) {
            OutputLinker.SQLinititate(input, "","","","","");
        } else if (input.contains("Country Report")) {
            OutputLinker.SQLinititate(input, "","","","","");
        } else if (input.contains("continent")) {
            if (!input.contains("N")) {
                queryContinent(input);
            } else {
                //Retrieve and display the continents the users can pick from.
                ArrayList<String> continents = queryHandler.getContinents();
                for (int i = 0; i < continents.size(); i++) {
                    System.out.println(String.valueOf(i+1) + ". "+ continents.get(i));
                }

                //Retrieve the user input for which continent the user wants.
                boolean exit = false;
                String userInput = "";
                while (!exit) {
                    //Retrieve the user inputs.
                    System.out.println("Please enter the number of the continent that you want to be used in the query: ");
                    userInput = in.nextLine();

                    //Check if the user inputs is contained within the list.
                    int index = Integer.parseInt(input)-1;
                    if (index >= 0 && index < continents.size()) {
                        exit = true;
                    }
                }

                //Call OutputLinker.SQLinitiate();
                int index = Integer.parseInt(userInput);
                if (capitalCities != -1) {
                    OutputLinker.SQLinititate(input, "", "", continents.get(index), "", String.valueOf(capitalCities));
                } else if (cities  != -1) {
                    OutputLinker.SQLinititate(input, "", "", continents.get(index), "", String.valueOf(cities));
                } else {
                    OutputLinker.SQLinititate(input, "", "", continents.get(index), "", String.valueOf(countries));
                }
            }
        } else if (input.contains("region")) {
            if (!input.contains("N")) {
                queryRegion(input);
            } else {
                //Retrieve and display the regions the users can pick from.
                ArrayList<String> regions = queryHandler.getRegions();
                for (int i = 0; i < regions.size(); i++) {
                    System.out.println(String.valueOf(i+1) + ". "+ regions.get(i));
                }

                //Retrieve the user input for which region the user wants.
                boolean exit = false;
                String userInput = "";
                while (!exit) {
                    //Retrieve the user inputs.
                    System.out.println("Please enter the number of the region that you want to be used in the query: ");
                    userInput = in.nextLine();

                    //Check if the user inputs is contained within the list.
                    int index = Integer.parseInt(input)-1;
                    if (index >= 0 && index < regions.size()) {
                        exit = true;
                    }
                }

                //Call OutputLinker.SQLinitiate();
                int index = Integer.parseInt(userInput)-1;
                if (capitalCities != -1) {
                    OutputLinker.SQLinititate(input, "", "", "", regions.get(index), String.valueOf(capitalCities));
                } else if (cities  != -1) {
                    OutputLinker.SQLinititate(input, "", "", "", regions.get(index), String.valueOf(cities));
                } else {
                    OutputLinker.SQLinititate(input, "", "", "", regions.get(index), String.valueOf(countries));
                }
            }
        } else if (input.contains("country")) {
            if (!input.contains("N")) {
                queryCountry(input);
            } else {
                //Retrieve and display the countries the users can pick from.
                ArrayList<String> _countries = queryHandler.getCountries();
                for (int i = 0; i < _countries.size(); i++) {
                    System.out.println(String.valueOf(i+1) + ". " + _countries.get(i));
                }

                //Retrieve the user input for which country the user wants.
                boolean exit = false;
                String userInput = "";
                while (!exit) {
                    //Retrieve the user inputs.
                    System.out.println("Please enter the number of the country that you want to be used in the query: ");
                    userInput = in.nextLine();

                    //Check if the user inputs is contained within the list.
                    int index = Integer.parseInt(input)-1;
                    if (index >= 0 && index < _countries.size()) {
                        exit = true;
                    }
                }

                //Call OutputLinker.SQLinitiate();
                int index = Integer.parseInt(userInput)-1;
                if (capitalCities != -1) {
                    OutputLinker.SQLinititate(input, _countries.get(index), "", "", "", String.valueOf(capitalCities));
                } else if (cities  != -1) {
                    OutputLinker.SQLinititate(input, _countries.get(index), "", "", "", String.valueOf(cities));
                } else {
                    OutputLinker.SQLinititate(input, _countries.get(index), "", "", "", String.valueOf(countries));
                }
            }
        } else if (input.contains("district")) {
            if (!input.contains("N")) {
                queryDistrict(input);
            } else {
                //Retrieve and display the countries the users can pick from.
                ArrayList<String> districts = queryHandler.getDistricts();
                for (int i = 0; i < districts.size(); i++) {
                    System.out.println(String.valueOf(i+1) + ". " + districts.get(i));
                }

                //Retrieve the user input for which country the user wants.
                boolean exit = false;
                String userInput = "";
                while (!exit) {
                    //Retrieve the user inputs.
                    System.out.println("Please enter the number of the country that you want to be used in the query: ");
                    userInput = in.nextLine();

                    //Check if the user inputs is contained within the list.
                    int index = Integer.parseInt(input)-1;
                    if (index >= 0 && index < districts.size()) {
                        exit = true;
                    }
                }

                //Call OutputLinker.SQLinitiate();
                int index = Integer.parseInt(userInput)-1;
                if (capitalCities != -1) {
                    OutputLinker.SQLinititate(input, "", districts.get(index), "", "", String.valueOf(capitalCities));
                } else if (cities  != -1) {
                    OutputLinker.SQLinititate(input, "", districts.get(index), "", "", String.valueOf(cities));
                } else {
                    OutputLinker.SQLinititate(input, "", districts.get(index), "", "", String.valueOf(countries));
                }
            }
        } else if (input.contains("world")) {
            //There is no need to receive an input from the user.
            if (capitalCities != -1) {
                OutputLinker.SQLinititate(input, "", "", "", "", String.valueOf(capitalCities));
            } else if (cities  != -1) {
                OutputLinker.SQLinititate(input, "", "", "", "", String.valueOf(cities));
            } else {
                OutputLinker.SQLinititate(input, "", "", "", "", String.valueOf(countries));
            }
        }
    }

    /*
     * Purpose: This handles trying to find the districts the user wants to query with.
     * Parameters: value - This is the query that the user selected.
     */
    private static void queryDistrict(String value) {
        //Query the database to find the continents the user can select from.
        ArrayList<String> districts = queryHandler.getDistricts();

        //If there exists an error, print out the message and exit the function.
        if (districts == null) {
            System.out.println(queryHandler.getErrorMessage());
            return;
        }

        //User input variables.
        String input = "";
        boolean exit = false;

        if (value.contains("All")) {
            //Display the options to the users to select.
            for (int i = 0; i < districts.size(); i++) {
                System.out.println(String.valueOf(i+1)+districts.get(i));
            }

            //Retrieve the user input.
            while (!exit) {
                //Retrieve the user inputs.
                System.out.println("Please enter the number of districts you want to be used in the query: ");
                input = in.nextLine();

                //Check if the user inputs is contained within the list.
                int index = Integer.parseInt(input)-1;
                if (index >= 0 && index < districts.size()) {
                    exit = true;
                }
            }

            //Since the user selected a query with each in it, we do not need them to enter a value.
            OutputLinker.SQLinititate(value, "", input,"","","");
        } else {
            //Since the user selected a query that does not contain each, we need to find the number of
            //continents the user wants for the query.
            while (!exit) {
                //Retrieve the user inputs.
                System.out.println("Please enter the number of districts you want to be used in the query: ");
                input = in.nextLine();

                //Check if the user input is within the correct range.
                int num = Integer.parseInt(input);
                if (num > 0 && num < districts.size()) {
                    exit = true;
                }
            }

            //Call the query or call this query again if there is an error.
            if (input != "") {
                OutputLinker.SQLinititate(value, "","","","", input);
            } else {
                queryDistrict(value);
            }
        }
    }

    /*
     * Purpose: This handles trying to find the continent the user wants to query with.
     * Parameters: value - This is the query that the user selected.
     */
    private static void queryContinent(String value) {
        //Query the database to find the continents the user can select from.
        ArrayList<String> continents = queryHandler.getContinents();

        //If there exists an error, print out the message and exit the function.
        if (continents == null) {
            System.out.println(queryHandler.getErrorMessage());
            return;
        }

        //User input variables.
        String input = "";
        boolean exit = false;

        if (value.contains("All")) {
            //Display the options to the users to select.
            for (int i = 0; i < continents.size(); i++) {
                System.out.println(String.valueOf(i+1)+continents.get(i));
            }

            //Retrieve the user input.
            while (!exit) {
                //Retrieve the user inputs.
                System.out.println("Please enter the number of districts you want to be used in the query: ");
                input = in.nextLine();

                //Check if the user inputs is contained within the list.
                int index = Integer.parseInt(input)-1;
                if (index >= 0 && index < continents.size()) {
                    exit = true;
                }
            }

            //Since the user selected a query with each in it, we do not need them to enter a value.
            OutputLinker.SQLinititate(value, "","",input,"","");
        } else {
            //Retrieve the user input.
            while (!exit) {
                //Retrieve the user inputs.
                System.out.println("Please enter the number of continents you want to be used in the query: ");
                input = in.nextLine();

                //Check if the user input is within the correct range.
                int num = Integer.parseInt(input);
                if (num > 0 && num < continents.size()) {
                    exit = true;
                }
            }

            //Call the query or call this query again if there is an error.
            if (input != "") {
                OutputLinker.SQLinititate(value, "","","","", input);
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
        //Query the database to find the regions the user can select from.
        ArrayList<String> regions = queryHandler.getRegions();

        //If there exists an error, print out the message and exit the function.
        if (regions == null) {
            System.out.println(queryHandler.getErrorMessage());
            return;
        }

        //User input variables.
        String input = "";
        boolean exit = false;

        if (value.contains("All")) {
            //Display the options to the users to select.
            for (int i = 0; i < regions.size(); i++) {
                System.out.println(String.valueOf(i+1)+regions.get(i));
            }

            //Retrieve the user input.
            while (!exit) {
                //Retrieve the user inputs.
                System.out.println("Please enter the number of districts you want to be used in the query: ");
                input = in.nextLine();

                //Check if the user inputs is contained within the list.
                int index = Integer.parseInt(input)-1;
                if (index >= 0 && index < regions.size()) {
                    exit = true;
                }
            }

            //Since the user selected a query with each in it, we do not need them to enter a value.
            OutputLinker.SQLinititate(value, "","","", input,"");
        } else {
            //Since the user selected a query that does not contain each, we need to find the number of
            //regions the user wants for the query.
            while (!exit) {
                //Retrieve the user inputs.
                System.out.println("Please enter the number of regions you want to be used in the query: ");
                input = in.nextLine();

                //Check if the user input is within the correct range.
                int num = Integer.parseInt(input);
                if (num > 0 && num < regions.size()) {
                    exit = true;
                }
            }

            //Call the query or call this query again if there is an error.
            if (input != "") {
                OutputLinker.SQLinititate(value,"","","","", input);
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
        //Query the database to find the list of countries in the world.
        ArrayList<String> countries = queryHandler.getCountries();

        //If there exists an error, print out the message and exit the function.
        if (countries == null) {
            System.out.println(queryHandler.getErrorMessage());
            return;
        }

        //User input variables.
        String input = "";
        boolean exit = false;

        if (value.contains("All")) {
            //Display the options to the users to select.
            for (int i = 0; i < countries.size(); i++) {
                System.out.println(String.valueOf(i+1)+countries.get(i));
            }

            //Retrieve the user input.
            while (!exit) {
                //Retrieve the user inputs.
                System.out.println("Please enter the number of districts you want to be used in the query: ");
                input = in.nextLine();

                //Check if the user inputs is contained within the list.
                int index = Integer.parseInt(input)-1;
                if (index >= 0 && index < countries.size()) {
                    exit = true;
                }
            }

            //Since the user selected a query with each in it, we do not need them to enter a value.
            OutputLinker.SQLinititate(value, input,"","","","");
        } else {
            //Since the user selected a query without each in it, we need them to enter a value.
            while (!exit) {
                //Retrieve the user inputs.
                System.out.println("Please enter the number of countries you want to be used in the query: ");
                input = in.nextLine();

                //Check if the user input is within the correct range.
                int num = Integer.parseInt(input);
                if (num > 0 && num < countries.size()) {
                    exit = true;
                }
            }

            //Call the query.
            if (input != "") {
                OutputLinker.SQLinititate(value, "","","","", input);
            } else {
                queryCountry(value);
            }
        }
    }

    /*
     * Purpose: This checks if the string contains a non-integer.
     * Parameters: str - This is the string we are checking.
     */
    public static boolean checkString(String str) {
        //Return true if it contains a non-numerical value.
        List<String> numericalValues = Arrays.asList( new String[]{"0","1","2","3","4","5","6","7","8","9"} );

        for (int i = 0; i < str.length(); i++) {
            //Check if val is non-numerical, if yes then return true.
            String val = Character.toString(str.charAt(i));
            if (!numericalValues.contains(val)) {
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
                //Fetch the number of capital cities.
                int numCapitalCities = queryHandler.getCapitalCities().size();

                //Check if the input contains a non-integer.
                System.out.println(String.format("Enter the number of capital cities you want from the query out of %d: ", numCapitalCities));
                String input = in.nextLine();

                //Convert the user input into an integer.
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= numCapitalCities) {
                    capitalCities = num;
                    break;
                }
            }
        } else {
            //This is when capital cities is not needed.
            capitalCities = -1;
        }

        //Retrieve the value for cities.
        if (value.contains("cities")) {
            while (true) {
                //Fetch the number of cities.
                int numCities = queryHandler.getCities().size();

                //Check if the input contains a non-integer.
                System.out.println(String.format("Enter the number of cities you want from the query out of %d: ", numCities));
                String input = in.nextLine();

                //Convert the user input into an integer.
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= numCities) {
                    cities = num;
                    break;
                }
            }
        } else {
            //This is when cities is not needed.
            cities = -1;
        }

        //Retrieve the value for countries.
        if (value.contains("countries")) {
            while (true) {
                //Fetch the number of countries.
                int numCountries = queryHandler.getCountries().size();

                //Check if the input contains a non-integer.
                System.out.println(String.format("Enter the number of countries you want from the query out of %d: ", numCountries));
                String input = in.nextLine();

                //Convert the user input into an integer.
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= numCountries) {
                    countries = num;
                    break;
                }
            }
        } else {
            //This is when countries is not needed.
            countries = -1;
        }
    }
}