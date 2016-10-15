package com.eat.go;

import com.eat.go.user.UserDto;
import io.swagger.annotations.ApiModel;


/**
 * @author Nik Smirnov
 */
@ApiModel("User")
public class UserResponse extends JSONResponse<UserDto> {

    public UserResponse(UserDto dto) {
        super(dto, Status.SUCCESS);
    }
}
