package com.robbyrenz;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        FullName fullName = new FullName(faker.name().firstName(), faker.name().lastName());
        System.out.println(faker.internet().emailAddress());
    }
}
