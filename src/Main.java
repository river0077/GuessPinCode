import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            AppUI app = new AppUI();
            frame.setTitle("Guess Pin Code");
            frame.setUndecorated(true);
            frame.add(app);
            frame.setResizable(false);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(3);
            app.enableWindowDrag(frame);
            frame.setVisible(true);
        });
    }
}
