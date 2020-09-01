package com.river.dao;

import com.river.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDao {

    @Autowired
    private MongoOperations mongoTemplate;

    public void saveProject(Project project){
        mongoTemplate.save(project);
    }

    public void deleteProject(Project  project){
        mongoTemplate.remove(project);
    }


    public List<Project> getProjects(Project project){
        Query query = new Query();
        //模糊查询
        if(!StringUtils.isEmpty(project.getProjectName())){
            query.addCriteria(Criteria.where("projectName").regex(".*?\\"+project.getProjectName()+".*"));
        }
        query.with(new Sort(Sort.Direction.DESC , "createDate"));

        List<Project> allProject = mongoTemplate.find(query , Project.class);
        return allProject;
    }

    public Project getProjectById(String projectId){
        Query query = new Query(Criteria.where("projectId").is(projectId));
        Project project = mongoTemplate.findOne(query , Project.class);
        return project;
    }



}
