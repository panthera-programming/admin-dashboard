package com.SpringBoot.admindashboard.Controller;

import com.SpringBoot.admindashboard.Entities.ClientEntity;
import com.SpringBoot.admindashboard.Entities.HttpResponse;
import com.SpringBoot.admindashboard.Entities.ProductEntity;
import com.SpringBoot.admindashboard.Entities.StaffEntity;
import com.SpringBoot.admindashboard.Service.ClientService;
import com.SpringBoot.admindashboard.Service.EmailService;
import com.SpringBoot.admindashboard.Service.ProductService;
import com.SpringBoot.admindashboard.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class restController {
    @Autowired
    private ProductService productService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ClientService clientService;
    @GetMapping("/products")
    public ResponseEntity<HttpResponse> allProductsEndpoint()
    {
        List<ProductEntity> products = productService.getAllProducts();

        return (
                ResponseEntity.ok().body(
                        HttpResponse.builder()
                                .data(Map.of("products", products))
                                .message("All products returned")
                                .requestMethod("GET")
                                .status(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .build()
                )
        );
    }
    @PostMapping("product/new")
    public ResponseEntity<HttpResponse> createNewProduct(@RequestBody ProductEntity product)
    {
        String message = productService.createNewProduct(product);
        if (message.equals("Product successfully saved"))
        {
            return (
                    ResponseEntity.created(URI.create("")).body(
                            HttpResponse.builder()
                                    .data(Map.of("msg", message))
                                    .message("Success")
                                    .requestMethod("POST")
                                    .status(HttpStatus.CREATED)
                                    .statusCode(HttpStatus.CREATED.value())
                                    .build()
                    )
            );
        }
        return (
                ResponseEntity.created(URI.create("")).body(
                        HttpResponse.builder()
                                .data(Map.of("msg", "ERROR CREATING NEW PRODUCT"))
                                .message("Product creation UNSuccessful")
                                .requestMethod("POST")
                                .status(HttpStatus.BAD_REQUEST)
                                .statusCode(HttpStatus.BAD_REQUEST.value())
                                .build()
                )
        );
    }
    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<HttpResponse> deleteProduct(@RequestAttribute Long id)
    {
        String message = productService.deleteProduct(id);

        return (
                ResponseEntity.ok().body(
                        HttpResponse.builder()
                                .data(Map.of("msg", message))
                                .message("Product Successfully deleted!")
                                .requestMethod("DELETE")
                                .status(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .build()
                )
        );
    }

    /**
     * STAFF RELATED MAPPINGS
     */
    @PostMapping("/admin/addStaff")
    public ResponseEntity<HttpResponse> createNewStaff(@RequestBody StaffEntity staff)
    {
        String message = staffService.registerStaff(staff);
        if (message.equals("Staff Created Successfully!")) {
            staffService.setPasswordMail(staff);
            return (
                    ResponseEntity.created(URI.create("")).body(
                            HttpResponse.builder()
                                    .data(Map.of("msg", message))
                                    .message("Staff creation Successful")
                                    .requestMethod("POST")
                                    .status(HttpStatus.CREATED)
                                    .statusCode(HttpStatus.CREATED.value())
                                    .build()
                    )
            );
        }
        return (
                ResponseEntity.created(URI.create("")).body(
                        HttpResponse.builder()
                                .data(Map.of("msg", "ERROR ADDING STAFF"))
                                .message("Staff creation UNSuccessful")
                                .requestMethod("POST")
                                .status(HttpStatus.BAD_REQUEST)
                                .statusCode(HttpStatus.BAD_REQUEST.value())
                                .build()
                )
        );
    }
    @PostMapping("/setPassword/{id}")
    public ResponseEntity<HttpResponse> saveStaffPassword(@RequestAttribute Long id, @RequestBody String password)
    {
        StaffEntity staff = staffService.getStaffById(id);
        staff.setPassword(password);
        staff.setId(id);
        staffService.saveStaffPassword(staff);

        return (
                ResponseEntity.ok().body(
                        HttpResponse.builder()
                                .data(Map.of("msg", "Password Successfully set"))
                                .message("Password setting successful")
                                .requestMethod("POST")
                                .status(HttpStatus.CREATED)
                                .statusCode(HttpStatus.CREATED.value())
                                .build()
                )
        );

    }


    /**
     * CLIENT RELATED MAPPINGS
     */

    @PostMapping("/home/addClient")
    public ResponseEntity<HttpResponse> createNewClient(@RequestBody ClientEntity client)
    {
        String message = clientService.saveClient(client);
        if (message.equals("Client saved successfully"))
        {
            return (
                    ResponseEntity.created(URI.create("")).body(
                            HttpResponse.builder()
                                    .data(Map.of("data", "Client creation successful"))
                                    .message(message)
                                    .requestMethod("POST")
                                    .status(HttpStatus.CREATED)
                                    .statusCode(HttpStatus.CREATED.value())
                                    .build()
                    )
            );
        }
        return (
                ResponseEntity.created(URI.create("")).body(
                        HttpResponse.builder()
                                .data(Map.of("data", "ERROR CREATING NEW CLIENT"))
                                .message("Client creation UNSuccessful")
                                .requestMethod("POST")
                                .status(HttpStatus.BAD_REQUEST)
                                .statusCode(HttpStatus.BAD_REQUEST.value())
                                .build()
                )
        );
    }
}
