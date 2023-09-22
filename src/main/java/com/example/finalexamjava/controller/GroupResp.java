package com.example.finalexamjava.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;
import java.util.function.Function;

public record GroupResp(
        Long id,
        String groupName,
        int member,
        String creator,
        @JsonFormat(pattern = "yyyy-MM-dd")
        OffsetDateTime updated


) {

}
