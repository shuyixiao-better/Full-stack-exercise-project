package shuyixiao.config;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 白名单路径，不需要验证token
        String[] whitelist = {
                "/user/login",
                "/user/register",
                "/public/**",
                "/api/user/login"  // 添加的新白名单路径
        };
        String requestPath = request.getRequestURI();

        // 检查是否是白名单路径
        for (String path : whitelist) {
            if (pathMatcher.match(path, requestPath)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        // 获取Authorization头的JWT令牌
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "未提供有效的令牌");
            return;
        }

        // 去掉Bearer前缀
        token = token.substring(7);

        try {
            // 验证JWT令牌
            Claims claims = JwtUtils.parseToken(token);
            String tokenType = claims.get("tokenType", String.class);

            // 确保是访问令牌而不是刷新令牌
            if (!TokenConstants.ACCESS_TOKEN_TYPE.equals(tokenType)) {
                sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "无效的令牌类型");
                return;
            }

            // 令牌验证通过，将用户信息存入请求上下文
            String username = claims.getSubject();
            request.setAttribute("username", username);

            // 继续处理请求
            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException e) {
            sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "令牌已过期");
        } catch (Exception e) {
            sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "无效的令牌");
        }
    }

    private void sendErrorResponse(HttpServletResponse response, int status, String message) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 使用与前端匹配的字段名称
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", status);
        responseMap.put("msg", message);

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(responseMap));
    }
}