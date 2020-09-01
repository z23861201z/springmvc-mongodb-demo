package com.river.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "事项")
public class Item implements Serializable {

    @ApiModelProperty(value = "事项编号")
    private String itemId;

    @ApiModelProperty(value = "事项名称")
    private String itemName;
}
