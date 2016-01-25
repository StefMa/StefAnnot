package main;

import anotation.Binder;
import anotation.Set;

public class InstanceObject {

    @Set(intValue = 100)
    public int myInt;

    @Set(stringValue = "GitHub")
    public String myString;

    public InstanceObject() {
        Binder.bind(this);
        System.out.println("myInt value: " + myInt);
        System.out.println("myString value: " + myString);
    }

}
