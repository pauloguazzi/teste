package utfpr.ct.dainf.if6ae.exemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**

 */
@WebServlet(name = "Login Servlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processa requisições HTTP para os métodos
     * <code>GET</code> e
     * <code>POST</code>.
     *
     * @param request Requisição
     * @param response Resposta
     * @throws ServletException Se ocorrer um exceção específica de Servlet
     * @throws IOException Se ocorrer uma exceção de E/S
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charsetmU=TF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String perfil = request.getParameter("perfil");
            
            //Valores do perfil:
            switch(perfil){
                case "1":
                    perfil = "Cliente";
                    break;
                case "2":
                    perfil = "Gerente";
                    break;
                case "3":
                    perfil = "Administrador";
                    break;
            }
                    
            //Comparar para ver se o Login é igual a senha.
            if(login.equals(senha))
            {
                //redireciona para /sucesso com o login e perfil na query string.
                response.sendRedirect(request.getContextPath() + "/sucesso?login="+login+"&perfil="+perfil);
            }
            
            else
            {
                //redireciona para erro.xhtml
                response.sendRedirect("erro.xhtml");
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Processa a requisição HTTP para o método
     * <code>GET</code>.
     *
     * @param request Requisição
     * @param response Resposta
     * @throws ServletException Se ocorrer um exceção específica de Servlet
     * @throws IOException Se ocorrer uma exceção de E/S
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Processa a requisição HTTP para o método
     * <code>POST</code>.
     *
     * @param request Requisição
     * @param response Resposta
     * @throws ServletException Se ocorrer um exceção específica de Servlet
     * @throws IOException Se ocorrer uma exceção de E/S
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Retorna uma descrição resumida do servlet.
     * @return Uma descrição resumida.
     */
    @Override
    public String getServletInfo() {
        return "Exemplo de servlet simples";
    }// </editor-fold>
}
