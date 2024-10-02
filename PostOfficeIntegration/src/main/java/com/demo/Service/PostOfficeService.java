package com.demo.Service;

import java.util.List;
import java.util.Map;

public interface PostOfficeService {
List<Map<String,Object>>getbypincode(int pincode);
List<Map<String,Object>>getbybranchname(String name);
}
