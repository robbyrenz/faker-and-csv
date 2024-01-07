package com.robbyrenz;

import com.github.javafaker.Cat;
import com.github.javafaker.Dog;
import com.github.javafaker.Faker;
import io.vavr.control.Either;

import java.util.concurrent.ThreadLocalRandom;

public class ObjectMother {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private final Faker faker;
    public ObjectMother(Faker faker) {
        this.faker = faker;
    }

    public FullName constructFullName() {
        var firstName = faker.name().firstName();
        var lastName = faker.name().firstName();
        return new FullName(firstName, lastName);
    }

    public PersonalInfo constructPersonalInfo() {
        var age = faker.number().numberBetween(18, 101);
        var streetAddress = faker.address().streetAddress();
        var university = faker.university().name();
        var job = faker.job().title();
        var emailAddress = faker.internet().emailAddress();
        return new PersonalInfo.PersonalInfoBuilder()
                .age(age)
                .streetAddress(streetAddress)
                .graduatedFromUniversity(university)
                .job(job)
                .emailAddress(emailAddress)
                .build();
    }

    public FunFacts constructFunFacts() {
        Either<Dog, Cat> pet;
        if (tossACoin()) {
            pet = Either.left(faker.dog());
        } else {
            pet = Either.right(faker.cat());
        }
        var color = faker.color().name();
        var book = faker.book().title();
        var pokemon = faker.pokemon().name();
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
