package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Inbox;
import top.timebook.service.InboxService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * inbox controller
 * @author xiongzl
 * @since 2021-03-18
 */
@Slf4j
@RestController
@RequestMapping("/api/inboxs")
public class InboxController {

    @Resource
    private InboxService inboxService;

    /**
     * 根据用户 id 获取收集箱中所有的事项
     * @param params
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<Map<String, Object>>> getInboxs(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "InboxController.getInboxs", params);
        List<Map<String, Object>> inboxs = inboxService.getInboxs(params);
        log.info("result: {}", inboxs);
        return OperationResult.makeOKRsp(inboxs);
    }

    /**
     * 根据 id 查询收集箱事项
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<Inbox> getInbox(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "InboxController.getInbox", params);
        Inbox inbox = inboxService.getInbox(params);
        log.info("result: {}", inbox);
        return OperationResult.makeOKRsp(inbox);
    }

    /**
     * 添加收集箱事项
     * @param inbox
     * @return
     */
    @PostMapping
    public ResponseResult addInbox(@RequestBody Inbox inbox){
        log.info("methodName: {}, params: {}", "InboxController.addInbox", inbox);
        Long id = inboxService.addInbox(inbox);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除收集箱事项
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteInbox(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "InboxController.deleteInbox", id);
        inboxService.deleteInbox(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新收集箱事项
     * @param inbox
     * @return
     */
    @PutMapping
    public ResponseResult updateInbox(@RequestBody Inbox inbox){
        log.info("methodName: {}, params: {}", "InboxController.updateInbox", inbox);
        inboxService.updateInbox(inbox);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新收集箱事项
     * @param inbox
     * @return
     */
    @PutMapping("/handle")
    public ResponseResult handleInbox(@RequestBody Inbox inbox){
        log.info("methedName: {}, params: {}", "InboxController.handleInbox", inbox);
        inboxService.handleInbox(inbox);
        return OperationResult.makeOKRsp();
    }









}

