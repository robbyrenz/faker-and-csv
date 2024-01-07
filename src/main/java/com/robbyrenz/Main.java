package com.robbyrenz;

import com.github.javafaker.Cat;
import com.github.javafaker.Dog;
import com.github.javafaker.Faker;
import io.vavr.control.Either;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    private static final int NUMBER_OF_RECORDS = 10;
    private static final ObjectMother OBJECT_MOTHER = new ObjectMother(new Faker());

    @SneakyThrows(IOException.class)
    public static void main(String[] args) {
        var people = new ArrayList<Person>();
        for (int i = 0; i < NUMBER_OF_RECORDS; i++) {
            var fullName = OBJECT_MOTHER.constructFullName();
            var personalInfo = OBJECT_MOTHER.constructPersonalInfo();
            var funFacts = OBJECT_MOTHER.constructFunFacts();
            people.add(new Person(fullName, personalInfo, funFacts));
        }

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(Headers.getAllHeaderValues())
                .build();

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("./sample.csv"));
             CSVPrinter printer = new CSVPrinter(writer, csvFormat)) {
            for (Person person : people) {
                printer.printRecord(
                        person.fullName().firstName(),
                        person.fullName().lastName(),
                        person.personalInfo().age(),
                        person.personalInfo().streetAddress(),
                        person.personalInfo().graduatedFromUniversity(),
                        person.personalInfo().job(),
                        person.personalInfo().emailAddress(),
                        getNameOfPet(person.funFacts().pet()),
                        person.funFacts().favoriteColor(),
                        person.funFacts().favoriteBook(),
                        person.funFacts().favoritePokemon());
            }
            printer.flush();
        }
    }

    private static String getNameOfPet(Either<Dog, Cat> pet) {
        if (pet.isLeft()) {
            return pet.getLeft().breed();
        }
        return pet.get().breed();
    }
}
