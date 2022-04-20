package lesson41.hw.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lesson41.hw.model.Book;
import lesson41.hw.repository.BookRepository;
import org.bson.Document;


@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "dropDb", author = "Shardina", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertNewBook1", author = "Shardina")
    public void insertNewBook1 (MongoDatabase db) {
        MongoCollection<Document> myCollection = db.getCollection("books");
        var doc = new Document()
                .append("_id", "10")
                .append("isbn", "749739574")
                .append("name", "Мастер и Маргарита")
                .append("autor", "Булгаков")
                .append("market", "Ozon")
                .append("size", "473");
        myCollection.insertOne(doc);
    }

    @ChangeSet(order = "003", id = "insertNewBook2", author = "Shardina")
    public void insertNewBook2 (BookRepository bookRepository) {
        Book book = new Book("11", "346537462", "Руслан и Людмила", "Пушкин А.С.", "wb", "145");
        System.out.println(book);
        bookRepository.save(book);
    }
}
