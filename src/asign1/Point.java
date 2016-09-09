package asign1;

/**
 * Created by hampus on 2016-09-09.
 */
public class Point {

    private int xCorr;
    private int yCorr;

    public  Point() {
        xCorr = 0;
        yCorr = 0;
    }

    public  Point(int x, int y){
        xCorr = x;
        yCorr = y;
    }

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(3,4);


        System.out.println(p1.toString());   // ==> (0,0)
        System.out.println(p2.toString());   // ==> (3,4)


        if (p1.isEqualTo(p2))              // False!

            System.out.println("The two points are equal");


        double dist = p1.distanceTo(p2);
        System.out.println("Point Distance: "+dist);


        p2.move(5, -2);       // ==> (8,2)
        p1.moveToXY(8,2);      // ==> (8,2)


        if (p1.isEqualTo(p2))              // True!

            System.out.println("The two points are equal");
    }

    public  void setX(int newX){
        xCorr = newX;
    }
    public  void sety(int newy){
        yCorr = newy;
    }

    public int getX(){
        return xCorr;
    }

    public int getY(){
        return yCorr;
    }

    public  boolean isEqualTo(Point otherPoint){
        if(this.getX() == otherPoint.getX() && this.getY() == otherPoint.getY()){
            return true;
        }
        return false;
    }

    public void move(int x, int y){
        this.setX(this.getX() + x);
        this.sety(this.getY() + y);
    }

    public void moveToXY(int x, int y){
        this.setX(x);
        this.sety(y);
    }

    public double distanceTo(Point otherPoint){
        return Math.sqrt((this.getX() - otherPoint.getX())*(this.getX() - otherPoint.getX())  + (this.getY() - otherPoint.getY())*(this.getY() - otherPoint.getY()));
    }

    public String toString(){
        return " (" + this.getX() + "," + this.getY() + ")";
    }
}
