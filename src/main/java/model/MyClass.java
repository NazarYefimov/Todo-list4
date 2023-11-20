package model;

public class MyClass implements Cloneable {

    // ваші інші поля і методи

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
