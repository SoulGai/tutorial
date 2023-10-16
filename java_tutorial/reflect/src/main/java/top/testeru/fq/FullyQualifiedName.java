package top.testeru.fq;

/**
 * @program: java_tutorial
 * @author: 盖盖
 * @description: 返回一个对象的类的完全限定名称
 * @Date: 2023/10/16
 */
public class FullyQualifiedName {

    public static void main(String[] args) {
        FullyQualifiedName fullyQualifiedName = new FullyQualifiedName();
        // top.testeru.fq.FullyQualifiedName
        System.out.println(fullyQualifiedName.getName());
    }


    /**
     * getClass().getName() 是 Java 中的一个方法，它返回一个对象的类的完全限定名称。
     * 这个方法可以在 Java 中的任何对象上调用。返回的字符串包含了包名和类名，用点号分隔。
     * 例如，如果类名是 "MyClass"，它在包 "com.example" 中，那么类的完全限定名称就是 "com.example.MyClass"。
     */

    private String getName(){
        return getClass().getName();
    }
}
