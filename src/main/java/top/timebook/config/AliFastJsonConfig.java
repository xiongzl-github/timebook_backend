package top.timebook.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Ali fast json config.
 *
 * @author xiongzl
 */
@Configuration
public class AliFastJsonConfig {

    /**
     * Fast json http message converters http message converters.
     *
     * @return the http message converters
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1. 定义一个convert消息转换对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 2. 添加fastJson的配置信息
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                // 消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty,
                // 是否输出值为null的字段,默认为false。
                SerializerFeature.WriteMapNullValue,
                // 字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //设置使用自定义日期格式，这样所有序列化的日期就会按指定格式序列化
                SerializerFeature.WriteDateUseDateFormat,
                //开发环境调试使用，线上环境请取消,仅是格式化输出json设置，会输出太多无用空格
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteEnumUsingToString,
                SerializerFeature.DisableCircularReferenceDetect
        );
        // 3. 在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 4. 将convert添加到converters当中
        return new HttpMessageConverters(fastConverter);
    }
}
