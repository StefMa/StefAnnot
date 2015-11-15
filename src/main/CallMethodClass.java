package main;

import anotation.FieldCallMethod;

@SuppressWarnings("unused")
public class CallMethodClass {

    @FieldCallMethod(methodName = "fieldCallMethod")
    public String testField;

    public void fieldCallMethod() {
        System.out.println("I was called from annotation!");
    }

}
