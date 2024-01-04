package com.example.demo;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;

@DgsComponent
public class TutorialDgsMutation {
    private final AuthorRepository authorRepository;
    private final TutorialRepository tutorialRepository;

    public TutorialDgsMutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
    }

    @DgsData(parentType = "Mutation", field = "createAuthor")
    public Author createAuthor(String name, Integer age)
    {
        Author newAuthor = new Author(name, age);
        return authorRepository.save(newAuthor);
    }

    @DgsData(parentType = "Mutation", field = "createTutorial")
    public Tutorial createTutorial(String title, String description, Integer authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if(author != null)
        {
            Tutorial newTutorial = new Tutorial(title, description, author);
            return tutorialRepository.save(newTutorial);
        }
        return null;
    }

    @DgsData(parentType = "Mutation", field = "updateTutorial")
    public Tutorial updateTutorial(Integer tutorialID,String title, String description) {
        Tutorial tutorial = tutorialRepository.findById(tutorialID).orElse(null);
        if(tutorial != null)
        {
            tutorial.setTitle(title);
            tutorial.setDescription(description);
            return tutorialRepository.save(tutorial);
        }
        return tutorial;
    }

    @DgsData(parentType = "Mutation", field = "deleteTutorial")
    public Boolean deleteTutorial(Integer tutorialID) {
        tutorialRepository.deleteById(tutorialID);
        return true;
    }

}
