package view;
import javax.swing.JButton;
import java.awt.Color;

public class CustomButton extends JButton {
    // Constructor
    public CustomButton(String titleButton, int width, int height, Color backgroundColor, Color foregroundColor) {
        super(titleButton);
        setPreferredSize(new java.awt.Dimension(width, height));
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setFocusPainted(false);
        setBorderPainted(false);
    }
}
