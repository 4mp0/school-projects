
import javax.swing.*;
//import java.awt.*;

class Label {
    private JLabel Label;
    private String LabelName, LabelValue;
    private int x, y, Width, Height;

    public Label(String LabelName, String LabelValue, int x, int y, int Width, int Height) {
        // Gven values of the new JLabel:
        this.LabelName = LabelName;
        this.LabelValue = LabelValue;
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.Height = Height;
        Label = new JLabel(LabelName);

        // Set the label's text and its position and size
        Label.setText(LabelName);
        Label.setBounds(x, y, Width, Height);
    }

    public JLabel GetLabel() {
        return Label;
    }

    public String GetValue() {
        return LabelValue;
    }
}

class Button {
    private JButton button;
    private String ButtonName, ButtonValue;
    private int x, y, Width, Height;

    public Button(String ButtonName, String ButtonValue, int x, int y, int Width, int Height) {
        // Gven values of the new button:
        this.ButtonName = ButtonName;
        this.ButtonValue = ButtonValue;
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.Height = Height;
        button = new JButton(ButtonName);

        // This function contains the coordinates and size of the button
        button.setText(ButtonName);
        button.setBounds(x, y, Width, Height);
    }

    public JButton GetButton() {
        return button;
    }

    public String GetValue() {
        return ButtonValue;
    }
}

public class App implements Runnable {

    private JFrame Window = new JFrame();
    private JPanel panel = new JPanel();
    private Button Num0, Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8, Num9, AddButton, SubtractButton, MultiplyButton, DivideButton, EqualButton;
    private Label Output;

    private int x = 0;
    private boolean bool = false;
    private String OutputNum = "";
    private String[] OutputAddNum, OutputSubNum, OutputMultNum, OutputDivNum;

    public App(String[] args) {
        /*
         * Format for all Parameters:
         * 
         * @String ButtonName
         * 
         * @int ButtonValue
         * 
         * @int x
         * 
         * @int y
         * 
         * @int Width
         * 
         * @int Height
         */

        // Contents:
        Output = new Label("0", "0", 25, 105, 100, 100);

        AddButton = new Button("+", " + ", 282, 307, 50, 50);
        SubtractButton = new Button("-", " - ", 282, 256, 50, 50);
        MultiplyButton = new Button("*", " * ", 282, 205, 50, 50);
        DivideButton = new Button("/", " / ", 282, 154, 50, 50);

        EqualButton = new Button("=", " = ", 282, 358, 50, 50);

        Num0 = new Button("0", "0", 0, 350, 50, 58);
        Num1 = new Button("1", "1", 0, 291, 50, 58);
        Num2 = new Button("2", "2", 51, 291, 50, 58);
        Num3 = new Button("3", "3", 102, 291, 50, 58);
        Num4 = new Button("4", "4", 0, 231, 50, 58);
        Num5 = new Button("5", "5", 51, 231, 50, 58);
        Num6 = new Button("6", "6", 102, 231, 50, 58);
        Num7 = new Button("7", "7", 0, 171, 50, 58);
        Num8 = new Button("8", "8", 51, 171, 50, 58);
        Num9 = new Button("9", "9", 102, 171, 50, 58);
    }

    public String algorithm() {
        x = 0;

        if (OutputNum.contains("+")) {
            OutputAddNum = OutputNum.split(" \\+ ");
            for (String num : OutputAddNum) {
                x += Integer.parseInt(num);
            }
        } else if (OutputNum.contains("-")) {
            OutputSubNum = OutputNum.split(" \\- ");
            x = Integer.parseInt(OutputSubNum[0]);
            for (int i = 1; i < OutputSubNum.length; i++) {
                x -= Integer.parseInt(OutputSubNum[i]);
            }
        } else if (OutputNum.contains("*")) {
            OutputMultNum = OutputNum.split(" \\* ");
            x = Integer.parseInt(OutputMultNum[0]);
            for (int i = 1; i < OutputMultNum.length; i++) {
                x *= Double.parseDouble(OutputMultNum[i]);
            }
        } else if (OutputNum.contains("/")) {
            OutputDivNum = OutputNum.split(" \\/ ");
            x = Integer.parseInt(OutputDivNum[0]);
            for (int i = 1; i < OutputDivNum.length; i++) {
                x /= Integer.parseInt(OutputDivNum[i]);
            }
        }
        return String.valueOf(x);
    }

    public void run() {
        Window.setTitle("Calculator");
        Window.setSize(350, 450);

        // Set to Manual Layout
        panel.setLayout(null);

        // Add objs to layout:
        panel.add(Num0.GetButton());
        panel.add(Num1.GetButton());
        panel.add(Num2.GetButton());
        panel.add(Num3.GetButton());
        panel.add(Num4.GetButton());
        panel.add(Num5.GetButton());
        panel.add(Num6.GetButton());
        panel.add(Num7.GetButton());
        panel.add(Num8.GetButton());
        panel.add(Num9.GetButton());
        panel.add(Output.GetLabel());

        panel.add(AddButton.GetButton());
        panel.add(SubtractButton.GetButton());
        panel.add(MultiplyButton.GetButton());
        panel.add(DivideButton.GetButton());
        panel.add(EqualButton.GetButton());

        // Display the panel:
        Window.add(panel);

        // Conditions:
        Num0.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num0.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num1.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num1.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num2.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num2.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num3.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num3.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num4.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num4.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num5.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num5.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num6.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num6.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num7.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num7.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num8.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num8.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        Num9.GetButton().addActionListener(e -> {
            if (bool == true) {
                OutputNum = "";
                bool = false;
            }
            OutputNum += Num9.GetValue();
            Output.GetLabel().setText(OutputNum);
        });

        AddButton.GetButton().addActionListener(e -> {
            if (OutputNum.length() >= 1) {
                if (Character.isDigit(OutputNum.charAt(OutputNum.length() - 1))) {
                    OutputNum += AddButton.GetValue();
                    Output.GetLabel().setText(OutputNum);
                }
                bool = false;
            }
        });

        SubtractButton.GetButton().addActionListener(e -> {
            if (OutputNum.length() >= 1) {
                if (Character.isDigit(OutputNum.charAt(OutputNum.length() - 1))) {
                    OutputNum += SubtractButton.GetValue();
                    Output.GetLabel().setText(OutputNum);
                }
                bool = false;
            }
        });

        MultiplyButton.GetButton().addActionListener(e -> {
            if (OutputNum.length() >= 1) {
                if (Character.isDigit(OutputNum.charAt(OutputNum.length() - 1))) {
                    OutputNum += MultiplyButton.GetValue();
                    Output.GetLabel().setText(OutputNum);
                }
                bool = false;
            }
        });

        DivideButton.GetButton().addActionListener(e -> {
            if (OutputNum.length() >= 1) {
                if (Character.isDigit(OutputNum.charAt(OutputNum.length() - 1))) {
                    OutputNum += DivideButton.GetValue();
                    Output.GetLabel().setText(OutputNum);
                }
                bool = false;
            }
        });

        EqualButton.GetButton().addActionListener(e -> {

            OutputNum = algorithm();
            Output.GetLabel().setText(OutputNum);
            bool = true;
        });

        Window.setVisible(true);
        Window.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App(args));
    }
}