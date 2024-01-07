package com.robbyrenz;

import com.github.javafaker.Cat;
import com.github.javafaker.Dog;
import io.vavr.control.Either;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record FunFacts(@NonNull
                       Either<Dog, Cat> pet,
                       @NonNull
                       String favoriteColor,
                       @NonNull
                       String favoriteBook,
                       @NonNull
                       String favoritePokemon) {
    @Override
    public String toString() {
        String typeOfPet;
        if (pet.isLeft()) {
//            typeOfPet = pet.getLeft().getClass().getSimpleName();
            typeOfPet = pet.getLeft().breed();
        } else {
//            typeOfPet = pet.get().getClass().getSimpleName();
            typeOfPet = pet.get().breed();
        }
        return "FunFacts{" +
                "pet=" + typeOfPet +
                ", favoriteColor=" + favoriteColor +
                ", favoriteBook=" + favoriteBook +
                ", favoritePokemon=" + favoritePokemon +
                '}';
    }
}
