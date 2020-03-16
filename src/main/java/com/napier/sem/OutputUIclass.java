package com.napier.sem;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
/*
            Jack Masterton
 */


public class OutputUIclass {
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

    public void tableDouble(String[][] inputData, String[][] inputInfo) {

        //Creates new table frame

        JFrame frame = new JFrame();
        //Insert data into table
        JTable table = new JTable(inputData, inputData[1]);
        JTable table2 = new JTable(inputInfo, inputInfo[1]);
        //define size of table
        frame.setBounds(30, 40, inputData[1].length * 70, inputData[1].length * 36);
        frame.add(table, BorderLayout.NORTH);
        frame.add(table2, BorderLayout.SOUTH);
        frame.setSize(inputData.length * 100, inputData[1].length * 18);
        frame.setVisible(true);
    }


}