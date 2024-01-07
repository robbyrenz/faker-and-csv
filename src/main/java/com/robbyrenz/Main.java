package com.robbyrenz;

import com.github.javafaker.Faker;
import com.github.javafaker.SlackEmoji;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        SlackEmoji slackEmoji = faker.slackEmoji();
        System.out.println(slackEmoji.celebration());
    }
}
