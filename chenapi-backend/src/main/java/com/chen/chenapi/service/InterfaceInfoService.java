package com.chen.chenapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.chenapi.model.entity.InterfaceInfo;
import com.chen.chenapi.model.entity.Post;

/**
* @author chen
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-11-02 09:37:21
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
