package com.marka.journal.repository;

import com.marka.journal.model.Document;
import com.marka.journal.model.JournalItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends CrudRepository<JournalItem, Integer> {
    List<JournalItem> findByDocument(Document document);
}
