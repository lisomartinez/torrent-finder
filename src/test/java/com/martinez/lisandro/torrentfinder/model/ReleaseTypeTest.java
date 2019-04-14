package com.martinez.lisandro.torrentfinder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReleaseTypeTest {

    @Test
    void equals() {
        assertThat(ReleaseType.of("release")).isEqualTo(ReleaseType.of("RELEASE"));
    }
}