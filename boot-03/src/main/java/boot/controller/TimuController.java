package boot.controller;

import boot.mapper.TimuMapper;
import boot.pojo.Timu;
import boot.service.TimuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/timu")
public class TimuController {

    @Autowired
    TimuService timuService;

    @Autowired
    TimuMapper timuMapper;

    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return timuService.removeById(id);
    }

    /**
     * 获取指定参数的题目
     * @param ttype
     * @return
     */
    @GetMapping()
    public List<Timu> getAllTimus(@RequestParam(defaultValue = " ") String ttype){

        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("ttype",ttype);
        List<Timu> timus = timuMapper.selectByMap(columnMap);
        return timus;
    }

    /**
     * 获取所有题目
     * @return
     */
    @GetMapping("/getAll")
    public List<Timu> getAll(){
        return timuService.list();
    }

    @PostMapping("/post")
    public boolean saveOrUpdateQuesBank(@RequestBody Timu timu){
        return timuService.saveOrUpdateQuesBank(timu);
    }
}
