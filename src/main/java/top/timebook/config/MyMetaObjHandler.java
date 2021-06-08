package top.timebook.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * TODO
 *
 * @author xiongzl
 * @version 1.0
 * @date 2021/3/19 14:13
 */
@Component
public class MyMetaObjHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if(metaObject.hasSetter("createTime")){
            Object createTime = getFieldValByName("createTime", metaObject);
            if(Objects.nonNull(createTime)){
                setFieldValByName("createTime",createTime,metaObject);
            }else{
                setFieldValByName("createTime",new Date(),metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(metaObject.hasSetter("updateTime")){
            Object updateTime = getFieldValByName("updateTime", metaObject);
//            if(Objects.nonNull(updateTime)){
//                setFieldValByName("updateTime",updateTime,metaObject);
//            }else{
//                setFieldValByName("updateTime",new Date(),metaObject);
//            }
            setFieldValByName("updateTime",new Date(),metaObject);
        }
    }

}
