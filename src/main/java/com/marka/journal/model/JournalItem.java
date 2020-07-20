package com.marka.journal.model;

import javax.persistence.*;


// Журнал действий с документами
@Entity
@Table(name = "JournalItems")
public class JournalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journalitem_generator")
    @SequenceGenerator(name = "journalitem_generator", sequenceName = "S_JOURNALITEMS", allocationSize = 1)
    private int id;

    @Column
    private String docStatusName;

    @Column
    private String inspectorFIO;

    @ManyToOne(optional = false)
    private Document document;

    public JournalItem(Document document, String docStatusName, String inspectorFIO) {
        this.document = document;
        this.docStatusName = docStatusName;
        this.inspectorFIO = inspectorFIO;
    }

    public JournalItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocStatusName() {
        return docStatusName;
    }

    public void setDocStatusName(String docStatusName) {
        this.docStatusName = docStatusName;
    }

    public String getInspectorFIO() {
        return inspectorFIO;
    }

    public void setInspectorFIO(String inspectorFIO) {
        this.inspectorFIO = inspectorFIO;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
