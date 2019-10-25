package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.*;
import com.lambdaschool.starthere.services.CategoryService;
import com.lambdaschool.starthere.services.InterestService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Loggable
@RestController
@RequestMapping("/topnine")
public class InterestController
{
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private InterestService interestService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "return all Interests",
    response = Interest.class,
    responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: category/user(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})

    @GetMapping(value = "/interests", produces = {"application/json"})
    public ResponseEntity<?> listAllInterests(@PageableDefault(page = 0, size = 9) Pageable pageable, HttpServletRequest request)
    {
        List<Interest> interestList = interestService.findAll(pageable);
        return new ResponseEntity<>(interestList, HttpStatus.OK);
    }


    @ApiOperation(value = "add a new interest object",
            response = Interest.class)
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Interest added"), @ApiResponse(code = 404,
            message = "Interest already exists",
            response = ErrorDetail.class)})

    @PostMapping(value = "/interests/interest/add/{userid}", produces ={"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> addNewInterest(@Valid @RequestBody Interest newInterest, @PathVariable long userid) throws URISyntaxException
    {
        interestService.save(newInterest, userid);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newInterestURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Interestid}").buildAndExpand(newInterest.getInterestid()).toUri();
        responseHeaders.setLocation(newInterestURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @ApiOperation(value = "return all Categories",
            response = Category.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: category/user(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})

    @GetMapping(value = "/categories", produces = {"application/json"})
    public ResponseEntity<?> listAllCategories(@PageableDefault(page = 0, size = 9) Pageable pageable, HttpServletRequest request)
    {
        List<Category> catergoryList = categoryService.findAll(pageable);
        return new ResponseEntity<>(catergoryList, HttpStatus.OK);
    }

    @ApiOperation(value = "add a new category object")
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Category added"), @ApiResponse(code = 404,
            message = "Category already exists",
            response = ErrorDetail.class)})

    @PostMapping(value = "/categories/category/add", produces ={"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> addNewCategory(@Valid @RequestBody Category newCategory) throws URISyntaxException
    {
        newCategory = categoryService.save(newCategory);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newInterestURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Categoryid}").buildAndExpand(newCategory.getCategoryid()).toUri();
        responseHeaders.setLocation(newInterestURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @ApiOperation(value = "add an existing interest to existing user using ids")
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Interest Added to User"), @ApiResponse(code = 404,
            message = "Interest/User Not Found",
            response = ErrorDetail.class)})

    @PostMapping(value = "/interests/interest/{intid}/user/{userid}")
    public ResponseEntity<?> addBookToAuthor(@PathVariable long intid,
                                             @PathVariable long userid)
    {
        interestService.addInterestToUser(intid, userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/interest/{id}")
    public ResponseEntity<?> updateUser(HttpServletRequest request,
                                        @RequestBody
                                                Interest updateinterest,
                                        @PathVariable
                                                long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        interestService.update(updateinterest,
                id/*,
                request.isUserInRole("ADMIN")*/);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/interest/{id}")
    public ResponseEntity<?> deleteUserById(HttpServletRequest request,
                                            @PathVariable
                                                    long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        interestService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
