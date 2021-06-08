package top.timebook.service;

import top.timebook.model.Icon;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-07
 */
public interface IconService extends IService<Icon> {

    List<Icon> getIcons();
}
