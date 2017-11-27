package view;

import controller.ImageController;
import model.Image;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(urlPatterns="/image/*")
public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1251001105853430500L;

    @Inject
    private ImageController imgCtnrl;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String [] urlParts = req.getRequestURI().split("/");
        String path =  urlParts[urlParts.length - 1];
        try{
            Image img = imgCtnrl.findByPath(path);
            resp.setContentLength(img.getSize().intValue());
            resp.setContentType(img.getType());
            InputStream in = imgCtnrl.read(path);
            OutputStream out = resp.getOutputStream();
            int reads;
            byte[] buffer = new byte [1024];
            while((reads = in.read(buffer)) > -1){
                out.write(buffer, 0, reads);
            }
            in.close();
            out.close();
        } catch (Exception e){
            e.printStackTrace();
            resp.sendError(404,"FILE NOT FOUND");
        }

    }

}