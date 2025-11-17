
// Battleship game

import javax.swing.*;

public class App implements Runnable
{
    private JFrame window = new JFrame();
    private JButton endRoundButton = new JButton();

    private int round;

    private App (String[] args)
    {
        window.setTitle("Battleship game");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);

        

        window.setResizable(false);
        window.setVisible(true);
    }

    public void run()
    {

    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new App(args));
    }
}