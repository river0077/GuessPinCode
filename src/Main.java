import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            GamePanel game = new GamePanel();
            GameLogic logic = new GameLogic();
            GameController controller = new GameController(game, logic);
            frame.setTitle("Guess Pin Code");
            frame.setUndecorated(true);
            frame.add(game);
            frame.setResizable(false);
            frame.setSize(400, 270);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(3);
            controller.enableWindowDrag(frame);
            frame.setVisible(true);
        });
    }
}
