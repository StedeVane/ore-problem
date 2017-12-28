package com.tcl.matrix;

public interface Matrix  {


    public double get(int i, int j);

    public int getRowDimension();
    public int getColumnDimension();

    public void checkMatrixDimensions(Matrix b);

    public Matrix plus(Matrix b);
    public Matrix mul(double d);

    public Matrix getMatrix(int i0, int i1, int j0, int j1);
}
