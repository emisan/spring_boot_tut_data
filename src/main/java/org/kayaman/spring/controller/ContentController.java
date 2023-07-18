package org.kayaman.spring.controller;

import org.kayaman.spring.model.Content;
import org.kayaman.spring.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * REST API for {@link ContentRepository}.
 *
 * @author Hayri Emrah Kayaman
 */
@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("")
    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Integer id) {
        return contentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No content for id " + id)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody final Content content) {
        contentRepository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody final Content content, @PathVariable final Integer id) {
        if (!contentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found for id " + id);
        }
        contentRepository.update(content, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable final Integer id) {
        contentRepository.delete(id);
    }
}
