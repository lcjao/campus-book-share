package com.example.campusbookshare.service;

import com.example.campusbookshare.model.BorrowRecord;
import com.example.campusbookshare.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BorrowRecordService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public BorrowRecord createBorrowRecord(BorrowRecord borrowRecord) {
        borrowRecord.setCreated_at(new Date());
        return borrowRecordRepository.save(borrowRecord);
    }
}