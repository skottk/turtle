package turtle;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by skottk on 10/8/14.
 */
public class World extends Frame
{

    protected Turtle turtle;


    public World()
    {


        this.setVisible(true);
        Dimension dim = new Dimension( 1000, 1000);
        this.setSize( dim );

        turtle = new Turtle( this, dim.width / 2, dim.height / 2  );

    }

    public Turtle getTurtle()
    {
        return turtle;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (null != turtle)
        {
            turtle.paint( g );
        }
    }


    public static void main(String[] args) {
        World w = new World();

        Turtle t = w.getTurtle();

        double angle = Math.PI - Math.PI/5;

        t.penDown();

        for ( int i = 0; i < 5; i++ )
        {
            t.forward(250);
            t.turn( angle );
        }

        w.repaint();




    }

}
