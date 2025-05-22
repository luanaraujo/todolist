package br.com.luanaraujo.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

// import at.favre.lib.crypto.bcrypt.BCrypt; // Not needed anymore
// import br.com.luanaraujo.todolist.user.IUserRepository; // Deleted package
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    // @Autowired
    // private IUserRepository userRepository; // Deleted package

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // var servletPath = request.getServletPath();
        // System.out.println("PATH " + servletPath);
        // if (servletPath.startsWith("/tasks/")) {
        //     // Pegar a autenticação (usuario e senha)
        //     var authorization = request.getHeader("Authorization");

        //     var authEncoded = authorization.substring("Basic".length()).trim();

        //     byte[] authDecode = Base64.getDecoder().decode(authEncoded);

        //     var authString = new String(authDecode);

        //     // ["danieleleao", "12345"]
        //     String[] credentials = authString.split(":");
        //     String username = credentials[0];
        //     String password = credentials[1];

        //     // Validar usuário
        //     var user = this.userRepository.findByUsername(username); // Deleted package
        //     if (user == null) {
        //         response.sendError(401);
        //     } else {
        //         // Validar senha
        //         var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()); // user.getPassword() no longer exists
        //         if (passwordVerify.verified) {
        //             // Segue viagem
        //             request.setAttribute("idUser", user.getId()); // user.getId() no longer exists
        //             filterChain.doFilter(request, response);
        //         } else {
        //             response.sendError(401);
        //         }

        //     }
        // } else {
        //     filterChain.doFilter(request, response);
        // }
        
        // Allowing all requests to pass through for now.
        filterChain.doFilter(request, response);
    }

}
