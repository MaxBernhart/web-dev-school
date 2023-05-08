package edu.lawrence.events.objects;

public class Event {
    private int id;
    private String title;
    private String time;
    private String place;
    private String description;
    
    public Event() { this.id = 0; }
    
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getTime() { return time; }
    public String getPlace() { return place; }
    public String getDescription() { return description; }
    
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setTime(String time) { this.time = time; }
    public void setPlace(String place) { this.place = place; }
    public void setDescription(String description) { this.description = description; }
}
