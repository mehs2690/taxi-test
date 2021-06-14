package com.mehs.dev.taxitest.data.repositories;

import com.mehs.dev.taxitest.data.schemas.MongoInvoice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<MongoInvoice, String> {

}
