package abstractClasses;

public class Woman extends Human {
    public Woman(int age, String name) {
        super(age, name);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I am a woman.");
    }

    @Override
    public void breath() {
        System.out.println("Woman's breathing...");
    }
}
