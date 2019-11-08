//package edu.practise.universal_teacher.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@Component
//public class  CorsFilter  implements Filter {
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers",  "X-Requested-With, accept, content-type");
//        chain.doFilter(req, res);
//    }
//
//    public void init(FilterConfig filterConfig) {}
//
//    public void destroy() {}
//
//}
////
