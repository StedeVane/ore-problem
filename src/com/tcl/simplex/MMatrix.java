package com.tcl.simplex;


import java.util.ArrayList;
import java.util.List;

public class MMatrix {

    private List<List<Double>> matrix;
    private int n,m;

    private List<String> rowLable, columnLable;

    public MMatrix(List<List<Double>> matrix, List<String> rowLable, List<String> columnLable) {
        this.matrix = new ArrayList<>();
        this.matrix.addAll(matrix);
        this.rowLable = new ArrayList<>(rowLable);
        this.columnLable = new ArrayList<>(columnLable);

        this.n = matrix.size();
        this.m = matrix.get(0).size();
    }

    public MMatrix(MMatrix matrix) {
        this.matrix = new ArrayList<>();
        this.matrix.addAll(matrix.matrix);

        this.rowLable = new ArrayList<>(matrix.rowLable);
        this.columnLable = new ArrayList<>(matrix.columnLable);

        this.n = matrix.n;
        this.m = matrix.m;
    }

    public double get(int i, int j) {
        return matrix.get(i).get(j);
    }

    public void set(int i, int j, double d) {
        this.matrix.get(i).set(j,d);
    }


    public MMatrix gaussian() {
        MMatrix result = new MMatrix(this);
        int ii=0;

        while (ii<n) {
            int i = ii;
            for (; i < result.n; i++) {
                if (result.get(i, ii) != 0) break;
            }
            if (i==n) {ii++; continue;}
            result.swappingRow(i, ii);
            result.divRow(ii, result.get(ii, ii));

            for (i = 0; i < result.n; i++) {
                if (ii != i) {
                    double d = result.get(i, ii);
                    for (int j = 0; j < result.m; j++) {
                        result.set(i, j, result.get(i, j) - d * result.get(ii, j));
                    }
                }
            }

     //       System.out.println(ii+":\t"+result);

            ii++;
        }

        return result;
    }


    private void divRow(int i, double d) {
        for (int j=0;j<matrix.get(i).size();j++) {
            matrix.get(i).set(j,matrix.get(i).get(j)/d);
        }
    }

    private void swappingRow(int i, int j) {
        if (i==j) return;

        List<Double> temp = matrix.get(i);
        matrix.set(i,matrix.get(j));
        matrix.set(j,temp);

        String str = rowLable.get(i);
        rowLable.set(i,rowLable.get(j));
        rowLable.set(j,str);
    }

    private void swappingColumn(int i,int j) {
        if (i==j) return;

        for (List<Double> row : matrix) {
            double d = row.get(i);
            row.set(i,row.get(j));
            row.set(j,d);
        }

        String str = columnLable.get(i);
        columnLable.set(i,columnLable.get(j));
        columnLable.set(j,str);
    }

    @Override
    public String toString() {
        String tab = "\t\t";
        String result = super.toString()+"\n"+tab;

        for (String c: columnLable) {
            result+=c+tab;
        }
        result+="\n";


        for (int i=0;i<matrix.size();i++) {
            result+=rowLable.get(i)+":"+tab;
            for (Double ij: matrix.get(i)) {
                result+=ij+tab;
            }
            result+="\n";
        }
        return result;
    }
}
