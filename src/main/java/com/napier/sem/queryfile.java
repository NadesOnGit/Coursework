package com.napier.sem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Authors: Giles Anderson & Mo Ayaanle.
 */
public class queryfile
{
    public Connection con;

    public ArrayList<country> popWorld()
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT country.name, country.population "
                            + "FROM country "
                            + "ORDER BY country.population DESC";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country ctry = new country();
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
            errorMessage.append("Unable to print world population");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the countries in a continent organised by largest population to smallest. */
    public ArrayList<country> popContinent(String continent)
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
                            + "ORDER BY country.population DESC";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country ctry = new country();
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
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the countries in a region organised by largest population to smallest. */
    public ArrayList<country> popRegion(String region)
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
                            + "ORDER BY country.population DESC";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country ctry = new country();
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
            errorMessage.append("Unable to print Region population");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated countries in the world WHERE N is provided by the user.*/
    public ArrayList<country> nWorldCountryPop(String N)
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
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country ctry = new country();
                ctry.Name = rset.getString("country.name");
                ctry.Continent = rset.getString("country.continent");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print world population when N is provided");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated countries in a continent WHERE N is provided by the user.*/
    public ArrayList<country> nContinentCountryPop(String N, String continent)
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
                            + "ORDER BY country.population DESC LIMIT '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country ctry = new country();
                ctry.Name = rset.getString("country.name");
                ctry.Continent = rset.getString("country.continent");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print country population within a continent when N is provided");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated countries in a region WHERE N is provided by the user.*/
    public ArrayList<country> nRegionCountryPop(String N, String region)
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
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country ctry = new country();
                ctry.Name = rset.getString("country.name");
                ctry.Continent = rset.getString("country.continent");
                ctry.Population = rset.getInt("country.population");
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print country population within a region when N is provided");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the cities in the world organised by largest population to smallest.*/
    public ArrayList<city> worldCityPop()
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
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in the world");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the cities in a continent organised by largest population to smallest.*/
    public ArrayList<city> continentCityPop(String continent)
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
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in a continent");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the cities in a region organised by largest population to smallest. */
    public ArrayList<city> regionCityPop(String region)
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
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in a region");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the cities in a country organised by largest population to smallest. */
    public ArrayList<city> countryCityPop(String country)
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
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in a country");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the cities in a district organised by largest population to smallest. */
    public ArrayList<city> districtCityPop(String district)
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
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print population fo cities in a district");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated cities in the world WHERE N is provided by the user.*/
    public ArrayList<city> nWorldCityPop(String N)
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country, country.continent "
                            + "FROM city JOIN country ON (country.code = city.countrycode) "
                            + "ORDER BY city.population DESC LIMIT '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in the world");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated cities in a continent WHERE N is provided by the user.*/
    public ArrayList<city> nContinentCityPop(String N, String continent)
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
                            + "ORDER BY city.population DESC LIMIT '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in a continent");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated cities in a region WHERE N is provided by the user.*/
    public ArrayList<city> nRegionCityPop(String N, String region)
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
                            + "ORDER BY city.population DESC LIMIT '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in a region");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated cities in a country WHERE N is provided by the user.*/
    public ArrayList<city> nCountryCityPop(String N, String country)
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
                            + "ORDER BY city.population DESC LIMIT '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in a continent");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated cities in a district WHERE N is provided by the user.*/
    public ArrayList<city> nDistrictCityPop(String N, String district)
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
                            + "ORDER BY city.population DESC LIMIT '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cty = new city();
                cty.Name = rset.getString("city.name");
                cty.Population = rset.getString("city.population");
                cities.add(cty);
            }
            return cities;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print the top N populated cities in a continent");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the capital cities in the world organised by largest population to smallest. */
    public ArrayList<city> worldCapitalCityPop()
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
            ArrayList<city> capitals = new ArrayList<city>();
            while (rset.next())
            {
                city cptl = new city();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getString("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all capital cities in the world");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the capital cities in a continent organised by largest population to smallest. */
    public ArrayList<city> continentCapitalCityPop(String continent)
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
            ArrayList<city> capitals = new ArrayList<city>();
            while (rset.next())
            {
                city cptl = new city();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getString("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all capital cities in a continent");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*All the capital cities in a region organised by largest to smallest. */
    public ArrayList<city> regionCapitalCityPop(String region)
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
            ArrayList<city> capitals = new ArrayList<city>();
            while (rset.next())
            {
                city cptl = new city();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getString("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all capital cities in a region");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated capital cities in the world WHERE N is provided by the user.*/
    public ArrayList<city> nWorldCapitalCityPop(String N)
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
                            + "ORDER BY Population DESC '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> capitals = new ArrayList<city>();
            while (rset.next())
            {
                city cptl = new city();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getString("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print N populations of all capital cities in the world");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated capital cities in a continent WHERE N is provided by the user.*/
    public ArrayList<city> nContinentCapitalCityPop(String N, String continent)
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
                            + "ORDER BY city.population DESC '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> capitals = new ArrayList<city>();
            while (rset.next())
            {
                city cptl = new city();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getString("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all N capital cities in a continent");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The top N populated capital cities in a region WHERE N is provided by the user.*/
    public ArrayList<city> nRegionCapitalCityPop(String N, String region)
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
                            + "ORDER BY city.population DESC '"+ N +"';";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> capitals = new ArrayList<city>();
            while (rset.next())
            {
                city cptl = new city();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getString("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all N capital cities in a region");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*The population of people, people living in cities, and people not living in cities in each continent.*/
    public ArrayList<city> continentInOutCityPop()
    {
        try
        {
            // Generate the SQL statement
            Statement stmt = con.createStatement();
            // Add SQL statement to a string
            String strSelect =
                    "SELECT continent AS Continent, SUM(DISTINCT country.population) AS Population, SUM(city.population) AS " + '"' + "City Population" + '"' + ", (SUM(DISTINCT country.population) - SUM(city.population)) AS NotInCities "
                + "FROM city JOIN country ON (country.code = city.countrycode) "
                + "GROUP BY continent";
            // Run SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<city> capitals = new ArrayList<city>();
            while (rset.next())
            {
                city cptl = new city();
                cptl.Name = rset.getString("city.name");
                cptl.Population = rset.getString("city.population");
                capitals.add(cptl);
            }
            return capitals;
        }
        catch (Exception e)
        {
            StringBuilder errorMessage = new StringBuilder("Error: ");
            errorMessage.append(e.getMessage());
            errorMessage.append("Unable to print populations of all N capital cities in a region");
            System.out.println(errorMessage);
            return null;
        }
    }

    /*The population of people, people living in cities, and people not living in cities in each region.*/

    /*The population of people, people living in cities, and people not living in cities in each country.*/
}