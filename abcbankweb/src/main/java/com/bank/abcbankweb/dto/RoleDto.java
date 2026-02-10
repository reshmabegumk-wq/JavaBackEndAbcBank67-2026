package com.bank.abcbankweb.dto;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class RoleDto {

    private Integer roleId;

    @NotBlank
    @Size(max = 50)
    private String roleName;
}
