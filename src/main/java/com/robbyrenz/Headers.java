package com.robbyrenz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Headers {
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    AGE("age"),
    STREET_ADDRESS("street_address"),
    UNIVERSITY("university"),
    JOB("job"),
    EMAIL_ADDRESS("email_address"),
    PET("pet"),
    FAVORITE_COLOR("favorite_color"),
    FAVORITE_BOOK("favorite_book"),
    FAVORITE_POKEMON("favorite_pokemon");

    private final String value;

    Headers(String value) {
        this.value = value;
    }

    public static String[] getAllHeaderValues() {
        Map<String, Headers> foo = Stream.of(values())
                .collect(toMap(header -> header.value,
                        e -> e,
                        (x, y) -> y,
                        LinkedHashMap::new));

        return foo.keySet().toArray(new String[0]);
    }
}
