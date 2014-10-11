package turtle;

/**
 * Created by skottk on 10/8/14.
 */
public class Point {
    private double x;
    private double y;

    public Point ( double x, double y )
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point Point = (Point) o;

        if (x != Point.x) return false;
        if (y != Point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        double dResult = x;
        dResult = 31 * dResult + y;
        return (int) dResult;
    }

    public double getY() {

        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {

        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String toString()
    {
        return "{ " + x + ", " + y + " }";
    }
}
