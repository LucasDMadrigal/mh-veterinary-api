package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Offering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private double price;
    
    private String image;

    @ElementCollection
    @Column(name="DaysOfService")
    private List<String> daysOfService; // los dias para determinado servicio.

    @ElementCollection
    @Column(name="HoursOfService")
    private List<String> hoursOfService; // los horarios para determinado servicio

    @OneToMany(mappedBy = "offering")
    private List<Appointment> appointments = new ArrayList<>(); // contiene los bloques horarios reservados

    @OneToMany(mappedBy = "offering")
    private List<AvailableSlots> availableSlots = new ArrayList<>(); // contiene los bloques horarios disponibles
    // CONSTRUCTORES
    
    public Offering() {
    }

    public Offering(String name, String description, double price, List<String> daysOfService, List<String> hoursOfService, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.daysOfService = daysOfService;
        this.hoursOfService = hoursOfService;
        this.image = image;
    }

    public Offering(String name, String description, double price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    // GETTERS Y SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getDaysOfService() {
        return daysOfService;
    }

    public void setDaysOfService(List<String> daysOfService) {
        this.daysOfService = daysOfService;
    }

    public List<String> getHoursOfService() {
        return hoursOfService;
    }

    public void setHoursOfService(List<String> hoursOfService) {
        this.hoursOfService = hoursOfService;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    // Otros metodos
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        appointment.setOffering(this);
    }

    public List<AvailableSlots> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<AvailableSlots> availableSlots) {
        this.availableSlots = availableSlots;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
}