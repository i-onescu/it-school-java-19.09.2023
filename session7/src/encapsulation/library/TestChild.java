package encapsulation.library;


import encapsulation.test.TestParent;

public class TestChild extends TestParent {

    public void hello() {
        System.out.println(this.age);
        System.out.println(this.defaultAge);
    }
}
