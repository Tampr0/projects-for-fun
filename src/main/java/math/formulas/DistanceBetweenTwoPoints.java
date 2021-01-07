package math.formulas;

public class DistanceBetweenTwoPoints {

    public void distanceBetweenTwoCoorditates(Coordinates first, Coordinates second) {
        double result = Math.sqrt(Math.pow(Math.abs(first.x - second.x),2) + Math.pow(Math.abs(first.y - second.y),2));
        System.out.println(result);
    }
}
class Coordinates {
    double x;
    double y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

