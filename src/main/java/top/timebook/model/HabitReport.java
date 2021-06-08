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
 * @since 2021-03-22
 */
@Data
@TableName("habitReport")
@EqualsAndHashCode(callSuper = false)
public class HabitReport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 习惯 id
     */
    @TableField(value = "habitId")
    private Long habitId;

    /**
     * 习惯完成结果
     */
    @TableField(value = "habitResult")
    private Integer habitResult;

    /**
     * 习惯完成时间
     */
    @TableField(value = "habitTime")
    private Date habitTime;

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
