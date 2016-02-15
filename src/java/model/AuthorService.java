/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Buchw_000
 */
public class AuthorService {
    
    private List<Author> authors;
    
    public AuthorService(){
        testData();
    }
    
    public final List<Author> getAllAuthors(){
        return authors;
    }
    
    private void testData(){
        authors = new ArrayList<>(Arrays.asList
        (new Author(01, "Tom Clancey", LocalDateTime.now()), 
                new Author(01, "Tom Clancey", LocalDateTime.now()), 
                new Author(01, "Tom Clancey", LocalDateTime.now())));
    }



}
