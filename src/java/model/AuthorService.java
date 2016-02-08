/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Buchw_000
 */
public class AuthorService {
    
    public List getAuthors()
    {
        Author author1 = new Author(01, "Tom Clancey", LocalDateTime.now());
        Author author2 = new Author(02, "J.K. Rowling", LocalDateTime.now());
        Author author3 = new Author(03, "J.R.R. Tolkien", LocalDateTime.now());            
        
        List<Author> Authors = new ArrayList<>();
        List<String> SearchResults = new ArrayList<>();
        
       Authors.add(author1);
       Authors.add(author2);
       Authors.add(author3);       

       
       //practice using maps
       Authors.stream().map((au) -> { SearchResults.add(au.getAuthorName());
           return au;
       }).map((au) -> { SearchResults.add(String.valueOf(au.getAuthorId()));
           return au;
       }).forEach((au) -> { SearchResults.add(String.valueOf(au.getDateAdded()));
       });
                 
       return SearchResults;
        
     
       
       
    }
    
}
