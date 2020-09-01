package com.river.controller;

import com.river.dao.ProjectDao;
import com.river.model.Project;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "projectController" , description = "项目相关Controller")
@Controller
@RestController
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @RequestMapping(value = "getProject" , method = RequestMethod.GET)
    @ApiOperation(value = "获取项目列表")
    public List<Project> getProject(@ApiParam(value = "项目名称")
                                    @RequestParam(value = "projectName", required = false) String projectName){
        Project project = new Project();
        project.setProjectName(projectName);
        return projectDao.getProjects(project);
    }

    @ApiOperation(value = "保存项目信息")
    @RequestMapping(value = "saveProject" , method = RequestMethod.POST)
    public String saveProject(Project project){
        projectDao.saveProject(project);
        return "保存成功";
    }

    @ApiModelProperty(value = "删除项目")
    @RequestMapping(value = "deleteProject" , method = RequestMethod.POST)
    public String deleteProject(@RequestParam(value = "recordId", required = true)
                                    @ApiParam(value = "数据主键") String recordId){
        Project project = new Project();
        project.setId(recordId);
        projectDao.deleteProject(project);
        return "删除成功";
    }


}
