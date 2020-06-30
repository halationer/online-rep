package com.shopping.service;

import com.shopping.common.Address;
import com.shopping.common.ServerResponse;

public interface IAddressService {
     public ServerResponse addLogic(Address address);
     public ServerResponse delLogic(Integer id);
     public ServerResponse selectLogic(Integer id);
     public ServerResponse updateLogic(Address address);
     public ServerResponse listLogic(Integer id,int pageNum,int pageSize);
 }
