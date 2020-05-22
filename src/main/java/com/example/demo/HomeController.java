package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {

    ArrayList<Customer> petowner1 = new ArrayList<>();

    @Autowired
    CustomerService customService;

    @GetMapping("/form")
    public String loadFormPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/process")
    public String processCustomerPage(Customer customer, Model model) {

        model.addAttribute("pet", new Pet2());

        Customer custtemp2 = new Customer();
        custtemp2.setCustomerName(customer.getCustomerName());
        custtemp2.setPhoneNumber(customer.getPhoneNumber());
        custtemp2.setPetType(customer.getPetType());
        petowner1.add(custtemp2);

        if (customer.getPetType().equals("dog")) {
            return "dogform";
        } else {
            return "catform";
        }
    }

    @PostMapping("/addPet")
    public String loadCustomerAndPetPage(Pet2 pet, Model model) {
        Customer cust = new Customer();

            cust.setCustomerName(petowner1.get(0).getCustomerName());
            cust.setPhoneNumber(petowner1.get(0).getPhoneNumber());
            cust.setPetType(petowner1.get(0).getPetType());

//         empty the temp arraylist
        petowner1.remove(0);

        cust.setPet(pet);

        if (!cust.getCustomerName().equals("")) {
            customService.addPetAndCustomer(cust);
        }

        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @GetMapping("/dogs")
    public String listDogs(Model model) {
        model.addAttribute("dogOwners", customService.listDogOwners());
        return "dogs";
    }

    @GetMapping("/cats")
    public String listCats(Model model) {
        model.addAttribute("catOwners", customService.listCatOwners());
        return "cats";
    }

    @PostMapping("/processDog")
    public String processDogPage(Model model) {
        return "dogform";
    }

    @PostMapping("/processCat")
    public String processCatPage(Model model) {


        return "catform";
    }

    @GetMapping("/allpets")
    public String showAllPet(Model model) {
        model.addAttribute("allpets", customService.listAllOwners());
        return "allpets";
    }

}
