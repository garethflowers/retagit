package garethflowers.retagit;

/**
 * @author Gareth Flowers
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    MainGUI mainGUI;
                    mainGUI = new MainGUI();
                } catch (Exception ex) {
                    System.out.println(ex.getStackTrace());
                }
            }
        });
    }

    private Main() {
    }
}
