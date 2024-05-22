package guru.spingframework.spring6wepapp.bootstrap;


import guru.spingframework.spring6wepapp.domain.Author;
import guru.spingframework.spring6wepapp.domain.Book;
import guru.spingframework.spring6wepapp.domain.Publisher;
import guru.spingframework.spring6wepapp.repositories.AuthorRepository;
import guru.spingframework.spring6wepapp.repositories.BookRepository;
import guru.spingframework.spring6wepapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

     private final AuthorRepository authorRepository;
     private final BookRepository bookRepository;
     private final PublisherRepository publisherRepository;
     public BootstrapData( AuthorRepository authorRepository,  BookRepository bookRepository, PublisherRepository   publisherRepository) {
        this.authorRepository =authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;


     }

    @Override
    public void run(String... args) throws Exception {
    Author eric = new Author();
    eric.setFirstname("Eric");
    eric.setLastname("Evans");

    Book ddd = new Book();
    ddd.setTitle("Domain Driven Design");
    ddd.setIsbn("271005");

    Author ericSaved = authorRepository.save(eric);
    Book dddSaved = bookRepository.save(ddd);

    Author rod = new Author();
    rod.setFirstname("Rod");
    rod.setLastname("Vo");

    Book lod = new Book();
    lod.setTitle("Harry");
    lod.setIsbn("123456");

    Author rodSaved = authorRepository.save(rod);
    Book lodSaved = bookRepository.save(lod);


//    add the book but has not saved the author
    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(lodSaved);
    dddSaved.getAuthors().add(ericSaved);
    lodSaved.getAuthors().add(rodSaved);

    authorRepository.save(ericSaved);
    authorRepository.save(rodSaved);

    Publisher publisher = new Publisher();
    publisher.setPublisherName("Publisher Name");
    publisher.setAddress("Publisher Address");
    publisherRepository.save(publisher);

    Publisher savedPublisher = publisherRepository.save(publisher);

    dddSaved.setPublisher (savedPublisher);
    lod.setPublisher (savedPublisher);
    bookRepository.save(dddSaved);
    bookRepository.save(lod);



    System.out.println("In Bootstrap");
    System.out.println("Author Count:" + authorRepository.count());
    System.out.println("Book Count:" + bookRepository.count());
    System.out.println("Publisher Count:" + publisherRepository.count());


     }

}
