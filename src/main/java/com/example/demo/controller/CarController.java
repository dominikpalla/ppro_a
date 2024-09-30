package com.example.demo.controller;

import com.example.demo.model.Car;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private List<Car> cars = new ArrayList<Car>();

    @GetMapping("/")
    public String list(Model model){
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

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("edit", false);
        return "edit";
    }

    @GetMapping("/edit/{index}")
    public String create(Model model, @PathVariable int index){
        if(index > -1 && index < cars.size()){
            Car car = cars.get(index);
            car.setId((long) index);
            model.addAttribute("car", car);
            model.addAttribute("edit", true);
            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/save")
    public String delete(Model model, @ModelAttribute Car car){
        //Validation
        if(car.getId() != null){
            cars.remove(cars.get(Integer.parseInt(String.valueOf(car.getId()))));
        }
        cars.add(car);
        return "redirect:/";
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
