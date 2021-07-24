package com.xjtu.dormitory.user.sys_admin;

import java.util.Map;

public interface GetWorkerListService {
    Map<String, Object> getWorkerListInfo(WorkerDto dto);
}
