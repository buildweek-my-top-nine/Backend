package com.lambdaschool.starthere.repository;

        import com.lambdaschool.starthere.models.Interest;
        import com.lambdaschool.starthere.models.User;
        import com.lambdaschool.starthere.view.JustTheCount;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.PagingAndSortingRepository;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

public interface InterestRepository extends PagingAndSortingRepository<Interest, Long>
{
    @Query(value = "SELECT COUNT(*) as count FROM userinterests WHERE interestid = :interestid AND userid = :userid",
            nativeQuery = true)
    JustTheCount checkCombo(long interestid,
                                 long userid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO userinterests (interestid, userid) VALUES (:interestid, :userid)",
            nativeQuery = true)
    void insertUserinterests(long interestid,
                     long userid);

    Interest findByInterestname(String name); // <-- added functionality
//
//    List<Interest> findByInterestNameContainingIgnoreCase(String title);
}
