//package zw.co.Afrosoft.sms;
//
//import java.io.Serializable;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import jakarta.xml.bind.annotation.XmlElement;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.NoArgsConstructor;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "user",
//        "password",
//        "message",
//        "mobiles",
//        "senderid",
//        "accountusagetypeid",
//        "unicode",
//        "isallowduplicatemobile"
//})
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Sms implements Serializable {
//
//    private final static long serialVersionUID = 8963940122235722883L;
//    @XmlElement
//    @JsonProperty("user")
//    private String user;
//    @XmlElement
//    @JsonProperty("password")
//    private String password;
//    @XmlElement
//    @JsonProperty("message")
//    private String message;
//    @XmlElement
//    @JsonProperty("mobiles")
//    private String mobiles;
//    @XmlElement
//    @JsonProperty("senderid")
//    private String senderid;
//    @XmlElement
//    @JsonProperty("accountusagetypeid")
//    private String accountusagetypeid;
//    @XmlElement
//    @JsonProperty("unicode")
//    private String unicode;
//    @XmlElement
//    @JsonProperty("isallowduplicatemobile")
//    private String isallowduplicatemobile;
//}
