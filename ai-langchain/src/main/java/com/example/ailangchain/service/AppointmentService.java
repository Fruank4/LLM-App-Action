package com.example.ailangchain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ailangchain.entity.Appointment;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}