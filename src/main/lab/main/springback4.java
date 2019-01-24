package main.lab.main;
import main.lab.config.ApplicationConfigController;
import org.springframework.context.*;
public class springback4 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationConfigController.getApplicationContext();
    }
}
