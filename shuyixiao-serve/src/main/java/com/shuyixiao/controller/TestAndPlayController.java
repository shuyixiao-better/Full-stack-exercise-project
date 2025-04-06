package shuyixiao.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.web.bind.annotation.*;
import shuyixiao.config.*;
import shuyixiao.data.Applicant;
import shuyixiao.data.AuditFlow;
import shuyixiao.data.Menu;
import shuyixiao.data.UserData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName TestAndPlayController.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年03月28日 22:58:00
 */
@RestController
@RequestMapping("/api/")
public class TestAndPlayController {
    @PostMapping("/user/login")
    public ResponseData login() {
        System.out.println("/user/login");
        // 颁发令牌，不应该用魔法值，用常量
        String accessToken = JwtUtils.generatorToken("userName", "passWord", TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken("userName", "passWord" ,TokenConstants.REFRESH_TOKEN_TYPE);
        // 创建返回的数据对象
        ResponseData responseData = new ResponseData();
        responseData.setCode(200);
        TokenResponse userData = new TokenResponse();
        userData.setAccessToken(accessToken);
        userData.setRefreshToken(refreshToken);
        responseData.setData(userData);
        return responseData;
    }

    @PostMapping("/leave/list")
    public ResponseData getData() {
        System.out.println("/leave/list");

        // 创建返回的数据对象
        ResponseData responseData = new ResponseData();
        responseData.setCode(200);

        // 创建分页信息
        Page page = new Page();
        page.setPageNum(1);
        page.setPageSize(10);
        page.setTotal(1);

        // 创建申请人信息
        Applicant applicant = new Applicant();
        applicant.setUserId("104510");
        applicant.setUserName("李明彰");

        // 创建审核流程列表
        List<AuditFlow> auditFlows = new ArrayList<>();
        auditFlows.add(new AuditFlow("603081dd525ae1359dd7e2fc", "1000004", "lee", "lee@mashibing.com"));
        auditFlows.add(new AuditFlow("603081dd525ae1359dd7e2fd", "1000011", "liuge", "liuge@mashibing.com"));
        auditFlows.add(new AuditFlow("603081dd525ae1359dd7e2fe", "1000013", "zhouyuxian", "zhouyuxian@mashibing.com"));

        // 创建日志列表
        List<Log> logs = new ArrayList<>();
        logs.add(new Log("603082f316663b36f713b16b", "1000004", "lee", "2023-02-17T03:33:07.175Z", "同意", "审核通过"));
        return responseData;
    }

    @GetMapping("/notify/count")
    public ResponseData notifyMessage() {
        System.out.println("/notify/count");

        // 创建返回的数据对象
        ResponseData responseData = new ResponseData();
        responseData.setCode(200);
        responseData.setCount(1);
        responseData.setMsg("您有1条未读消息");
        return responseData;
    }

    @GetMapping("/menu/list")
    public ResponseData menuList() {
        System.out.println("/menu/list");
        ResponseData responseData = new ResponseData();

        // 构造菜单数据
        List<Menu> menuList = new ArrayList<>();

        // 示例：构造一个顶级菜单
        Menu systemManagement = new Menu();
        systemManagement.setParentId(Arrays.asList("0"));
        systemManagement.setUpdateTime("2022-06-06T10:03:38.947Z");
        systemManagement.setCreateTime("2021-05-30T09:22:00.000Z");
        systemManagement.set_id("11");
        systemManagement.setMenuType(1);
        systemManagement.setMenuName("系统管理");
        systemManagement.setIcon("Grid");
        systemManagement.setPath("/system");
        systemManagement.setOrder("0");
        systemManagement.setComponent("");
        systemManagement.setMenuState(1);

        Menu systemManagement2 = new Menu();
        systemManagement2.setParentId(Arrays.asList("0"));
        systemManagement2.setUpdateTime("2022-06-06T10:03:38.947Z");
        systemManagement2.setCreateTime("2021-05-30T09:22:00.000Z");
        systemManagement2.set_id("12");
        systemManagement2.setMenuType(1);
        systemManagement2.setMenuName("审批管理");
        systemManagement2.setIcon("Promotion");
        systemManagement2.setPath("/system");
        systemManagement2.setOrder("0");
        systemManagement2.setComponent("");
        systemManagement2.setMenuState(1);

        // 构造子菜单
        List<Menu> children = new ArrayList<>();
        Menu userManagement = new Menu();
        userManagement.setParentId(Arrays.asList("11"));
        userManagement.setUpdateTime("2022-027-04T07:12:21.077Z");
        userManagement.setCreateTime("2022-06-30T08:10:00.000Z");
        userManagement.set_id("111");
        userManagement.setMenuType(1);
        userManagement.setMenuName("舒一笑用户管理");
        userManagement.setPath("/system/user");
        userManagement.setOrder("1");
        userManagement.setComponent("/system/user");
        userManagement.setMenuState(1);

        Menu userManagement2 = new Menu();
        userManagement2.setParentId(Arrays.asList("11"));
        userManagement2.setUpdateTime("2022-027-04T07:12:21.077Z");
        userManagement2.setCreateTime("2022-06-30T08:10:00.000Z");
        userManagement2.set_id("112");
        userManagement2.setMenuType(1);
        userManagement2.setMenuName("休假管理");
        userManagement2.setPath("/system/user");
        userManagement2.setOrder("1");
        userManagement2.setComponent("/system/user");
        userManagement2.setMenuState(1);

        // 构造子菜单的子菜单
        List<Menu> userActions = new ArrayList<>();
        Menu createUser = new Menu();
        createUser.setParentId(Arrays.asList("11", "111"));
        createUser.setUpdateTime("2022-11-21T09:54:44.242Z");
        createUser.setCreateTime("2022-10-20T06:46:50.711Z");
        createUser.set_id("1111");
        createUser.setMenuType(2);
        createUser.setMenuState(1);
        createUser.setMenuName("新增");
        createUser.setMenuCode("user-create");
        createUser.set__v(0);

        userActions.add(createUser);

        userManagement.setChildren(userActions);
        userManagement.setAction(userActions);

        children.add(userManagement);
        children.add(userManagement2);

        systemManagement.setChildren(children);
        systemManagement2.setChildren(children);

        menuList.add(systemManagement);
        menuList.add(systemManagement2);

        // 设置返回数据
        responseData.setCode(200);
        responseData.setMenuList(menuList);

        responseData.setMsg("");

        return responseData;
    }
}