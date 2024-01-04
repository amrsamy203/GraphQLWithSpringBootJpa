# GraphQL With Spring Boot-Jpa
 Build Spring Boot With h2 database, GraphQL and Docker

# How to run the project
 - First Clone the project
 - Move to the cmd at project dire location and write docker-compose up

# How to use the system
 - Open the browser and move to http://localhost:8080/graphiql
 - Now Can write queries to act with the system such as Ex.:
   - To create Author: mutation { createAuthor(name: "zaki", age: 27) { name age } }
   - To find all authors: query { findAllAuthors { name age} }
   - To create Tutorial: mutation { createTutorial(title: "GraphQl", description: "Introduction to GraphQl", authorId: 1) { title description } }
   - And There exist more examples to fetch more crud operation.
