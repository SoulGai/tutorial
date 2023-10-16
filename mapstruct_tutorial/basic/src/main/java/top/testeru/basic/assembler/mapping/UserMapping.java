package top.testeru.basic.assembler.mapping;


import org.mapstruct.Mapper;
import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValueMappingStrategy.RETURN_NULL;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import top.testeru.basic.bo.UserBO;
import top.testeru.basic.dataobject.UserDO;

import java.util.List;

/**
 * @program: mapstruct_tutorial
 * @author: 盖盖
 * @description: 用户实体类之间转换
 *          assembler[汇编语言].mapping[映射]
 * @Date: 2023/10/16
 */
//componentModel：指定 MapStruct 生成的映射实现类的作用域，可以是 "default"、"spring"、"cdi"、"jsr330" 等。
//nullValueCheckStrategy：指定 MapStruct 在映射时对 null 值的检查策略，可以是 "ALWAYS"、"ON_IMPLICIT_CONVERSION"、"ON_EXPLICIT_CONVERSION"。
//nullValueMappingStrategy：指定 MapStruct 在映射时对 null 值的处理策略，可以是 "RETURN_DEFAULT"、"RETURN_NULL"、"SET_TO_DEFAULT"。
//nullValuePropertyMappingStrategy：指定 MapStruct 在映射时对 null 值属性的处理策略，可以是 "SET_TO_NULL"、"IGNORE"。
//unmappedTargetPolicy：指定 MapStruct 在映射时对未映射属性的处理策略，可以是 "IGNORE"、"WARN"、"ERROR"。
@Mapper(
        //指定 MapStruct 生成的映射实现类的作用域，可以是 "default"、"spring"、"cdi"、"jsr330" 等。
        //生成的映射器是一个 Spring bean，可以通过 @Autowired 检索
        componentModel = "spring",
        //指定 MapStruct 在映射时对 null 值的检查策略 始终包含空检查
        nullValueCheckStrategy = ALWAYS,
        nullValueMappingStrategy = RETURN_NULL,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
        )
public interface UserMapping {


    UserBO covert2UserBO(UserDO userDO);


}
