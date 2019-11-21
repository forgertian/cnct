package com.cnct.cntroller;

import com.cnct.common.vo.PageResult;
import com.cnct.pojo.Role;
import com.cnct.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    //1、添加角色
    //2、修改角色
    //3、删除角色
    //4、角色查询
    @GetMapping("/findrole")
    public ResponseEntity<PageResult<Role>> findRoles(
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value = "rows",required = false,defaultValue = "10") Integer rows){
        return ResponseEntity.ok().body(roleService.findRoles(page,rows));
    }

    @PostMapping("/addrole")
    public ResponseEntity<Role> addRole(Role role){
        return ResponseEntity.ok().body(roleService.addRole(role));
    }

    @PutMapping("/editrole")
    public ResponseEntity<Role> editRole(Role role){
        return ResponseEntity.ok().body(roleService.editRole(role));
    }
    @DeleteMapping("/deleterole/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok().body(null);
    }

    /**
     * 后台角色管理时 检查该角色是否可以进行删除
     * @param id
     * @return
     */
    @GetMapping("/checkrole/{id}")
    public ResponseEntity<Boolean> checkRole(@PathVariable("id") Long id){
        Boolean res = roleService.checkRole(id);
        return ResponseEntity.ok().body(res);
    }
}
