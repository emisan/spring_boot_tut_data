package org.kayaman.spring.repository;

import jakarta.annotation.PostConstruct;
import org.kayaman.spring.model.Content;
import org.kayaman.spring.model.Status;
import org.kayaman.spring.model.Type;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory repository to request {@link org.kayaman.spring.controller.ContentController} REST API
 */
@Repository
public class ContentRepository {

    private final List<Content> contents = new ArrayList<>();

    @PostConstruct
    private void init() {
        final Content content =
                new Content(
                        1,
                        "Spring boot article",
                        "An article about spring boot",
                        Status.IN_PROGRESS,
                        Type.ARTICLE,
                        LocalDateTime.now(),
                        null,
                        ""
                        );
        contents.add(content);
    }

    public List<Content> findAll()
    {
        return contents;
    }

    public Optional<Content> findById(Integer id) {
        return contents.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    public void save(final Content content) {
        final boolean doesNotExist = contents.stream().noneMatch(c -> content != null && c.id().equals(content.id()));
        if (doesNotExist) {
            contents.add(content);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.FOUND,
                    "Content with id " + content.id() + " already added to contents.");
        }
    }

    public void update(final Content content, final Integer id) {
        Content found = null;
        if (content != null && id != null) {
            found = this.findById(id).orElse(null);
        }
        if (found != null) {
            delete(id);
            contents.add(content);
        }
    }

    public boolean existsById(final Integer id) {
        return findById(id).isPresent();
    }

    public void delete(Integer id) {
        contents.removeIf(c -> c.id().equals(id));
    }
}
