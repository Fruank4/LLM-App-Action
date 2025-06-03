package com.example.ailangchain.tools;

import com.example.ailangchain.entity.Appointment;
import com.example.ailangchain.service.AppointmentService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author <a>李闯——Frank</a>
 * @Description: ：）
 */

@Component
public class AppointmentTools {

    @Autowired
    private AppointmentService appointmentService;


    @Tool(name = "查询是否可预约", value="根据科室名称，日期，时间和医生查询是否有号源，并返回给用户")
    public boolean queryDepartment(
            @P(value = "科室名称") String name,
            @P(value = "日期") String date,
            @P(value = "时间，可选值:上午、下午") String time,
            @P(value = "医生名称", required = false) String doctorName
    ){
        System.out.println("查询是否有号源");

        // 默认有空闲
        return true;
    }

    @Tool(name = "康复预约", value = "先执行工具方法queryDepartment查询是否可预约，并直接给用户回答是否，并让用户确认所有预约信息，用户确认后再正式进行预约")
    public String appointment(Appointment appointment) {
        Appointment one = appointmentService.getOne(appointment);
        if (one == null) {
            boolean success = appointmentService.save(appointment);
            if (success) {
                return "预约成功";
            } else  {
                return "预约失败";
            }
        }
        return "您已经预约过了";
    }

    @Tool(name="取消预约挂号", value = "根据参数，查询预约是否存在，如果存在则删除预约记录并返回取 消预约成功，否则返回取消预约失败")
    public String cancelAppointment(Appointment appointment) {
        Appointment one = appointmentService.getOne(appointment);
        if (one != null) {
            //删除预约记录
            if (appointmentService.removeById(one.getId())) {
                return "取消预约成功";
            } else {
                return "取消预约失败";
            }
        }
        //取消失败
        return "您没有预约记录，请核对预约科室和时间";
    }
}
