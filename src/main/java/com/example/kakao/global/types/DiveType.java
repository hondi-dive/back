package com.example.kakao.global.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum DiveType {

    SNORKEL("SNORKEL", "스노클"),
    FREEDIVE("FREEDIVING", "프리다이브"),
    SCUBA("SCUBA", "스쿠버");

    private final String key;
    private final String displayName;

    public static DiveType of(String key) {
        return Arrays.stream(DiveType.values())
                .filter(d -> d.getKey().equals(key))
                .findAny()
                .orElse(SNORKEL);
    }
}

