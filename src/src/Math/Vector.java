package Math;

public class Vector {
    public double x;
    public double y;

    public Vector() {
        this(0, 0);
    }
    public Vector(Vector spawnPosition) {
        this(spawnPosition.x, spawnPosition.y);
    }
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void Normalize() {
        x /= Math.sqrt(x * x + y * y);
        y /= Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
