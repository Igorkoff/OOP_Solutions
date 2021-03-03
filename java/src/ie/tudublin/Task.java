package ie.tudublin;

import processing.data.TableRow;

public class Task 
{
    private String task;
    private int start;
    private int end;

    // Class Constructors

    public Task(TableRow row)
    {
        this
        (
            row.getString("Task"),
            row.getInt("Start"),
            row.getInt("End")
        );

    }   // end constructor 2

    public Task(String task, int start, int end) 
    {
        this.task = task;
        this.start = start;
        this.end = end;

    }   // end constructor 1

    // Task: Getter and Setter

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    // Start: Getter and Setter

    public int getStart()
    {
        return start;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    // End: Getter and Setter

    public int getEnd() 
    {
		return end;
	}

	public void setEnd(int end)
    {
		this.end = end;
	}

    // To String

    @Override
    public String toString() 
    {
        return "Task [Task=" + task + ", Start=" + start + ", End=" + end + "]";

    }   // end toString

}   // end Task
