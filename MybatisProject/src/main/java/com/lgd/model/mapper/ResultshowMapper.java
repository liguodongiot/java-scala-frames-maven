package com.lgd.model.mapper;

import com.lgd.model.pojo.Resultshow;
import com.lgd.model.pojo.ResultshowExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ResultshowMapper {
    int countByExample(ResultshowExample example);

    int deleteByExample(ResultshowExample example);

    @Delete({
        "delete from resultshow",
        "where time = #{time,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String time);

    @Insert({
        "insert into resultshow (time, roadgateNode, ",
        "monitorNode, alarmNode)",
        "values (#{time,jdbcType=VARCHAR}, #{roadgatenode,jdbcType=INTEGER}, ",
        "#{monitornode,jdbcType=INTEGER}, #{alarmnode,jdbcType=INTEGER})"
    })
    int insert(Resultshow record);

    int insertSelective(Resultshow record);

    List<Resultshow> selectByExample(ResultshowExample example);

    @Select({
        "select",
        "time, roadgateNode, monitorNode, alarmNode",
        "from resultshow",
        "where time = #{time,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Resultshow selectByPrimaryKey(String time);

    int updateByExampleSelective(@Param("record") Resultshow record, @Param("example") ResultshowExample example);

    int updateByExample(@Param("record") Resultshow record, @Param("example") ResultshowExample example);

    int updateByPrimaryKeySelective(Resultshow record);

    @Update({
        "update resultshow",
        "set roadgateNode = #{roadgatenode,jdbcType=INTEGER},",
          "monitorNode = #{monitornode,jdbcType=INTEGER},",
          "alarmNode = #{alarmnode,jdbcType=INTEGER}",
        "where time = #{time,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Resultshow record);
}