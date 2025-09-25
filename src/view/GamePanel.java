package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel {
    public static final Color BACKGROUND_COLOR = new Color(0x283C4F);
    private JLabel title, result;
    private JPanel panelBar, panelTitle, panelExitandMinimize, panelCenter, panelUp, panelDown, panelTextField,
            panelBottom, panelSelect;
    private JButton buttonMinimize, buttonExit, buttonCheck, buttonRestart;
    private JButton[] buttonsUp, buttonsDown;
    private JTextField[] textFields;

    public GamePanel() {
        setLayout(new BorderLayout());
        setBackground(BACKGROUND_COLOR);
        // UI components
        panelBar = new JPanel();
        panelBar.setLayout(new BorderLayout());
        panelBar.setOpaque(false);
        panelTitle = new JPanel();
        panelTitle.setOpaque(false);
        title = new JLabel("  Guess Pin Code");
        title.setForeground(Color.WHITE);
        title.setFont(title.getFont().deriveFont(12f));
        panelTitle.add(title);
        panelBar.add(panelTitle, BorderLayout.WEST);
        panelExitandMinimize = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelExitandMinimize.setOpaque(false);
        buttonMinimize = new CustomButton("–", 45, 25, BACKGROUND_COLOR, Color.WHITE);
        panelExitandMinimize.add(buttonMinimize);
        buttonExit = new CustomButton("X", 45, 24, Color.red, Color.black);
        panelExitandMinimize.add(buttonExit);
        panelBar.add(panelExitandMinimize, BorderLayout.EAST);
        panelCenter = new JPanel();
        panelCenter.setOpaque(false);
        panelUp = new JPanel();
        panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelUp.setOpaque(false);
        buttonsUp = new JButton[4];
        for (int i = 0; i < buttonsUp.length; i++) {
            buttonsUp[i] = new CustomButton("▲", 80, 50, BACKGROUND_COLOR, Color.WHITE);
            panelUp.add(buttonsUp[i]);
        }
        panelCenter.add(panelUp);
        panelTextField = new JPanel();
        panelTextField.setOpaque(false);
        panelTextField.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        textFields = new JTextField[4];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField();
            textFields[i].setPreferredSize(new Dimension(80, 60));
            textFields[i].setHorizontalAlignment(JTextField.CENTER);
            textFields[i].setText("0");
            textFields[i].setFont(textFields[i].getFont().deriveFont(30f));
            textFields[i].setEnabled(false);
            textFields[i].setDisabledTextColor(Color.WHITE);
            textFields[i].setBackground(BACKGROUND_COLOR);
            panelTextField.add(textFields[i]);
        }
        panelCenter.add(panelTextField);
        panelDown = new JPanel();
        panelDown.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelDown.setOpaque(false);
        buttonsDown = new JButton[4];
        for (int i = 0; i < buttonsDown.length; i++) {
            buttonsDown[i] = new CustomButton("▼", 80, 50, BACKGROUND_COLOR, Color.WHITE);
            panelDown.add(buttonsDown[i]);
        }
        panelCenter.add(panelDown);
        panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(2, 1));
        panelBottom.setOpaque(false);
        result = new JLabel("Let's try to guess the password!", JLabel.CENTER);
        result.setForeground(Color.WHITE);
        result.setFont(result.getFont().deriveFont(13f));
        panelBottom.add(result);
        panelSelect = new JPanel();
        panelSelect.setOpaque(false);
        buttonCheck = new JButton("Check");
        buttonCheck.setBackground(Color.GREEN);
        buttonCheck.setBorderPainted(false);
        buttonCheck.setFocusPainted(false);
        buttonRestart = new JButton("Restart");
        buttonRestart.setBackground(Color.ORANGE);
        buttonRestart.setBorderPainted(false);
        buttonRestart.setFocusPainted(false);
        panelSelect.add(buttonCheck);
        panelSelect.add(buttonRestart);
        panelBottom.add(panelSelect);
        Container window = this;
        window.add(panelBar, "North");
        window.add(panelCenter, "Center");
        window.add(panelBottom, "South");
        setVisible(true);
    }

    // get button check
    public JButton getButtonCheck() {
        return buttonCheck;
    }

    // get button restart
    public JButton getButtonRestart() {
        return buttonRestart;
    }

    // get button exit
    public JButton getButtonExit() {
        return buttonExit;
    }

    // get button minimize
    public JButton getButtonMinimize() {
        return buttonMinimize;
    }

    // get buttons up
    public JButton[] getButtonsUp() {
        return buttonsUp;
    }

    // get buttons down
    public JButton[] getButtonsDown() {
        return buttonsDown;
    }

    // get text fields
    public JTextField[] getTextFields() {
        return textFields;
    }

    // get result label
    public JLabel getResult() {
        return result;
    }

    // get panelBar
    public JPanel getPanelBar() {
        return panelBar;
    }
}
