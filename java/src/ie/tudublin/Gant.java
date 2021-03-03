package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gant extends PApplet
{
    ArrayList<Task> tasks = new ArrayList<Task>();  // create ArrayList

    private boolean isEnd = false;
    private int whichTask = -1;
    private int maxMonths = 30;

    float border = 0;
    float border_left = 0;
    float rowHeight = 0;

	public void loadTasks()
	{
        Table table = loadTable("tasks.csv", "header");  // create Table

        for (TableRow row:table.rows())
        {
            Task t = new Task(row);     // create star
            tasks.add(t);               // add star to the array

        }   // end for

	}   // end loadTasks

	public void printTasks()
	{
		for (Task t: tasks)
        {
            println(t);

        }   // end for
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

    public void settings()
	{
        fullScreen();

	}   // end settings
	
	public void setup() 
	{
        textAlign(CENTER, CENTER);
        colorMode(HSB);
        textSize(14);

        border = 0.1f * height;
        border_left = 0.2f * width;
        rowHeight = 0.05f * height;

        loadTasks();
        printTasks();

	}   // end setup

    public void drawGrid()
    {
        for (int i = 1 ; i <= maxMonths ; i++)
        {
            float x = map(i, 1, maxMonths, border_left, width - border);

            fill(0, 0, 100);
            stroke(0, 0, 100);
            line(x, border, x, height - border);    // draw vertical lines
            text(i, x, border * 0.5f);              // draw numbers on top

        }   // end for

    }   // end drawGrid

    public void drawTasks()
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            float c = map(i, 0, tasks.size(), 0, 255);
            float x1 = map(tasks.get(i).getStart(), 1, maxMonths, border_left, width - border);
			float x2 = map(tasks.get(i).getEnd(), 1, maxMonths, border_left, width - border);
            float y = border + border + rowHeight * i;

            // draw text

            fill(0, 0, 100);
            text(tasks.get(i).getTask(), border_left * 0.5f, y);

            // draw rectangles

            noStroke();
            fill(c, 255, 255);
			rect(x1, y - 15, x2 - x1, rowHeight, 5);

        }   // end for

    }   // end drawTasks
	
	public void draw()
	{			
		background(0);
        drawGrid();
        drawTasks();

	}   // end draw

}   // end Gant
