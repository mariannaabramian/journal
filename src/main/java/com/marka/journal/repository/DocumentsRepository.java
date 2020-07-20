package com.marka.journal.repository;

import com.marka.journal.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentsRepository extends CrudRepository<Document, Integer> {


}
