package top.timebook.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiongzl
 * @since 2021-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Todolist implements Serializable {

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

    /**
     * 类型 id
     */
    @TableField(value = "categoryId")
    private Long categoryId;

    /**
     * 级联目标数组
     */
    @TableField(value = "targetIds")
    private String targetIds;

    /**
     * 目标期数 id
     */
    @TableField(value = "targetPeriodId")
    private Long targetPeriodId;

    /**
     * 目标 id
     */
    @TableField(value = "targetId")
    private Long targetId;

    /**
     * 任务名称
     */
    private String taskname;

    /**
     * 重复类型
     */
    @TableField(value = "repeatType")
    private Integer repeatType;

    /**
     * 预计用时
     */
    @TableField(value = "estimatedTime")
    private Integer estimatedTime;

    /**
     * 任务开始时间
     */
    @TableField(value = "startTime")
    private Date startTime;

    /**
     * 调整后截止时间数组
     */
    @TableField(value = "adjustDeadline")
    private String adjustDeadline;

    /**
     * 截止日期
     */
    private Date deadline;

    /**
     * 难度等级
     */
    private Integer difficulty;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 时间段类型
     */
    @TableField(value = "timeslotType")
    private Integer timeslotType;

    /**
     * task 未完成原因
     */
    @TableField(value = "reasonType")
    private Integer reasonType;

    /**
     * 调整类型
     */
    @TableField(value = "adjustType")
    private Integer adjustType;

    /**
     * 是否公开
     */
    private Integer display;

    /**
     * 是否完成
     */
    private Integer completed;

    /**
     * 是否核心
     */
    private Integer core;

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
