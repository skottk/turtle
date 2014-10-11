package turtle;

import java.awt.*;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;

/**
 * Created by skottk on 10/8/14.
 */
 public class Turtle {
    private Point location;
    private double angle;
    boolean penDown = false;

    private ArrayList<Point[]> strokes;

    World world;

    private final double LENGTH = 64;
    private final double WIDTH = 32;

    public Turtle( World world, double x, double y )
    {
        strokes = new ArrayList<Point[]>();
        this.location = new Point( x, y );
        this.angle = 0;
        this.world = world;
    }

    void penDown()
    {
        penDown = true;
    }

    void penUp()
    {
        penDown = false;
    }

    public void turn( double angle )
    {
        this.angle += angle;
    }

    void draw( Point from, Point to)
    {
        Point[] stroke = { from, to };
        strokes.add( stroke );
    }


    public Point forward( double distance )
    {
        double newX = location.getX() + distance * Math.cos( angle );
        double newY = location.getY() + distance * Math.sin( angle );

        Point newLocation = new Point( newX, newY );

        if ( penDown )
        {
            this.draw(location, newLocation);
        }

        location = newLocation;

        return location;

    }

    public ArrayList<Point[]> getShape()
    {
        ArrayList<Point[]> shape = new ArrayList<Point[]>();

        // Describe a triangle with midpoint of base at location and pointing toward the current angle
        Point front = new Point(
                 (location.getX() + (LENGTH) * Math.cos( angle )),
                 (location.getY() + (LENGTH) * Math.sin( angle ))
        );

        System.out.println( front );


        Point right = new Point(
                 (location.getX() + (WIDTH/2) * Math.cos( angle + Math.PI/2 )),
                 (location.getY() + (WIDTH/2) * Math.sin( angle + Math.PI/2 ))
        );

        System.out.println( right );


        Point left = new Point(
                 (location.getX() - (WIDTH/2) * Math.cos( angle + Math.PI/2 )),
                 (location.getY() - (WIDTH/2) * Math.sin( angle + Math.PI/2 ))
        );

        System.out.println( left );


        Point[] side1 = {front, right};
        Point[] side2 = {right, left};
        Point[] side3 = {left, front};
        shape.add( side1 );
        shape.add( side2 );
        shape.add( side3 );
        System.out.println(shape);

        return shape;
    }


    private void paintLines ( Graphics g, ArrayList<Point[]> lines )
    {
         for ( Point[] stroke : lines )
        {
            Point from = stroke[0];
            Point to = stroke[1];
            g.drawLine( (int) Math.round(  from.getX() ), (int) Math.round(  from.getY() ), (int) Math.round(  to.getX() ), (int) Math.round(  to.getY() ) );
        }

    }


    public void paint(Graphics g)
    {
        paintLines(g, this.strokes);
        paintLines(g, this.getShape());
    }
}
