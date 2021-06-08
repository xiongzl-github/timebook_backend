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
 * @since 2021-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Setting implements Serializable {

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
     * timeline 提醒间隔
     */
    @TableField(value = "timelineRemindDuration")
    private Integer timelineRemindDuration;

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
