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
 * @since 2021-05-07
 */
@Data
@TableName("timelineCategory")
@EqualsAndHashCode(callSuper = false)
public class TimelineCategory implements Serializable {

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
     * 类别名称
     */
    @TableField(value = "categoryName")
    private String categoryName;

    /**
     * 组件类别
     */
    @TableField(value = "componentType")
    private Integer componentType;

    /**
     * 简介
     */
    private String intro;

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
