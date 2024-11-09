import javax.swing.*;

public class app {

    private static void initWindow() {
        JFrame window = new JFrame("this is the window i guess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        initWindow();
    }

}
