/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.controller;

import com.dev.taskManager.entity.User;
import com.dev.taskManager.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *
 * @author eduar
 */
@Component
public class AuthorizationMiddleware implements HandlerInterceptor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Obtener el usuario actual desde la sesión o el token de autenticación
        User currentUser = getCurrentUserFromSessionOrToken(request);

        // Verificar si el usuario tiene el permiso necesario para acceder a la ruta solicitada
        if (!hasPermission(currentUser, request.getRequestURI(), request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }

        return true;
    }

    private User getCurrentUserFromSessionOrToken(HttpServletRequest request) {
        // Aquí obtendrías el usuario actual desde la sesión o el token de autenticación
        // Puedes utilizar Spring Security para obtener el usuario autenticado
        // Spring Security: SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // En este ejemplo, asumiremos que tienes un mecanismo para obtener el ID del usuario desde el token en la solicitud
        String userIdString = request.getHeader("Authorization");
        if (userIdString != null && !userIdString.isEmpty()) {
            try {
                Integer userId = Integer.parseInt(userIdString);
                return userRepository.findUserById(userId).orElse(null);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    private boolean hasPermission(User user, String uri, String method) {
        // Verificar si el usuario existe y tiene permisos asignados
        if (user == null || user.getPermissions() == null || user.getPermissions().isEmpty()) {
            return false;
        }

        // Verificar si el usuario tiene el permiso necesario para acceder a la ruta solicitada
        // En este ejemplo, asumiremos que el usuario debe tener el permiso en el formato "ROL_ACCION", por ejemplo: "ADMIN_CREATE_USER"
        String requiredPermission = getRequiredPermission(uri, method);
        return user.getPermissions().stream()
                .anyMatch(permission -> permission.name().equals(requiredPermission));
    }

    private String getRequiredPermission(String uri, String method) {
        // Aquí implementarías la lógica para obtener el permiso requerido a partir de la URI y el método
        // Puedes definir tus propias reglas para mapear rutas y métodos a permisos
        // Por ejemplo, podrías tener una tabla de configuración que asocie rutas y métodos a permisos
        // En este ejemplo, asumiremos que la ruta y el método determinan el permiso directamente
        return method + "_" + uri.replace("/", "").toUpperCase();
    }
}
