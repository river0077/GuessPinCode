import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppUI extends JFrame {
    private JPanel panelCenter;
    private JPanel panelUp;
    private JPanel panelDown;
    private JPanel panelTextField;
    private JPanel panelSelect;
    private JButton[] buttonsUp;
    private JButton[] buttonsDown;
    private JTextField[] textFields;
    private JButton buttonCheck;
    private JButton buttonReset;

    public AppUI() {
        setTitle("Guess PinCode");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        // UI components
        panelCenter = new JPanel();
        panelUp = new JPanel();
        buttonsUp = new JButton[4];
        for (int i = 0; i < buttonsUp.length; i++) {
            buttonsUp[i] = setImgforButton("resources/up.png");
            buttonsUp[i].addActionListener(new ButtonProcess());
            panelUp.add(buttonsUp[i]);
        }
        panelCenter.add(panelUp);
        panelTextField = new JPanel();
        panelTextField.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        textFields = new JTextField[4];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField();
            textFields[i].setPreferredSize(new Dimension(80, 60));
            textFields[i].setHorizontalAlignment(JTextField.CENTER);
            textFields[i].setText("0");
            textFields[i].setFont(textFields[i].getFont().deriveFont(30f));
            textFields[i].setEnabled(false);
            textFields[i].setDisabledTextColor(Color.BLACK);
            textFields[i].setBackground(Color.WHITE); 
            panelTextField.add(textFields[i]);
        }
        panelCenter.add(panelTextField);
        panelDown = new JPanel();
        buttonsDown = new JButton[4];
        for (int i = 0; i < buttonsDown.length; i++) {
            buttonsDown[i] = setImgforButton("resources/down.png");
            buttonsDown[i].addActionListener(new ButtonProcess());
            panelDown.add(buttonsDown[i]);
        }
        panelCenter.add(panelDown);
        panelSelect = new JPanel();
        buttonCheck = new JButton("Check");
        buttonReset = new JButton("Reset");
        buttonCheck.addActionListener(new ButtonProcess());
        buttonReset.addActionListener(new ButtonProcess());
        panelSelect.add(buttonCheck);
        panelSelect.add(buttonReset);
        Container window = getContentPane();
        window.add(panelCenter, "Center");
        window.add(panelSelect, "South");
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
            for(int i = 0; i < buttonsUp.length; i++) {
                if(button == buttonsUp[i]) {
                    int currentValue = Integer.parseInt(textFields[i].getText());
                    currentValue++;
                    if(currentValue > 9) currentValue = 0;
                    textFields[i].setText(String.valueOf(currentValue));
                    textFields[i].setDisabledTextColor(Color.BLACK);
                } else if(button == buttonsDown[i]) {
                    int currentValue = Integer.parseInt(textFields[i].getText());
                    currentValue--;
                    if(currentValue < 0) currentValue = 9;
                    textFields[i].setText(String.valueOf(currentValue));
                    textFields[i].setDisabledTextColor(Color.BLACK);
                } else if (button == buttonCheck) {
                    Script script = new Script();
                    if(script.ifDuplicateNumbers(textFields)) {
                        JOptionPane.showMessageDialog(null, "Duplicate numbers are not allowed!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    textFields = script.checkPassword(textFields);
                    if(script.rightPassword(textFields)) {
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct pin code!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        revalidate();
                        repaint();
                        return;
                    }
                    revalidate();
                    repaint();
                } else if (button == buttonReset) {
                    for(int j = 0; j < textFields.length; j++) {
                        textFields[j].setText("0");
                        textFields[j].setDisabledTextColor(Color.BLACK);
                    }
                }
            }
        }
    }
}
