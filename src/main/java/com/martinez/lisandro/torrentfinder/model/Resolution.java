package com.martinez.lisandro.torrentfinder.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Resolution implements Comparable<Resolution> {
    public static final Resolution RESOLUTION_720P = Resolution.of("720p");

    private final String resolution;

    public static Resolution of(String resolution) {
        return new Resolution(resolution);
    }

    @Override
    public int compareTo(Resolution other) {
        if (this.resolution.equalsIgnoreCase(other.resolution)) return 0;

        if (this.resolution.equalsIgnoreCase("1080p") && (other.resolution.equalsIgnoreCase("SD"))) {
            return 2;
        } else if (this.resolution.equalsIgnoreCase("1080p") && (other.resolution.equalsIgnoreCase("480p"))) {
            return 2;
        } else if (this.resolution.equalsIgnoreCase("1080p") && (other.resolution.equalsIgnoreCase("720p"))) {
            return 1;
        } else if (this.resolution.equalsIgnoreCase("720p") && (other.resolution.equalsIgnoreCase("SD"))) {
            return 1;
        } else if (this.resolution.equalsIgnoreCase("720p") && (other.resolution.equalsIgnoreCase("480p"))) {
            return 1;
        } else if (this.resolution.equalsIgnoreCase("720p") && (other.resolution.equalsIgnoreCase("1080p"))) {
            return -1;
        } else if (this.resolution.equalsIgnoreCase("SD") && (other.resolution.equalsIgnoreCase("1080p"))) {
            return -2;
        } else if (this.resolution.equalsIgnoreCase("SD") && (other.resolution.equalsIgnoreCase("720p"))) {
            return -1;
        } else if (this.resolution.equalsIgnoreCase("SD") && (other.resolution.equalsIgnoreCase("480p"))) {
            return 0;
        } else if (this.resolution.equalsIgnoreCase("480p") && (other.resolution.equalsIgnoreCase("1080p"))) {
            return -2;
        } else if (this.resolution.equalsIgnoreCase("480p") && (other.resolution.equalsIgnoreCase("720p"))) {
            return -1;
        } else if (this.resolution.equalsIgnoreCase("480p") && (other.resolution.equalsIgnoreCase("SD"))) {
            return 0;
        }


        throw new IllegalArgumentException("Invalid resolution comparison between: " + this.resolution + " and " + other.resolution);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resolution that = (Resolution) o;

        return resolution.equalsIgnoreCase(that.resolution);
    }

    @Override
    public int hashCode() {
        return resolution.hashCode();
    }
}
