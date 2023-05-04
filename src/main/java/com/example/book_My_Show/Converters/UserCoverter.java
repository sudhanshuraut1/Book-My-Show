package com.example.book_My_Show.Converters;

import com.example.book_My_Show.Entities.UserEntity;
import com.example.book_My_Show.EntryDtos.UserEntryDto;

public class UserCoverter {

    // Static methods to avoid function calling via objects
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        UserEntity userEntity = UserEntity.builder().age(userEntryDto.getAge()).address(userEntryDto.getAddress()).email(userEntryDto.getEmail()).name(userEntryDto.getName()).mobNo(userEntryDto.getMobNo()).build();

        return userEntity;
    }
}
