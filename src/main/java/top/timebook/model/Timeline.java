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
public class Timeline implements Serializable {

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
     * 开始时间
     */
    @TableField(value = "startTime")
    private String startTime;

    /**
     * 结束时间
     */
    @TableField(value = "endTime")
    private String endTime;

    /**
     * todolist id
     */
    @TableField(value = "todolistId")
    private Long todolistId;

    /**
     * 目标 id
     */
    @TableField(value = "targetId")
    private Long targetId;

    /**
     * 目标期数 id
     */
    @TableField(value = "targetPeriodId")
    private Long targetPeriodId;

    /**
     * 进度
     */
    private Integer progress;

    /**
     * 工作状态
     */
    @TableField(value = "workStatus")
    private Integer workStatus;

    @TableField(value = "emotion")
    private Integer emotion;

    private String feel;

    /**
     * 是否公开
     */
    private Integer display;

    /**
     * 其他数据
     */
    private String other;

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
