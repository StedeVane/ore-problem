package com.tcl.matrix;

public class ArrayMatrix extends AbstractMatrix {

    private double[][] A;

    public ArrayMatrix(double[][] A){
        if (A==null) throw new IllegalArgumentException("argument must not be null");

        this.n = A.length;
        if (n!=0) this.m = A[0].length;

        for (int i=0;i<n;i++) {
            if (A[i].length != m) {
                throw new IllegalArgumentException("All rows must have the same length.");
            }
            for (int j=0;j<m;j++) {
                this.A[i][j] = A[i][j];
            }
        }
    }

    public ArrayMatrix(Matrix A) {
        if (A==null) throw new IllegalArgumentException("argument must not be null");

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                this.A[i][j] = A.get(i,j);
            }
        }
    }

    @Override
    public double get(int i, int j) {
        return A[i][j];
    }

    @Override
    public Matrix plus(Matrix B) {
        this.checkMatrixDimensions(B);
        ArrayMatrix R = new ArrayMatrix(A);
        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                R.A[i][j] += this.A[i][j];
            }
        }
        return R;
    }

}
