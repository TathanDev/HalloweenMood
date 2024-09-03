package fr.tathan.halloween_mood.common.config;

import java.io.Serializable;
import java.lang.reflect.Type;

public record ConfigEntry<T>(T value, String description) implements Serializable {
    public Type getType() {
        return this.value().getClass();
    }
}