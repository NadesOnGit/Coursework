package com.napier.sem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OutputUI {

    private JButton button1;
    private JScrollPane javapane;
    private JPanel OutputUIpanel;
    private JTextPane textPane1;
    public int coloumCount;
    public OutputUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int rowCount;
                System.out.println("eee");

                List<String> row = new ArrayList<String>();

                //Insert input here
                String[] line = {"+------------+------------+----------+", "| Population | Percentage | Language |", "+------------+------------+----------+", "| 1191843539 | 20%        | Chinese  |", "|  405633070 | 7%         | Hindi    |", "|  355029462 | 6%         | Spanish  |", "|  347077867 | 6%         | English  |", "|  233839239 | 4%         | Arabic   |", "+------------+------------+----------+"};
                for (int i = 0; i < line.length; i++) {

                    String[] rowLine = line[i].split("|");
                    row.add(line[i]);


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
                    if (!row.get(i).contains("+")) {
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


                //Creates new table frame
                JFrame frame = new JFrame();
                //Insert data into table
                JTable table = new JTable(rowOutputFix, rowOutputFix[1]);
                frame.setBounds(30, 40, 200, 300);
                frame.add(table);
                frame.setSize(500, 200);
                frame.setVisible(true);

            }
        });

    }


    // Used from github.com/Kevin-Sim/SET08103/blob/master/labs/lab03/README.md | Extracting Connect and Disconnect Functionality


    public static void main(String[] args) {
        JFrame frame = new JFrame("OutputUI");
        frame.setContentPane(new OutputUI().OutputUIpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}