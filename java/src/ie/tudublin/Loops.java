package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet 
{
    public void settings() 
    {
        size(600, 600);
        cx = width / 2;
        cy = height / 2;

    }   // end settings

    int mode = 0;

    float cx;
    float cy;

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

    float offset = 0;

    public void draw() 
    {
        background(0);
        noStroke();

        switch (mode)
        {
            case 0:
            {
                float w = (float) 0.4 * width;  // width
                float h = (float) 0.2 * height; // height

                if (mouseX > cx - (w / 2) && mouseX < cx + (w / 2)) // if horizontally within rectangle
                {
                    if(mouseY > cy - (h /2) && mouseY < cy + (h/2)) // if vertically within rectangle
                    {
                        fill(50, 255, 255); // yellow colour

                    }   // end inner if
                }
                else
                {
                    fill(200, 255, 255);    // purple colour

                }   // end outer if

                rectMode(CENTER);
                rect(cx, cy, w, h); // draw a square
                rectMode(CORNER);

                break;

            }   // end case 0

            case 1:
            {
                fill(50, 255, 255); // yellow colour

                if (mouseX < cx)
                {
                    if (mouseY < cy)
                    {
                        rect(0, 0, cx, cy);     // top left rectangle
                    }
                    else 
                    {
                        rect(0, cy, cx, cy);   // bottom left rectangle

                    }   // end inner if
                }
                else if (mouseX > cx)
                {
                    if (mouseY < cy)
                    {
                        rect(cx, 0, cx, cy);    // top right rectangle
                    }
                    else
                    {
                        rect(cx, cy, cx, cy);   // bottom right rectangle

                    }   // end inner if

                }   // end outer if

                break;

            }   // end case 1
            
            case 2:
            {
                int numRects = (int) mouseX / 20;       // mouse affects amount of rectangles
                float w = width / (float) numRects;
                float cGap = 255 / (float) numRects;

                for (int i = 0; i < numRects; i++)
                {
                    fill(i * cGap, 255, 255);   // change colour
                    rect(i * w, 0, w, height);  // draw rectangle

                }   // end for

                break;

            }   // end case 2

            case 3:
            {
                int numRects = (int) mouseX / 20;       // mouse affects amount of rectangles
                float w = width / (float) numRects;
                float cGap = 255 / (float) numRects;

                for (int i = 0; i < numRects; i++)
                {
                    fill(i * cGap, 255, 255);                   // change colour
                    rect(i * w, i * w, w, w);                   // draw from top left to bottom right
                    rect(width - ((i + 1) * w), w * i, w, w);   // draw from top right to bottom left

                }   // end for

                break;

            }   // end case 3
            
            case 4:
            {
                offset += (mouseX / 100);   // colour change speed

                int numCircles = 20;
                float w = width / (float) numCircles;
                float cGap = 255 / (3 * (float) numCircles);

                for (int i = 0; i < numCircles; i++)
                {
                    for (int j = 0; j < numCircles; j++)
                    {
                        float c = (cGap * (i + j) + offset) % 255;  // calculate colour
                        fill(c, 255, 255);                          // change colour

                        ellipse(w / 2 + (j * w), w / 2 + (i * w), w, w);    // draw circle

                    }   // end inner for

                }   // end outer for

                break;

            }   // end case 4

            case 5:
            {
                int numCircles = (int) mouseX / 20;
                float cGap = 255 / (float) numCircles;
                float gap = width / (float) numCircles;
                float w = width;

                for (int i = numCircles; i >= 1; i--)   // from the largest to the smallest
                {
                    w = i * gap;    // calculate circle width

                    fill(i * cGap, 255, 255);   // change colour
                    ellipse(cx, cy, w, w);      // draw circle

                }   // end for

                break;

            }   // end case 5

            case 6:
            {
                stroke(255);
                
                int numLines = 5;
                float theta = TWO_PI / (float) numLines;
                float radius = 200;

                for (int i = 0; i < numLines; i ++)
                {
                    float angle = theta * i;        // caluclate angle
                    float x = sin(angle) * radius;  // x = sin(theta * i) * radius
                    float y = cos(angle) * radius;  // y = cos(theta * i) * radius
                    line(cx, cy, cx + x, cy + y);   // draw line

                }   // end for

                break;

            }   // end case 6

            case 7:
            {
                stroke(255);

                int sides = (mouseX / 50);
                float theta = TWO_PI / (float) sides;
                float radius = 200;

                for (int i = 1; i <= sides; i++)
                {
                    float x1 = sin(theta * (i - 1)) * radius;
                    float y1 = cos(theta * (i - 1)) * radius;
                    float x2 = sin(theta * i) * radius;
                    float y2 = cos(theta * i) * radius;
                    line(cx + x1, cy + y1, cx + x2, cy + y2);

                }   // end for

                break;

            }   // end case 7

            case 8:
            {
                colorMode(RGB);
                stroke(0, 255, 0);

                for (int i = -5; i <= 5; i++)
                {
                    float border = width * 0.1f;
                    float x = map(i, -5, 5, border, width - border);
                    
                    line(x, border, x, height - border);
                    line(border, x, width - border, x);
                    
                    fill(255, 255, 255);
                    textAlign(CENTER, CENTER);
                    text(i, x, border * 0.5f);
                    text(i, border * 0.5f, x);

                }   // end for

                colorMode(HSB);

                break;

            }   // end case 8

        }   // end switch

    }   // end draw

}   // end Loops