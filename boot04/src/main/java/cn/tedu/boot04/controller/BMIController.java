package cn.tedu.boot04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIController {

    @RequestMapping("/bmi")
    public String bmi(Double h,Double w){ //用包装类接收(包装类比基本类多出一个未赋值状态)
        double BMI = w/(h*h);
        if (BMI<18.5){
            return "偏瘦";
        }else if (BMI<24){
            return "正常";
        }else if(BMI<28){
            return "微胖";
        }else {
            return "有点胖了";
        }
    }
}
