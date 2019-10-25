package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Interest;
import com.lambdaschool.starthere.models.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterestService
{
    List<Interest> findAll(Pageable pageable);

    void save(Interest interest, long userid);

    void addInterestToUser(long intid, long userid);

    Interest update(Interest interest,
                long id);

    void delete(long id);
}
