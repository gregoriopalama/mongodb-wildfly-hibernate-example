package com.gregoriopalama.examples.ogmwildfly.service;

import com.gregoriopalama.examples.ogmwildfly.service.dto.MessageDto;
import com.gregoriopalama.examples.ogmwildfly.service.dto.UserDto;

/**
 * Created by gregorio on 24/08/16.
 */
public interface UserServiceBeanLocal {
    public MessageDto addUser(String username);
    public UserDto getUser(String username);
}
