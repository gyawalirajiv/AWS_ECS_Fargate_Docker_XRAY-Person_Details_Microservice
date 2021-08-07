package com.gyawalirajiv.personservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetailsDTO {
    private Long id;
    private Integer phoneNumber;
    private String address;
}
