package com.example.demo.mapper;

import com.example.demo.model.UserProfile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    @Select("SELECT * FROM UserProfile WHERE id=#{id}")
    public UserProfile getUserProfile(@Param("id") String id); //String의 id가 SQL 맵핑문장에 ${id}에 맵핑된다.

    @Select("SELECT * FROM UserProfile")
    public List<UserProfile> getUserProfileList();

    //왜 반환형이 int인지? 보통 반환되는 레코드 개수를 int형으로 반환한다.
    @Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
    public int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    public int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Delete("DELETE FROM UserProfile WHERE id=#{id}")
    public int deleteUserProfile(@Param("id") String id);
}
