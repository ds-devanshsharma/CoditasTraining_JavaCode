package Com.bean;

public class Circle {
    int radius;
    Point center;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "[" +
                "radius=" + radius +
                ", center=" + center +
                ']';
    }
    public float getArea(){
        return (float)Math.PI *radius *radius ;
    }
}
