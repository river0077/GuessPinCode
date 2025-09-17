import javax.swing.SwingUtilities;
public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppUI app = new AppUI();
                app.setVisible(true);
            }
        });
    }
}
