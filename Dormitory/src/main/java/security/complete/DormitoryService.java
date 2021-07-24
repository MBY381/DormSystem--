package com.xjtu.dormitory.security.complete;

import java.util.Map;

public interface DormitoryService {
    Map<String, Object> getDormitoryList(dormitoryDto dto);
}
