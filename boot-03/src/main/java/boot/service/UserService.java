package boot.service;

import boot.pojo.UserDTO;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<UserDTO> {

     UserDTO login(UserDTO userDTO);
}
