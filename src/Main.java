import javax.swing.JFrame;
public class Main {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Guess Pin Code");
        frame.setUndecorated(true);
        frame.add(new AppUI());
        frame.setResizable(false);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
