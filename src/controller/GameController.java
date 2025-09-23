package controller;

import logic.GameLogic;
import view.GamePanel;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;

public class GameController {
    private GamePanel gamePanel;
    private GameLogic logic;

    public GameController(GamePanel gamePanel, GameLogic logic) {
        this.gamePanel = gamePanel;
        this.logic = logic;
        // Add action listeners to buttons
        JButton[] buttonsUp = gamePanel.getButtonsUp();
        JButton[] buttonsDown = gamePanel.getButtonsDown();
        JButton buttonCheck = gamePanel.getButtonCheck();
        JButton buttonRestart = gamePanel.getButtonRestart();
        JButton buttonExit = gamePanel.getButtonExit();
        JButton buttonMinimize = gamePanel.getButtonMinimize();
        for (JButton button : buttonsUp) {
            button.addActionListener(new ButtonProcess());
        }
        for (JButton button : buttonsDown) {
            button.addActionListener(new ButtonProcess());
        }
        buttonCheck.addActionListener(new ButtonProcess());
        buttonRestart.addActionListener(new ButtonProcess());
        buttonExit.addActionListener(new ButtonProcess());
        buttonMinimize.addActionListener(new ButtonProcess());
    }

    // Enable window drag
    public void enableWindowDrag(JFrame frame) {
        final Point[] mouseDownCompCoords = { null };
        gamePanel.getPanelBar().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords[0] = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords[0] = null;
            }
        });
        gamePanel.getPanelBar().addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                frame.setLocation(currCoords.x - mouseDownCompCoords[0].x, currCoords.y - mouseDownCompCoords[0].y);
            }
        });
    }

    // Button process
    private class ButtonProcess implements ActionListener {
        private JButton[] buttonsUp = gamePanel.getButtonsUp();
        private JButton[] buttonsDown = gamePanel.getButtonsDown();
        private JButton buttonCheck = gamePanel.getButtonCheck();
        private JButton buttonRestart = gamePanel.getButtonRestart();
        private JButton buttonExit = gamePanel.getButtonExit();
        private JButton buttonMinimize = gamePanel.getButtonMinimize();
        private JTextField[] textFields = gamePanel.getTextFields();
        private JLabel result = gamePanel.getResult();
        private int attempts = 0;

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            JButton button = (JButton) e.getSource();
            for (int i = 0; i < buttonsUp.length; i++) {
                if (button == buttonsUp[i]) {
                    int currentValue = Integer.parseInt(textFields[i].getText());
                    currentValue++;
                    if (currentValue > 9)
                        currentValue = 0;
                    textFields[i].setText(String.valueOf(currentValue));
                    textFields[i].setDisabledTextColor(Color.WHITE);
                } else if (button == buttonsDown[i]) {
                    int currentValue = Integer.parseInt(textFields[i].getText());
                    currentValue--;
                    if (currentValue < 0)
                        currentValue = 9;
                    textFields[i].setText(String.valueOf(currentValue));
                    textFields[i].setDisabledTextColor(Color.WHITE);
                } else if (button == buttonCheck) {
                    if (logic.ifDuplicateNumbers(textFields)) {
                        result.setText("Duplicate numbers are not allowed! Try again!");
                        attempts++;
                        System.out.println(attempts + " attempts");
                        gamePanel.revalidate();
                        gamePanel.repaint();
                        return;
                    }
                    textFields = logic.checkPassword(textFields);
                    if (logic.rightPassword(textFields)) {
                        attempts++;
                        System.out.println(attempts + " attempts"); // for testing purposes
                        result.setText("You guessed the right password in " + attempts + " attempts!");
                        attempts = 0;
                        gamePanel.revalidate();
                        gamePanel.repaint();
                        return;
                    } else if (!logic.rightPassword(textFields)) {
                        result.setText("Try again!");
                        gamePanel.revalidate();
                        gamePanel.repaint();
                        attempts++;
                        System.out.println(attempts + " attempts"); // for testing purposes
                        return;
                    }
                    gamePanel.revalidate();
                    gamePanel.repaint();
                } else if (button == buttonRestart) {
                    for (int j = 0; j < textFields.length; j++) {
                        textFields[j].setText("0");
                        textFields[j].setDisabledTextColor(Color.WHITE);
                        // Restart the password
                        result.setText("Let's try to guess the password!");
                        gamePanel.revalidate();
                        gamePanel.repaint();
                    }
                    attempts = 0;
                    logic = new GameLogic();
                    // for testing purposes
                    System.out.println("Attempts reset to 0" + attempts);
                    System.out.println("New Password (for testing purposes): ");
                    int[] password = logic.getPassword();
                    for (int num : password) {
                        System.out.print(num);
                    }
                    System.out.println();
                    // end for testing purposes
                    return;
                } else if (button == buttonExit) {
                    System.exit(0);
                } else if (button == buttonMinimize) {
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(gamePanel);
                    topFrame.setState(JFrame.ICONIFIED);
                }
            }
        }
    }
}