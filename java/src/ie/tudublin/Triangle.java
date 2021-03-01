package ie.tudublin;

import processing.core.PApplet;

public class Triangle extends PApplet 
{
    public void settings()
    {
        size(500, 500);

    }   // end settings
  
    public void draw()
    {
        
        fill(50, 150, 255);
        rect(0, 0, 500, 500);
        
        fill(255, 255, 102);
        ellipse(250, 280, 380, 380);
        
        fill(0, 155, 75);
        triangle(250, 20, 50, 420, 450, 420);
        
        fill(245, 245, 245);
        ellipse(250, 200, 140, 75);
        
        fill(0, 0, 0);
        ellipse(250, 200, 40, 40);
        
        fill(0);
        textSize(14);
        text("Glory to Ukraine!", 195, 280);

    }   // end draw

}   // end Triangle