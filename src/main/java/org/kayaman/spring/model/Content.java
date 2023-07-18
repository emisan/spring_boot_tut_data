package org.kayaman.spring.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

/**
 * Record Entity to store and retrieve data from content table.
 *
 * @param id not null
 * @param title not null
 * @param description nullable
 * @param status not null
 * @param contentType not null
 * @param created not null
 * @param updated nullable
 * @param url nullable
 *
 * @author Hayri Emrah Kayaman
 */
public record Content(
        Integer id,
        @NotBlank String title,
        String description,
        Status status,
        Type contentType,
        @NotBlank LocalDateTime created,
        LocalDateTime updated,
        String url
) {
}
