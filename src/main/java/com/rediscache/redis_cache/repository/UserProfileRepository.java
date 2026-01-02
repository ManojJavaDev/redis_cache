package com.rediscache.redis_cache.repository;

import com.rediscache.redis_cache.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
