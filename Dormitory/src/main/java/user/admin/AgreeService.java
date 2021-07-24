package com.xjtu.dormitory.user.admin;

public interface AgreeService {
    boolean deleteNum(reacordDto dto);

    boolean plusNum(reacordDto dto);

    boolean changeDorm(reacordDto dto);

    boolean changeStatus(reacordDto dto);
}
