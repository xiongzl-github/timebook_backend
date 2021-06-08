package top.timebook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.timebook.model.Icon;
import top.timebook.mapper.IconMapper;
import top.timebook.service.IconService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-07
 */
@Service
public class IconServiceImpl extends ServiceImpl<IconMapper, Icon> implements IconService {

    @Resource
    private IconMapper iconMapper;

    @Override
    public List<Icon> getIcons() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status", 1);
        return iconMapper.selectList(queryWrapper);
    }
}
