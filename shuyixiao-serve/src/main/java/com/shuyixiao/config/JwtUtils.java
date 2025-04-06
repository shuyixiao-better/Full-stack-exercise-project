package shuyixiao.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.security.Key;
import java.nio.charset.StandardCharsets;

public class JwtUtils {

    private static final String SECRET_KEY = "your-secret-key-should-be-very-long-and-secure"; // 实际使用时应该放入配置文件

    // 访问令牌有效期：30分钟
    private static final long ACCESS_TOKEN_EXPIRATION = 30 * 60 * 1000;

    // 刷新令牌有效期：7天
    private static final long REFRESH_TOKEN_EXPIRATION = 7 * 24 * 60 * 60 * 1000;

    // 创建签名密钥
    private static Key getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static String generatorToken(String username, String credential, String tokenType) {
        long expiration = TokenConstants.ACCESS_TOKEN_TYPE.equals(tokenType)
                ? ACCESS_TOKEN_EXPIRATION : REFRESH_TOKEN_EXPIRATION;

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(username)
                .claim("credential", credential)  // 不要直接存储密码，可以存储一个派生值
                .claim("tokenType", tokenType)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}