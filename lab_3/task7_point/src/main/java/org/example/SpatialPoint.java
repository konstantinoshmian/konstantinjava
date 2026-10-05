package org.example;

public class SpatialPoint {
    private final Complex c1;
    private final Complex c2;

    public SpatialPoint(Complex c1, Complex c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public double getX() { return c1.getReal(); }
    public double getY() { return c1.getImag(); }
    public double getZ() { return c2.getReal(); }

    public double distanceToOrigin() {
        return Math.sqrt(c1.abs() * c1.abs() + getZ() * getZ());
    }

    public double distanceTo(SpatialPoint other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        double dz = this.getZ() - other.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public String toString() {
        return String.format("Точка(X=%.2f, Y=%.2f, Z=%.2f)", getX(), getY(), getZ());
    }
}
