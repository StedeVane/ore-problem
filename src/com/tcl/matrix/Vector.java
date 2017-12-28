package com.tcl.matrix;

public interface Vector {

    public double get(int i);

    public int getDimension();

    public void checkDimensions(Vector b);

    public Vector plus(Vector b);
    public Vector mul(double d);
}
