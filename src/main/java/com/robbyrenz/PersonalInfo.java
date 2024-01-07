package com.robbyrenz;

import lombok.Builder;

@Builder
public record PersonalInfo(int age,
                           String streetAddress,
                           String graduatedFromUniversity,
                           String job,
                           String emailAddress) {}
