package com.hesen.blog.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_type")
public class Type {
    private Long id;
    @NotBlank(message = "博客类型名称不能为空")
    private String name;

    @TableField(exist = false)
    private List<Blog> blogs;
}
