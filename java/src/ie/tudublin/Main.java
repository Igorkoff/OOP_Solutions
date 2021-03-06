package ie.tudublin;

public class Main
{
    public void triangle()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Triangle());
    }

    public void loops()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Loops());
    }

    public void arrays()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Arrays());
    }
    
    public void life()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Life());
    }

    public void stars()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new StarMap());
    }

    public void gant()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Gant());
    }

    public void game()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Rapid_Response());
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        main.game();
    }
}
