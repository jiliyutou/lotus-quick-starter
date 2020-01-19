package com.lotus.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ExampleDO {

    private Integer id;
    private String key;
    private String value;

    /** sqlite 日期类型映射有点问题，暂时用String处理 */
    private String created;
    private String lastModified;
}
