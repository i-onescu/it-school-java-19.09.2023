package encapsulation.library;

import oopExercises.encapsulation.test.TestParent;

public class TestChild extends TestParent {

    public void hello() {
        System.out.println(this.age);
        System.out.println(this.defaultAge);
    }
}
