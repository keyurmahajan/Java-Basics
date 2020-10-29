package com.kbm.java.practise.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Example of Immutable class (MyImmutable)
 *
 * 1. Declare the class as final so it can’t be extended.
 * 2. Make all fields private so that direct access is not allowed.
 * 3. Don’t provide setter methods for variables.
 * 4. Make all mutable fields final so that its value can be assigned only once.
 * 5. Initialize all the fields via a constructor performing deep copy.
 * 6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 *
 * @author Keyur Mahajan
 */
public class ImmutableClass {

    public static class Person implements Cloneable {
        private String name;
        private int id;

        public Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        protected Person clone() throws CloneNotSupportedException {
            return new Person(getName(), getId());
        }
    }

    // make class final so no one can extend
    public static final class MyImmutable{

        // make member variable private and final
        private final List<Person> myObject;

        // inject required parameter in constructor and do deep clone while assigning
        public MyImmutable(List<Person> myObject){
            List<Person> list = new ArrayList<>();
            myObject.forEach(p-> {
                try {
                    list.add(p.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            });

            this.myObject = list;
        }

        // No setter method allowed

        // return clone object list only
        public List<Person> getMyObject(){
            List<Person> list = new ArrayList<>();
            myObject.forEach(p-> {
                try {
                    list.add(p.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            });
            return list;
        }

    }
}
