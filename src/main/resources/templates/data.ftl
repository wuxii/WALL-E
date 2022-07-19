// auto code gen
package ${p.package};

import lombok.Getter;
import lombok.Setter;

<#list p.importNames as name>
import ${name};
</#list>

import com.google.gson.annotations.SerializedName;

@Getter
@Setter
public class ${p.typeName?cap_first} {

    <#list p.fields as f>
    /**
     * ${f.description}.<#if f.example != ""> 示例值: ${f.example}</#if>
     */
    @SerializedName("${f.name}")
    private ${f.typeName} ${f.name};

    </#list>
}
