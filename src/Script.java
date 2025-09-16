import java.awt.Color;

import javax.swing.JTextField;

public class Script {
    int[] password = {3, 1, 4, 2};
    public JTextField[] checkPassword(JTextField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            int value = Integer.parseInt(fields[i].getText());
            if (value == password[i]) {
                rightPosition(fields[i]);
            } else if (value != password[i] && contains(password, value)) {
                wrongPosition(fields[i]);
            } else {
                notInPassword(fields[i]);
            }
        }
        return fields;
    }
    public boolean rightPassword(JTextField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            int value = Integer.parseInt(fields[i].getText());
            if (value != password[i]) {
                return false;
            }
        }
        for (JTextField field : fields) {
            field.setDisabledTextColor(Color.GREEN);
        }
        return true;
    }
    public boolean contains(int[] password2, int value) {
        for (int i : password2) {
            if (i == value) return true;
        }
        return false;
    }
    public void rightPosition(JTextField field) {
        field.setDisabledTextColor(Color.GREEN);

    }
    public void wrongPosition(JTextField field) {
        field.setDisabledTextColor(Color.YELLOW);
        
    }
    public void notInPassword(JTextField field) {
        field.setDisabledTextColor(Color.RED);
        
    }
    public boolean ifDuplicateNumbers(JTextField[] fields) {
        int[] num = new int[4];
        for (int i = 0; i < fields.length; i++) {
            num[i] = Integer.parseInt(fields[i].getText());
        }
        boolean check = false;
        for (int i = 0; i < num.length; i++) {
            outer:for (int j = i + 1; j < num.length; j++) {
                if (num[i] != num[j]) {
                    continue outer;
                } else {
                    check = true;
                }
            }
        }
        return check;
    }

}
