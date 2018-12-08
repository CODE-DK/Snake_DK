public class Snake {

    public static final int MAX_LENGTH = 10;
    private int length;
    private int image_size;

    private int[] x = new int[MAX_LENGTH];
    private int[] y = new int[MAX_LENGTH];

    public Snake(int length, int image_size) {
        this.length = length;
        this.image_size = image_size;
    }

    public int getLength() {
        return length;
    }

    public void grow() {
        length++;
    }

    public void step(){
        for (int i = length; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
    }

    public void left(){
        x[0] -= image_size;
    }

    public void right(){
        x[0] += image_size;
    }

    public void up(){
        y[0] -= image_size;
    }

    public void down(){
        y[0] += image_size;
    }

    public void init(){
        for (int i = 0; i < length; i++) {
            x[i] = length * image_size - i * image_size;
            y[i] = length * image_size;
        }
    }

    public int[] xCoord(){
        return x;
    }

    public int[] yCoord(){
        return y;
    }
}
