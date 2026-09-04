package com.codewithmosh.store.repositories;

import com.codewithmosh.store.dtos.UserSummary;
import com.codewithmosh.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

}