package com.vn.devmaster.services.dto;

import com.vn.devmaster.services.entites.Clazz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private ClazzDTO clazz;
}
