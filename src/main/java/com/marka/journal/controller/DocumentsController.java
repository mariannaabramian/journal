package com.marka.journal.controller;

import com.marka.journal.repository.DocumentsRepository;
import com.marka.journal.repository.JournalRepository;
import com.marka.journal.model.DocType;
import com.marka.journal.model.Document;
import com.marka.journal.model.JournalItem;
import com.marka.journal.form.DocumentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DocumentsController {
    @Autowired
    private DocumentsRepository documentsRep;

    @Autowired
    private JournalRepository journal;

    @GetMapping("/document/{id}/history")
    public String docHistory(@PathVariable int id, Model model) {
        Document document = documentsRep.findById(id).get();
        List<JournalItem> foundHistory = journal.findByDocument(document);

        model.addAttribute("document", document);
        model.addAttribute("history", foundHistory);

        return "history";
    }

    @GetMapping("/documents/add")
    public String addDocumentForm(Model model) {
        model.addAttribute("document", new Document());

        return "documentForm";
    }

    @PostMapping("/documents/add")
    public String save(ModelMap model,
                       @ModelAttribute("docForm") DocumentForm docForm,
                       Document doc,
                       BindingResult validationResult) {


        if (validationResult.hasErrors()) {
            return "documentForm";
        }

        documentsRep.save(doc);

        return "documents";
    }

    @GetMapping("/documents")
    public String listDocs(Model model) {

        for (int i = 0; i < 10; ++i) {
            String s1;
            if (i <= 5) {
                s1 = "new";
            } else {
                s1 = "registered";
            }
            ;

            Document document = new Document(
                    i + "ALKO IMPORT FIRM",
                    DocType.APPLICATION,
                    "100" + i,
                    "Ivanov I.I.",
                    s1,
                    "loadDate"
            );
            documentsRep.save(document);

//
//            for (int j = 0; j < 10; ++j) {
//                JournalItem journalItem = new JournalItem(document, "status-" + j, "Иванов И.И.");
//                journal.save(journalItem);
//            }
        }




        ArrayList<Document> allDocuments = new ArrayList<>();
        documentsRep.findAll().

                forEach(allDocuments::add);
//        accounts.findAll().forEach(account -> {
//            allAccounts.add(account);
//        });

        model.addAttribute("documents", allDocuments);
        return "documents";
    }


}
