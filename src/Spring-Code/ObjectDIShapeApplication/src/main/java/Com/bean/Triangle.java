package Com.bean;

public class Triangle {
    Point a;
    Point b;
    Point c;

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "[" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ']';
    }
}
