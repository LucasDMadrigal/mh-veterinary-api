package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.AppointmentDTO;
import com.veterinary.veterinaryApp.Repositories.AppointmentRepository;
import com.veterinary.veterinaryApp.models.*;
import com.veterinary.veterinaryApp.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<AppointmentDTO> getAppointmentDTOs() {
        return getAllAppointments().stream().map(AppointmentDTO::new).toList();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void setEntities(Appointment appointment, Client client, Pet pet, Veterinarian veterinarian, Offering offering, Invoice invoice) {
        appointment.setClient(client);
        appointment.setPet(pet);
        appointment.setVeterinarian(veterinarian);
        appointment.setOffering(offering);
        appointment.setInvoice(invoice);
    }
}
