package top.timebook.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiongzl
 * @since 2021-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Inbox implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("userId")
    private Long userId;

    private String remark;

    /**
     * 是否显示
     */
    private Integer display;

    /**
     * 是否处理
     */
    private Integer handle;

    @TableField(value = "handleTime")
    private Date handleTime;

    private Integer status;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime", fill = FieldFill.UPDATE)
    private Date updateTime;


}
