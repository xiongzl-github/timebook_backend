package top.timebook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.timebook.core.result.OperationResult;
import top.timebook.core.result.ResponseResult;
import top.timebook.model.Motto;
import top.timebook.service.MottoService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-19
 */
@Slf4j
@RestController
@RequestMapping("/api/mottos")
public class MottoController {

    @Resource
    private MottoService mottoService;

    /**
     * 根据用户 id 获取所有的座右铭
     * @param params
     * @return
     */
    @GetMapping("/userId")
    public ResponseResult<List<Motto>> getMottos(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "MottoController.getMottos", params);
        List<Motto> mottos = mottoService.getMottos(params);
        log.info("result: {}", mottos);
        return OperationResult.makeOKRsp(mottos);
    }

    /**
     * 根据 id 查询座右铭
     * @param params
     * @return
     */
    @GetMapping
    public ResponseResult<Motto> getMotto(@RequestParam Map<String, Object> params){
        log.info("methodName: {}, params: {}", "MottoController.getMotto", params);
        Motto motto = mottoService.getMotto(params);
        log.info("result: {}", motto);
        return OperationResult.makeOKRsp(motto);
    }

    /**
     * 添加座右铭
     * @param motto
     * @return
     */
    @PostMapping
    public ResponseResult addMotto(@RequestBody Motto motto){
        log.info("methodName: {}, params: {}", "MottoController.addMotto", motto);
        Long id = mottoService.addMotto(motto);
        log.info("result: {}", id);
        return OperationResult.makeOKRsp(id);
    }

    /**
     * 根据 id 删除座右铭
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseResult deleteMotto(@RequestParam Long id){
        log.info("methodName: {}, params: {}", "MottoController.deleteMotto", id);
        mottoService.deleteMotto(id);
        return OperationResult.makeOKRsp();
    }

    /**
     * 更新座右铭
     * @param motto
     * @return
     */
    @PutMapping
    public ResponseResult updateMotto(@RequestBody Motto motto){
        log.info("methodName: {}, params: {}", "MottoController.updateMotto", motto);
        mottoService.updateMotto(motto);
        return OperationResult.makeOKRsp();
    }

}

