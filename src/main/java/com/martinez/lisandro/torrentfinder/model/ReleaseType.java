package com.martinez.lisandro.torrentfinder.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ReleaseType {
    private final String relaseType;

    public static ReleaseType of(String relaseType) {
        return new ReleaseType(relaseType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReleaseType that = (ReleaseType) o;

        return relaseType.equalsIgnoreCase(that.relaseType);
    }

    @Override
    public int hashCode() {
        return relaseType.hashCode();
    }
}
