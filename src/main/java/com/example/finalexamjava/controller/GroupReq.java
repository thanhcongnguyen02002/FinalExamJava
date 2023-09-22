package com.example.finalexamjava.controller;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.function.Function;

public record GroupReq(
        @NotBlank
        @Size(min = 3, max = 50, message = "groupname is invalid ")
        String groupName,
        int member,
        @NotBlank
        @Size
        String creator
) {
        public <R> R transform(Function<? super GroupReq, ? extends R> func) {
                return func.apply(this);
        }
}
