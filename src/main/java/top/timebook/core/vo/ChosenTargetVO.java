package top.timebook.core.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author xiongzl
 * @version 1.0
 * @date 2021/4/27 14:39
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ChosenTargetVO {

    private String targetId;

    private Integer targetTime;

}
