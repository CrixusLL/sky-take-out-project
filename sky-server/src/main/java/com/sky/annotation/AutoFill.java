package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * ClassName: AutoFill
 * Package: com.sky.annotation
 * Description:自定义注解，用于标识某个方法需要进行功能字段自动填充处理
 *
 * @Author Leland_Lau
 * @Create 2024/3/15 13:21
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    OperationType value();
}
