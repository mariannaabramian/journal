package com.marka.journal.form;

import com.marka.journal.model.DocType;

public class DocumentForm {
    private DocType docType;
    private String importerName;
    private String importerDocumentNumber;
    private String inspectorFIO;
    private String status;
    private String loadDate;
    private String registrationNumber;

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
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
}
