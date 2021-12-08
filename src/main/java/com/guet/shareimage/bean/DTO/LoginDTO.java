package com.guet.shareimage.bean.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LZDWTL
 * @date 2021-12-04 16:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    public String username;
    public String password;
}
