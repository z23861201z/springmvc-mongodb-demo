//package com.river.dao;
//
//import com.river.model.Project;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import java.util.List;
//
//public interface Project2Dao extends MongoRepository<Project , String> {
//
//    List<Project> findByProjectNameLike(String projectName);
//
//    List<Project> findProjectsByProjectNameOrderByCreateDate(String projectName);
//}
