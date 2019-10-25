package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.StartHereApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartHereApplication.class) // unit testing, tests functionality. looking for main class
public class InterestServiceImplTest
{
    @Autowired
    private InterestService interestService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findAll()
    {
        assertEquals(5, interestService.findAll(Pageable.unpaged()).size());
    }

    @Test
    public void save()
    {
        interestService.save()
    }

    @Test
    public void addInterestToUser()
    {
    }

    @Test
    public void update()
    {
    }

    @Test
    public void deleteFound()
    {
        interestService.delete(1L);
        assertEquals(4, interestService.findAll(Pageable.unpaged()).size());
    }
}