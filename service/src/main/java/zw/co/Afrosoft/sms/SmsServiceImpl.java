//package zw.co.Afrosoft.sms;
//import jakarta.xml.bind.JAXBContext;
//import jakarta.xml.bind.JAXBException;
//import jakarta.xml.bind.Marshaller;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestTemplate;
//import zw.co.Afrosoft.NotificationRequest;
//
//import java.io.StringWriter;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.Objects;
//
//@Slf4j
//@Service
//public class SmsServiceImpl implements SmsService{
//
//    @Value("${sms.username}")
//    private String username;
//    @Value("${sms.password}")
//    private String password;
//    @Value("${gateway.url}")
//    private String url;
//    @Value("${sms.senderId}")
//    private String senderId;
//    @Value("${sms.accountusagetypeid}")
//    private String clientId;
//    @Override
//    public void sendSMS( NotificationRequest request) {
//        var sms = Sms.builder()
//                .message(request.getContent())
//                .password(password)
//                .user(username)
//                .senderid(senderId)
//                .accountusagetypeid(clientId)
//                .mobiles(request.getRecipient().getPhoneNumber())
//                .build();
//        helper(sms);
//
//    }
//    private void helper(Sms sms){
//        SmsRequest smsRequest = SmsRequest.builder()
//                .sms(sms)
//                .build();
//
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(SmsRequest.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            StringWriter sw = new StringWriter();
//            jaxbMarshaller.marshal(smsRequest, sw);
//            String xmlString = sw.toString();
//
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.setContentType(MediaType.APPLICATION_XML);
//            HttpEntity<String> request = new HttpEntity<>(xmlString, httpHeaders);
//            RestTemplate restTemplate = new RestTemplate();
//
//            log.info("Sending sms request {}", request.getBody());
//            String response = restTemplate.postForObject(new URI(url), request, String.class);
//
//            if (Objects.nonNull(response) && response.contains("messageid"))
//                log.info("Message sent  >>> {}", smsRequest);
//            else{
//                log.info("response: {}", response);
//
//
//            }
//
//        } catch (JAXBException | ResourceAccessException | URISyntaxException e) {
//            log.error("Failed to send message  with error >>> {}", e.getMessage());
//        }
//    }
//}
