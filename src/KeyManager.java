import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        }

        if (key == KeyEvent.VK_UP && !down) {
            right = false;
            up = true;
            left = false;
        }
        if (key == KeyEvent.VK_DOWN && !up) {
            right = false;
            down = true;
            left = false;
        }
    }
}
