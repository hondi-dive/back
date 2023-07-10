package com.example.kakao.global.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum EntryType {

    BEATCH("BEATCH", "비치/해안"),
    BOAT("BOAT", "보트"),
    ETC("ETC", "기타");

    private final String key;
    private final String displayName;

    public static EntryType of(String key) {
        return Arrays.stream(EntryType.values())
                .filter(e -> e.getKey().equals(key))
                .findAny()
                .orElse(ETC);
    }
}

