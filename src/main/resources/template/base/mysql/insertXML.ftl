
    <insert id="insert${className}" <#if tableAttrs.autoKey??> useGeneratedKeys="true" keyProperty="${tableAttrs.autoKey}"</#if>>
        INSERT INTO ${sense}${tableName}${sense}
        (
        <trim suffixOverrides=",">
                <#list attrs as attr>
                    <if test="${attr.propertiesName}!=null">
                        ${sense}${attr.columnName}${sense},
                    </if>
                </#list>
        </trim>
        )
        VALUES
        (
        <trim suffixOverrides=",">
            <#list attrs as attr>
                <if test="${attr.propertiesName}!=null">
                    ${"#\{"}${attr.propertiesName}},
                </if>
            </#list>
        </trim>
        )
    </insert>


    <insert id="insertBatch${className}" <#if tableAttrs.autoKey??> useGeneratedKeys="true" keyProperty="${tableAttrs.autoKey}"</#if>>

        INSERT INTO ${sense}${tableName}${sense}
        (
        <trim suffixOverrides=",">
                <#list attrs as attr>
                    <#--<if test="${attr.propertiesName}!=null">-->
                        ${sense}${attr.columnName}${sense},
                    <#--</if>-->
                </#list>
        </trim>
        )
        VALUES
        <foreach collection="list" separator="," item="item">
        (
        <trim suffixOverrides=",">
            <#list attrs as attr>
                <if test="item.${attr.propertiesName}!=null">
                    ${"#\{"}item.${attr.propertiesName}},
                </if>
                <if test="item.${attr.propertiesName}==null">
                    default,
                </if>
            </#list>
        </trim>
        )
        </foreach>
    </insert>
