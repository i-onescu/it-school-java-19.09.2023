public class InterfaceSegregation {

    public static void main(String[] args) {
    }

    // For the Interface Segregation Principle, we must avoid
    // forcing the clients to implement methods they won't use

    // the same avoidance method can be adopted as for Liskov principle.
    interface InterfaceOne {
        void doThis();
    }

    interface InterfaceTwo extends InterfaceOne {
        void doThat();
    }

    static class ClassOne implements InterfaceOne {

        @Override
        public void doThis() {
            System.out.println("classtwo dothis");
        }
    }

    static class ClassTwo implements InterfaceTwo {

        @Override
        public void doThis() {
            System.out.println("classone dothis");
        }

        @Override
        public void doThat() {
            System.out.println("classone dothat");
        }
    }
}
