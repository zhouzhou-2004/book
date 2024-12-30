package com.book.book.service.impl;

import com.book.book.mapper.LibraryInfoMapper;
import com.book.book.model.pojo.LibraryInfo;
import com.book.book.service.LibraryInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class LibraryInfoImpl implements LibraryInfoService {
    @Autowired
    private LibraryInfoMapper libraryInfoMapper;

    //    获取图书馆信息
    @Override
    public List<LibraryInfo> getLibraryInfo() {
        List<LibraryInfo> libraryById = libraryInfoMapper.getLibraryById();
        if (libraryById != null){
            return libraryById;
        }else {
            return null;
        }
    }

    //保存更新的图书馆信息
    @Override
    public int update(LibraryInfo libraryInfo) {
        int updateM = libraryInfoMapper.update(libraryInfo);
        if (updateM > 0){
            return updateM;
        }else {
            return 0;
        }
    }







}
