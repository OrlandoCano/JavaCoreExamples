package com.luxoft.fullstack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class CollectionsExample {
    static Collection<String> names;
    public static void main(String[] args) {
        names = new ArrayList<>();
        addNames();
        System.out.println("ArrayList");
        System.out.println(names);

        names = new HashSet<>();
        addNames();
        System.out.println("HashSet");
        System.out.println(names);

        names = new LinkedList<>();
        addNames();
        System.out.println("LinkedList");
        System.out.println(names);

        names = new LinkedHashSet<>();
        addNames();
        System.out.println("LinkedHashSet");
        System.out.println(names);

    }

    private static void addNames(){
        names.add("John");
        names.add("Mary");
        names.add("Matt");
        names.add("Joe");
        names.add("Joe");
    }
}
