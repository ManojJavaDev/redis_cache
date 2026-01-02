package com.rediscache.redis_cache.service;

import com.rediscache.redis_cache.entity.UserProfile;
import com.rediscache.redis_cache.repository.UserProfileRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepositoryImpl userProfileRepository;
    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public String addUserProfile(UserProfile userProfile) {

        if(userProfile !=null){
            userProfileRepository.save(userProfile);
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
    public String updateUserProfile() {
        return null;
    }
}
