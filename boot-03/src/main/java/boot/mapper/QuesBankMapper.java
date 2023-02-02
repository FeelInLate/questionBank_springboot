package boot.mapper;

import boot.pojo.QuesBank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;


@Mapper
public interface QuesBankMapper extends BaseMapper<QuesBank> {

//    @Select("select * from QuesBank")
////    public List<QuesBank> getAllQues();
//
//    @Insert("insert into QuesBank(qname,qtype) values(#{qname},#{qtype})")
//    int insert(QuesBank quesBank);
//
//    int update(QuesBank quesBank);
//
//    @Delete("delete from QuesBank where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select  * from QuesBank where qname like #{qname} limit #{pageNum}, #{pageSize}")
//    List<QuesBank> selectPage(Integer pageNum, Integer pageSize,String qname);
//
//    @Select("select count(*) from QuesBank where qname like concat('%',#{qname},'%')   ")
//    Integer selectTotal(String qname) ;

}
