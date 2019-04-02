    int insert${className}(${className} object);

    int insertBatch${className}(@Param("list") List<${className}> object);

<#if cdsRooter==true>
    int insertBatch${className}(@Param("list") List<${className}> object,CDSRouter cdsRouter);
</#if>
