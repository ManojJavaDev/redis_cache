package com.rediscache.redis_cache.service;

import com.rediscache.redis_cache.entity.UserProfile;
import com.rediscache.redis_cache.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserProfileRepository userProfileRepository;

    @Cacheable(value = "userProfile", key = "#userProfile.id")
    @Override
    public List<UserProfile> getAllUserProfiles() {
        System.out.println("Fetching from DB and not using caching");
        return userProfileRepository.findAll();
    }

    @Override
    public String addUserProfile(UserProfile userProfile) {

        if(userProfile !=null){
            userProfileRepository.save(userProfile);
            System.out.println("Added resource to DB");
            return userProfile.getName()+"  User profile is added successfully";
        }else{
            return "user profile cannot be empty";
        }
    }

    @Override
    public String deleteUserProfile(Long Id) {
        return null;
    }


    @Override
    @CachePut(value = "userProfile", key = "#userProfile.id")
    public String updateUserProfile(UserProfile userProfile) {
        Optional<UserProfile> userProfileBeforeChange = userProfileRepository.findById(userProfile.getId());

        if (userProfileBeforeChange.isEmpty() != true) {
            UserProfile userProfile1 = userProfileBeforeChange.get();
            String NameBeforeEdit = userProfile1.getName();
            userProfileRepository.save(userProfile);
            return "userProfile Id Name has been updated from : " + NameBeforeEdit
                    + " to " + userProfile.getName();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found with category Id : " + userProfile.getId());
    }

}
