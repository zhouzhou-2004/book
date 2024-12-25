package com.book.book.mapper;


import com.book.book.model.pojo.LibraryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface LibraryInfoMapper {

    // 查询图书馆信息
    List<LibraryInfo> getLibraryById();

    // 更新图书馆信息的SQL语句，根据传入的Library对象更新对应记录
    int update(LibraryInfo libraryInfo);

}