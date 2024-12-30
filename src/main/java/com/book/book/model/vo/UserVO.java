package com.book.book.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Integer id; //序号
    private String nickname; //昵称
    private String username; //用户名
    private String birthday; //生日
    private String tel; //电话
    private String email; //邮箱
    private String address; //地址
    private Integer size; //可借数量
    private Integer identity; //身份
    private Integer isAdmin;
    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", birthday='" + birthday + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", size=" + size +
                ", identity=" + identity +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
