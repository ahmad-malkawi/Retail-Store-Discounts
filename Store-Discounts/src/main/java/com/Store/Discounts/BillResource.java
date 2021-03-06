package com.Store.Discounts;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Store.Discounts.model.Bill;
import com.Store.Discounts.services.BillService;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
@RequestMapping("/bill")
public class BillResource {

	private final BillService billService;

	public BillResource(BillService billService) {
		this.billService = billService;
	}

	@GetMapping("All")
	public ResponseEntity<List<Bill>> getBills() {

		List<Bill> bills = billService.findAllBills();
		return new ResponseEntity<>(bills, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable("id") Long id) {

		Bill bill = billService.findBillById(id);
		return new ResponseEntity<>(bill, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Bill> addBill(@RequestBody ObjectNode json) {
		
		Bill newBill = billService.addBillWithDiscunt(json.get("phone").asText(),json.get("amount").asDouble());
		return new ResponseEntity<>(newBill, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) {

		Bill newBill = billService.upDateBill(bill);
		return new ResponseEntity<>(newBill, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Bill> deleteBillById(@PathVariable("id") Long id) {

		billService.deleteBill(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
