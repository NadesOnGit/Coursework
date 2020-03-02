package com.napier.sem;

import java.util.ArrayList;


/*
    Jack Masterton
 */


public class OutputLinker {
    //Used to create a table that is based on the Country object
    public void countryTable(ArrayList<Country> inputList,  boolean doubleTable){
        OutputUIclass outputUI = new OutputUIclass();
        String[][] string = new String[inputList.size()][4];
        for (int i = 0; i < inputList.size(); i++) {
            string[i][0] = inputList.get(i).Code;
            string[i][1] = inputList.get(i).Name;
            string[i][2] = inputList.get(i).Region;
            string[i][3] = Double.toString(inputList.get(i).Population);
            string[i][4] = Integer.toString(inputList.get(i).Capital);
        }
        if(doubleTable){
            //outputUI.tableDouble(inputList,);
        }
        else {
            outputUI.tableSingle(string);
        }


    }
    //Used to create a table that is based on the City object
    public void cityTable(ArrayList<City> inputList,  boolean doubleTable) {
        OutputUIclass outputUI = new OutputUIclass();
        String[][] string = new String[inputList.size()][3];
        for (int i = 0; i < inputList.size(); i++) {
            string[i][0] = inputList.get(i).Name;
            string[i][1] = inputList.get(i).Country;
            string[i][2] = inputList.get(i).District;
            string[i][3] = Integer.toString(inputList.get(i).Population);
        }
        if (doubleTable) {
            //outputUI.tableDouble(inputList,);
        } else {
            outputUI.tableSingle(string);
        }
    }
    public void extraTable(){

    }
    //used to process the output data from a query to make it readable to the table builder
    public boolean SQLinititate(String input, String countryInput, String distInput, String contInput, String regInput, String numbInput, Boolean needSubtable) {
        QueryHandler query = new QueryHandler("./db/test_db/world.sql");
        OutputUIclass outputUI = new OutputUIclass();
        try{
            //used to select which query to run based on user input
        if (input == "1") {

            ArrayList<Country> list = query.popWorld();

            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = list.get(i).Region;
                string[i][3] = Double.toString(list.get(i).Population);
                string[i][4] = Integer.toString(list.get(i).Capital);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.popContinent(contInput);
            //ArrayList<country> contextList = query.whatevermothoditscalled();
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = list.get(i).Region;
                string[i][3] = Double.toString(list.get(i).Population);
                string[i][4] = Integer.toString(list.get(i).Capital);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.popRegion(regInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = list.get(i).Region;
                string[i][3] = Double.toString(list.get(i).Population);
                string[i][4] = Integer.toString(list.get(i).Capital);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.nWorldCountryPop(numbInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = list.get(i).Region;
                string[i][3] = Double.toString(list.get(i).Population);
                string[i][4] = Integer.toString(list.get(i).Capital);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.nContinentCountryPop(numbInput, contInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = list.get(i).Region;
                string[i][3] = Double.toString(list.get(i).Population);
                string[i][4] = Integer.toString(list.get(i).Capital);
            }
            outputUI.tableSingle(string);
        } else if (input == "e") {
            ArrayList<Country> list = query.nRegionCountryPop(numbInput, regInput);
            String[][] string = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                string[i][0] = list.get(i).Name;
                string[i][1] = list.get(i).Continent;
                string[i][2] = list.get(i).Region;
                string[i][3] = Double.toString(list.get(i).Population);
                string[i][4] = Integer.toString(list.get(i).Capital);
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
        }catch (Exception e){

        }



        return true;
    }
}