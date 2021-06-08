package top.timebook.service;

import top.timebook.model.Inbox;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-18
 */
public interface InboxService extends IService<Inbox> {

    List<Map<String, Object>> getInboxs(Map<String, Object> params);

    Long addInbox(Inbox inbox);

    Inbox getInbox(Map<String, Object> params);

    void deleteInbox(Long id);

    void updateInbox(Inbox inbox);

    void handleInbox(Inbox inbox);
}
