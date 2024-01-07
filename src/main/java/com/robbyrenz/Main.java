package com.robbyrenz;

import com.github.javafaker.Faker;
import com.github.javafaker.SlackEmoji;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        SlackEmoji slackEmoji = faker.slackEmoji();
        System.out.println(slackEmoji.celebration());
    }

    private record Person(FullName fullName,
                          PersonalInfo personalInfo,
                          FunFacts funFacts) {}

    private record FullName(String firstName,
                            String lastName) {}
    private record PersonalInfo(int age,
                                String streetAddress,
                                String graduatedFromUniversity,
                                String job) {}

    private record FunFacts(String pet,
                            String favoriteColor,
                            String favoriteBook,
                            String favoritePokemon) {}
}
