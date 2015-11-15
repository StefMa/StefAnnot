package anotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Binder {

    public static <T> void bind(Class<T> clazz) {
        // Method Annotations check
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Println.class)) {
                Println annotation = method.getAnnotation(Println.class);
                executePrintLnAnnotation(annotation);
            }

            if (method.isAnnotationPresent(Print.class)) {
                Print annotation = method.getAnnotation(Print.class);
                executePrintAnnotation(annotation);
            }
        }

        // Class Annotations check
        if (clazz.isAnnotationPresent(MethodCalculation.class)) {
            int methodCount = clazz.getDeclaredMethods().length;
            System.out.println("Method count for Class '" + clazz.getName() + "': " + methodCount);
        }

        // Field Annotations check
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldCallMethod.class)) {
                FieldCallMethod annotation = field.getAnnotation(FieldCallMethod.class);
                String methodName = annotation.methodName();
                try {
                    Method method = clazz.getMethod(methodName);
                    method.invoke(clazz.newInstance());
                } catch (NoSuchMethodException
                        | InstantiationException
                        | IllegalAccessException
                        | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void executePrintLnAnnotation(Println println) {
        System.out.println("Hello world");
    }

    private static void executePrintAnnotation(Print print) {
        int times = print.times();
        String value = print.value();
        for (int i = 0; i < times; ++i) {
            System.out.println(value);
        }
    }

}
