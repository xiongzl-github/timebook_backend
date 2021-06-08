package top.timebook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Setting;
import top.timebook.service.SettingService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-05-07
 */
@Slf4j
@RestController
@RequestMapping("/api/settings")
public class SettingController {

    @Resource
    private SettingService settingService;

    /**
     * 根据 id 查询 setting
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<Setting> getSetting(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "SettingController.getSetting", params);
        Setting setting = settingService.getSetting(params);
        log.info("result: {}", setting);
        return OperationResult.makeOKRsp(setting);
    }

    /**
     * 添加setting
     * @param setting
     * @return
     */
    @PostMapping
    public ResponseResult addSetting(@RequestBody Setting setting){
        log.info("methodName: {}, params: {}", "SettingController.addSetting", setting);
        Long id = settingService.addSetting(setting);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 更新setting
     * @param setting
     * @return
     */
    @PutMapping
    public ResponseResult updateSetting(@RequestBody Setting setting){
        log.info("methodName: {}, params: {}", "SettingController.updateSetting", setting);
        settingService.updateSetting(setting);
        return OperationResult.makeOKRsp();
    }




}

