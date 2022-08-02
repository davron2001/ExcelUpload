package com.example.excelupload.controller;

import com.example.excelupload.entity.Invoice;
import com.example.excelupload.repository.InvoiceRepository;
import com.example.excelupload.service.IExcelDataService;
import com.example.excelupload.service.IFileUploaderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    IFileUploaderService fileService;
    @Autowired
    IExcelDataService excelservice;
    @Autowired
    InvoiceRepository repo;
    @GetMapping("/get")
    public String index() {
        return "uploadPage";
    }
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message",
                "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/saveData")
    public String saveExcelData(Model model) {

        List<Invoice> excelDataAsList = excelservice.getExcelDataAsList();
        int noOfRecords = excelservice.saveExcelData(excelDataAsList);
        model.addAttribute("noOfRecords",noOfRecords);
        return "success";
    }

}
