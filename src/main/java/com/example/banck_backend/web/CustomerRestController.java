package com.example.banck_backend.web;

import com.example.banck_backend.dtos.CustomerDTO;
import com.example.banck_backend.exception.CustomerNotFoundException;
import com.example.banck_backend.service.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CustomerRestController {
    private BankAccountService bankAccountService;
@GetMapping("/customers")
@PreAuthorize("hasAnyRole('SCOPE_USER')")
    public List<CustomerDTO> customers(){
        return bankAccountService.CUSTOMERLIST();
    }

    @GetMapping("/customers/search")
    @PreAuthorize("hasAnyRole('SCOPE_USER')")
    public List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword", defaultValue = "") String keyword){
        return bankAccountService.searchCustomers("%"+keyword+"%");
    }

    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAnyRole('SCOPE_USER')")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
         return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    @PreAuthorize("hasAnyRole('SCOPE_ADMIN')")
    public  CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
    return bankAccountService.saveCostumer(customerDTO);
}

@PutMapping("/customers/{customerId}")
@PreAuthorize("hasAnyRole('SCOPE_ADMIN')")
public CustomerDTO updateCustomer(@PathVariable Long customerId,@RequestBody CustomerDTO customerDTO){
customerDTO.setId(customerId);
return bankAccountService.updateCustomer(customerDTO);

}
@DeleteMapping("/customers/{id}")
@PreAuthorize("hasAnyRole('SCOPE_ADMIN')")
public void deleteCustomer(@PathVariable Long id){
    bankAccountService.deleteCustomer(id);

}
}
