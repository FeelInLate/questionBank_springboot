package boot.service.UserServiceImpl;

import boot.mapper.UserMapper;
import boot.pojo.UserDTO;
import boot.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDTO> implements UserService {

    @Override
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<UserDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        UserDTO one = getOne(queryWrapper);//从数据库查询用户信息
        if (one != null) {
            return one;
        }
        return null;
    }
}
