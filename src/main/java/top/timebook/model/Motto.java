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
 * @since 2021-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Motto implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

      @TableField(value = "userId")
    private Long userId;

    /**
     * 座右铭
     */
    private String motto;

    /**
     * 作者
     */
    private String author;

    /**
     * 是否隐藏
     */
    private Integer display;

    private Integer status;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime", fill = FieldFill.UPDATE)
    private Date updateTime;


}
