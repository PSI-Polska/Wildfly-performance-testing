package pl.psi.wildfly_performance_testing.rest;

import pl.psi.wildfly_performance_testing.dao.*;
import pl.psi.wildfly_performance_testing.model.small.Address;
import pl.psi.wildfly_performance_testing.model.small.Author;
import pl.psi.wildfly_performance_testing.model.small.Book;
import pl.psi.wildfly_performance_testing.model.small.Chapter;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/")
public class SmallRest {
    @Inject
    UserDao dao;

    @Inject
    AuthorDao authorDao;

    @Inject
    AddressDao addressDao;

    @Inject
    BookDao bookDao;

    @Inject
    ChapterDao chapterDao;

    Random randGenerator = new Random(4283);

    @GET
    @Path("/authors")
    @Produces({"application/json"})
    @Transactional
    public Response getAuthors() {
        List<Author> all = authorDao.findAll();
        // lazy loading!
        all.forEach(i -> {
            i.getBooks().forEach(j->j.getChapters().size());
        });
        return Response.ok(all).build();
    }


    @GET
    @Path("/authors/create")
    @Produces({"application/json"})
    @Transactional
    public Response newAuthors() {
        createAuthor(0);
        return Response.ok().build();
    }



    @GET
    @Path("/authors/create/batch")
    @Produces({"application/json"})
    @Transactional
    public Response newAuthorsBatch() {
        for(int i=0;i<20+new Random().nextInt(20);i++){
            createAuthor(i);
        }
        return Response.ok().build();
    }

    @GET
    @Path("/books")
    @Produces({"application/json"})
    @Transactional
    public Response getBooks() {
        List<Book> all = bookDao.findAll();
        // lazy loading!
        all.forEach(i -> i.getChapters().size());
        return Response.ok(all).build();
    }


    @GET
    @Path("/books/create")
    @Produces({"application/json"})
    @Transactional
    public Response newBooks() {
        createBook();
        return Response.ok().build();
    }



    @GET
    @Path("/books/create/batch")
    @Produces({"application/json"})
    @Transactional
    public Response newBooksBatch() {
        for(int i=0;i<20+new Random().nextInt(20);i++){
            createBook();
        }
        return Response.ok().build();
    }

    private void createBook() {
        Book book = new Book();
        book.setTitle(String.valueOf(randGenerator.nextInt()));
        book.setDescription(String.valueOf(randGenerator.nextInt()));
        createBookChapters(book);
        book.setReleaseDate(generateDate(1945,10));
        assignAuthor(book);
        //bookDao.create(book);
    }

    private void assignAuthor(Book book) {
        Author randAuthor = authorDao.getRandomEntity();
        book.setAuthor(randAuthor);
        randAuthor.getBooks().add(book);
        authorDao.update(randAuthor);
    }

    private void createBookChapters(Book book) {
        int chCount = 10+randGenerator.nextInt(50);
        List<Chapter> chapters = new ArrayList<>();
        for(int i=1;i<=chCount;i++){
            chapters.add(createChapter(book,i));
        }
        book.setChapters(chapters);
        book.setChapterCount(chCount);
    }

    private Chapter createChapter(Book book, int i) {
        Chapter chapter= new Chapter();
        chapter.setNumber(i);
        chapter.setTitle(String.valueOf(randGenerator.nextInt()));
        chapter.setContent(String.valueOf(randGenerator.nextLong()));
        chapter.setBook(book);

        return chapter;
    }

    private void createAuthor(int i) {
        Author author = initAuthor();
        author.setAddress(createAddress(i));
        authorDao.create(author);
    }

    private Author initAuthor() {
        Author author = new Author();
        author.setFirstname(String.valueOf(randGenerator.nextInt()));
        author.setLastname(String.valueOf(randGenerator.nextInt()));
        author.setDateOfBirth(generateDate(1900,10));
        author.setDateOfDeath(generateDate(1960,40));
        author.setBooks(new ArrayList<Book>());
        return author;
    }

    private Date generateDate(int startYear ,int yearRange) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, startYear+ randGenerator.nextInt(yearRange));
        cal.set(Calendar.MONTH, Calendar.JANUARY+ randGenerator.nextInt(13));
        cal.set(Calendar.DAY_OF_MONTH, 1+randGenerator.nextInt(25));
        return cal.getTime();
    }

    private Address createAddress(int i) {
        Address address = new Address();
        address.setCity(String.valueOf(randGenerator.nextInt()));
        address.setCountry(String.valueOf(randGenerator.nextInt()));
        setAddressDummies(i, address);
        addressDao.create(address);
        return address;
    }

    private void setAddressDummies(int i, Address address) {
        address.setDummyAtrib1(i);
        address.setDummyAtrib2(i);
        address.setDummyAtrib3(i);
        address.setDummyAtrib4("4");
        address.setDummyAtrib5("5");
    }


}