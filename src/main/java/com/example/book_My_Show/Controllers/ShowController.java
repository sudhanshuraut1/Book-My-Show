package com.example.book_My_Show.Controllers;

import com.example.book_My_Show.EntryDtos.ShowEntryDto;
import com.example.book_My_Show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowService showService;

       @PostMapping("add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){

           return new ResponseEntity<>();

       }

}
