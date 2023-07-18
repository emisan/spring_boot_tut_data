package org.kayaman.spring.components;

import org.springframework.stereotype.Component;

@Component
public class Message {

    private String msg;

    public void setMessage(final String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }
}
