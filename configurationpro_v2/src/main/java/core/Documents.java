package core;



public class Documents implements Cloneable{
    protected String Documents_id;
    protected String Documents_name;
    protected String Documents_description;
    protected String Documents_image;

    public Documents(String Documents_id, String Documents_name, String Documents_description, String Documents_image) {
        this.Documents_id = Documents_id;
        this.Documents_name = Documents_name;
        this.Documents_description = Documents_description;
        this.Documents_image = Documents_image;
    }

    public Documents clone() throws CloneNotSupportedException {
        return (Documents) super.clone();
    }

    // Getter and setter methods
    public String getDocuments_id() {
        return Documents_id;
    }

    public void setDocuments_id(String Documents_id) {
        this.Documents_id = Documents_id;
    }

    public String getDocuments_name() {
        return Documents_name;
    }

    public void setDocuments_name(String Documents_name) {
        this.Documents_name = Documents_name;
    }

    public String getDocuments_description() {
        return Documents_description;
    }

    public void setDocuments_description(String Documents_description) {
        this.Documents_description = Documents_description;
    }

    public String getDocuments_image() {
        return Documents_image;
    }

    public void setDocuments_image(String Documents_image) {
        this.Documents_image = Documents_image;
    }
}