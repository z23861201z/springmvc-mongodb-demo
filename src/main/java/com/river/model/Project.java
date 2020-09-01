package com.river.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class Project implements Serializable {

    @Id
    @ApiModelProperty(value = "主键" , hidden = true)
    private String id;

    @ApiModelProperty(value = "项目编号" ,required = true)
    private String projectId;

    @ApiModelProperty(value = "项目名称" ,required = true)
    private String projectName;

    @ApiModelProperty(value = "阶段集合" ,required = true)
    private List<Stage> stageList;

    @ApiModelProperty(value = "项目进度",required = true)
    private Long progress;

    @ApiModelProperty(value = "时间进度",required = true)
    private Long timeProgress;

    @ApiModelProperty(value = "创建时间",required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
