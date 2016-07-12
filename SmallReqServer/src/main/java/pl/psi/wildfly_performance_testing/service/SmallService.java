package pl.psi.wildfly_performance_testing.service;

import pl.psi.wildfly_performance_testing.dao.*;
import pl.psi.wildfly_performance_testing.model.small.Address;
import pl.psi.wildfly_performance_testing.model.small.Author;
import pl.psi.wildfly_performance_testing.model.small.Book;
import pl.psi.wildfly_performance_testing.model.small.Chapter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
@Stateless
public class SmallService {

    @Inject
    AuthorCrudService authorDao;
    @Inject
    AddressCrudService addressCrudServ;
    @Inject
    BookCrudService bookDao;

//    @Inject
//            EntityManager entityManager;
    Random randGenerator = new Random(4283);

    public SmallService() {
    }

    public List<Author> listAllAuthors(){
        List<Author> all =authorDao.findAll();
        // lazy loading!
        all.forEach(i -> {
            i.getBooks().forEach(j->j.getChapters().size());
        });
        return all;
    }
    public List<Book> listAllBooks(){
        List<Book> all = bookDao.findAll();
        // lazy loading!
        all.forEach(i -> i.getChapters().size());
        return all;
    }

    public void createBook() {

        //setTransactionLvlUncomitted();
        Book book = new Book();
        book.setTitle(String.valueOf(randGenerator.nextInt()));
        book.setDescription(String.valueOf(randGenerator.nextInt()));
        createBookChapters(book);
        book.setReleaseDate(generateDate(1945, 10));
        assignAuthor(book);
        //bookDao.create(book);
    }

//    private void setTransactionLvlUncomitted() {
//        Connection connection = entityManager.unwrap(Connection.class);
//        try {
//            connection.setTransactionIsolation(Connection.TRANSACTION_NONE);
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    }

    void assignAuthor(Book book) {
        Author randAuthor = authorDao.getRandomEntity();
        book.setAuthor(randAuthor);
        randAuthor.getBooks().add(book);
        authorDao.update(randAuthor);
    }

    void createBookChapters(Book book) {
        int chCount = 2 + randGenerator.nextInt(5);
        List<Chapter> chapters = new ArrayList<Chapter>();
        for (int i = 1; i <= chCount; i++) {
            chapters.add(createChapter(book, i));
        }
        book.setChapters(chapters);
        book.setChapterCount(chCount);
    }

    Chapter createChapter(Book book, int i) {
        Chapter chapter = new Chapter();
        chapter.setNumber(i);
        chapter.setTitle(String.valueOf(randGenerator.nextInt()));
        chapter.setContent(String.valueOf(randGenerator.nextLong()));
        chapter.setBook(book);

        return chapter;
    }

    public void createAuthor(int i) {
        //setTransactionLvlUncomitted();
        Author author = initAuthor();
        author.setAddress(createAddress(i));
        authorDao.create(author);
    }

    Author initAuthor() {
        Author author = new Author();
        author.setFirstname(String.valueOf(randGenerator.nextInt()));
        author.setLastname(String.valueOf(randGenerator.nextInt()));
        author.setDateOfBirth(generateDate(1900, 10));
        author.setDateOfDeath(generateDate(1960, 40));
        author.setBooks(new ArrayList<Book>());
        return author;
    }

    Date generateDate(int startYear, int yearRange) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, startYear + randGenerator.nextInt(yearRange));
        cal.set(Calendar.MONTH, Calendar.JANUARY + randGenerator.nextInt(13));
        cal.set(Calendar.DAY_OF_MONTH, 1 + randGenerator.nextInt(25));
        return cal.getTime();
    }

    Address createAddress(int i) {
        Address address = new Address();
        address.setCity(String.valueOf(randGenerator.nextInt()));
        address.setCountry(String.valueOf(randGenerator.nextInt()));
        setAddressDummies(i, address);
        addressCrudServ.create(address);
        return address;
    }

    void setAddressDummies(int i, Address address) {
        address.setDummyAtrib1(i);
        address.setDummyAtrib2(i);
        address.setDummyAtrib3(i);
        address.setDummyAtrib4("4");
        address.setDummyAtrib5("5");
    }
}