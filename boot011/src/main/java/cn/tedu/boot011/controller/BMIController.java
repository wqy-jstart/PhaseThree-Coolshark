package cn.tedu.boot011.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIController {
    @RequestMapping("/bmi")
    @ResponseBody
    public String BMI(double H,double W){
        double BMI = W/(H*H);
        if (BMI<18.5){
            return "偏瘦";
        }else if (18.5<=BMI&&BMI<=24){
            return "正常";
        }else if(24<=BMI&&BMI<=28){
            return "微胖";
        }else {
            return "有点胖了";
        }
    }
}
