package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.models.UserDTO;
import com.msbills.repositories.BillRepository;
import com.msbills.repositories.FeignUserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

  private final FeignUserRepository feignUserRepository;
  private final BillRepository repository;

  public List<Bill> getAllBill() {
    return repository.findAll();
  }

  public Bill saveBill(Bill bill) {
    return repository.save(bill);
  }

  public Bill findByCustomer(String customer) {
    ResponseEntity<UserDTO> user = feignUserRepository.findByCustomer(customer);
    Bill bill = repository.findByCustomerBill(customer).orElse(null);
    bill.setUserDTO(user.getBody());
    return bill;
  }

}
