package com.scaler.bmsseptevening2026.Controllers;

import com.scaler.bmsseptevening2026.DTO.ResponseStatus;
import com.scaler.bmsseptevening2026.DTO.UserSignUpRequestDTO;
import com.scaler.bmsseptevening2026.DTO.UserSignUpResponseDTO;
import com.scaler.bmsseptevening2026.Models.User;
import com.scaler.bmsseptevening2026.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    UserSignUpResponseDTO signup(UserSignUpRequestDTO requestDTO){
        UserSignUpResponseDTO responseDTO = new UserSignUpResponseDTO();
        try{
            User user = userService.signup(requestDTO.getName(),
                    requestDTO.getEmail(),
                    requestDTO.getPassword());
            responseDTO.setUserId(user.getId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("User signed up successfully");
        }catch (Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User signed up failed due to : "+ e.getMessage());
        }
        return responseDTO;
    }
}
