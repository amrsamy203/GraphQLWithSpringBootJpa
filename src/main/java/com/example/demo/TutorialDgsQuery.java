package com.example.demo;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;

@DgsComponent
public class TutorialDgsQuery {
    private final AuthorRepository authorRepository;
    private final TutorialRepository tutorialRepository;

    public TutorialDgsQuery(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
    }



    @DgsQuery
    public List<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    @DgsQuery
    public int countTutorials() {
        return (int) tutorialRepository.count();
    }

    @DgsQuery
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @DgsQuery
    public int countAuthors() {
        return (int) authorRepository.count();
    }

}
