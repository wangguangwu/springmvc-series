package com.wangguangwu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.TimeUnit;

/**
 * @author wangguangwu
 */
@RequestMapping("async")
@RestController
public class AsyncController {

    @GetMapping("/m1")
    public String m1() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("主线程:[" + Thread.currentThread() + ", " + startTime + " start");
        // 休眠 3 秒，模拟业务操作
        TimeUnit.SECONDS.sleep(3);
        long endTime = System.currentTimeMillis();
        System.out.println("主线程:[" + Thread.currentThread() + ", 耗时 " + (endTime - startTime) + " ms");
        return "success";
    }

    /**
     * 使用 springmvc 的异步功能，业务处理放在异步线程中执行
     * 返回值需要为 DeferredResult
     *
     * timeout 小于 3000 时，主线程瞬间结束，返回 timeout
     * timeout 大于 3000 时，主线程瞬间结束，异步的逻辑执行结束，返回 success
     */
    @RequestMapping("/m2/{timeout}")
    public DeferredResult<String> m2(@PathVariable("timeout") long timeout) {
        long startTime = System.currentTimeMillis();
        System.out.println("主线程:[" + Thread.currentThread() + ", " + startTime + " start");
        // 1. 创建 DeferredResult
        DeferredResult<String> result = new DeferredResult<>(timeout, () -> {
            System.out.println("timeout");
            return "timeout";
        });
        // 2. 异步处理业务
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                result.setResult("success");
                System.out.println("异步线程:[" + Thread.currentThread() + ", 耗时 " + (System.currentTimeMillis() - startTime) + " ms");
            } catch (InterruptedException e) {
                result.setResult("发生异常了:" + e.getMessage());
            }
        }).start();
        long endTime = System.currentTimeMillis();
        System.out.println("主线程:[" + Thread.currentThread() + ", 耗时 " + (endTime - startTime) + " ms");
        return result;
    }

}
