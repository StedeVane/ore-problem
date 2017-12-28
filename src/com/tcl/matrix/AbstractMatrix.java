package com.tcl.matrix;

public abstract class AbstractMatrix implements Matrix {

    protected int n;
    protected int m;


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


}
