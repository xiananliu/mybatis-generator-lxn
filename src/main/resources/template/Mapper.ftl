package ${packageMapper}.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ${packageModel}.${className};
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
<#if cdsRooter==true>
import com.jdd.baoxian.common.CDSRouter;
</#if>
/**
*  @author ${author}
*/
public interface ${mapperName}BaseMapper {

    <#include "base/insertMapper.ftl">

    <#include "base/updateMapper.ftl">

    <#include "base/insertOrUpdateMapper.ftl">

    <#include "base/selectMapper.ftl">

}