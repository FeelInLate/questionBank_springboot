package boot.config;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
@Configuration
public class CorsConfig implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        // 指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有
        // response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1, http://locahost"); // 允许白名单IP
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        // 预检请求的结果缓存60分钟
        response.setHeader("Access-Control-Max-Age", "3600");
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
