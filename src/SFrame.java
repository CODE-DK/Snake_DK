import javax.swing.*;

public class SFrame extends JFrame {

    private final int COLS = 20;
    private final int IMAGE_SIZE = 30;

    private final int WIDTH = COLS * IMAGE_SIZE;
    private final int HEIGHT = WIDTH + 22;

    public SFrame(){
        init();
    }

    private  void  init(){
        setTitle("Snake : DK project");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(500, 500);

        add(new Game());
        setVisible(true);
    }

    public static void main(String[] args) {
        new SFrame();
    }
}
