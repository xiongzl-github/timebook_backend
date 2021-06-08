package top.timebook.model;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Icon implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String icon;

    private Integer status;

    /**
     * type: 1. 原生, 2. 自定义
     */
    private Integer type;

    @TableField(value = "iconName")
    private String iconName;


}
