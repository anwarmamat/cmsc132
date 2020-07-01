
//package shape;

abstract class Shape {
   private int x;
   private int y;
   
   // constructor
   Shape(int newx, int newy) {
      moveTo(newx, newy);
   }

   // accessors for x & y
   int getX() { return x; }
   int getY() { return y; }
   void setX(int newx) { x = newx; }
   void setY(int newy) { y = newy; }

   // move the x & y position
   void moveTo(int newx, int newy) {
      setX(newx);
      setY(newy);
   }
   void rMoveTo(int deltax, int deltay) {
      moveTo(getX() + deltax, getY() + deltay);
   }

   // virtual draw method
   abstract void draw();
   abstract double getArea();
   abstract double getPrimeter();
}


//package shape;

public class ShapeTest {
    public static void main(String argv[]) {

      // create some shape instances
      Shape shapes[] = new Shape[3];
      shapes[0] = new Rectangle(10, 20, 5, 6);
      shapes[1] = new Circle(15, 25, 8);
      shapes[2] = new Square(30, 30, 10);

      // iterate through the list and handle shapes polymorphically
      for (Shape s: shapes){
         s.draw();
         s.rMoveTo(100, 100);
         s.draw();
         double a = s.getArea();
         double p = s.getPrimeter();
         System.out.println("area=" + a +  " \tPrimeter=" + p);
      }

      // call a rectangle specific function
      Rectangle arect = new Rectangle(0, 0, 15, 15);
      arect.setWidth(30);
      arect.draw();
      System.out.println("area=" + arect.getArea() +  " \tPrimeter=" + arect.getPrimeter());
   }
    
}
