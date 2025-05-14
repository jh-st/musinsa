package com.jh.version2.common.variable;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum Category implements EnumType {

    TOP("상의", 1),
    OUT("아우터", 2),
    BOT("바지", 3),
    SNK("스니커즈", 4),
    BAG("가방", 5),
    CAP("모자", 6),
    SCK("양말", 7),
    ACC("액세서리", 8);

    private final String text;
    private final int order;

    @Override
    public String getId() {
        return this.name();
    }

    @Override
    @JsonValue
    public String getText() {
        return this.text;
    }

    public static Optional<Category> from(String value) {
        return Arrays.stream(Category.values())
                .filter(c -> c.text.equalsIgnoreCase(value))
                .findFirst();
    }

}
