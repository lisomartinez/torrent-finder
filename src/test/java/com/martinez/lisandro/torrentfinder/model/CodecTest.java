package com.martinez.lisandro.torrentfinder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CodecTest {

    @Test
    void equalsIgnoreCase() {
        assertThat(Codec.of("codec")).isEqualTo(Codec.of("CODEC"));
    }
}