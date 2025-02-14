package com.example.campusbookshare.controller;

import com.example.campusbookshare.model.BorrowRecord;
import com.example.campusbookshare.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordController {
    @Autowired
    private BorrowRecordService borrowRecordService;

    @PostMapping
    public BorrowRecord createBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        return borrowRecordService.createBorrowRecord(borrowRecord);
    }
}