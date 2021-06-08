package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Icon;
import top.timebook.model.Inbox;
import top.timebook.service.IconService;
import top.timebook.service.InboxService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-07
 */
@Slf4j
@RestController
@RequestMapping("/api/icons")
public class IconController {

    @Resource
    private IconService iconService;

    /**
     * 查询所有的图标
     * @return
     */
    @GetMapping
    public ResponseResult<List<Icon>> getIcons(){
        log.info("methodName: {}", "IconController.getIcons");
        List<Icon> icons = iconService.getIcons();
        log.info("result: {}", icons);
        return OperationResult.makeOKRsp(icons);
    }


}

