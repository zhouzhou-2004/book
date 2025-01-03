package com.book.book.service.impl;

import com.book.book.mapper.ReaderMapper;
import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
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
    public PageResult<UserVO> selectReaderList(QueryRequest queryRequest) {
        // 计算偏移量(起始索引) （查询页码-1）*每页显示记录数。
        int offset = (queryRequest.getPageNum() - 1) * queryRequest.getPageSize();
        // 查询总记录数，传递 classNo 和 name 参数
        Long total = readerMapper.selectTotal(
                queryRequest.getClassNo(),
                queryRequest.getName()
        );
        // 查询分页数据，只传递 offset 和 pageSize 参数
        List<UserVO> users = readerMapper.selectReaderList(
                offset,
                queryRequest.getPageSize(),
                queryRequest.getClassNo(),
                queryRequest.getName()
        );

        return new PageResult<>(users, queryRequest.getPageNum(), queryRequest.getPageSize(), total);

    }

    @Override
    public List<UserVO> selectByLike(String LikeName) {
        try {
            List<UserVO> userVO = readerMapper.selectByLike(LikeName);
            if (userVO != null){
                //查询到数据，返回
                return userVO;
            }else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
