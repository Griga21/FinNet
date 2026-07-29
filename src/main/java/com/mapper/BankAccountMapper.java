package com.mapper;

import com.dto.BankAccountResponse;
import com.dto.CreateBankAccountRequest;
import com.entity.BankAccount;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccount toEntity(CreateBankAccountRequest request);
    BankAccountResponse toResponse(BankAccount entity);
    List<BankAccountResponse> toResponseList(List<BankAccount> entities);
}