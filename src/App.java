import javadraw.*;

public class App extends Window {

    double rotation = 0;
    Oval car;
    double speed = 5;
    double dx;
    double dy;
    boolean left, right, forward, back = false;

    public static void main(String[] args) throws Exception {
        Window.open();
    }

    public void start() {
        car = new Oval(screen, 400, 300, 20, 20);

        while (true) {
            calculateXY();
            movement();
            screen.update();
            screen.sleep(1 / 30.0);
        }
    }

   

    public void calculateXY(){
        dx = Math.sin(Math.toRadians(rotation)) * speed;
        dy = Math.cos(Math.toRadians(rotation)) * speed;
    }

    public void movement(){
        if(left){
            rotation += 5;
        }

        if(right){
            rotation -= 5;
        }

        if(forward){
            car.move(dx, dy);
        }
    }

    public void keyDown(Key k) {
        if (k == Key.W) {
            forward = true;
        }

        if (k == Key.S) {
            back = true;
        }
        if (k == Key.A) {
            left = true;
        }
        if (k == Key.D) {
            right = true;
        }

    }

    public void keyUp(Key k) {
        if (k == Key.W) {
            forward = false;
        }

        if (k == Key.S) {
            back = false;
        }
        if (k == Key.A) {
            left = false;
        }
        if (k == Key.D) {
            right = false;
        }

    }
}
