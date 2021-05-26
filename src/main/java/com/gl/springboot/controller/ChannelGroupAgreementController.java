package com.gl.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gl.springboot.entity.ChannelGroupAgreement;
import com.gl.springboot.service.IChannelGroupAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 团体契约 前端控制器
 * </p>
 *
 * @author guanlei
 * @since 2021-04-06
 */
@RestController
@RequestMapping("/channel-group-agreement")
public class ChannelGroupAgreementController {

    @Autowired
    private IChannelGroupAgreementService channelGroupAgreementService;

    @PostMapping(value = "/queryList")
    public IPage<ChannelGroupAgreement> queryChannelGroupAgreementList(Page<ChannelGroupAgreement> request){
        LambdaQueryWrapper<ChannelGroupAgreement> queryWrapper = Wrappers.lambdaQuery();
        IPage<ChannelGroupAgreement> page = channelGroupAgreementService.page(request,queryWrapper);
        return page;
    }

}
