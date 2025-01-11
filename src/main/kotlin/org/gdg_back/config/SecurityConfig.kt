package org.gdg_back.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .cors { it.configurationSource(corsConfigurationSource()) }
            .authorizeHttpRequests { auth ->
                auth.anyRequest().permitAll()
            }
        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration().apply {
            // (1) 모든 출처 허용
            //     - 만약 쿠키, Authorization 등을 사용한다면 addAllowedOrigin("*")와 allowCredentials(true)는 함께 쓸 수 없습니다.
            //       -> "교차 리소스 요청에 자격 증명을 포함하려면 특정 origin을 지정"해야 합니다.
            addAllowedOrigin("*")

            // or, addAllowedOriginPattern("*") 도 가능하지만
            // 버전에 따라 동작이 달라질 수 있으니 주의

            // (2) 허용 메서드
            addAllowedMethod("*")  // 모든 메서드 허용

            // (3) 허용 헤더
            addAllowedHeader("*")  // 모든 헤더 허용

            // (4) [옵션] 인증 정보(쿠키 등) 사용 여부
            //    - 만약, 프론트에서 fetch(..., { credentials: 'include' }) 형태로 쿠키를 보내야 한다면
            //      allowCredentials(true) 로 설정하고, addAllowedOrigin("http://localhost:3000") 처럼 구체적인 도메인으로 제한해야 한다.
            // allowCredentials(true)

            // (5) 기타
            maxAge = 3600L
        }

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}
