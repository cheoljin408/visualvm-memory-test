package com.example.visualvmmemorytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemoryTestController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/memorytest")
    public Integer memoryTest() {
        List<byte[]> list = new ArrayList<>();
        int index = 1;

        while (true) {
            // 1MB each loop, 1 x 1024 x 1024 = 1048576
            byte[] b = new byte[1048576];
            list.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.printf("[%d] free memory: %s%n", index++, rt.freeMemory());
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
