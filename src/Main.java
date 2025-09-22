import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            GamePanel game = new GamePanel();
            frame.setTitle("Guess Pin Code");
            frame.setUndecorated(true);
            frame.add(game);
            frame.setResizable(false);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(3);
            game.enableWindowDrag(frame);
            frame.setVisible(true);
        });
    }
}
