```
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];

    /** Cache the hash code for the string */
    private int hash; // Default to 0

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = -6849794470754667710L;
```
这就是String不可更改的原因，String类实际保存数据的是一个final字符数组，当然这个字符数组也是引用，final修饰数组导致
String不能修改。
但通过反射可以修改数组的值，但是不改变数组首地址，因此符合final规则。
目的？
1 String会大量使用，因此利用字符串常量池的功能来实现字符串的享元模式，减少创建，复用字符串，提高效率，如果能够更改字符串的值，会导致其他引用也被迫改变
造成安全问题。
节省内存，提高效率，避免安全性问题。
