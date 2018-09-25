package com.hailian.utils;

import java.util.UUID;

public class UUIDUtils {
	 public String getUUID(){
         return UUID.randomUUID().toString().replace("-", "");
    }
}
