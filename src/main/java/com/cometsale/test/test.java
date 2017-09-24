/*
 * Copyright 2017 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cometsale.test;
import com.cometsale.model.UserDetails;
import com.cometsale.mongodb.UserDB;



public class test {
  
    public static void main(final String[] args) {
      UserDetails userA= new UserDetails("test121241","testuser","t","est");
      UserDB.push(userA);
      
        UserDetails findResult= UserDB.find("test121241","netID").get(0);
        System.out.println("firstName:"+findResult.getFirstName()+"\nNetID:"+findResult.getNetId());
        
        UserDB.update("test121241","netID","updateFirstName", "firstName");
      
        findResult=(UserDetails) UserDB.find("test121241","netID").get(0);
        System.out.println("firstName:"+findResult.getFirstName()+"\nNetID:"+findResult.getNetId());
        
    }
}