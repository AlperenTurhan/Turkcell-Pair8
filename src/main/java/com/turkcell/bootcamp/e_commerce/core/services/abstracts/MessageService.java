package com.turkcell.bootcamp.e_commerce.core.services.abstracts;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArgs(String key, Object... args);
}
