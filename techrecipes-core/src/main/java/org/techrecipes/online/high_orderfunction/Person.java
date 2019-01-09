package org.techrecipes.online.high_orderfunction;
/**
 * Created by sjayapal on 2/10/2017.
 */
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        return "The person object is \n" + "Name: " + this.name + "\n" + "Age :" + this.age;
    }
}
