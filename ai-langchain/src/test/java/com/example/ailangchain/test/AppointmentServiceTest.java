package com.example.ailangchain.test;

import com.example.ailangchain.entity.Appointment;
import com.example.ailangchain.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */
@SpringBootTest
class AppointmentServiceTest {
    @Autowired
    private AppointmentService appointmentService;
    @Test
    void testGetOne() {
        Appointment appointment = new Appointment();
        appointment.setUsername("LC");
        appointment.setIdCard("231181199812299999");
        appointment.setDepartment("颈椎康复");
        appointment.setTime("上午");
        appointment.setDate("2025-05-01");
        Appointment appointmentDB = appointmentService.getOne(appointment);
        System.out.println(appointmentDB);
    }
    @Test
    void testSave() {
        Appointment appointment = new Appointment();
        appointment.setUsername("LC");
        appointment.setIdCard("231181199812299999");
        appointment.setDepartment("膝盖韧带");
        appointment.setDate("2025-05-01");
        appointment.setTime("上午");
        appointment.setDoctorName("张医生");
        appointmentService.save(appointment);
    }

    @Test
    void testDelete() {
        appointmentService.removeById(1L);
    }
}

