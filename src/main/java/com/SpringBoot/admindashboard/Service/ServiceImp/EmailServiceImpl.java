package com.SpringBoot.admindashboard.Service.ServiceImp;

import com.SpringBoot.admindashboard.Entities.ClientEntity;
import com.SpringBoot.admindashboard.Entities.ProductEntity;
import com.SpringBoot.admindashboard.Repository.ClientRepository;
import com.SpringBoot.admindashboard.Service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private ClientRepository clientRepository;
    @Value("spring.mail.username")
    private String from;
    @Override
    public void sendClientMail(String subject, String message, ClientEntity client) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setPriority(1);
            helper.setTo(client.getEmail());
            helper.setFrom(from);
            helper.setSubject(subject);

            Context ctx = new Context();
            String mailText = templateEngine.process("clientMailTemplate.html", ctx);
            ctx.setVariables(Map.of("clientname", client.getName(), "message", message));

            helper.setText(mailText, true);
            mailSender.send(mimeMessage);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendBulkClientMail(String subject, Long product_id, ProductEntity product) {
        List<ClientEntity> clients = clientRepository.findByProduct(product);
    }
}
