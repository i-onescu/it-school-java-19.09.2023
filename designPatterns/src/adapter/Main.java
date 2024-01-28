package designPatterns.src.adapter;

public class Main {

    public static void main(String[] args) {
        ModuleInterface moduleInterface = new MyModule();
        moduleInterface.displayText("salutare");

        ModuleInterface newModule = new ModuleAdapter(new ExternalModule());
        newModule.displayText("salutare");
    }
}
