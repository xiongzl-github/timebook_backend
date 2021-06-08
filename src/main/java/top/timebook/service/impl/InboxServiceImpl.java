package top.timebook.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.transaction.annotation.Transactional;
import top.timebook.core.constant.BuzConstant;
import top.timebook.model.Inbox;
import top.timebook.mapper.InboxMapper;
import top.timebook.service.InboxService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-18
 */
@Service
public class InboxServiceImpl extends ServiceImpl<InboxMapper, Inbox> implements InboxService {

    @Resource
    private InboxMapper inboxMapper;

    @Override
    public List<Map<String, Object>> getInboxs(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.allEq(params, false);
        List<Map<String, Object>> inboxs = inboxMapper.selectMaps(queryWrapper);
        for (Map<String, Object> inbox : inboxs) {
            if(ObjectUtil.equal(inbox.get("display"), BuzConstant.INBOX_DISPLAY)){
                inbox.put("display", true);
            } else {
                inbox.put("display", false);
            }
        }
        return inboxs;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addInbox(Inbox inbox) {
        inboxMapper.insert(inbox);
        return inbox.getId();
    }

    @Override
    public Inbox getInbox(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", params.get("id"));
        queryWrapper.eq("status", BuzConstant.SQL_STATUS_NORMAL);
        return inboxMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteInbox(Long id) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("updateTime", new Date());
        updateWrapper.set("status", BuzConstant.SQL_STATUS_DELETED);
        updateWrapper.eq("id", id);
        inboxMapper.update(null, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateInbox(Inbox inbox) {
        inboxMapper.updateById(inbox);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void handleInbox(Inbox inbox) {
        inboxMapper.updateById(inbox);
    }
}
