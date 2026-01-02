package com.rediscache.redis_cache.controller;

import com.rediscache.redis_cache.entity.UserProfile;
import com.rediscache.redis_cache.service.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(path = "/api")
public class UserProfileController {

    @Autowired
    UserProfileServiceImpl userProfileService;

    @PostMapping("/addProfile")
    private ResponseEntity<String> addUserProfile(@RequestBody UserProfile userProfile){
        try {
            String status = userProfileService.addUserProfile(userProfile);
            return new ResponseEntity<>(status, HttpStatus.CREATED);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }
    }

}
