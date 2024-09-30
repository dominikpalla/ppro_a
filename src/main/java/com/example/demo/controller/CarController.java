package com.example.demo.controller;

import com.example.demo.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private List<Car> cars = new ArrayList<Car>();

    @GetMapping("/")
    public String list(Model model){
        cars.add(new Car("ABC123", "blue",
                30.4f, 5));
        model.addAttribute("cars", cars);
        return "list";
    }

    @GetMapping("/detail/{index}")
    public String detail(Model model, @PathVariable int index){
        if(index > -1 && index < cars.size()){
            Car car = cars.get(index);
            model.addAttribute("car", car);
            return "detail";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{index}")
    public String delete(Model model, @PathVariable int index){
        if(index > -1 && index < cars.size()){
            cars.remove(index);
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
}
