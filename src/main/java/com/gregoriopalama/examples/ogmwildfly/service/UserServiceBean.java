package com.gregoriopalama.examples.ogmwildfly.service;

import com.gregoriopalama.examples.ogmwildfly.dao.Session;
import com.gregoriopalama.examples.ogmwildfly.dao.User;
import com.gregoriopalama.examples.ogmwildfly.repository.UserRepositoryBean;
import com.gregoriopalama.examples.ogmwildfly.service.dto.MessageDto;
import com.gregoriopalama.examples.ogmwildfly.service.dto.UserDto;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by gregorio on 24/08/16.
 */
@Stateless
@LocalBean
@Path("/user")
public class UserServiceBean implements UserServiceBeanLocal {

    @EJB
    UserRepositoryBean userRepository;

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    @Override
    public MessageDto addUser(@PathParam("username") String username) {
        MessageDto result = new MessageDto();
        try {
            if (userRepository.findByUsername(username) != null) {
                result.setMessage("User already in the system");
                return result;
            }
        } catch (Exception e) {
            //should implement the exception handling, but this code is merely for example purpose
        }

        User model = new User();
        model.setUsername(username);
        Session session = new Session();
        session.setStartDate(new Date());
        session.setEndDate(new Date());
        model.setSession(session);
        userRepository.insert(model);

        result.setMessage("User added");
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    @Override
    public UserDto getUser(@PathParam("username") String username) {
        User model = userRepository.findByUsername(username);
        UserDto dto = new UserDto();
        dto.setUsername(model.getUsername());
        return dto;
    }
}
