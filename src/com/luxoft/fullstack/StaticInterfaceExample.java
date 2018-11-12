package com.luxoft.fullstack;

public class StaticInterfaceExample {
    public static void main(String[] args) {
        Concrete c = new Concrete();
        Concrete2 c2 = new Concrete2();
        StaticInterface s = new Concrete();
        c.m1(); // = Concrete.m1();
        c2.m1(); // Concretre2.m1();

        // s.m1(); // compilation error
        StaticInterface.m1(); // != s.m1();
        System.out.println(s.s2);

    }
}

interface StaticInterface{
    public static final String s = "hello";
    static String s2 = "static";
    final String s3 = "final";
    public String s4 = "public";
    String s6 = "Hi";

    //private String s5 = "hi"; // compilation error

    static void m1(){
        System.out.println("interface static m1");
    }
    static void m4(){
        System.out.println("interface static m4");
    }
    void m2();

    default void m3(){

    }
}

class Concrete implements StaticInterface{
    public static void m1(){
        System.out.println("Concrete static m1");
    }

    @Override
    public void m2() {

    }
}

class Concrete2 {
    public static void m1(){
        System.out.println("Concrete2 m1");
    }
}

interface Interface1{
    void m1();
}

interface Interface3 {
    void m3();
}

//interface Interface4 extends Abstract1{ // compilation error
//interface Interface4 extends Concrete3{ // compilation error
interface Interface4{
    void m4();
}

//interface Interface2 implements Interface1{ // compilation error
interface Interface2 extends Interface1, Interface3, Interface4{
    void m2();
}

abstract class Abstract1{
}

class Concrete3 implements Interface2{

    @Override
    public void m2() {

    }

    @Override
    public void m1() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }

}
