package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet 
{
    ArrayList<Star> stars = new ArrayList<Star>();  // create ArrayList

    int startStar = -1;
    int endStar = -1;

    public void mouseClicked()
    {
        float border = width * 0.1f;

        for (int i = 0 ; i < stars.size(); i++)
        {
            Star s = stars.get(i);
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            if (dist(mouseX, mouseY, x, y ) < s.getAbsMag() / 2)
            {
                println(s.getDisplayName());
                break;

            }   // end if

        }   // end for

    }   // end mouseClicked

    public void loadStars()
    {
        Table table = loadTable("data.csv", "header");  // create Table

        for (TableRow row:table.rows())
        {
            Star s = new Star(row);     // create star
            stars.add(s);               // add star to the array

        }   // end for
    }

    public void printStars()
    {
        for (Star s: stars)
        {
            println(s);

        }   // end for

    }   // end printStars

    public void settings() 
    {
        size(800, 800);

    }   // end settings

    public void setup() 
    {
        colorMode(RGB);
        loadStars();

    }   // end setup

    public void drawGrid()
    {
        float border = 0.1f * width;
        textAlign(CENTER, CENTER);

        for (int i = -5 ; i <= 5 ; i++)
        {
            float x = map(i, -5, 5, border, width - border);
            float y = map(i, -5, 5, border, height - border);

            // draw lines

            stroke(0, 0, 255);
            line(x, border,x, height - border);
            line(border, y, width - border, y);

            // draw text

            fill(255);
            text(i, x, border / 2);
            text(i, border / 2, y);

        }   // end for

    }   // end drawGrid

    public void drawStars()
    {
        for (Star s: stars)
        {
            s.render(this);

        }   // end for

    }   // end drawStars

    public void draw() 
    {
        background(0);
        drawGrid();
        drawStars();

    }   // end draw

}   // end StarMap
