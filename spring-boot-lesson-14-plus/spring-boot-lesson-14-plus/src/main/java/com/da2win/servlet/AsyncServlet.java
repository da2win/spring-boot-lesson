package com.da2win.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        Optional<String> stringOptional = Optional.empty();

        PrintWriter writer = resp.getWriter();

        // 异步开始了
        writer.println("线程[" + Thread.currentThread().getName() + "]异步开始了...");


        AsyncContext asyncContext = req.startAsync(req, resp);

        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                writer.println("线程[" + Thread.currentThread().getName() + "]请求开始了...");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                System.err.println("超时...");
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                System.err.println("错误!!!");
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {

            }
        });

        asyncContext.start(new Runnable() {
            @Override
            public void run() {

                writer.println("线程[" + Thread.currentThread().getName() + "]请求开始执行了...");

            }
        });

        asyncContext.complete();

        writer.println("结束异步!");
    }
}
