package com.rediscache.redis_cache.service;


import com.rediscache.redis_cache.entity.UserProfile;

import java.util.List;


public interface UserProfileService {

    List<UserProfile> getAllUserProfiles();

    String addUserProfile(UserProfile userProfile);

    String deleteUserProfile(Long Id);



    String updateUserProfile(UserProfile userProfile);
}




