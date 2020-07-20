package com.marka.journal.controller;

import com.marka.journal.model.Document;
import com.marka.journal.repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DocumentsRESTController {

    @Autowired
    private DocumentsRepository docRepository;

    @GetMapping("/all/documents")
    public List<Document> foundDocuments(){
        ArrayList<Document> allDocuments = new ArrayList<>();
        for (Document doc : docRepository.findAll()){
            allDocuments.add(doc);
        }
        return allDocuments;

    }

}
