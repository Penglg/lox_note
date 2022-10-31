package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Approval;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 免表approval表的数据访问层
 */
public interface ApprovalDao {
    @Insert("insert into approval values(null, #{noteID}, #{userId}, #{content}, #{result})")
    int insert(Approval approval);

    // 对结果result进行更新
    @Update("update approval set result=#{result} where id=#{id}")
    int update(Approval approval);

    @Delete("delete from approval where id=#{id}")
    int delete(Integer id);

    @Select("select * from approval where id=#{id}")
    Approval findById(Integer id);

    @Select("select * from approval")
    List<Approval> findAll();

    // 根据user的主键id调出其所有申请
    @Select("select * from approval where user_id=#{userId}")
    List<Approval> findByUserId(Integer userId);

    // 管理员获取所有未处理的笔记审批申请
    @Select("select * from approval where result=-1")
    List<Approval> findUnprocessed();
}
