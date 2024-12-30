package com.book.book.controller;

import com.book.book.model.pojo.LibraryInfo;
import com.book.book.service.LibraryInfoService;
import com.book.book.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lib")
public class LibraryInfoController {
    @Autowired
    private LibraryInfoService libraryInfoService;

    //获取图书馆信息
    @RequestMapping("/libM")
    public ResponseUtils getLibraryInfo(){
        try {
            List<LibraryInfo> libraryInfo = libraryInfoService.getLibraryInfo();
            System.out.println(libraryInfo);
            if(libraryInfo != null){
                return new ResponseUtils(200,"获取成功",libraryInfo);
            }else {
                return new ResponseUtils(400,"获取失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //编辑图书馆信息功能
    @RequestMapping("/update")
    public ResponseUtils update(@RequestBody LibraryInfo libraryInfo){
        try {
            int updateM = libraryInfoService.update(libraryInfo);
            System.out.println(libraryInfo);
            if(updateM > 0){
                return new ResponseUtils(200,"修改成功",libraryInfo);
            }else {
                return new ResponseUtils(400,"修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
