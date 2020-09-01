package com.river.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "阶段")
public class Stage implements Serializable {

    @ApiModelProperty(value = "阶段流水号")
    private String stageSeq;

    @ApiModelProperty(value = "阶段名称")
    private String stageName;

    @ApiModelProperty(value = "事项集合")
    private List<Item> itemList;
}
