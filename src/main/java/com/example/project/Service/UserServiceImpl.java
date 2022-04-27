package com.example.project.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.project.Model.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> users = new HashMap<Integer, User>();
    private final AtomicLong counter = new AtomicLong();
    
    public UserServiceImpl() {
        users.put((int)counter.incrementAndGet(), new User(1001, "Rigen", "Kronaj", "example@email.com", 3));
        users.put((int)counter.incrementAndGet(), new User(1002, "Nikaela", "Kronaj", "example2@email.com", 3));
    }

    public Collection<User> getUser(Integer UID) {
        Map<Integer, User> user = new HashMap<Integer, User>();
        AtomicLong counter2 = new AtomicLong();
        for(Map.Entry<Integer, User> el : users.entrySet()){
            if(el.getValue().getUID().equals(UID))
                user.put((int)counter2.incrementAndGet(), el.getValue());
        }

        return user.values();
    }
}
