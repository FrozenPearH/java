package org.hlos.mds.infra.repository.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hlos.mds.domain.entity.OrganizationTl;
import org.hlos.mds.domain.entity.ResourceTl;
import org.hlos.mds.domain.entity.Tools;
import org.hlos.mds.domain.repository.ToolsRepository;
import org.hlos.mds.infra.mapper.ToolsMapper;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 全局工装器具表 资源库实现
 *
 * @author lizhang.huang@hand-china.com 2019-12-04 14:34:55
 */
@Component
public class ToolsRepositoryImpl extends BaseRepositoryImpl<Tools> implements ToolsRepository {

    private final ToolsMapper toolsMapper;

    public ToolsRepositoryImpl(ToolsMapper toolsMapper) {
        this.toolsMapper = toolsMapper;
    }

    @Override
    public Integer checkToolsDTO(Tools tools) {
        return toolsMapper.checkToolsDTO(tools);
    }


    @Override
    @ProcessLovValue
    public Page<Tools> queryTools(PageRequest pageRequest, Long tenantId, String toolCode, String toolName) {
        Page<Tools> tools = PageHelper.doPage(pageRequest, () -> toolsMapper.queryTools(tenantId, toolCode, toolName));
        List<OrganizationTl> organizationTls = toolsMapper.queryOrganizationCurrentLang();
        List<ResourceTl> resourceTls = toolsMapper.queryResourceCurrentLang();
        if (tools.size() > 0) {
            tools.forEach(t -> {
                t.setOrganization(getOrgName(t.getOrganizationId(), organizationTls));
                t.setProdLineName(getResName(t.getProdLineId(), resourceTls));
                t.setEquipmentName(getResName(t.getEquipmentId(), resourceTls));
                t.setWorkcellName(getResName(t.getWorkcellId(), resourceTls));
                t.setWarehouseName(getOrgName(t.getWarehouseId(), organizationTls));
                t.setWmAreaName(getOrgName(t.getWmAreaId(), organizationTls));
            });
        }
        return tools;
    }

    private String getOrgName(Long id,List<OrganizationTl> organizationTls) {
        ImmutableMap<Long, OrganizationTl> organizationTlImmutableMap = Maps.uniqueIndex(organizationTls, OrganizationTl::getOrganizationId);
        OrganizationTl o1 = organizationTlImmutableMap.get(id);
        if (Objects.isNull(o1)) {
            return "";
        } else {
            return o1.getOrganizationName();
        }
    }

    private String getResName(Long id, List<ResourceTl> resourceTls) {
        ImmutableMap<Long, ResourceTl> resourceTlImmutableMap = Maps.uniqueIndex(resourceTls, ResourceTl::getResourceId);
        ResourceTl r1 = resourceTlImmutableMap.get(id);
        if (Objects.isNull(r1)) {
            return "";
        } else {
            return r1.getResourceName();
        }
    }
}
