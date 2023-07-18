package org.kayaman.spring.controller;

import org.kayaman.spring.components.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API root content of this application
 *
 * @author Hayri Emrah Kayaman
 */
@RestController
@RequestMapping("/api")
public class RootController {

    @Autowired
    private Message message;

    @GetMapping("")
    public String getRootContent() {
        message.setMessage("Hello to Spring-Boot!");
        return message.getMessage();
    }
}
