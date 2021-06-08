package top.timebook.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-16
 */
@Data
@TableName("targetPeriod")
@EqualsAndHashCode(callSuper = false)
public class TargetPeriod implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户 id
     */
    @TableField(value = "userId")
    private Long userId;

    @TableField(value = "targetPeriodName")
    private String targetPeriodName;

    @TableField(value = "targetThemeId")
    private Long targetThemeId;

    /**
     * 期数
     */
    @TableField(value = "periodNum")
    private Integer periodNum;

    /**
     * 可利用时间
     */
    @TableField(value = "availableTime")
    private Integer availableTime;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 选中的目标
     */
    @TableField(value = "chosenTargets")
    private String chosenTargets;

    /**
     * 截止日期
     */
    private Date deadline;

    /**
     * 截止日期类型
     */
    @TableField(value = "deadlineType")
    private Integer deadlineType;

    /**
     * 目标规划
     */
    @TableField(value = "targetPlan")
    private Integer targetPlan;

    /**
     * 目标周期
     */
    @TableField(value = "targetCycle")
    private Integer targetCycle;

    /**
     * 是否完成
     */
    private Integer completed;

    /**
     * 是否公开
     */
    private Integer display;

    /**
     * 期望的目标
     */
    @TableField(value = "expectTargetPeriod")
    private String expectTargetPeriod;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime", fill = FieldFill.UPDATE)
    private Date updateTime;


}
