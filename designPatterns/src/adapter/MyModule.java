package designPatterns.src.adapter;

public class MyModule implements ModuleInterface {
    @Override
    public void displayText(String text) {
        if (text.equals(text.toLowerCase())) {
            System.out.println(text);
        }
    }
}
