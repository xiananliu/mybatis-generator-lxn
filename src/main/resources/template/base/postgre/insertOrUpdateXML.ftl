
    <insert id="insertOrUpdate" <#if tableAttrs.autoKey??> useGeneratedKeys="true" keyProperty="${tableAttrs.autoKey}"</#if>>
        INSERT INTO ${sense}${tableName}${sense}
        (
        <trim suffixOverrides=",">
                <#list attrs as attr>
                    <if test="add.${attr.propertiesName}!=null">
                        ${sense}${attr.columnName}${sense},
                    </if>
                </#list>
        </trim>
        )
        VALUES
        (
        <trim suffixOverrides=",">
            <#list attrs as attr>
                <if test="add.${attr.propertiesName}!=null">
                    ${"#\{"}add.${attr.propertiesName}},
                </if>
            </#list>
        </trim>
        )

        ON DUPLICATE KEY UPDATE

        <trim suffixOverrides=",">
        <#list attrs as attr>
            <#if attr.isAuto == "NO" && attr.isKey == 0>
            <if test="set.${attr.propertiesName} != null<#if attr.javaTypeName=="String"> and set.${attr.propertiesName}!=''</#if>">
                ${sense}${attr.columnName}${sense} = ${"#\{set."}${attr.propertiesName}},
            </if>
            </#if>
        </#list>
        </trim>
    </insert>



