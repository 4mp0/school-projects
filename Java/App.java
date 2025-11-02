
import javax.swing.*;

public class App implements Runnable 
{

    public App(String[] args) 
    {

    }

    public void run() 
    {


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App(args));
    }
}