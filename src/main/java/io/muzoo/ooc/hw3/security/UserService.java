package io.muzoo.ooc.hw3.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<String, User> users = new HashMap<>();

    {
        users.put("gigadot", new User("gigadot", "12345"));
        users.put("nessie", new User("nessie", "something"));
    }

    public User findByUsername(String username){
        return users.get(username);
    }

    public boolean checkIfUserExists(String username){
        return users.containsKey(username);
    }


}
