package com.tcl.simplex;


import java.util.ArrayList;
import java.util.List;

public class Table {

    private int rowCount;
    private int columnCount;

    private List<List<Double>> matrix;
    private List<String> rowList, columnList;


    public Table(List<String> rowList, List<String> columnList) {
        this.rowList = new ArrayList<>(rowList);
        this.columnList = new ArrayList<>(columnList);




    }


}
