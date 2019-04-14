package com.martinez.lisandro.torrentfinder.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Size implements Comparable<Size> {
    private static final int EMPTY_SIZE = 0;
    private static final String EMPTY_UNIT = "";
    public static final Size EMPTY = new Size(EMPTY_SIZE, EMPTY_UNIT);
    private final int size;
    private final String unit;

    public static Size of(int size, String unit) {
        return new Size(size, unit);
    }

    @Override
    public int compareTo(Size o) {
        if (this.unit.equalsIgnoreCase(o.unit)) {
            return this.size - o.size;
        }

        if (this.unit.equals(EMPTY_UNIT) && o.unit.equals(EMPTY_UNIT)) return this.size - o.size;

        //arbitrarily chosen behavior
        if (this.unit.equals(EMPTY_UNIT)) return 1;
        if (o.unit.equals(EMPTY_UNIT)) return -1;


        if (this.unit.equalsIgnoreCase("GB")) {
            int size = this.size * 1024;
            if (o.unit.equalsIgnoreCase("MB")) return size - o.size;
            if (o.unit.equalsIgnoreCase("GB")) return this.size - o.size;
        } else {
            int size = o.size * 1024;
            if (o.unit.equalsIgnoreCase("MB")) return this.size - o.size;
            if (o.unit.equalsIgnoreCase("GB")) return this.size - size;
        }

        throw new IllegalArgumentException("Invalid Sizes: " + this.size + this.unit + " and " + o.size + o.unit);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size1 = (Size) o;

        if (size != size1.size) return false;
        return unit != null ? unit.equalsIgnoreCase(size1.unit) : size1.unit == null;

    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
