package com.ecommerce.ecommerce.email;

import lombok.NoArgsConstructor;

public interface EmailService {
    void sendSimpleEmail(String to);
    void sendMimeMessageWithAttachments(String name, String to, String token);

    void sendHtmlEmail(int otpCode, String to, String emailTemplate);

}
