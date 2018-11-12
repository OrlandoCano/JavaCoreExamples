package com.luxoft.fullstack;

public class DefaultInterfaceExample {
    public static void main(String[] args) {
        ConcreteDefault c = new ConcreteDefault();
        c.m1();
        c.m2();
        c.m2("Jorge");
        c.m3();
        c.m4();
        DefaultInterface d = new ConcreteDefault();
        d.m2();

    }
}

interface DefaultInterface{
    //protected void m1(); // Compilation error
    void m1();

    void m4();
    //protected default void m2(){ //Compilation error
    default void m2(){
        System.out.println("Default Interface M2");
    }
    default void m3(){
        System.out.println("Default Interface M3");
    }
}

class ConcreteDefault implements DefaultInterface{

    @Override
    public void m1() {
        System.out.println("concrete m1()");
    }

    public void m2(){
        System.out.println("Concrete m2()");
    }

    public void m2(String name){
        System.out.println("concrete m2(name)");
    }

    @Override
    public void m4() {
        System.out.println("concrete m4");
    }

}

class ConcreteDefault2 {
    public void m1(){
        System.out.println("concrete 2m1");
    }
}


class ConcreteDefault3 extends ConcreteDefault2{
    public void m1(){
        super.m1();
        System.out.println("concrete3 m1");
    }
}
