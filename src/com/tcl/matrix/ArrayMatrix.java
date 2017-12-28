package com.tcl.matrix;

public class ArrayMatrix extends AbstractMatrix {

    private double[][] a;

    public ArrayMatrix(double[][] a){
        if (a==null) throw new IllegalArgumentException("argument must not be null");

        this.n = a.length;
        if (n!=0) this.m = a[0].length;

        for (int i=0;i<n;i++) {
            if (a[i].length != m) {
                throw new IllegalArgumentException("All rows must have the same length.");
            }
            for (int j=0;j<m;j++) {
                this.a[i][j] = a[i][j];
            }
        }
    }

    public ArrayMatrix(Matrix a) {
        if (a==null) throw new IllegalArgumentException("argument must not be null");

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                this.a[i][j] = a.get(i,j);
            }
        }
    }

    @Override
    public double get(int i, int j) {
        return a[i][j];
    }

    @Override
    public Matrix plus(Matrix b) {
        this.checkMatrixDimensions(b);
        double[][] result = new double[n][m];

        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = this.get(i,j) + b.get(i,j);
            }
        }
        return new ArrayMatrix(result);
    }

    @Override
    public Matrix mul(double d) {

        double[][] result = new double[n][m];
        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = this.get(i,j)*d;
            }
        }
        return new ArrayMatrix(result);
    }

    @Override
    public Matrix getMatrix(int i0, int i1, int j0, int j1) {
        double[][] result = new double[i1-i0+1][j1-j0+1];
        for (int i=i0;i<i1;i++) {
            for (int j=j0;j<j1;j++) {
                result[i][j] = this.get(i,j);
            }
        }
        return new ArrayMatrix(result);
    }

    public RowVector getRow(int i) {
        double[][] d = new double[1][m];
        for (int j=0;j<m;j++) d[0][j] = this.get(0,j);
        return new ArrayMatrix(d);
    }
}
