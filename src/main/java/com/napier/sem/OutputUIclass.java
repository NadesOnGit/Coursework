package com.napier.sem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class OutputUIclass {

    public String[][] tableBuilder(String[] inputString) {

        int rowCount;
        System.out.println("eee");

        List<String> row = new ArrayList<String>();

        for (int i = 0; i < inputString.length; i++) {

            String[] rowLine = inputString[i].split("|");
            row.add(inputString[i]);


        }


        rowCount = row.size();
        String column = row.get(1);
        int columnCount = column.split("\\|").length;
        Object[] lineRow = {row};

        List<String> fixOutput = new ArrayList<>();
        System.out.println("WWW");

        int o = 0;
        for (int i = 0; i < row.size(); i++) {
            //Removes useless "+-----+-----+" rows
            if (!row.get(i).contains("-+")) {
                fixOutput.add(row.get(i));
                o++;

            }

        }
        //Declares data+row output
        String[][] rowOutput = new String[o][columnCount];
        //Variable used to remove blank first row
        String[][] rowOutputFix = new String[o][columnCount - 1];
        for (int i = 0; i < fixOutput.size(); i++) {
            //Splits Data into separate rows using "|"
            rowOutput[i] = fixOutput.get(i).split("\\|");
            int u = 0;
            //Removes blank first column
            for (int v = 1; v < rowOutput[i].length; v++) {
                rowOutputFix[i][u] = rowOutput[i][v];
                u++;
            }

        }

        return rowOutputFix;

    }
    //For single table
    public void tableSingle(String[] inputData){
        //Creates new table frame
        String[][] rowData = tableBuilder(inputData);
        JFrame frame = new JFrame();
        //Insert data into table
        JTable table = new JTable(rowData, rowData[1]);
        //define size of table
        frame.setBounds(30, 40, rowData[1].length * 70, rowData[1].length * 36);
        frame.add(table);
        frame.setSize(rowData.length * 100, rowData[1].length * 18);
        frame.setVisible(true);
    }
    //For main table + info table
    public void tableDouble(String[] inputData, String[] inputInfo){
        String[][] rowData = tableBuilder(inputData);
        String[][] infoData = tableBuilder(inputInfo);
        //Creates new table frame

        JFrame frame = new JFrame();
        frame.setTitle("Report Output");
        //Insert data into table
        JTable table = new JTable(rowData, rowData[1]);
        JTable infoTable = new JTable(infoData, infoData[1]);
        //defines size of table
        frame.setBounds(30, 40, rowData[1].length * 70+ infoData[1].length*70, inputData[1].length() * 6+inputInfo[1].length()*3);

        frame.add(table, BorderLayout.NORTH);
        frame.add(infoTable,BorderLayout.SOUTH);
        frame.setSize(rowData[1].length * 100+infoData[1].length*140, inputData[1].length()*6 + inputInfo[1].length()*3);

        frame.setVisible(true);

    }


}




