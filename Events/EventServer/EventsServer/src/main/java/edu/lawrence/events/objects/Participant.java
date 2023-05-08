package edu.lawrence.events.objects;

public class Participant {
    private int id;
    private int event;
    private String name;
    private String email;
    
    public Participant() { this.id = 0; }
    
    public int getId() { return this.id; }
    public int getEvent() { return this.event; }
    public String getName() { return this.name; }
    public String getEmail() { return this.email; }
    
    public void setId(int id) { this.id = id; }
    public void setEvent(int event) { this.event = event; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
