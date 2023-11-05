package com.cloudserv.claims.controllers;

import com.cloudserv.claims.DBService.CollectionHandler;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case")
public class CaseRestService {
    @Autowired
    CollectionHandler collectionHandler;

    @RequestMapping(value = "/gt/{case_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getCase(@PathVariable String case_id) {
       return collectionHandler.findOne("mc_case",null);
   }

}
