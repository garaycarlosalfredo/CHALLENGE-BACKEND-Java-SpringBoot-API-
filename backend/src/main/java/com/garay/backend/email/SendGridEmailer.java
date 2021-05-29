package com.garay.backend.email;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;

import java.io.IOException;

public class SendGridEmailer {

   public static void mail(String email) throws IOException {

       Email from = new Email(email);
       Email to = new Email(email); // use your own email address here

       String subject = "Sending with Twilio SendGrid is Fun";
       Content content = new Content("text/html", "and <em>easy</em> to do anywhere with <strong>Java</strong>");

       Mail mail = new Mail(from, subject, to, content);

       SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
       Request request = new Request();

       request.setMethod(Method.POST);
       request.setEndpoint("mail/send");
       request.setBody(mail.build());

       Response response = sg.api(request);

       System.out.println(response.getStatusCode());
       System.out.println(response.getHeaders());
       System.out.println(response.getBody());
   }
}