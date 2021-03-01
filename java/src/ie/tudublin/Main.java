package ie.tudublin;

public class Main
{
    public void triangle()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Triangle());
    }

    public void loops()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

    public void arrays()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Arrays());
    }
    
    public void life()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Life());
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.life();
    }
} 