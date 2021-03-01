package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet 
{
    public void settings()
    {
        size(600, 600);

    }   // end settings

    int mode = 1;

    String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };

    public void keyPressed()
    {
        // the value of mode will be the number of the number key pressed

        if (keyCode >= '0' && keyCode <= '9')
        {
            mode = keyCode - '0';

        }   // end if

    }   // end keyPressed

    public void setup()
    {
        colorMode(HSB);

    }   // end setup

    public void draw() 
    {
        background(0);

        switch (mode) 
        {
            case 1: 
            {
                // Bar Chart

                float border = width * 0.1f;    // border: 10% of the window

                stroke(255);
                textAlign(CENTER, CENTER);

                line(border, border, border, height - border);  // y - axis
                line(border, height - border, width - border, height - border); // x - axis

                for (float f = 0; f <= 120; f+= 10)
                {
                    float y = map(f, 0, 120, height - border, border);  // map numbers

                    fill(255);
                    line(border - 5, y, border, y);     // draw lines
                    text((int) f, border * 0.5f, y);    // draw numbers

                }   // end for

                float w = (width - border * 2 ) / (float) rainfall.length;  // width of one bar

                for (int i = 0; i < rainfall.length; i++)
                {
                    float x = map(i, 0, rainfall.length, border, width - border);   // map bar width
                    float h = map(rainfall[i], 0, 120, 0, -(height - border * 2));  // map bar height
                    float c = map(i, 0, rainfall.length, 0, 255);   // map colors

                    fill(c, 255, 255);
                    rect(x, height - border - 1, w, h);     // draw bars

                    fill(255);
                    text(months[i], x + (w * 0.5f), height - (border * 0.5f));  // draw months

                }   // end for

                text("Rainfall Bar Chart", width * 0.5f, border * 0.5f);    // draw heading

                break;

            }   // end case 1

            case 2: 
            {
                // Trend Line

                float border = width * 0.1f;    // border: 10% of the window

                stroke(255);
                textAlign(CENTER, CENTER);

                line(border, border, border, height - border);  // y - axis
                line(border, height - border, width - border, height - border); // x - axis

                for (float f = 0; f <= 120; f+= 10)
                {
                    float y = map(f, 0, 120, height - border, border);  // map numbers

                    fill(255);
                    line(border - 5, y, border, y);     // draw lines
                    text((int) f, border * 0.5f, y);    // draw numbers

                }   // end for

                float w = (width - border * 2 ) / (float) rainfall.length;  // width of one bar

                for (int i = 1; i < rainfall.length; i++)
                {
                    // map point 1

                    float x1 = map(i - 1, 0, rainfall.length - 1, border + (w * 0.5f), width - border - (w * 0.5f));
                    float y1 = map(rainfall[i - 1], 0, 120, height - border, border);

                    // map point 2

                    float x2 = map(i, 0, rainfall.length - 1, border + (w * 0.5f), width - border - (w * 0.5f));
                    float y2 = map(rainfall[i], 0, 120, height - border, border);

                    line(x1, y1, x2, y2);   // draw line

                }   // end for

                for (int i = 0; i < rainfall.length; i++)
                {
                    float x = map(i, 0, rainfall.length, border, width - border);   // map bar width
                    text(months[i], x + (w * 0.5f), height - (border * 0.5f));      // draw months

                }   // end for

                text("Rainfall Trend Line", width * 0.5f, border * 0.5f);   // draw heading

                break;

            }   // end case 2

        }   // end switch

    }   // end draw

}   // end Arrays