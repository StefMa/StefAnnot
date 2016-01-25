package main;

import anotation.Binder;
import anotation.Print;
import anotation.Println;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        Binder.bind(Main.class);
        Binder.bind(CounterClass.class);
        Binder.bind(CallMethodClass.class);

        new InstanceObject();
    }

    @Println
    public void helloWorldFromAnnotation() {
        // It prints 'Hello world' because of annotation
    }

    @Print(value = "Hello one time")
    @Println
    public void helloSmiley() {
        // It prints 'Hello one time' because of annotation
        // It prints 'Hello world' because of annotation
    }

    @Print(value = "Hello 4 times", times = 4)
    public void helloSmileyWithCount() {
        // It prints 'Hello 4 times' 4 times because of annotation
    }

}
