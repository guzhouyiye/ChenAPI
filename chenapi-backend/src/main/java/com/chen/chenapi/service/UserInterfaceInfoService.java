package com.chen.chenapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.chenapi.model.entity.InterfaceInfo;
import com.chen.chenapi.model.entity.UserInterfaceInfo;

/**
* @author chen
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-11-05 16:43:19
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
