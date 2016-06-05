
//package shape;

class Rectangle extends Shape {
   private int width;
   private int height;

   // constructor
   Rectangle(int newx, int newy, int newwidth, int newheight) {
      super(newx, newy);
      setWidth(newwidth);
      setHeight(newheight);
   }

   // accessors for the width & height
   int getWidth() { return width; }
   int getHeight() { return height; }
   void setWidth(int newwidth) { width = newwidth; }
   void setHeight(int newheight) { height = newheight; }

   // draw the rectangle
   void draw() {
      System.out.println("Drawing a Rectangle at:(" + getX() + ", " + getY() +
         "), width " + getWidth() + ", height " + getHeight());
   }
   double getArea(){
       return width * height;
   }
           
   double getPrimeter(){
       return 2 * (width + height);
   }
}