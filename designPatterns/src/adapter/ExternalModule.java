package designPatterns.src.adapter;

public class ExternalModule {

    public void displayText(String text) {
        if (text.equals(text.toUpperCase())) {
            System.out.println(text);
        }
    }
}
