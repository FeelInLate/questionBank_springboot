package boot.service;

import boot.mapper.QuesBankMapper;
import boot.pojo.QuesBank;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuesBankService extends ServiceImpl<QuesBankMapper,QuesBank> {

    @Autowired
    QuesBankMapper quesBankMapper;

    public boolean saveOrUpdateQuesBank(QuesBank quesBank) {
       return saveOrUpdate(quesBank);
    }
}
