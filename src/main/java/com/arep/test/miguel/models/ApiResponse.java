package com.arep.test.miguel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
    private String operation;
    private int input;
    private List<Integer> output;
}
