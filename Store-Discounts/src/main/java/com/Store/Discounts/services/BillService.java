package com.Store.Discounts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Store.Discounts.Repository.BillRepository;
import com.Store.Discounts.model.Bill;
import com.Store.Discounts.model.Person;

import enums.PersonType;

@Service
public class BillService {
	private final BillRepository billRepository;
	private final PersonService personService;

	@Autowired
	public BillService(BillRepository billRepository, PersonService personService) {
		this.billRepository = billRepository;
		this.personService = personService;
	}

	public Bill addBill(Bill bill) {
		return billRepository.save(bill);
	}

	public List<Bill> findAllBills() {
		return billRepository.findAll();
	}

	public Bill upDateBill(Bill bill) {
		return billRepository.save(bill);
	}

	public void deleteBill(Long id) {
		billRepository.deleteById(id);
	}

	public Bill findBillById(Long id) {
		return billRepository.getById(id);
	}

	public Bill addBillWithDiscunt(String Phone, double amount) {
		if(amount == 0) {
			return null;
		}
		Person findPersonByPhone = personService.getOrCreatePersonByPhone(Phone);
		Bill bill = new Bill();
		bill.setPerson(findPersonByPhone);
		bill.setBillAmount(amount);
		return billRepository.save(getDicountedBill(findPersonByPhone, bill));
	}

	private Bill getDicountedBill (Person person , Bill bill){
		
		PersonType personType = PersonService.getPersonType(person);
		if(personType.equals(PersonType.employee)) {
			bill.setDiscountAmount(bill.getBillAmount()*0.3);
			bill.setReson("the person is an employee of the store");
		}else if(personType.equals(PersonType.customer)) {
			bill.setDiscountAmount(bill.getBillAmount()*0.1);
			bill.setReson("the person is is a regular customer of the store");
		}else {
			double billAmountDevHandred = Math.floor(bill.getBillAmount()/100);
			if(billAmountDevHandred>0){
				bill.setDiscountAmount(billAmountDevHandred*5);
				bill.setReson("For every $100 on the bill, there would be a $ 5 discount");
			}
		}
		bill.setBillTotal(bill.getBillAmount()-bill.getDiscountAmount());
		return bill;
		
	}

}
