package com.typogenius.actions;


import java.util.Arrays;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.models.User;

public class UserDataAction extends ActionSupport {
    private String id;
    private String name;
    private List<User> users;

    public String execute() {
        // Logic to retrieve user data based on the parameters
        if (id != null && !id.isEmpty()) {
            // Retrieve user by ID
            users = Arrays.asList(new User(1, "John Doe", "john@example.com"));
        } else if (name != null && !name.isEmpty()) {
            // Retrieve users by name
            users = Arrays.asList(new User(1, "John Doe", "john@example.com"), new User(2, "Jane Doe", "jane@example.com"));
        } else {
            // Retrieve all users
            users = Arrays.asList(new User(1, "John Doe", "john@example.com"), new User(2, "Jane Doe", "jane@example.com"), new User(3, "Bob Doe", "bob@example.com"));
        }
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSON(serialize = true)
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}