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
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Target implements Serializable {

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
     * 父 id
     */
    @TableField(value = "parentId")
    private Long parentId;

    /**
     * 目标主题
     */
    @TableField(value = "targetThemeId")
    private String targetThemeId;

    /**
     * 目标名称
     */
    @TableField(value = "targetName")
    private String targetName;

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
