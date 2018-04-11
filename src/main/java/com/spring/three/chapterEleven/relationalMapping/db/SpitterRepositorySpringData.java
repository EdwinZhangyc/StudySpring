package com.spring.three.chapterEleven.relationalMapping.db;

import com.spring.three.chapterEleven.relationalMapping.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 程序清单11.4 借助Spring Data，以接口定义的方式创建Repository
 */
public interface SpitterRepositorySpringData extends JpaRepository<Spitter, Long>, SpitterSweeper {

    /**
     * 11.3.1 定义查询方法
     * @param username
     * @return
     */
    Spitter findByUsername(String username);

    List<Spitter> readByFirstnameOrLastname(String first, String last);
    //忽略大小写IgnoringCase与IgnoresCase是同义的
    List<Spitter> readByFirstnameIgnoringCaseOrLastnameIgnoresCase(String first, String last);
    //可以进行排序，按照lastname升序firstname降序
    List<Spitter> readByFirstnameIgnoringCaseOrLastnameIgnoresCaseOrderByLastnameAscFirstnameDesc(String first, String last);

    /**
     * 11.3.2 声明自定义查询
     * 如果所需的数据无法通过方法名称进行定义，那么我们可以使用@Query注解尝试
     */
    @Query("select s from Spitter s where s.email like '%gmail.com'")
    List<Spitter> findAllGmailSpitters();

    /**
     * 11.3.3 混合定义的功能
     */
}