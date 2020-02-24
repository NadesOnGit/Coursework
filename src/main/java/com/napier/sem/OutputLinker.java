package com.napier.sem;

import java.util.ArrayList;


/*
    Jack Masterton
 */


public class OutputLinker {
    public boolean SQLinititate(String input, String countryInput, String distInput, String contInput, String regInput, String numbInput, Boolean needSubtable) {
        queryfile query = new queryfile();
        OutputUIclass outputUI = new OutputUIclass();

        if (input == "e") {

            ArrayList<Country> list = query.popWorld();

            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Code;
                string[i][1] = list.get(i).Name;
                string[i][2] = list.get(i).Region;
                string[i][3] = Double.toString(list.get(i).Population);
                string[i][4] = Integer.toString(list.get(i).Capital);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.popContinent(contInput);
            //ArrayList<country> contextList = query.whatevermothoditscalled();
            String[][] string = new String[list.size()][1];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = Double.toString(list.get(i).Population);

            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.popRegion(regInput);
            String[][] string = new String[list.size()][1];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = Double.toString(list.get(i).Population);

            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.nWorldCountryPop(numbInput);
            String[][] string = new String[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = Double.toString(list.get(i).Population);

            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.nContinentCountryPop(numbInput, contInput);
            String[][] string = new String[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = Double.toString(list.get(i).Population);

            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.nRegionCountryPop(numbInput, regInput);
            String[][] string = new String[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = Double.toString(list.get(i).Population);

            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.worldCityPop();
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.continentCityPop(contInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.regionCityPop(regInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.countryCityPop(countryInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.districtCityPop(distInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.nWorldCityPop(numbInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.nContinentCityPop(numbInput, contInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.nRegionCityPop(numbInput, regInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.nCountryCityPop(numbInput, countryInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.nDistrictCityPop(numbInput, regInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.worldCapitalCityPop();
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.continentCapitalCityPop(contInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.regionCapitalCityPop(regInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.nWorldCapitalCityPop(numbInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.nContinentCapitalCityPop(numbInput, contInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<City> list = query.continentInOutCityPop();
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][2] = list.get(i).Country;
                string[i][2] = list.get(i).District;
                string[i][4] = Integer.toString(list.get(i).Population);
            }
            outputUI.tableSingle(string);
        }



        return true;
    }
}