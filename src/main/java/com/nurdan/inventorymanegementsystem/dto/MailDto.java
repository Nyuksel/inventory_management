package com.nurdan.inventorymanegementsystem.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MailDto {
    private String send;
    private String to;
    private String subject;
    private String detail;

    public MailDto(){

    }
    public MailDto(MailDto dto) {
        System.out.println("Gönderen = " + dto.getSend());
        System.out.println("Alıcı = " + dto.getTo());
        System.out.println("Konu = " + dto.getSubject());
        System.out.println("Detay = " + dto.getDetail());
    }
}
