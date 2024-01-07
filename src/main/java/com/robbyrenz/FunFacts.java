package com.robbyrenz;

import lombok.Builder;

@Builder
public record FunFacts(String pet,
                       String favoriteColor,
                       String favoriteBook,
                       String favoritePokemon) {}
