package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private Map<String, UserProfile> userProfileMap;

    @PostConstruct //초기화 어노테이션
    public void init() {
        userProfileMap = new HashMap<String, UserProfile>();
        userProfileMap.put("1", new UserProfile("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
        userProfileMap.put("2", new UserProfile("2", "홍길자", "111-1112", "서울시 강남구 대치2동"));
        userProfileMap.put("3", new UserProfile("3", "홍길순", "111-1113", "서울시 강남구 대치3동"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable String id) {
        UserProfile userProfile = userProfileMap.get("1");
        return userProfile;
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        ArrayList<UserProfile> userProfileArrayList = new ArrayList<>(userProfileMap.values());
        return userProfileArrayList;
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        UserProfile userProfile = userProfileMap.get(id);
        userProfile.setName(name);
        userProfile.setAddress(address);
        userProfile.setPhone(phone);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        userProfileMap.put(id, userProfile);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        userProfileMap.remove(id);
    }
}
