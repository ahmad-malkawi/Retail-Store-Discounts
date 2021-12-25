package com.Store.Discounts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Store.Discounts.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

}
