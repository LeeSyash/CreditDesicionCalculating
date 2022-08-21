package com.moskot.testTask.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Getter
public enum MobileOperators {
    KYIVSTAR(new HashSet<>(Arrays.asList("067","096","097","098")),0.95F),
    VODAFONE(new HashSet<>(Arrays.asList("050","066","095","099")),0.94F),
    LIFE(new HashSet<>(Arrays.asList("093","063","093")),0.92F),
    OTHER(0.9F);

    private HashSet<String> codes;
    private float k;

    MobileOperators(HashSet<String> codes, float k) {
        this.codes = codes;
        this.k = k;
    }

    MobileOperators(float k) {
        this.k = k;
    }
}
