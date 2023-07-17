package java.com.menghuan.menghuan.utils;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cateyes.smart.park.base.bean.dto.BaseDto;
import com.cateyes.smart.park.base.bean.vo.PageInfo;
import com.cateyes.smart.park.base.util.PageUtil;
import com.cateyes.smart.park.cbb.approvalflow.flow.ApprovalHandler;
import com.cateyes.smart.park.cbb.approvalflow.flow.Handler;
import com.cateyes.smart.park.cbb.approvalflow.model.ApprovalResult;
import com.cateyes.smart.park.cbb.approvalflow.model.ApprovalType;
import com.cateyes.smart.park.cbb.approvalflow.model.ApproveInfo;
import com.cateyes.smart.park.invest.bean.po.FlowInfo;
import com.cateyes.smart.park.invest.bean.po.FlowLevel;
import com.cateyes.smart.park.invest.bean.po.FlowTrack;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Description: TODO
 *
 * @author: CatEyes
 * @date: 2023/3/31 10:03
 */
public class SpBaseServiceImpl {
    /**
     * Description: 公共分页查询-单表
     * 
     * @param mapper
     * @param wrapper
     * @param dto
     * @return PageInfo<T>
     * @throws @author
     *             CatEyes
     * @date 2023/4/3 11:13
     **/
    public <K extends BaseMapper<T>, T> PageInfo<T> query(K mapper, Wrapper<T> wrapper, BaseDto dto) {
        IPage<T> resultPage = mapper.selectPage(new Page<T>(dto.getPageNo(), dto.getPageSize()), wrapper);
        return PageUtil.build(dto.getPageNo(), dto.getPageSize(), resultPage.getRecords(), (int)resultPage.getTotal());
    }

    /**
     * Description: 构建审批流审批框架
     * 
     * @param flowLevels
     * @param records
     * @return Handler
     * @throws @author
     *             CatEyes
     * @date 2023/4/3 11:22
     **/
    public Handler buildFlowStruts(List<FlowLevel> flowLevels, List<FlowTrack> records) {
        List<ApprovalHandler> handlers = Lists.newArrayList();
        flowLevels.forEach(item -> {
            List<ApproveInfo> temp = Lists.newArrayList();
            List<FlowTrack> levelRecords = records.stream()
                .filter(record -> record.getApproveLevel().equals(item.getApproveLevel())).collect(Collectors.toList());
            Arrays.stream(item.getApprover().split("，|,")).forEach(one -> {
                if (CollectionUtils.isNotEmpty(levelRecords)
                    && levelRecords.stream().anyMatch(track -> track.getApprover().equals(Integer.valueOf(one)))) {
                    temp.add(new ApproveInfo(Long.valueOf(one),
                        levelRecords.stream().filter(track -> track.getApprover().equals(Integer.valueOf(one)))
                            .findAny().map(FlowTrack::getResult).get() == 1 ? ApprovalResult.AGREE
                                : ApprovalResult.REFUSE));
                } else {
                    temp.add(new ApproveInfo(Long.valueOf(one), ApprovalResult.NONE));
                }
            });
            handlers.add(new ApprovalHandler(item.getApproveLevel(),
                item.getType() == 0 ? ApprovalType.OR : ApprovalType.AND, temp));
        });
        handlers.sort(Comparator.comparing(ApprovalHandler::getApproveLevel));
        Handler.FlowBuilder builder = new Handler.FlowBuilder();
        handlers.forEach(handler -> {
            builder.addHandler(handler);
        });
        return builder.build();
    }

    protected <T, M, N> Map<M, N> collectionToMap(BaseMapper<T> mapper, Function<T, M> key, Function<T, N> item,
        Collection<? extends Serializable> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Maps.newHashMap();
        }
        List<T> ts = mapper.selectBatchIds(idList);
        return Optional.ofNullable(ts.stream().collect(Collectors.toMap(t -> key.apply(t), t -> item.apply(t))))
            .orElse(Maps.newHashMap());
    }


    private <M,N> void removeFlowRelation(BaseMapper<M> mapperM, BaseMapper<N> mapperN, Wrapper<M> wrapper) {
        List<M> flowInfos = mapperM.selectList(wrapper);
        if (CollectionUtils.isEmpty(flowInfos)) {
            return;
        }
        List<String> ids = flowInfos.stream()
                .map(entity -> {
                    if (entity instanceof FlowInfo) {
                        return ((FlowInfo) entity).getId();
                    } else if (entity instanceof FlowTrack) {
                        return ((FlowTrack) entity).getFlowInfoId();
                    } else {
                        // Handle other entity types if needed
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        mapperM.delete(Wrappers.<M>lambdaQuery().in(M instanceof FlowInfo, ids));
        mapperN.delete(Wrappers.<N>lambdaQuery().in(FlowTrack::getFlowInfoId, ids));
    }

}
