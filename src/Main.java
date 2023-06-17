import com.cfg.Constants;
import com.front.Window;

public class Main {
    public static void main(String[] args) {


        Window window = Window.getInstance();


        Thread thread = new Thread(window);
        thread.start();



    }
}