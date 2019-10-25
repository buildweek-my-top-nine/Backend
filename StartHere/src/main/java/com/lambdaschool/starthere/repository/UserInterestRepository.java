package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Interest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserInterestRepository extends PagingAndSortingRepository<Interest, Long>
{
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM userinterests WHERE interestid = (:interestid)",
            nativeQuery = true)
    void deleteUserinterests(long interestid);
}
