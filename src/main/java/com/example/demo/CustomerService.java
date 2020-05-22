package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public class CustomerService {

    ArrayList<Customer> owner = new ArrayList<>();
    ArrayList<Customer> dogOwners = new ArrayList<>();
    ArrayList<Customer> catOwners = new ArrayList<>();


    public void addPetAndCustomer(Customer tempCustomer){

        owner.add(tempCustomer);
    }

public ArrayList<Customer> listDogOwners(){
        for(int i = 0; i < owner.size(); i++){

            if(owner.get(i).getPetType().equals("dog")){
                dogOwners.add(owner.get(i));
            }
        }
        return dogOwners;
}

    public ArrayList<Customer> listCatOwners(){
        for(int i = 0; i < owner.size(); i++){
            if(owner.get(i).getPetType().equals("cat")){
                catOwners.add(owner.get(i));
            }
        }
        return catOwners;
    }
    public ArrayList<Customer> listAllOwners(){
        return owner;
    }

}
