package com.tcl.matrix;

public interface Matrix  {


    public double get(int i, int j);

    public int getRowCount();
    public int getColumnCount();

    public int getRowDimension();
    public int getColumnDimension();

    public void checkMatrixDimensions(Matrix B);

    public Matrix plus (Matrix B);
}
