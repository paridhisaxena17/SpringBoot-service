package com.example.springbootxmljsontransform.service;

import com.example.springbootxmljsontransform.entity.Record;
import com.example.springbootxmljsontransform.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    private RecordRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Record handleRequest(Long id) {
        // Check if record exists in DB
        Optional<Record> record = repository.findById(id);

        if (record.isPresent()) {
            return record.get();
        } else {
            // Call third-party service
            String url = "https://thirdparty.com/service?id=" + id;
            Record response = restTemplate.getForObject(url, Record.class);

            // Save the response in the database
            if (response != null) {
                repository.save(response);
            }

            return response;
        }
    }
}
