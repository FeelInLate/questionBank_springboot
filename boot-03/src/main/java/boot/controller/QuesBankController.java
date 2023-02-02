package boot.controller;

import boot.pojo.QuesBank;
import boot.service.QuesBankService;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/quesbank")
public class QuesBankController {

    @Autowired
    QuesBankService quesBankService;
    /**
     * 新增和修改
     * @param quesBank
     * @return
     */
    @PostMapping("/post")
    public boolean saveOrUpdateQuesBank(@RequestBody QuesBank quesBank){
        return quesBankService.saveOrUpdateQuesBank(quesBank);
    }

    /**
     * 查看所有
     * @return
     */
    @GetMapping()
    public List<QuesBank> getAllQues(){
         return quesBankService.list();
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return quesBankService.removeById(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return quesBankService.removeByIds(ids);
    }

    /**
     * 分页查询
     * 路径：/user/page?pageNum=1&pageSize=10
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping( "/page")
    public IPage<QuesBank> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam(defaultValue = "") String qname,
                                    @RequestParam(defaultValue = "") String qtype,
                                    @RequestParam(defaultValue = "") String qdate) {
        IPage<QuesBank> page = new Page<>(pageNum, pageSize);
        QueryWrapper<QuesBank> queryWrapper = new QueryWrapper<>();
        if (!"".equals(qname)){
            queryWrapper.like("qname",qname);
        }
        if (!"".equals(qtype)){
            queryWrapper.like("qtype",qtype);
        }
        if (!"".equals(qdate)){
            queryWrapper.like("qdate",qdate);
        }
        queryWrapper.orderByDesc("id");
        return quesBankService.page(page,queryWrapper);
    }

    /**
     * 导出接口
     * @param response
     * @throws Exception
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception{
        //从数据库查询出所有的数据
        List<QuesBank> list = quesBankService.list();
        //通过工具类创建writer写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(true);
        //在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id","考卷号");
        writer.addHeaderAlias("qname","考卷名称");
        writer.addHeaderAlias("qtype","考卷类型");
        writer.addHeaderAlias("qdate","考卷时间");

        //一次性写出list内的对象到Excel，使用默认样式，强制输出标题
        writer.write(list,true);

        //设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("考卷信息","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out,true);
        out.close();
        writer.close();
    }

    /**
     * 导入
     * @param file
     * @throws IOException
     */
    @PostMapping("/import")
    public boolean imp(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<QuesBank> list = reader.readAll(QuesBank.class);
        quesBankService.saveBatch(list);
        return true;
    }

}
