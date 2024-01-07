package com.robbyrenz;

import com.github.javafaker.Faker;

public class Main {
    private static final ObjectMother OBJECT_MOTHER= new ObjectMother(new Faker());
    private static final FullName fullName = OBJECT_MOTHER.constructFullName();
    private static final PersonalInfo personalInfo = OBJECT_MOTHER.constructPersonalInfo();
    private static final FunFacts funFacts = OBJECT_MOTHER.constructFunFacts();

    public static void main(String[] args) {
        var person = new Person(fullName, personalInfo, funFacts);
        System.out.println(person);
    }
}
