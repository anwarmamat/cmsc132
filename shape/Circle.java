
//package shape;

class Circle extends Shape {
   private int radius;

   // constructor
   Circle(int newx, int newy, int newradius) {
      super(newx, newy);
      setRadius(newradius);
   }

   // accessors for the radius
   int getRadius() { return radius; }
   void setRadius(int newradius) { radius = newradius; }

   // draw the circle
   void draw() {
      System.out.println("Drawing a Circle at:(" + getX() + ", " + getY() +
         "), radius " + getRadius());
   }
   
   double getArea(){
       return radius * radius * Math.PI;
   }
   double getPrimeter(){
       return 2 * Math.PI * radius;
   }
}

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