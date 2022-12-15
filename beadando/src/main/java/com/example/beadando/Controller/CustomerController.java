package com.example.beadando.Controller;

import com.example.beadando.Entity.CustomerEntity;
import com.example.beadando.Entity.ProductEntity;
import com.example.beadando.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //listázás és nézet
    @GetMapping("/customers")
    public String listCustomers(Model model){
        model.addAttribute("customers",customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/customers/new")
    public String createCustomerForm(Model model){
        CustomerEntity product = new CustomerEntity();
        model.addAttribute("customer", product);
        return "create_customer";
    }

    @PostMapping("/customers")
    public String saveProduct(@ModelAttribute("customer") CustomerEntity customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "edit_customer";

    }

    @PostMapping("/customers/{id}")
    public String updateProduct(@PathVariable Long id,
                                @ModelAttribute("customer") CustomerEntity customer,
                                Model model){
        CustomerEntity existingCustomer = customerService.getCustomerById(id);
        existingCustomer.setId(id);
        existingCustomer.setVezeteknev(customer.getVezeteknev());
        existingCustomer.setKeresztnev(customer.getKeresztnev());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setSzuldatum(customer.getSzuldatum());

        customerService.updateCustomer(existingCustomer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
}
