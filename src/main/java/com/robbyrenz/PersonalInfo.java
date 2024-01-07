package com.robbyrenz;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record PersonalInfo(@NonNull
                           Integer age,
                           @NonNull
                           String streetAddress,
                           @NonNull
                           String graduatedFromUniversity,
                           @NonNull
                           String job,
                           @NonNull
                           String emailAddress) {}
