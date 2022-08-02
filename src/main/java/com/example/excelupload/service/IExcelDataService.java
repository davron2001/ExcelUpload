package com.example.excelupload.service;

import com.example.excelupload.entity.Invoice;

import java.util.List;


public interface IExcelDataService {

    List<Invoice> getExcelDataAsList();
    int saveExcelData(List<Invoice> invoices);

}
