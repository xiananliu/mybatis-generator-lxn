<#if databaseType = "mysql">
    <#include "mysql/insertOrUpdateXML.ftl">

</#if>
<#if databaseType = "postgres">
    <#include "postgre/insertOrUpdateXML.ftl">
</#if>
