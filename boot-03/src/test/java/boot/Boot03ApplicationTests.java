package boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Boot03ApplicationTests {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Test
//    void contextLoads() {
////        jdbcTemplate.queryForObject("select * from work ")
////        jdbcTemplate.queryForList("select * from work");
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from work", Long.class);
//        log.info("记录总数：{}",aLong);
//    }

}
