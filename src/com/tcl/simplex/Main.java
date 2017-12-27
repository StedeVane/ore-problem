package com.tcl.simplex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<String> rowLable = new ArrayList<>();
        for (int i=0;i<n;i++) {
            rowLable.add(scanner.next());
        }


        int m = scanner.nextInt();
        List<String> columnLable = new ArrayList<>();
        for (int j=0;j<m;j++) {
            columnLable.add(scanner.next());
        }


        List<List<Double>> l = new ArrayList<>();

        for (int i=0;i<n;i++) {
            List<Double> d = new ArrayList<>();
            for (int j=0;j<m;j++) {
                d.add(scanner.nextDouble());
            }
            l.add(d);
        }

        MMatrix matrix = new MMatrix(l,rowLable,columnLable);
        System.out.println(matrix);
        MMatrix mmm = matrix.gaussian();



    }

}
