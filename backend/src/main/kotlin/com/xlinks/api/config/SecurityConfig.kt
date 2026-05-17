package com.xlinks.api.config

import com.xlinks.core.domain.User
import com.xlinks.core.domain.XAccount
import com.xlinks.core.repository.UserRepository
import com.xlinks.core.repository.XAccountRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.SecurityFilterChain
import java.time.Instant

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val userRepository: UserRepository,
    private val xAccountRepository: XAccountRepository
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { auth ->
            auth.requestMatchers("/", "/login**", "/error", "/api/public/**").permitAll().anyRequest().authenticated()
        }.oauth2Login { oauth2 ->
            oauth2.loginPage("/login").defaultSuccessUrl("/dashboard", true).userInfoEndpoint { it.userService(xOAuth2UserService()) }
        }.logout { it.logoutSuccessUrl("/").permitAll() }.csrf { it.disable() }
        return http.build()
    }

    @Bean
    fun xOAuth2UserService(): OAuth2UserService<OAuth2UserRequest, OAuth2User> {
        val delegate = DefaultOAuth2UserService()
        return OAuth2UserService { userRequest ->
            val oAuth2User = delegate.loadUser(userRequest)
            val xUserId = oAuth2User.getAttribute<String>("data.id") ?: oAuth2User.name
            val username = oAuth2User.getAttribute<String>("data.username") ?: "x_user"
            val user = userRepository.findByUsername(username) ?: userRepository.save(User(username = username))
            val accessToken = userRequest.accessToken.tokenValue
            val refreshToken = userRequest.additionalParameters["refresh_token"] as? String
            val expiresIn = (userRequest.additionalParameters["expires_in"] as? Long) ?: 7200
            val xAccount = xAccountRepository.findByXUserId(xUserId) ?: XAccount(user = user, xUserId = xUserId, username = username)
            xAccount.accessToken = accessToken
            xAccount.refreshToken = refreshToken
            xAccount.tokenExpiresAt = Instant.now().plusSeconds(expiresIn)
            xAccountRepository.save(xAccount)
            oAuth2User
        }
    }
}