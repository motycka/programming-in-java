package lesson07.classloader;

import java.net.URL;

public class ClassLoaderExample {

    public void getClassLoader() {

        // get class loader
        ClassLoader classLoader = this.getClass().getClassLoader();
        // get resource from class loader
        URL url = classLoader.getResource("timezone-cities.txt");
        System.out.println(url);
        // get class resource - same for static and non-static context
        URL url2 = ClassLoaderExample.class.getResource("timezone-cities.txt");
        System.out.println(url2);
    }

    public static void getStaticClassLoader() {
        // In static context, this.getClass() is equivalent to ClassLoaderExample.class
        ClassLoader staticClassLoader = ClassLoaderExample.class.getClassLoader();
        // the rest is same as in non-static context ...
    }

}
