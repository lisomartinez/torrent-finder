package com.martinez.lisandro.torrentfinder.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Codec {
    private final String codec;

    public static Codec of(String codec) {
        return new Codec(codec);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Codec codec1 = (Codec) o;

        return codec.equalsIgnoreCase(codec1.codec);
    }

    @Override
    public int hashCode() {
        return codec.hashCode();
    }
}
