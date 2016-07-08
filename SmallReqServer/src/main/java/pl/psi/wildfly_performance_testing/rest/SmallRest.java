package pl.psi.wildfly_performance_testing.rest;

import pl.psi.wildfly_performance_testing.model.small.Author;
import pl.psi.wildfly_performance_testing.model.small.Book;
import pl.psi.wildfly_performance_testing.service.SmallService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;

@Path("/")
public class SmallRest {
    @Inject
    private SmallService smallService;

    @GET
    @Path("/authors")
    @Produces({"application/json"})
    @Transactional
    public Response getAuthors() {
        List<Author> all = smallService.listAllAuthors();
        return Response.ok(all).build();
    }


    @GET
    @Path("/authors/create")
    @Produces({"application/json"})
    @Transactional
    public Response newAuthors() {
        smallService.createAuthor(0);
        return Response.ok().build();
    }



    @GET
    @Path("/authors/create/batch")
    @Produces({"application/json"})
    @Transactional
    public Response newAuthorsBatch() {
        for(int i=0;i<20+new Random().nextInt(20);i++){
            smallService.createAuthor(i);
        }
        return Response.ok().build();
    }

    @GET
    @Path("/books")
    @Produces({"application/json"})
    @Transactional
    public Response getBooks() {
        List<Book> all = smallService.listAllBooks();
        return Response.ok(all).build();
    }


    @GET
    @Path("/books/create")
    @Produces({"application/json"})
    @Transactional
    public Response newBooks() {
        smallService.createBook();
        return Response.ok().build();
    }



    @GET
    @Path("/books/create/batch")
    @Produces({"application/json"})
    @Transactional
    public Response newBooksBatch() {
        for(int i=0;i<20+new Random().nextInt(20);i++){
            smallService.createBook();
        }
        return Response.ok().build();
    }



}