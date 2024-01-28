package designPatterns.src.adapter;

public class ModuleAdapter implements ModuleInterface {
    private final ExternalModule module;

    public ModuleAdapter(ExternalModule module) {
        this.module = module;
    }

    @Override
    public void displayText(String text) {
        String upperString = convertToUpperString(text);
        module.displayText(upperString);
    }

    private String convertToUpperString(String text) {
        return text.toUpperCase();
    }
}
