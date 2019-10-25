package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceFoundException;
import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Interest;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.repository.InterestRepository;
import com.lambdaschool.starthere.repository.UserInterestRepository;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "interestService")
public class InterestServiceImpl implements InterestService
{
    @Autowired
    private InterestRepository interestRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserInterestRepository userInterestRepository;

    @Override
    public List<Interest> findAll(Pageable pageable)
    {
        List<Interest> list = new ArrayList<>();
        interestRepo.findAll(pageable)
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public void save(Interest interest, long userid)
    {
        if (interestRepo.findByInterestname(interest.getInterestname()) != null)
        {
            throw new ResourceFoundException(interest.getInterestname() + " is already taken! ");
        } else {
            Interest newInterest = new Interest();

            newInterest.setInterestname(interest.getInterestname());
            newInterest.setDescription(interest.getDescription());
//            newInterest.setUsers(interest.getUsers());
            newInterest.setCategory(interest.getCategory());

            interestRepo.save(newInterest);

            long newId = newInterest.getInterestid();

            addInterestToUser(newId, userid);
        }
    }

    @Override
    public void addInterestToUser(long intid, long userid) throws ResourceFoundException
    {
        interestRepo.findById(intid).orElseThrow(() -> new ResourceNotFoundException("Interest id " + intid + " not found"));
        userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException("User id " + userid + " not found"));

        if (interestRepo.checkCombo(intid, userid)
                .getCount() <= 0)
        {
            interestRepo.insertUserinterests(intid, userid);
        } else
        {
            throw new ResourceFoundException("Interest and User Combination Already Exists");
        }
    }

    @Override
    public Interest update(Interest interest, long id)
    {
        Interest currentInterest = interestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interest id: " + Long.toString(id) + " not found."));

        if (interest.getInterestname() != null)
        {
            currentInterest.setInterestname(interest.getInterestname());
//            currentInterest.setCategory(interest.getCategory());
            currentInterest.setDescription(interest.getDescription());
        }

        return interestRepo.save(currentInterest);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        interestRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Interest id " + id + " not found"));

        userInterestRepository.deleteUserinterests(id);
        interestRepo.deleteById(id);
    }
}
