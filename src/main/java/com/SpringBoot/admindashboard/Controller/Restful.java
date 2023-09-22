package com.SpringBoot.admindashboard.Controller;

import com.SpringBoot.admindashboard.Entities.ClientEntity;
import com.SpringBoot.admindashboard.Entities.HttpResponse;
import com.SpringBoot.admindashboard.Entities.ProductEntity;
import com.SpringBoot.admindashboard.Entities.StaffEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
public class Restful {

    @PostMapping("/api/client/new")
    public ResponseEntity<HttpResponse> registerClient(@RequestBody ClientEntity client)
    {
        String msg;
        System.out.println("\n\n*****\t"+client+"\t*****\n\n");
        if (client != null)
        {
            msg = "Client registration SUCCESSFUL";
        }
        else
            msg = "Client registration UNSUCCESSFUL";

        return (ResponseEntity.created(URI.create("")).body(HttpResponse.builder()
                .data(Map.of("Client", client))
                .message(msg)
                .requestMethod("POST")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build())
        );
    }

    @PostMapping("/api/product/new")
    public ResponseEntity<HttpResponse> addNewProduct(@RequestBody ProductEntity product)
    {
        String msg;
        System.out.println("\n\n*****\t"+product+"\t*****\n\n");
        if (product != null)
        {
            msg = "Product creation SUCCESSFUL";
        }
        else
            msg = "Product creation UNSUCCESSFUL";

        return (ResponseEntity.created(URI.create("")).body(HttpResponse.builder()
                .data(Map.of("product", product))
                .message(msg)
                .requestMethod("POST")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build())
        );
    }
    @PostMapping("/api/staff/new")
    public ResponseEntity<HttpResponse> registerStaff(@RequestBody StaffEntity staff)
    {
        String msg;
        System.out.println("\n\n*****\t"+staff+"\t*****\n\n");
        if (staff != null)
        {
            msg = "Staff registration SUCCESSFUL";
        }
        else
            msg = "Staff registration UNSUCCESSFUL";

        return (ResponseEntity.created(URI.create("")).body(HttpResponse.builder()
                .data(Map.of("staff", staff))
                .message(msg)
                .requestMethod("POST")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build())
        );
    }
}
