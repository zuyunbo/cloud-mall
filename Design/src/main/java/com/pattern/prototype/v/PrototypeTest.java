package com.pattern.prototype.v;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {

    public static void main(String[] args) {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(18);
        concretePrototypeA.setName("prototype");
        List hobbies = new ArrayList<String>();
        concretePrototypeA.setHobbies(hobbies);
        System.out.println(concretePrototypeA);



        Client client = new Client(concretePrototypeA);
        Prototype prototype = client.startClone(concretePrototypeA);
        System.out.println(prototype);
    }

}
