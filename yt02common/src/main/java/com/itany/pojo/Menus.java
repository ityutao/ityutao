package com.itany.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 下午2:27
 * description:
 * version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menus implements Serializable {

    private Integer menusid;
    private String icon;
    private String menuname;
    private String url;
    private Set<Menus> menus;
}
