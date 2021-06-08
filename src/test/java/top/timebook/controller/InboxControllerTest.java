package top.timebook.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.timebook.TimebookApplication;
import top.timebook.model.Inbox;
import top.timebook.service.InboxService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = TimebookApplication.class)
@Slf4j
class InboxControllerTest {

    @Resource
    private InboxService inboxService;

    @Test
    void getInboxs() {
        Map paramMap = new HashMap();
        paramMap.put("userId", 1);
        paramMap.put("status", 1);
        inboxService.getInboxs(paramMap);
    }

    @Test
    void addInbox() {
        Inbox inbox = new Inbox();
        inbox.setUserId(1L);
        inbox.setRemark("学习 spring");
        inbox.setDisplay(1);
        inbox.setStatus(1);
        inbox.setCreateTime(new Date());
        inboxService.addInbox(inbox);
    }
}