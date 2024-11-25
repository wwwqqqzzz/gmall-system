package com.gmall.backend.service;

import com.gmall.backend.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GJY
 * @since 2022-09-06
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> findMenus(String name);
}
