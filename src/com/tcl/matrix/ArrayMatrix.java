package com.tcl.matrix;

public class ArrayMatrix implements Matrix {

    private double[][] a;

    private int n;
    private int m;

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

    public ArrayMatrix(Matrix b) {
        if (b==null) throw new IllegalArgumentException("argument must not be null");

        this.n = b.getRowDimension();
        this.m = b.getColumnDimension();

        this.a = new double[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                this.a[i][j] = b.get(i,j);
            }
        }
    }

    @Override
    public int getRowDimension() {
        return n;
    }

    @Override
    public int getColumnDimension() {
        return m;
    }

    @Override
    public void checkMatrixDimensions(Matrix b) {
        if (this.getRowDimension()!=b.getRowDimension() || this.getColumnDimension()!=b.getColumnDimension()) {
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
    }

    @Override
    public void checkVectorDimensions(RowVector v) {
        if (this.getColumnDimension()!=v.getDimension()) {
            throw new IllegalArgumentException("Vector dimensions must agree.");
        }
    }

    @Override
    public void checkVectorDimensions(ColumnVector v) {
        if (this.getRowDimension()!=v.getDimension()) {
            throw new IllegalArgumentException("Vector dimensions must agree.");
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
    public Matrix plus(RowVector b, int k) {
        this.checkVectorDimensions(b);
        double[][] result = new double[n][m];

        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = this.get(i,j);

            }
            if (i==k)
                for (int j=0;j<m;j++)
                    result[i][j] += b.get(j);
        }
        return new ArrayMatrix(result);
    }

    @Override
    public Matrix plus(ColumnVector b, int t) {
        this.checkVectorDimensions(b);
        double[][] result = new double[n][m];

        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = this.get(i,j);
                if (j==t)
                    result[i][j] += b.get(i);
            }
        }
        return new ArrayMatrix(result);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Matrix swapRow(int i0, int i1) {
        double[][] result = new double[n][m];
        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = this.get(i, j);
            }
        }

        double temp;
        for (int j=0; j<m; j++) {
            temp = result[i0][j];
            result[i0][j] = result[i1][j];
            result[i1][j] = temp;
        }

        return new ArrayMatrix(result);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Matrix swapColumn(int j0, int j1) {
        double[][] result = new double[n][m];
        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = this.get(i, j);
            }
        }

        double temp;
        for (int i=0; i<n; i++) {
            temp = result[i][j0];
            result[i][j0] = result[i][j1];
            result[i][j1] = temp;
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

    @Override
    public RowVector getRow(int i) {
        double[] result = new double[m];
        for (int j=0;j<m;j++) result[j] = this.get(i,j);
        return new ArrayVector(result);
    }

    @Override
    public ColumnVector getColumn(int j) {
        double[] result = new double[n];
        for (int i=0;i<n;i++) result[i] = this.get(i,j);
        return new ArrayVector(result);
    }

    @Override
    public Matrix clone() {
        return new ArrayMatrix(this);
    }
}
