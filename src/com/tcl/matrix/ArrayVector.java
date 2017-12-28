package com.tcl.matrix;

public class ArrayVector implements RowVector, ColumnVector {

    private int n;
    private double[] v;

    public ArrayVector(double[] v) {
        if (v==null) throw new IllegalArgumentException("argument must not be null");
        this.n = v.length;
        this.v = new double[n];
        for (int i=0;i<n;i++)
            this.v[i] = v[i];
    }

    @Override
    public double get(int i) {
        return v[i];
    }

    @Override
    public int getDimension() {
        return n;
    }

    @Override
    public void checkDimensions(Vector b) {
        if (this.getDimension() != b.getDimension()) throw new IllegalArgumentException("Vector dimensions must agree.");
    }

    @Override
    public Vector plus(Vector b) {
        this.checkDimensions(b);
        double[] result = new double[n];
        for (int i=0;i<n;i++) {
            result[i] = this.get(i)+b.get(i);
        }
        return new ArrayVector(result);
    }

    @Override
    public Vector mul(double d) {
        double[] result = new double[n];
        for (int i=0;i<n;i++) {
            result[i] = this.get(i)*d;
        }
        return new ArrayVector(result);
    }
}
