package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {

    ArrayList<Customer> petowner1 = new ArrayList<>();
//    ArrayList<Customer> tempDogOwners = new ArrayList<>();

    @Autowired
    CustomerService customService;

    @GetMapping("/form")
    public String loadFormPage(Model model){
        model.addAttribute("customer", new Customer());
                return "customer";
    }
    @PostMapping("/process")
    public String processCustomerPage(Customer customer, Model model){
//        System.out.println("print owner name = " + customer.getCustomerName());
//        System.out.println("print pet type = " + customer.getPetType());
        model.addAttribute("pet", new Pet());
//        save customer infor temporarily

        Customer custtemp2 = new Customer();
        custtemp2.setCustomerName(customer.getCustomerName());
        custtemp2.setPhoneNumber(customer.getPhoneNumber());
        custtemp2.setPetType(customer.getPetType());
        petowner1.add(custtemp2);
//        System.out.println("chekccc cutomer name form final contorlller plssss" + custtemp2.getCustomerName());
//
//        System.out.println("pet type at final check point = " + customer.getPetType());
        if(customer.getPetType().equals("dog")){
            return "dogform";
        }
        else{
            return "catform";
        }

    }
    @PostMapping("/addPet")
    public String loadCustomerAndPetPage(Pet pet, Model model){
        Customer cust = new Customer();
        for(int i = 0; i < 1; i++){

        cust.setCustomerName(petowner1.get(0).getCustomerName());
        cust.setPhoneNumber(petowner1.get(0).getPhoneNumber());
        cust.setPetType(petowner1.get(0).getPetType());
        }
//         empty the temp arraylist
        petowner1.remove(0);

        cust.setPet(pet);

        customService.addPetAndCustomer(cust);

        model.addAttribute("customer", new Customer());
        return "customer";
    }
    @GetMapping("/dogs")
    public String listDogs(Model model){

//        model.addAttribute("customer", new Customer());
        model.addAttribute("dogOwners", customService.listDogOwners());
        return "dogs";
    }

    @GetMapping("/cats")
    public String listCats(Model model){
        model.addAttribute("catOwners", customService.listCatOwners());
        return "cats";
    }


    @PostMapping("/processDog")
    public String processDogPage(Model model){
//        model.addAttribute("customer", new Customer());

        return "dogform";
    }
    @PostMapping("/processCat")
    public String processCatPage(Model model){
//        model.addAttribute("customer", new Customer());

        return "catform";
    }


}
