public class Main {
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppUI app = new AppUI();
                app.setVisible(true);
            }
        });
    }
}
