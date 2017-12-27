package com.tcl.matrix;

public abstract class AbstractMatrix implements Matrix {

    protected int n;
    protected int m;

    @Override
    public int getRowCount() {
        return n;
    }

    @Override
    public int getColumnCount() {
        return m;
    }

    @Override
    public int getRowDimension() {
        return m;
    }

    @Override
    public int getColumnDimension() {
        return n;
    }

    @Override
    public void checkMatrixDimensions(Matrix B) {
        if (this.getRowDimension()!=B.getRowDimension() || this.getColumnDimension()!=B.getColumnDimension()) {
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
    }


}
