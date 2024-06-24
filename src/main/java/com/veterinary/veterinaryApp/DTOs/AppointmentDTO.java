package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long id;
    private LocalDateTime dateTime;
    private LocalDateTime creationDatetime;
    private String notes;
    private String veterinarian;
    private String clientName;
    private String petName;
    private String offeringName;
    private InvoiceDTO invoice;

    public AppointmentDTO(Appointment appointment) {

        this.id = appointment.getId();
        this.dateTime = appointment.getDateTime();
        this.notes = appointment.getNotes();
        this.creationDatetime = appointment.getCreationDatetime();
        this.veterinarian = appointment.getVeterinarian().getName();
        this.clientName = appointment.getClient().getFirstName() + " " + appointment.getClient().getLastName();
        this.petName = appointment.getPet().getPetName();
        this.offeringName = appointment.getOffering().getName();
        this.invoice = new InvoiceDTO(appointment.getInvoice());

    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalDateTime getCreationDatetime() {
        return creationDatetime;
    }

    public String getNotes() {
        return notes;
    }

    public String getVeterinarian() {
        return veterinarian;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPetName() {
        return petName;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }
}
