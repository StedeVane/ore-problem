package com.tcl.matrix;

import java.io.Serializable;

public interface Matrix extends Serializable, Cloneable {


    public double get(int i, int j);

    public int getRowDimension();
    public int getColumnDimension();

    public void checkMatrixDimensions(Matrix b);
    public void checkVectorDimensions(RowVector b);
    public void checkVectorDimensions(ColumnVector b);

    public Matrix plus(Matrix b);
    public Matrix plus(RowVector b, int k);
    public Matrix plus(ColumnVector b, int t);

    public Matrix swapRow(int i0, int i1);
    public Matrix swapColumn(int j0, int j1);

    public Matrix mul(double d);

    public Matrix getMatrix(int i0, int i1, int j0, int j1);
    public RowVector getRow(int i);
    public ColumnVector getColumn(int j);

    public Matrix clone();
}
