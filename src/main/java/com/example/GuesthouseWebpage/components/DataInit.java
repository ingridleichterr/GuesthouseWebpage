package com.example.GuesthouseWebpage.components;


import com.example.GuesthouseWebpage.model.Authority;
import com.example.GuesthouseWebpage.model.User;
import com.example.GuesthouseWebpage.service.AuthorityService;
import com.example.GuesthouseWebpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

import static com.example.GuesthouseWebpage.utils.Constants.Security.*;

@Component
public class DataInit {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @PostConstruct
    public void initData(){
        initAuthorityData();
        initAdminData();
        initUserData();
    }

    private void initAdminData(){
        Optional<Authority> optionalAuthority = authorityService.findAuthorityByName(AUTHORITY_ADMIN);

        if (optionalAuthority.isPresent()){
            User user = new User();
            user.setEmail("admin@guesthouse.ee");
            user.setPassword("guesthouseAdmin");
            user.setAuthority(optionalAuthority.get());

            if (userService.findUserByEmail(user.getEmail()).isEmpty()){
                userService.createUser(user);
            }
        }
    }

    private void initUserData(){
        Optional<Authority> optionalAuthority = authorityService.findAuthorityByName(AUTHORITY_USER);

        if (optionalAuthority.isPresent()){
            User user = new User();
            user.setEmail("user@guesthouse.ee");
            user.setPassword("guesthouseUser");
            user.setAuthority(optionalAuthority.get());

            if (userService.findUserByEmail(user.getEmail()).isEmpty()){
                userService.createUser(user);
            }
        }
    }

    private void initAuthorityData() {
        Authority authorityAdmin = new Authority();
        authorityAdmin.setName(AUTHORITY_ADMIN);
        createAuthority(authorityAdmin);

        Authority authorityUser = new Authority();
        authorityUser.setName(AUTHORITY_USER);
        createAuthority(authorityUser);

    }

    private void createAuthority(Authority authority) {
        if (authorityService.findAuthorityByName(authority.getName()).isEmpty()) {
            authorityService.createAuthority(authority);
        }
    }
}


