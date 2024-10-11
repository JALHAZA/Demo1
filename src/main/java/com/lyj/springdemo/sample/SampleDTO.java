package com.lyj.springdemo.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleDTO {
    private String name;
    private int age;
    private String[] hobby;
}
