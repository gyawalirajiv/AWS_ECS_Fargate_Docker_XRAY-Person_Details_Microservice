package com.gyawalirajiv.personservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetails {

    private Long id;

    private Integer phoneNumber;
    private String address;
    private Long personId;
}
