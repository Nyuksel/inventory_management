package com.nurdan.inventorymanegementsystem.service.imp;

import com.nurdan.inventorymanegementsystem.dto.MailDto;
import com.nurdan.inventorymanegementsystem.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailServiceImp implements MailService {

    @Override
    public void sendMail(MailDto dto){
        log.info("Mail gönderiliyor");
        log.info("Mail Gönderildi",dto);
    }
}
