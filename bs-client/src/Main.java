import UI.LandingPage;
import logic.Service;

public class Main {

    public static void main(String[] args) {
        Service.run();
        LandingPage.getInstance().open();
    }

}
