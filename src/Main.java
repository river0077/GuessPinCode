import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import logic.GameLogic;
import view.GamePanel;
import controller.GameController;

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
        //     /**
        //      * for testing purposes
        //      */
        //     System.out.println("Password (for testing purposes): ");
        //     int[] password = logic.getPassword();
        //     for (int num : password) {
        //         System.out.print(num);
        //     }
        //     System.out.println();
        //     // end for testing purposes
        });
    }
}
