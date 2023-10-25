package interfaces.markerInterface;

// This is a regular class marked with MarkerInterface interace
// In order to check the interfaces implemented by a class
// we can call 'MarkedClass.class.getInterfaces()' which will return an array of interfaces.
public class MarkedClass implements MarkerInterface {

    public int x = 1;
}
