package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record RoleDto(Long id ,@NotBlank String role) {

}
