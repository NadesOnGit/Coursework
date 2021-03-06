package com.napier.sem;

import java.util.ArrayList;


/*
    Jack Masterton
 */


public class OutputLinker {


    //used to process the output data from a query to make it readable to the table builder
    public boolean SQLinititate(String input, String countryInput, String distInput, String contInput, String regInput, String numbInput) {
        QueryHandler query = new QueryHandler("world.sql");

        try {
            //used to select which query to run based on user input
            if (input == "All the countries in the world organised by largest population to smallest.") {

                ArrayList<Country> list = query.popWorld();
                System.out.println("All countries in the world organised by population from largest to smallest");
                for (Country country : list) {
                    System.out.format("%-18s%-8s%-8s", country.Name, country.Continent, country.Region, country.Population, country.Capital);
                }

            } else if (input == "All the countries in a continent organised by largest population to smallest.") {
                ArrayList<Country> list = query.popContinent(contInput);
                System.out.println("All countries in "+contInput+" organised by population from largest to smallest \n");
                for (Country country : list) {
                    System.out.format("%-18s%-8s%-8s", country.Name, country.Continent, country.Region, country.Population, country.Capital);
                }

            } else if (input == "All the countries in a region organised by largest population to smallest.") {
                ArrayList<Country> list = query.popRegion(regInput);
                System.out.println("All countries in "+regInput+"organised by population from largest to smallest");
                for (Country country : list) {
                    System.out.format("%-18s%-8s%-8s", country.Name, country.Continent, country.Region, country.Population, country.Capital);
                }

            } else if (input == "The top N populated countries in the world.") {
                ArrayList<Country> list = query.nWorldCountryPop(numbInput);
                System.out.println("Top "+numbInput+" most populated countries in the world");
                for (Country country : list) {
                    System.out.format("%-18s%-8s%-8s", country.Name, country.Continent, country.Region, country.Population, country.Capital);
                }
            } else if (input == "The top N populated countries in a continent.") {
                ArrayList<Country> list = query.nContinentCountryPop(numbInput, contInput);
                System.out.println("Top "+numbInput+" most populated countries in "+ contInput);
                for (Country country : list) {
                    System.out.format("%-18s%-8s%-8s", country.Name, country.Continent, country.Region, country.Population, country.Capital);
                }
            } else if (input == "The top N populated countries in a region.") {
                ArrayList<Country> list = query.nRegionCountryPop(numbInput, regInput);
                System.out.println("Top "+numbInput+" populated countries in "+regInput);
                for (Country country : list) {
                    System.out.format("%-18s%-8s%-8s", country.Name, country.Continent, country.Region, country.Population, country.Capital);
                }
            } else if (input == "All the cities in the world organised by largest population to smallest.") {
                ArrayList<City> list = query.worldCityPop();
                System.out.println("All cities in the world organised by population by largest to smallest");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }

            } else if (input == "All the cities in a continent organised by largest population to smallest.") {
                ArrayList<City> list = query.continentCityPop(contInput);
                System.out.println("All cities in "+contInput+" organised by population from largest to smallest");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "All the cities in a region organised by largest population to smallest.") {
                ArrayList<City> list = query.regionCityPop(regInput);
                System.out.println("All cities in "+regInput+" organised by population from largest to smallest");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "All the cities in a country organised by largest population to smallest.") {
                ArrayList<City> list = query.countryCityPop(countryInput);
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "All the cities in a district organised by largest population to smallest.") {
                ArrayList<City> list = query.districtCityPop(distInput);
                System.out.println("All the cities in "+distInput+" organised by population from largest to smallest");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The top N populated cities in the world.") {
                ArrayList<City> list = query.nWorldCityPop(numbInput);
                System.out.println("Top "+numbInput+" populated cities in the world");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The top N populated cities in a continent.") {
                ArrayList<City> list = query.nContinentCityPop(numbInput, contInput);
                System.out.println("The top "+numbInput+" populated cities in "+contInput);
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The top N populated cities in a region.") {
                ArrayList<City> list = query.nRegionCityPop(numbInput, regInput);
                System.out.println("The top "+numbInput+" most populaged cities in "+regInput);
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The top N populated cities in a country.") {
                ArrayList<City> list = query.nCountryCityPop(numbInput, countryInput);
                System.out.println("The top "+numbInput+" most populaged cities in "+countryInput);
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The top N populated cities in a district.") {
                ArrayList<City> list = query.nDistrictCityPop(numbInput, regInput);
                System.out.println("The top "+numbInput+" most populaged cities in "+distInput);
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "All the capital cities in the world organised by largest population to smallest.") {
                ArrayList<City> list = query.worldCapitalCityPop();
                System.out.println("Capital cities in the world organiesd by population");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "All the capital cities in a continent organised by largest population to smallest.") {
                System.out.println("Capital cities in "+contInput+" organised by population");
                ArrayList<City> list = query.continentCapitalCityPop(contInput);
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "All the capital cities in a region organised by largest to smallest.") {
                ArrayList<City> list = query.regionCapitalCityPop(regInput);
                System.out.println("Capital cities in "+regInput+" organised by population");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The top N populated capital cities in the world.") {
                ArrayList<City> list = query.nWorldCapitalCityPop(numbInput);
                System.out.println("Top "+numbInput+" most populated capital cities");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The top N populated capital cities in a continent.") {
                ArrayList<City> list = query.nContinentCapitalCityPop(numbInput, contInput);
                System.out.println("Top "+numbInput+" most populated capital cities in "+contInput);
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The top N populated capital cities in a region.") {
                ArrayList<City> list = query.continentInOutCityPop();
                System.out.println("Top "+numbInput+" most populated capital cities in "+regInput);
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The population of people, people living in cities, and people not living in cities in each continent.") {
                ArrayList<City> list = query.continentInOutCityPop();
                System.out.println("Population comparison of people living in cities and poeple not in cities per continent");
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The population of people, people living in cities, and people not living in cities in each region.") {
                System.out.println("Population comparison of people living in cities and poeple not in cities per region");
                ArrayList<City> list = query.regionInOutCityPop();
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }
            } else if (input == "The population of people, people living in cities, and people not living in cities in each country.") {
                System.out.println("Population comparison of people living in cities and poeple not in cities per country");
                ArrayList<City> list = query.countryInOutCityPop();
                for (City city : list) {
                    System.out.format("%-18s%-8s%-8s", city.Name, city.Country, city.District, city.Population);
                }

            }else if (input=="IFSTATEMENTTEST"){
                return true;
            }


            return false;


        }catch (Exception e){

        }
        return false;

    }

}

