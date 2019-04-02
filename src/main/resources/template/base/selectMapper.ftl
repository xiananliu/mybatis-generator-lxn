    PageList<${className}> query${className}(@Param("object")${className} object,PageBounds pageBounds);

<#if cdsRooter==true>
    PageList<${className}> query${className}(@Param("object")${className} object,PageBounds pageBounds,CDSRouter cdsRouter);
</#if>

    ${className} query${className}Limit1(${className} object);

<#if cdsRooter==true>
    ${className} query${className}Limit1(${className} object,CDSRouter cdsRouter);
</#if>