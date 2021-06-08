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
 * @since 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

      @TableField(value = "userId")
    private Long userId;

    /**
     * 类别名称
     */
    @TableField(value = "categoryName")
    private String categoryName;

    /**
     * 图标地址
     */
    private String icon;

    /**
     * 图标类型
     */
    @TableField(value = "iconType")
    private Integer iconType;

    /**
     * 类别类型
     */
    private Integer type;

    /**
     * 状态
     */
    private Integer status;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime", fill = FieldFill.UPDATE)
    private Date updateTime;


}
