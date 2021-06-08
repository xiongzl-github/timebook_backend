package top.timebook.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Habit implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

      @TableField(value = "userId")
    private Long userId;

    /**
     * 类别
     */
    @TableField(value = "categoryId")
    private Long categoryId;

    /**
     * 习惯
     */
    private String habit;

    /**
     * 周期
     */
    private Integer cycle;

    /**
     * 频率
     */
    private Integer frequency;

    /**
     * 刷新频率
     */
    @TableField(value = "refreshRate")
    private Integer refreshRate;

    /**
     * 期望达成率
     */
    @TableField(value = "expectAchievingRate")
    private Integer expectAchievingRate;

    /**
     * 比较器
     */
    private Integer comparator;

    /**
     * 是否公开
     */
    private Integer display;

    /**
     * 是否是核心指标
     */
    @TableField(value = "keyHabit")
    private Integer keyHabit;

    /**
     * 是否使用
     */
    private Integer apply;

    /**
     * 停止使用时间
     */
    @TableField(value = "stopUseTime")
    private Date stopUseTime;

    /**
     * status: 0. 删除, 1. 正常, 2. 停用
     */
    private Integer status;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime", fill = FieldFill.UPDATE)
    private Date updateTime;


}
