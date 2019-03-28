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


subString问题
JDK 6中的substring
String是通过字符数组实现的。在jdk 6 中，String类包含三个成员变量：char value[]， int offset，int count。他们分别用来存储真正的字符数组，数组的第一个位置索引以及字符串中包含的字符个数。

当调用substring方法的时候，会创建一个新的string对象，但是这个string的值仍然指向堆中的同一个字符数组。这两个对象中只有count和offset 的值是不同的。


下面是证明上说观点的Java源码中的关键代码：

//JDK 6
String(int offset, int count, char value[]) {
    this.value = value;
    this.offset = offset;
    this.count = count;
}

public String substring(int beginIndex, int endIndex) {
    //check boundary
    return  new String(offset + beginIndex, endIndex - beginIndex, value);
}

JDK 6中的substring导致的问题
如果你有一个很长很长的字符串，但是当你使用substring进行切割的时候你只需要很短的一段。这可能导致性能问题，因为你需要的只是一小段字符序列，但是你却引用了整个字符串（因为这个非常长的字符数组一直在被引用，所以无法被回收，就可能导致内存泄露）。在JDK 6中，一般用以下方式来解决该问题，原理其实就是生成一个新的字符串并引用他。

JDK 7 中的substring
上面提到的问题，在jdk 7中得到解决。在jdk 7 中，substring方法会在堆内存中创建一个新的数组，数组中只包含规定子串。

    JDK7中只包含hash 和char[] 两个值，没有偏移量。

