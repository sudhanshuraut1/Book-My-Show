package com.example.book_My_Show.Services;

import com.example.book_My_Show.Converters.UserCoverter;
import com.example.book_My_Show.Entities.UserEntity;
import com.example.book_My_Show.EntryDtos.UserEntryDto;
import com.example.book_My_Show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String  addUser(UserEntryDto userEntryDto) throws Exception{
        UserEntity userEntity = UserCoverter.convertDtoToEntity(userEntryDto);

        userRepository.save(userEntity);

        return "User added successfully";
    }


}
