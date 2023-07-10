package com.example.kakao.global.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum WaterFlowType {

    STRONG("STRONG", "강함"),
    MIDDLE("MIDDLE", "중간"),
    WEEK("WEEK", "약한");

    private final String key;
    private final String displayName;

    public static WaterFlowType of(String key) {
        return Arrays.stream(WaterFlowType.values())
                .filter(e -> e.getKey().equals(key))
                .findAny()
                .orElse(WEEK);
    }
}

