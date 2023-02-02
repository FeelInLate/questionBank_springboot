package boot.service;

import boot.mapper.TimuMapper;
import boot.pojo.Timu;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimuService extends ServiceImpl<TimuMapper, Timu> {


    @Autowired
    TimuMapper timuMapper;
    public boolean saveOrUpdateQuesBank(Timu timu) {
        return saveOrUpdate(timu);
    }
}
