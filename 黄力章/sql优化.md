表关联较多时，对部分数据量较少的表，利用java逻辑来匹对，减少过多表关联时的速度问题。


```java
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
```

先将改小数据量的表单独查出来放list中，利用`Maps.uniqueIndex`的特性（有一大堆对象，每个对象都有一些独特的属性，能够根据该独特属性查找到对应对象。），将某可确定唯一的字段当作key，对象当作value。

根据查询结果中的主表id，来关联对应的值。