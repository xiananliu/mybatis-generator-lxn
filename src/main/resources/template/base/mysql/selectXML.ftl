    <resultMap type="${packageModel}.${className}" id="${className}Map">
        <#list attrs as attr>
        <result property="${attr.propertiesName}" column="${attr.columnName}"/>
        </#list>
    </resultMap>


    <select id="query" resultMap="${className}Map">
        select
        <include refid="baseResult"></include>
        from  ${sense}${tableName}${sense}
        <include refid="queryWhere"></include>
    </select>

    <select id="queryCount" resultType="java.lang.Long">
        select
        count(1)
        from  ${sense}${tableName}${sense}
        <include refid="queryWhere"></include>
    </select>

    <sql id="queryWhere">
        <trim prefix="where" suffixOverrides="and | or">
            <#if logicField??&&logicField!= "">
                    ${logicField} = ${logicVal} and
            </#if>
            <#list attrs as attr>
                <if test="object.${attr.propertiesName} != null<#if attr.javaTypeName=="String"> and object.${attr.propertiesName}!=''</#if>">
                    ${sense}${attr.columnName}${sense} = ${"#\{"}object.${attr.propertiesName}} and
                </if>
            </#list>
            <if test = "(object instanceof ${packageModel}.${className}${r'$'}QueryBuilder) == true">
                <#list attrs as attr>
                    <if test="object.${attr.propertiesName}List != null">
                        ${sense}${attr.columnName}${sense} in
                        <foreach collection="object.${attr.propertiesName}List" close=")" open="(" separator="," item="item">
                            ${"#\{"}item}
                        </foreach> and
                    </if>
                    <#if attr.isBetween = "yes">
                        <if test="object.${attr.propertiesName}St !=null">
                            ${sense}${attr.columnName}${sense} >= ${"#\{"}object.${attr.propertiesName}St} and
                        </if>
                        <if test="object.${attr.propertiesName}Ed!=null">
                            ${sense}${attr.columnName}${sense} &lt;= ${"#\{"}object.${attr.propertiesName}Ed} and
                        </if>
                    </#if>
                    <#if attr.javaTypeName = "String">
                        <if test ="object.fuzzy${attr.propertiesName?cap_first}!=null and object.fuzzy${attr.propertiesName?cap_first}.size()>0">
                            (
                            <foreach collection="object.fuzzy${attr.propertiesName?cap_first}"  separator="or" item="item">
                                ${sense}${attr.columnName?cap_first}${sense} like concat('%',${"#\{"}item},'%')
                            </foreach>
                            ) and
                        </if>
                        <if test ="object.rightFuzzy${attr.propertiesName?cap_first}!=null and object.rightFuzzy${attr.propertiesName?cap_first}.size()>0">
                            (
                            <foreach collection="object.rightFuzzy${attr.propertiesName?cap_first}"  separator="or" item="item">
                                ${sense}${attr.columnName?cap_first}${sense} like concat(${"#\{"}item},'%')
                            </foreach>
                            ) and
                        </if>
                    </#if>
                </#list>
            </if>
        </trim>
    </sql>

    <select id="queryOne" resultMap="${className}Map">
        select
        <include refid="baseResult"></include>
        from  ${sense}${tableName}${sense}
        <include refid="queryWhere"></include>
        limit 1
    </select>

    <sql id="allResult">
        <trim suffixOverrides=",">
    <#list attrs as attr>
        ${sense}${attr.columnName}${sense}<#if attr.typeName == "BIT">+0 as ${sense}${attr.columnName}${sense}</#if>,
    </#list>
        </trim>
    </sql>



    <sql id="baseResult">
        <trim suffixOverrides=",">
            <if test = "(object instanceof ${packageModel}.${className}${r'$'}QueryBuilder) == true">

                <if test="object.fetchFields==null">
                    <include refid="allResult"></include>
                </if>
                <if test="object.fetchFields!=null">
                    <if test="object.fetchFields.AllFields !=null">
                        <include refid="allResult"></include>
                    </if>
                    <if test="object.fetchFields.AllFields ==null and object.fetchFields.fetchFields==null and object.fetchFields.excludeFields==null and object.fetchFields.otherFields==null">
                        <include refid="allResult"></include>
                    </if>
                    <if test="object.fetchFields.AllFields==null and object.fetchFields.fetchFields!=null">
                <#list attrs as attr>
                    <if test="object.fetchFields.object.fetchFields.${attr.propertiesName}==true">
                        ${sense}${attr.columnName}${sense}<#if attr.typeName == "BIT">+0 as ${sense}${attr.columnName}${sense}</#if>,
                    </if>
                </#list>
                    </if>
                    <if test="object.fetchFields.AllFields==null and object.fetchFields.excludeFields!=null">
                <#list attrs as attr>
                    <if test="object.fetchFields.excludeFields.${attr.propertiesName}==null">
                        ${sense}${attr.columnName}${sense}<#if attr.typeName == "BIT">+0 as ${sense}${attr.columnName}${sense}</#if>,
                    </if>
                </#list>
                    </if>
                    <if test="object.fetchFields.otherFields!=null and object.fetchFields.otherFields.size>0">
                        <foreach collection="object.fetchFields.otherFields" index="index" item="item" separator=",">
                        ${sense}${r"#{item}"}${sense}
                        </foreach>
                    </if>
                </if>
            </if>
            <if test="(object instanceof ${packageModel}.${className}${r'$'}QueryBuilder) == false" >
                <include refid="allResult"></include>
            </if>

        </trim>
    </sql>
