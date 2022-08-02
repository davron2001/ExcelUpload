package com.example.excelupload.repository;

import com.example.excelupload.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}