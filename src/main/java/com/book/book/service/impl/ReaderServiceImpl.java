package com.book.book.service.impl;

import com.book.book.mapper.ReaderMapper;
import com.book.book.model.dto.queryRequest.QueryRequest;
import com.book.book.model.pojo.Users;
import com.book.book.service.ReaderService;
import com.book.book.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public PageResult<Users> selectReaderList(QueryRequest queryRequest) {
        // 计算偏移量(起始索引) （查询页码-1）*每页显示记录数。
        int offset = (queryRequest.getPageNum() - 1) * queryRequest.getPageSize();
        //查询总记录数
        Long total = readerMapper.selectTotal(queryRequest.getClassNo(), queryRequest.getName());

        List<Users> users = readerMapper.selectReaderList(offset, queryRequest.getPageSize());

        return new PageResult<>(users, queryRequest.getPageNum(), queryRequest.getPageSize(), total);

    }



//    @Override
//    public List<Users> selectByLike(String likeName) {
//        try {
//            List<Users> tAdmins = readerMapper.selectByLike(likeName);
//            if (tAdmins != null){
//                //查询到数据，返回
//                return tAdmins;
//            }else {
//                return null;
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
