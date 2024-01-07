package com.robbyrenz;

import com.github.javafaker.Cat;
import com.github.javafaker.Dog;
import com.github.javafaker.Faker;
import io.vavr.control.Either;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final Faker FAKER = new Faker();
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        var fullName = constructFullName();
        var personalInfo = constructPersonalInfo();
        var funFacts = constructFunFacts();
        var person = new Person(fullName, personalInfo, funFacts);
        System.out.println(person);
    }

    private static FullName constructFullName() {
        var firstName = FAKER.name().firstName();
        var lastName = FAKER.name().firstName();
        return new FullName(firstName, lastName);
    }

    private static PersonalInfo constructPersonalInfo() {
        var age = FAKER.number().numberBetween(18, 101);
        var streetAddress = FAKER.address().streetAddress();
        var university = FAKER.university().name();
        var job = FAKER.job().title();
        var emailAddress = FAKER.internet().emailAddress();
        return new PersonalInfo.PersonalInfoBuilder()
                .age(age)
                .streetAddress(streetAddress)
                .graduatedFromUniversity(university)
                .job(job)
                .emailAddress(emailAddress)
                .build();
    }

    private static FunFacts constructFunFacts() {
        Either<Dog, Cat> pet;
        if (tossACoin()) {
            pet = Either.left(FAKER.dog());
        } else {
            pet = Either.right(FAKER.cat());
        }
        var color = FAKER.color().name();
        var book = FAKER.book().title();
        var pokemon = FAKER.pokemon().name();
        return FunFacts.builder()
                .pet(pet)
                .favoriteColor(color)
                .favoriteBook(book)
                .favoritePokemon(pokemon)
                .build();
    }

    private static boolean tossACoin() {
       return RANDOM.nextFloat() <= 0.5;
    }
}
