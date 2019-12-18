package com.hand.hlz25720.mapper;

import com.hand.hlz25720.entity.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmpMapper {
    @Select("SELECT id , name , age , job FROM emp WHERE id = #{id}")
    public Emp findById(Integer id);

    @Select("SELECT * FROM emp")
    public Collection<Emp> findAll();

    @Insert("INSERT INTO emp( id , name ,age , job ) VALUES ( #{id} , #{name} , #{age} , #{job})")
    public void insertToEmp(Emp emp);

    @Update("UPDATE emp SET  name = #{name} ,age = #{age} , job = #{job}  WHERE id = #{id}")
    public void updateToEmp(Emp emp);

    @Delete("DELETE FROM emp WHERE id = #{id} ")
    public void deleteById(Integer id);

}
