package com.eat.go;

import com.eat.go.owner.OwnerDto;
import io.swagger.annotations.ApiModel;


/**
 * @author Nik Smirnov
 */
@ApiModel("Owner")
public class OwnerResponse extends JSONResponse<OwnerDto> {

    public OwnerResponse(OwnerDto dto) {
        super(dto, Status.SUCCESS);
    }
}
