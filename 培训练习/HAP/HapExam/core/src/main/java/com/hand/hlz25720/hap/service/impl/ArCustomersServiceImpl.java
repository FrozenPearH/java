package com.hand.hlz25720.hap.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hand.hlz25720.hap.dto.ArCustomers;
import com.hand.hlz25720.hap.service.IArCustomersService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ArCustomersServiceImpl extends BaseServiceImpl<ArCustomers> implements IArCustomersService{

}