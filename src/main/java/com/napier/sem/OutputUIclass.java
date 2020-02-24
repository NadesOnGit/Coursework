package com.napier.sem;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
/*
            Jack Masterton
 */


public class OutputUIclass {

    public String[][] tableBuilder(ArrayList[] inputString) {
        String[] stringList = new String[inputString.length];
        int rowCount;
        System.out.println("eee");
        for (int i = 0; i < inputString.length; i++) {
            stringList[i] = inputString[i].toString();
        }

        List<String> row = new ArrayList<String>();

        for (int i = 0; i < stringList.length; i++) {

            String[] rowLine = stringList[i].split("|");
            row.add(stringList[i]);


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

    public void tableSingle(String[][] inputData) {
        //Creates new table frame

        JFrame frame = new JFrame();
        //Insert data into table
        JTable table = new JTable(inputData, inputData[1]);
        //define size of table
        frame.setBounds(30, 40, inputData[1].length * 70, inputData[1].length * 36);
        frame.add(table);
        frame.setSize(inputData.length * 100, inputData[1].length * 18);
        frame.setVisible(true);
    }

    public void tableDouble(ArrayList[] inputData, ArrayList[] inputInfo) {
        String[][] rowData = tableBuilder(inputData);
        String[][] infoData = tableBuilder(inputInfo);
        //Creates new table frame

        JFrame frame = new JFrame();
        JFrame frame2 = new JFrame();
        //Insert data into table
        JTable table = new JTable(rowData, rowData[1]);
        JTable infoTable = new JTable(infoData, infoData[1]);
        //define size of table
        frame.setBounds(30, 40, rowData[1].length * 70, inputData[1].size() * 8);
        frame2.setBounds(30, 40 + rowData[1].length * 70, infoData[1].length * 70, inputInfo[1].size() * 36);
        frame.add(table);
        frame2.add(infoTable);
        frame.setSize(rowData[1].length * 100, inputData[1].size() * 5);
        frame2.setSize(infoData[1].length * 100, inputInfo[1].size() * 3);
        frame.setVisible(true);
        frame2.setVisible(true);
    }


}