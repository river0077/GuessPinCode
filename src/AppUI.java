import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppUI extends JPanel {
    private JLabel title;
    private JPanel panelExitandTitle;
    private JPanel panelCenter;
    private JPanel panelUp;
    private JPanel panelDown;
    private JPanel panelTextField;
    private JPanel panelBottom;
    private JPanel panelResult;
    private JPanel panelSelect;
    private JButton buttonExit;
    private JButton[] buttonsUp;
    private JButton[] buttonsDown;
    private JTextField[] textFields;
    private JButton buttonCheck;
    private JButton buttonRestart;
    private JLabel result;
    private Script script = new Script();

    public AppUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(0x283C4F));
        // UI components
        panelExitandTitle = new JPanel();
        panelExitandTitle.setLayout(new BorderLayout());
        panelExitandTitle.setOpaque(false);
        title = new JLabel("  Guess Pin Code");
        title.setForeground(Color.WHITE);
        title.setFont(title.getFont().deriveFont(12f));
        panelExitandTitle.add(title, BorderLayout.WEST);
        buttonExit = new JButton("X");
        buttonExit.addActionListener(new ButtonProcess());
        buttonExit.setBackground(Color.RED);
        buttonExit.setBorderPainted(false);
        buttonExit.setFocusPainted(false);
        panelExitandTitle.add(buttonExit, BorderLayout.EAST);
        panelCenter = new JPanel();
        panelCenter.setOpaque(false);
        panelUp = new JPanel();
        panelUp.setOpaque(false);
        buttonsUp = new JButton[4];
        for (int i = 0; i < buttonsUp.length; i++) {
            buttonsUp[i] = setImgforButton("resources/up.png");
            buttonsUp[i].addActionListener(new ButtonProcess());
            buttonsUp[i].setBorderPainted(false);
            buttonsUp[i].setFocusPainted(false);
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
            textFields[i].setBackground(new Color(0x283C4F));
            panelTextField.add(textFields[i]);
        }
        panelCenter.add(panelTextField);
        panelDown = new JPanel();
        panelDown.setOpaque(false);
        buttonsDown = new JButton[4];
        for (int i = 0; i < buttonsDown.length; i++) {
            buttonsDown[i] = setImgforButton("resources/down.png");
            buttonsDown[i].addActionListener(new ButtonProcess());
            buttonsDown[i].setBorderPainted(false);
            buttonsDown[i].setFocusPainted(false);
            panelDown.add(buttonsDown[i]);
        }
        panelCenter.add(panelDown);
        panelBottom = new JPanel();
        panelBottom.setLayout(new BorderLayout());
        panelBottom.setOpaque(false);
        panelResult = new JPanel();
        panelResult.setOpaque(false);
        result = new JLabel("Let's try to guess the password!");
        result.setForeground(Color.WHITE);
        result.setFont(result.getFont().deriveFont(13f));
        panelResult.add(result);
        panelBottom.add(panelResult, BorderLayout.NORTH);
        panelSelect = new JPanel();
        panelSelect.setOpaque(false);
        panelSelect.setOpaque(false);
        buttonCheck = new JButton("Check");
        buttonCheck.setBackground(Color.GREEN);
        buttonCheck.setBorderPainted(false);
        buttonCheck.setFocusPainted(false);
        buttonRestart = new JButton("Restart");
        buttonRestart.setBackground(Color.ORANGE);
        buttonRestart.setBorderPainted(false);
        buttonRestart.setFocusPainted(false);
        buttonCheck.addActionListener(new ButtonProcess());
        buttonRestart.addActionListener(new ButtonProcess());
        panelSelect.add(buttonCheck);
        panelSelect.add(buttonRestart);
        panelBottom.add(panelSelect, BorderLayout.SOUTH);
        Container window = this;
        window.add(panelExitandTitle, "North");
        window.add(panelCenter, "Center");
        window.add(panelBottom, "South");
        setVisible(true);
    }

    public JButton setImgforButton(String imgPath) {
        try {
            // Method to set image for a button
            ImageIcon image = new ImageIcon(imgPath);
            // auto resize image to fit button
            image = new ImageIcon(image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            JButton button = new JButton(image);
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            return button;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private class ButtonProcess implements ActionListener {
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
                    if (script.ifDuplicateNumbers(textFields)) {
                        result.setText("Duplicate numbers are not allowed! Try again!");
                        return;
                    }
                    textFields = script.checkPassword(textFields);
                    if (script.rightPassword(textFields)) {
                        result.setText("You guessed the right password!");
                        revalidate();
                        repaint();
                        return;
                    } else {
                        result.setText("Try again!");
                    }
                    revalidate();
                    repaint();
                } else if (button == buttonRestart) {
                    for (int j = 0; j < textFields.length; j++) {
                        textFields[j].setText("0");
                        textFields[j].setDisabledTextColor(Color.WHITE);
                        // Restart the password
                        script = new Script();
                    }
                } else if (button == buttonExit) {
                    System.exit(0);
                }
            }
        }
    }
    public void enableWindowDrag(JFrame frame) {
        final Point[] mouseDownCompCoords = {null};
        panelExitandTitle.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords[0] = e.getPoint();
            }
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords[0] = null;
            }
        });
        panelExitandTitle.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                frame.setLocation(currCoords.x - mouseDownCompCoords[0].x, currCoords.y - mouseDownCompCoords[0].y);
            }
        });
    }
}
