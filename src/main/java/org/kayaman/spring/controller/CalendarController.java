package org.kayaman.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * REST API to response to current local data time
 *
 * @author Hayri Emrah Kayaman
 */
@RestController
@RequestMapping("/api")
public class CalendarController {

    @GetMapping("/calendar")
    public String getCalendar() {
        return LocalDateTime.now().toString();
    }
}
