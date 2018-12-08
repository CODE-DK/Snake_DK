import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JPanel implements ActionListener {

    private final int IMAGE_SIZE = 30;
    private final int COLS = 20;
    private final int SIZE = COLS * IMAGE_SIZE;

    private Image dotIcon;
    private Image appleIcon;

    private Apple apple;
    private Snake snake;

    private Random random = new Random();
    private Timer timer;
    private KeyManager manager;

    private boolean gameOver = false;

    public Game() {
        loadImages();
        addKeyListener(manager = new KeyManager());
        gameConfig();
        setFocusable(true);
    }

    public void gameConfig() {

        snake = new Snake(3, IMAGE_SIZE);
        snake.init();

        timer = new Timer(250, this);
        timer.start();
        createApple();
    }

    public void createApple() {
        apple = new Apple(
                random.nextInt(20) * IMAGE_SIZE,
                random.nextInt(20) * IMAGE_SIZE);
    }

    public void loadImages() {
        ImageIcon iia = new ImageIcon("apple.png");
        appleIcon = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dotIcon = iid.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameOver || !isWin()) {
            g.drawImage(appleIcon, apple.getX(), apple.getY(), this);

            for (int i = 0; i < snake.getLength(); i++) {
                g.drawImage(dotIcon, snake.xCoord()[i], snake.yCoord()[i], this);
            }
        } else if (gameOver){
            String message = "GAME OVER";
            g.drawString(message, SIZE / 2, SIZE / 2);
        } else {
            String message = "YOU WIN";
            g.drawString(message, SIZE / 2 , SIZE / 2);
        }
    }

    public void play() {
        snake.step();
        if (manager.isLeft()) snake.left();
        if (manager.isRight()) snake.right();
        if (manager.isUp()) snake.up();
        if (manager.isDown()) snake.down();
    }

    public void checkApple() {
        if (snake.xCoord()[0] == apple.getX() &&
                snake.yCoord()[0] == apple.getY()) {

            snake.grow();
            createApple();
        }
    }

    public void checkCollisions() {
        for (int i = snake.getLength(); i > 0; i--) {
            if (i > 4 &&
                    snake.xCoord()[0] == snake.xCoord()[i] &&
                    snake.yCoord()[0] == snake.yCoord()[i]) {
                gameOver = true;
            }
        }

        if (
                snake.xCoord()[0] > SIZE ||
                        snake.xCoord()[0] < 0 ||
                        snake.yCoord()[0] > SIZE ||
                        snake.yCoord()[0] < 0
                ) gameOver = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver || !isWin()) {
            checkApple();
            checkCollisions();
            play();
        }
        repaint();
    }

    private boolean isWin() {
        if (snake.getLength() == Snake.MAX_LENGTH) return true;
        return false;
    }

    private void Message(){

    }
}
