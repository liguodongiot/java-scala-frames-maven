package com.lgd.model.mapper;

import com.lgd.model.pojo.Students;
import com.lgd.model.pojo.StudentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentsMapper {
    int countByExample(StudentsExample example);

    int deleteByExample(StudentsExample example);

    @Delete({
        "delete from students",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into students (id, name, ",
        "salary)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{salary,jdbcType=DOUBLE})"
    })
    int insert(Students record);

    int insertSelective(Students record);

    List<Students> selectByExample(StudentsExample example);

    @Select({
        "select",
        "id, name, salary",
        "from students",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Students selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Students record, @Param("example") StudentsExample example);

    int updateByExample(@Param("record") Students record, @Param("example") StudentsExample example);

    int updateByPrimaryKeySelective(Students record);

    @Update({
        "update students",
        "set name = #{name,jdbcType=VARCHAR},",
          "salary = #{salary,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Students record);
}