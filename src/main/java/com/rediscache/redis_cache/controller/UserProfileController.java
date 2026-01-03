package com.rediscache.redis_cache.controller;

import com.rediscache.redis_cache.entity.UserProfile;
import com.rediscache.redis_cache.service.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


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
    @GetMapping("/getAllUserProfiles")
    private List<UserProfile> getAllUserProfiles(){
        return userProfileService.getAllUserProfiles();
    }



    @PutMapping("/updateUserProfile")
    public ResponseEntity<String> updateCategories(@RequestBody UserProfile userProfile){

        try{
            String status = userProfileService.updateUserProfile(userProfile);
            return new ResponseEntity<String>(status, HttpStatus.OK);
            // return  ResponseEntity.ok(status);
            //  return ResponseEntity.status(HttpStatus.OK).body(status)
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }
    }


}
