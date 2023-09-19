package com.SpringBoot.admindashboard.Controller;

import com.SpringBoot.admindashboard.Entities.ClientEntity;
import com.SpringBoot.admindashboard.Entities.IdAndPassword;
import com.SpringBoot.admindashboard.Entities.ProductEntity;
import com.SpringBoot.admindashboard.Entities.StaffEntity;
import com.SpringBoot.admindashboard.Service.ClientService;
import com.SpringBoot.admindashboard.Service.EmailService;
import com.SpringBoot.admindashboard.Service.ProductService;
import com.SpringBoot.admindashboard.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/login")
    public String renderLoginPage()
    {
        return ("loginPage");
    }
    @GetMapping("/home")
    public String staffHomePage()
    {
        return ("adminHome");
    }
    @GetMapping("/admin")
    public String adminHomePage()
    {
        return ("redirect:/home?admin=true");
    }

    @GetMapping("/products")
    public String allProductsEndpoint()
    {
        List<ProductEntity> products = productService.getAllProducts();

        return ("");
    }
    @PostMapping("product/new")
    public String createNewProduct(@RequestBody ProductEntity product)
    {
        String message = productService.createNewProduct(product);
        if (message.equals("Product successfully saved"))
        {
            return ("");
        }
        return ("");
    }
    @DeleteMapping("product/delete/{id}")
    public String deleteProduct(@RequestAttribute Long id)
    {
        String message = productService.deleteProduct(id);

        return ("");
    }

    /**
     * STAFF RELATED MAPPINGS
     */
    @GetMapping("/register/firstAdmin")
    public String firstAdmin(Model model)
    {
        StaffEntity staff = new StaffEntity();
        model.addAttribute("staff", staff);
        return ("adminReg");
    }
    @PostMapping("/register/firstAdmin")
    public String registerFirstAdmin(@ModelAttribute StaffEntity staff)
    {
        String message = staffService.registerStaff(staff);
        staffService.setPasswordMail(staff);
        return ("loginPage");
    }
    @GetMapping("/setPassword")
    public String staffSetPassword(@RequestParam Long id, Model model)
    {
        IdAndPassword idAndPassword = new IdAndPassword();
        idAndPassword.setId(id);
        model.addAttribute("idAndPassword", idAndPassword);
        return ("setPassword");
    }
    @PostMapping("/setPassword")
    public String saveStaffPassword(@ModelAttribute IdAndPassword idAndPassword)
    {
        System.out.printf("\n\n##########\t%s\t##########\n\n", idAndPassword.getPassword());
        StaffEntity staff = staffService.getStaffById(idAndPassword.getId());
        staff.setPassword(idAndPassword.getPassword());
        //staff.setId(id);
        staffService.saveStaffPassword(staff);

        return ("redirect:/login");

    }
    @PostMapping("/admin/addStaff")
    public String createNewStaff(@RequestBody StaffEntity staff)
    {
        String message = staffService.registerStaff(staff);
        if (message.equals("Staff Created Successfully!")) {
            staffService.setPasswordMail(staff);
            return ("");
        }
        return ("");
    }


    /**
     * CLIENT RELATED MAPPINGS
     */

    @PostMapping("/home/addClient")
    public String createNewClient(@RequestBody ClientEntity client)
    {
        String message = clientService.saveClient(client);
        if (message.equals("Client saved successfully"))
        {
            return ("");
        }
        return ("");
    }
}
