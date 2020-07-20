package com.marka.journal.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_generator")
    @SequenceGenerator(name = "document_generator", sequenceName = "S_DOCUMENTS", allocationSize = 1)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private DocType docType;

    @Column
    @Size(max = 250, message = "Длина поля не должна превышать 250 символов")
    private String importerName;

    @Column
    @Size(max = 250, message = "Длина поля не должна превышать 250 символов")
    private String importerDocumentNumber;

    @Column
    @Size(max = 250, message = "Длина поля не должна превышать 250 символов")
    private String inspectorFIO;

    @Column
    private String status;

    @Column
    private String loadDate;

    @Column
    @Size(max = 25, message = "Длина поля не должна превышать 25 символов")
    private String registrationNumber;

    public Document(String importerName,
                    DocType docType,
                    String importerDocumentNumber,
                    String inspectorFIO,
                    String status,
                    String loadDate) {
        this.importerName = importerName;
        this.docType = docType;
        this.importerDocumentNumber = importerDocumentNumber;
        this.inspectorFIO = inspectorFIO;
        this.status = status;
        this.loadDate = loadDate;
    }

    public Document() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInspectorFIO() {
        return inspectorFIO;
    }

    public void setInspectorFIO(String inspectorFIO) {
        this.inspectorFIO = inspectorFIO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(String loadDate) {
        this.loadDate = loadDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getImporterName() {
        return importerName;
    }

    public void setImporterName(String importerName) {
        this.importerName = importerName;
    }

    public String getImporterDocumentNumber() {
        return importerDocumentNumber;
    }

    public void setImporterDocumentNumber(String importerDocumentNumber) {
        this.importerDocumentNumber = importerDocumentNumber;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }
}
