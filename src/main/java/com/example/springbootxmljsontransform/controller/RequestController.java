package com.example.springbootxmljsontransform.controller;

import com.example.springbootxmljsontransform.entity.Record;
import com.example.springbootxmljsontransform.service.RequestService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private RequestService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/process", consumes = "application/xml", produces = "application/json")
    public ResponseEntity<Record> processRequest(@RequestBody String xmlInput) {
        try {
            // Parse XML and extract ID
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringReader reader = new StringReader(xmlInput);
            var document = builder.parse(new org.xml.sax.InputSource(reader));
            String id = document.getElementsByTagName("ID").item(0).getTextContent();

            // Process the request
            Record record = service.handleRequest(Long.parseLong(id));
            return ResponseEntity.ok(record);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
