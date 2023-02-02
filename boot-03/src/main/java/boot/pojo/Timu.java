package boot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("timu")
public class Timu {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String tname;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String ttype;
}
