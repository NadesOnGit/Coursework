package com.napier.sem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Purpose: This handles the connection with the database and sending the queries and
 *			the results of the queries.
 * Authors: Giles Anderson, Mo Ayaanle & Jack Bryce.
 * Last Date of Modification: 06/02/2020
 */
public class QueryHandler {
    //Instance Variables.
    private StringBuilder errorMessage;
    private Connection con;

    /*
     * Purpose: This establishes a conection to the database being used.
     * Parameters: filename - This is the name of the database that we are using.
     */
    public QueryHandler(String filename) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver.");
        }

        int retries = 5;
        for(int i = 0; i < retries; i++){
            try {
                //Establish a connection to the database. Username value
                Thread.sleep(3000);
                con = DriverManager.getConnection("jdbc:mysql://db/test_db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully Connected.");
                errorMessage = null;
                break;
            } catch (SQLException e) {
                //Build the error message.
                errorMessage = new StringBuilder("Error: ");

                errorMessage.append(e.getMessage());
                errorMessage.append(" - Unable to connect with database\n");
            }
            catch(InterruptedException ie){
                System.out.println("Thread interrupted? Should not happen.");
            }
        }

    }

    /*
     * Purpose: This returns the error message to the user.
     * Parameters: N/A.
     */
    public StringBuilder getErrorMessage() { return errorMessage; }

    /*
     * Purpose: This returns the names of the continents that the user can choose from (MainUserInterface).
     * Parameters: N/A.
     */
    public ArrayList<String> getContinents() {
        try {
            //Generate the SQL statement
            Statement stmt = con.createStatement();

            //Add SQL statement to a string
            String strSelect = "SELECT DISTINCT Continent FROM country;";

            //Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Extract the name of the continents from the ResultSet.
            ArrayList<String> continents = new ArrayList<String>();
            while (rset.next()) {
                continents.add(rset.getString("Continents"));
            }

            return continents;
        } catch (Exception e) {
            //
            // Build the error message.
            errorMessage = new StringBuilder("Error: ");

            errorMessage.append(e.getMessage());
            errorMessage.append(" - Unable to print continent names\n");
            return null;
        }
    }

    /*
     * Purpose: This returns the names of the regions that the user can choose from (MainUserInterface).
     * Parameters: N/A.
     */
    public ArrayList<String> getRegions() {
        try {
            //Generate the SQL statement
            Statement stmt = con.createStatement();

            //Add SQL statement to a string
            String strSelect = "SELECT DISTINCT Region FROM country;";

            //Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Extract the name of the region from the ResultSet.
            ArrayList<String> regions = new ArrayList<String>();
            while (rset.next()) {
                regions.add(rset.getString("Region"));
            }

            return regions;
        } catch (Exception e) {
            //Build the error message.
            errorMessage = new StringBuilder("Error: ");

            errorMessage.append(e.getMessage());
            errorMessage.append(" - Unable to print region names\n");

            return null;
        }
    }

    /*
     * Purpose: This returns the names of the countries that the user can choose from (MainUserInterface).
     * Parameters: N/A
     */
    public ArrayList<String> getCountries() {
        try {
            //Generate the SQL statement
            Statement stmt = con.createStatement();

            //Add SQL statement to a string
            String strSelect = "SELECT DISTINCT Region FROM country;";

            //Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Extract the name of the region from the ResultSet.
            ArrayList<String> countries = new ArrayList<String>();
            while (rset.next()) {
                countries.add(rset.getString("name"));
            }

            return countries;
        } catch (Exception e) {
            //Build the error message.
            errorMessage = new StringBuilder("Error: ");

            errorMessage.append(e.getMessage());
            errorMessage.append(" - Unable to print country names\n");

            return null;
        }
    }

    /*
     * Purpose: This displays the populations of all of the countries.
     * Parameters: N/A
     */
    public ArrayList<Country> popWorld() {
        try {
            //Generate the SQL statement
            Statement stmt = con.createStatement();

            //Add SQL statement to a string
            String strSelect =
                    "SELECT country.name, country.population "
                            + "FROM country "
                            + "ORDER BY country.population DESC;";
            //Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country ctry = new Country();
                ctry.Name = rset.getString("country.name");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print world population");

            return null;
        }
    }

    /*All the countries in a continent organised by largest population to smallest. */
    public ArrayList<Country> popContinent(String continent)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT country.name, country.population "
                            + "FROM country "
                            + "WHERE country.Continent = '"+ continent +"'"
                            + "ORDER BY country.population DESC;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.Name = rset.getString("country.name");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print continent population");
            return null;
        }
    }

    /*All the countries in a region organised by largest population to smallest. */
    public ArrayList<Country> popRegion(String region)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT country.name, country.population "
                            + "FROM country "
                            + "WHERE country.Region = '"+ region +"'"
                            + "ORDER BY country.population DESC;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.Name = rset.getString("country.name");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print Region population");

            return null;
        }
    }

    /*The top N populated countries in the world WHERE N is provided by the user.*/
    public ArrayList<Country> nWorldCountryPop(String N)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT country.name, country.continent, country.population "
                            + "FROM country "
                            + "ORDER BY country.population DESC LIMIT '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.Name = rset.getString("country.name");
                ctry.Continent = rset.getString("country.continent");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print world population when N is provided");

            return null;
        }
    }

    /*The top N populated countries in a continent WHERE N is provided by the user.*/
    public ArrayList<Country> nContinentCountryPop(String N, String continent)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT country.name, country.continent, country.population "
                            + "FROM country "
                            + "WHERE country.continent = '"+ continent +"'"
                            + "ORDER BY country.population DESC LIMIT '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.Name = rset.getString("country.name");
                ctry.Continent = rset.getString("country.continent");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print country population within a continent when N is provided");

            return null;
        }
    }

    /*The top N populated countries in a region WHERE N is provided by the user.*/
    public ArrayList<Country> nRegionCountryPop(String N, String region)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT country.name, country.continent, country.population "
                            + "FROM country "
                            + "WHERE country.region = '"+ region +"'"
                            + "ORDER BY country.population DESC LIMIT '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.Name = rset.getString("country.name");
                ctry.Continent = rset.getString("country.continent");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print country population within a region when N is provided");

            return null;
        }
    }

    /*All the cities in the world organised by largest population to smallest.*/
    public ArrayList<City> worldCityPop()
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "ORDER BY city.population DESC;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Country = rset.getString("country.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in the world");

            return null;
        }
    }

    /*All the cities in a continent organised by largest population to smallest.*/
    public ArrayList<City> continentCityPop(String continent)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE country.continent = '"+ continent +"'"
                            + "ORDER BY city.population DESC;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in a continent");

            return null;
        }
    }

    /*All the cities in a region organised by largest population to smallest. */
    public ArrayList<City> regionCityPop(String region)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE country.region = '"+ region +"'"
                            + "ORDER BY city.population DESC;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in a region");

            return null;
        }
    }

    /*All the cities in a country organised by largest population to smallest. */
    public ArrayList<City> countryCityPop(String country)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE country.name = '"+ country +"'"
                            + "ORDER BY city.population DESC;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in a country");

            return null;
        }
    }

    /*All the cities in a district organised by largest population to smallest. */
    public ArrayList<City> districtCityPop(String district)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name, city.population  "
                            + "FROM city "
                            + "WHERE city.district = '"+ district +"'"
                            + "ORDER BY city.population DESC;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in a district");

            return null;
        }
    }

    /*The top N populated cities in the world WHERE N is provided by the user.*/
    public ArrayList<City> nWorldCityPop(String N)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "ORDER BY city.population DESC LIMIT '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in the world");

            return null;
        }
    }

    /*The top N populated cities in a continent WHERE N is provided by the user.*/
    public ArrayList<City> nContinentCityPop(String N, String continent)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE country.continent = '"+ continent +"'"
                            + "ORDER BY city.population DESC LIMIT '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in a continent");

            return null;
        }
    }

    /*The top N populated cities in a region WHERE N is provided by the user.*/
    public ArrayList<City> nRegionCityPop(String N, String region)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE country.region = '"+ region +"'"
                            + "ORDER BY city.population DESC LIMIT '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }

            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in a region");

            return null;
        }
    }

    /*The top N populated cities in a country WHERE N is provided by the user.*/
    public ArrayList<City> nCountryCityPop(String N, String country)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE country.district = '"+ country +"'"
                            + "ORDER BY city.population DESC LIMIT '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in a continent");

            return null;
        }
    }

    /*The top N populated cities in a district WHERE N is provided by the user.*/
    public ArrayList<City> nDistrictCityPop(String N, String district)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE city.district = '"+ district +"'"
                            + "ORDER BY city.population DESC LIMIT '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getInt("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in a continent");

            return null;
        }
    }

    /*All the capital cities in the world organised by largest population to smallest. */
    public ArrayList<City> worldCapitalCityPop()
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE city.id = country.capital"
                            + "ORDER BY city.population DESC";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> capitals = new ArrayList<City>();
            while (rset.next())
            {
                City cptl = new City();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getInt("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all capital cities in the world");

            return null;
        }
    }

    /*All the capital cities in a continent organised by largest population to smallest. */
    public ArrayList<City> continentCapitalCityPop(String continent)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE city.id = country.capital AND continent = '"+ continent +"'"
                            + "ORDER BY city.population DESC";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> capitals = new ArrayList<City>();
            while (rset.next())
            {
                City cptl = new City();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getInt("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all capital cities in a continent");

            return null;
        }
    }

    /*All the capital cities in a region organised by largest to smallest. */
    public ArrayList<City> regionCapitalCityPop(String region)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE city.id = country.capital AND region = '"+ region +"'"
                            + "ORDER BY city.population DESC";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> capitals = new ArrayList<City>();
            while (rset.next())
            {
                City cptl = new City();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getInt("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all capital cities in a region");

            return null;
        }
    }

    /*The top N populated capital cities in the world WHERE N is provided by the user.*/
    public ArrayList<City> nWorldCapitalCityPop(String N)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE city.id = country.capital "
                            + "ORDER BY Population DESC '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> capitals = new ArrayList<City>();
            while (rset.next())
            {
                City cptl = new City();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getInt("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print N populations of all capital cities in the world");

            return null;
        }
    }

    /*The top N populated capital cities in a continent WHERE N is provided by the user.*/
    public ArrayList<City> nContinentCapitalCityPop(String N, String continent)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE city.id = country.capital AND continent = '"+ continent +"'"
                            + "ORDER BY city.population DESC '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> capitals = new ArrayList<City>();
            while (rset.next())
            {
                City cptl = new City();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getInt("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all N capital cities in a continent");

            return null;
        }
    }

    /*The top N populated capital cities in a region WHERE N is provided by the user.*/
    public ArrayList<City> nRegionCapitalCityPop(String N, String region)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "WHERE city.id = country.capital AND region = '"+ region +"'"
                            + "ORDER BY city.population DESC '"+ N+"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> capitals = new ArrayList<City>();
            while (rset.next())
            {
                City cptl = new City();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getInt("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all N capital cities in a region");

            return null;
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*The population of people, people living in cities, and people not living in cities in each continent.*/
    public ArrayList<City> continentInOutCityPop()
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT continent AS Continent, SUM(DISTINCT country.population) AS Population, SUM(city.population) AS City_Population, (SUM(DISTINCT country.population) - SUM(city.population)) AS NotInCities "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "GROUP BY continent;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> citiesInOut = new ArrayList<City>();
            while (rset.next()) {
                City cityInOut = new City();
                cityInOut.Name = rset.getString("Continent");
                cityInOut.Population = rset.getInt("Population");
                cityInOut.CityPopulation = rset.getInt("City_Population");
                cityInOut.NonCityPopulation = rset.getInt("NotInCities");
                citiesInOut.add(cityInOut);
            }
            return citiesInOut;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all N capital cities in a region");

            return null;
        }
    }

    /*The population of people, people living in cities, and people not living in cities in each region.*/
    public ArrayList<City> regionInOutCityPop() {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT continent AS Continent, SUM(DISTINCT country.population) AS Population, SUM(city.population) AS City_Population, (SUM(DISTINCT country.population) - SUM(city.population)) AS NotInCities "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "GROUP BY region;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> citiesInOut = new ArrayList<City>();
            while (rset.next()) {
                City cityInOut = new City();
                cityInOut.Name = rset.getString("Continent");
                cityInOut.Population = rset.getInt("Population");
                cityInOut.CityPopulation = rset.getInt("City_Population");
                cityInOut.NonCityPopulation = rset.getInt("NotInCities");
                citiesInOut.add(cityInOut);
            }
            return citiesInOut;
        }
        catch (Exception e)
        {            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all N capital cities in a region");

            return null;
        }
    }

    /*The population of people, people living in cities, and people not living in cities in each country.*/
    public ArrayList<City> countryInOutCityPop() {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT continent AS Continent, SUM(DISTINCT country.population) AS Population, SUM(city.population) AS City_Population, (SUM(DISTINCT country.population) - SUM(city.population)) AS NotInCities "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "GROUP BY country.name;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> citiesInOut = new ArrayList<City>();
            while (rset.next()) {
                City cityInOut = new City();
                cityInOut.Name = rset.getString("Continent");
                cityInOut.Population = rset.getInt("Population");
                cityInOut.CityPopulation = rset.getInt("City_Population");
                cityInOut.NonCityPopulation = rset.getInt("NotInCities");
                citiesInOut.add(cityInOut);
            }
            return citiesInOut;
        }
        catch (Exception e)
        {
            errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all N capital cities in a region");

            return null;
        }
    }
    /*Language Report*/
    public ArrayList<String> languageReport()
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT rawpopdata.Population, CONCAT(Percentage,'%') AS Percentage, Language FROM country, (SELECT ROUND(langpop,0) AS Population, ROUND(langpop/worldp*100,0)  AS Percentage, language AS Language FROM country, (SELECT SUM(population*percentage/100) AS langpop, language"
                            + "FROM country INNER JOIN countryLanguage ON country.Code = countryLanguage.countrycode"
                            + "WHERE language ='english' or language = 'chinese' or language = 'spanish' or language = 'hindi' or language='arabic'"
                            + "GROUP BY language)AS lang, (SELECT SUM(population) AS worldp FROM country)AS worldpop GROUP BY language ORDER BY langpop DESC)AS rawpopdata"
                            + "GROUP BY Language ORDER BY population DESC;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<String> langReport = new ArrayList<String>();
            while (rset.next())
            {
                String language = rset.getString("Language");
                String percentageSpeakers = rset.getString("Percentage");
                langReport.add(language + ' ' + percentageSpeakers);
            }
            return langReport;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print language report");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*Population Report*/
    /*World*/
    public ArrayList<String> worldPopulationReport()
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT sum(Population) AS total_population "
                            + "FROM country;";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<String> popReport = new ArrayList<String>();
            while (rset.next())
            {
                String World = "World";
                int Population = rset.getInt("total_population");
                popReport.add(World);
                popReport.add(Integer.toString((Population)));
            }
            return popReport;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print world population report");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*continent*/
    public ArrayList<String> continentPopulationReport(String continent)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT continent, sum(Population) AS total_population "
                            + "FROM country"
                            + "WHERE continent = '"+ continent +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<String> popReport = new ArrayList<String>();
            while (rset.next())
            {
                String Continent = rset.getString("continent");
                int Population = rset.getInt("total_population");
                popReport.add(Continent);
                popReport.add(Integer.toString((Population)));
            }
            return popReport;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print continent population report");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*region*/
    public ArrayList<Country> regionPopulationReport(String region)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT region, sum(Population) AS total_population "
                            + "FROM country"
                            + "WHERE region = "+ region +";";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> popReport = new ArrayList<Country>();
            while (rset.next())
            {
                String Region = rset.getString("region");
                int Population = rset.getInt("total_population");
                Country currentCountry = new Country();
                currentCountry.Region = Region;
                currentCountry.Population = Population;
                popReport.add(currentCountry);
            }
            return popReport;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print region population report");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*country*/
    public ArrayList<Country> countryPopulationReport(String country)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT name, population "
                            + "FROM country"
                            + "WHERE name = '"+ country +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> popReport = new ArrayList<Country>();
            while (rset.next())
            {
                String Country = rset.getString("country");
                int Population = rset.getInt("total_population");
                Country currentCountry = new Country();
                currentCountry.Name = Country;
                currentCountry.Population = Population;
                popReport.add(currentCountry);
            }
            return popReport;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print country population report");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*district*/
    public ArrayList<City> districtPopulationReport(String district)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT District, sum(population) AS total_population "
                            + "FROM city"
                            + "WHERE district = '"+ district +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> popReport = new ArrayList<City>();
            while (rset.next())
            {
                String District = rset.getString("district");
                int Population = rset.getInt("total_population");
                City currentCity = new City();
                currentCity.District = District;
                currentCity.Population = Population;
                popReport.add(currentCity);
            }
            return popReport;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print district population report");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*city*/
    public ArrayList<City> cityPopulationReport(String city)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT name, population "
                            + "FROM city"
                            + "WHERE name = '"+ city +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> popReport = new ArrayList<City>();
            while (rset.next())
            {
                String City = rset.getString("city");
                int Population = rset.getInt("total_population");
                City currentCity = new City();
                currentCity.Name = City;
                currentCity.Population = Population;
                popReport.add(currentCity);
            }
            return popReport;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print city population report");
            System.out.println(errorMessage);
            return null;
        }
    }
}