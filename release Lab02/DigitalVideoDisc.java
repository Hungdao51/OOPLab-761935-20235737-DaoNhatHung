package AimsProject;

public class DigitalVideoDisc {
    
    //8. Create the DigitalVideoDisc class and its attributes
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    //9. Create accessors and mutators for the class DigitalVideoDisc
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    //10. Create Constructor method
    public DigitalVideoDisc(int id, String title, String category, String director, int length, double cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    
    public DigitalVideoDisc(String title){
        this.title = title;
    }

    public DigitalVideoDisc(String title, double cost){
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, double cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, double cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;
    }
}
