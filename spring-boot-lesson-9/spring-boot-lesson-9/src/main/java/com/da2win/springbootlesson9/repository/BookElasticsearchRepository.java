package com.da2win.springbootlesson9.repository;

import com.da2win.springbootlesson9.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.MappingElasticsearchEntityInformation;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;
import org.springframework.stereotype.Repository;

@Repository("bookRepository")
public class BookElasticsearchRepository extends AbstractElasticsearchRepository<Book, String> {

    @Autowired
    public BookElasticsearchRepository(ElasticsearchOperations elasticsearchTemplate) {
        super(createElasticsearchEntityInformation(), elasticsearchTemplate);
    }

    private static ElasticsearchEntityInformation<Book, String> createElasticsearchEntityInformation() {
        TypeInformation<Book> typeInformation = ClassTypeInformation.from(Book.class);
        ElasticsearchPersistentEntity<Book> entity = new SimpleElasticsearchPersistentEntity<>(typeInformation);
        ElasticsearchEntityInformation<Book, String> information = new MappingElasticsearchEntityInformation<>(entity);
        return information;
    }

    @Override
    protected String stringIdRepresentation(String s) {
        return s;
    }
}
